package org.scoula.food.dao;

import org.scoula.basic.database.JDBCUtil;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantDaoImpl implements RestaurantDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public void insert(RestaurantVO restaurant) {
        String sql = "insert into tbl_restaurant values(?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, restaurant.getId());
            ps.setString(2, restaurant.getName());
            ps.setString(3, restaurant.getCategory());
            ps.setString(4, restaurant.getAddress());
            ps.setString(5, restaurant.getDescription());
            int count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertReview(RestaurantReviewVO review) {
        String sql = "insert into tbl_restaurant_review values(?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, review.getNo());
            ps.setInt(2, review.getRestaurantId());
            ps.setString(3, review.getWriter());
            ps.setString(4, review.getContent());
            ps.setInt(5, review.getScore());
            int count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private RestaurantVO mapRestaurant(ResultSet rs) throws SQLException {
        return RestaurantVO.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .category(rs.getString("category"))
                .address(rs.getString("address"))
                .description(rs.getString("description"))
                .build();
    }

    private RestaurantReviewVO mapReview(ResultSet rs) throws SQLException {
        return RestaurantReviewVO.builder()
                .no(rs.getInt("no"))
                .writer(rs.getString("writer"))
                .content(rs.getString("content"))
                .score(rs.getInt("score"))
                .build();
    }

    @Override
    public Optional<RestaurantVO> getRestaurantWithReviews(int id) {
        RestaurantVO restaurant = null;
        String sql = """
                select r.*, rr.no, rr.writer, rr.content, rr.score
                from tbl_restaurant r 
                left outer join tbl_restaurant_review rr
                on rr.restaurant_id = r.id
                where r.id = ?
                """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    restaurant = mapRestaurant(rs);
                    List<RestaurantReviewVO> reviews = new ArrayList<>();
                    try {
                        do {
                            RestaurantReviewVO review = mapReview(rs);
                            reviews.add(review);
                        } while (rs.next());
                    } catch (SQLException e) {}
                    restaurant.setReviews(reviews);
                    return Optional.of(restaurant);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
