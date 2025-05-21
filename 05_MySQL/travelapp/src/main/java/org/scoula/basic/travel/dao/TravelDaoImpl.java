package org.scoula.basic.travel.dao;

import org.scoula.basic.database.JDBCUtil;
import org.scoula.basic.travel.domain.TravelImageVO;
import org.scoula.basic.travel.domain.TravelVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelDaoImpl implements TravelDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public void insert(TravelVO travel) {
        // travel 값을 받아와서 tbl_travel에 삽입하는 메소드
        String sql = "insert into tbl_travel(no, district,title,description, address, phone) values(?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, travel.getNo());
            pstmt.setString(2, travel.getDistrict());
            pstmt.setString(3, travel.getTitle());
            pstmt.setString(4, travel.getDescription());
            pstmt.setString(5, travel.getAddress());
            pstmt.setString(6, travel.getPhone());
            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            // jdbc의 에러는 SQLException이다. 그리고 SQLException는 Exception의 자식이므로 반드시 예외처리를 해야 한다.
            // 그러나 run time exception으로 바꾸고 싶다면, 초기 interface생성시 throw하지 않고 여기서 try catch에서 예외를 던지면 된다.
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertImage(TravelImageVO image) {
        String sql = "insert into tbl_travel_image(filename, travel_no) values(?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, image.getFilename());
            pstmt.setLong(2, image.getTravelNo());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from tbl_travel";
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getDistricts() {
        // 목록 보기의 전형적인 패턴
        List<String> districts = new ArrayList<>();  // 먼저 빈 리스트 만들고!!!!!!!!!!
        String sql = "SELECT DISTINCT(district) FROM tbl_travel ORDER BY district";
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {  //여러 개이므로 next를 가지고 온다. 
                districts.add(rs.getString("district"));  //컬럼명으로 데이터 가져와서 리스트에 추가
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return districts;
    }

    // ResultSet을 TravelVO로 매핑하는 작업
    private TravelVO map(ResultSet rs) throws SQLException {
        return TravelVO.builder()
                .no(rs.getLong("no"))
                .district(rs.getString("district"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .address(rs.getString("address"))
                .phone(rs.getString("phone"))
                .build();
    }

    // 전체 목록 조회
    @Override
    public List<TravelVO> getTravels() {
        List<TravelVO> travels = new ArrayList<>();
        String sql = "select * from tbl_travel order by district, title";  // 구역이 같으면 title로 정렬한다는 의미
        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                TravelVO travel = map(rs);
                travels.add(travel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    // 페이지별 목록 얻기
    @Override
    public List<TravelVO> getTravels(int page) {
        List<TravelVO> travels = new ArrayList<>();
        String sql = "select * from tbl_travel order by district, title limit ?,?";  //페이지 네이션 처리를 위해 limit를 많이 사용함
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            int count = 10;
            int start = (page - 1) * count;  // 시작번호를 위한 공식임 -> 시작 위치가 10개찍 늘어난다.
            pstmt.setInt(1, start);
            pstmt.setInt(2, count);

            // 먼저 pstmt에 파라미터를 넣어주고 그 sql을 실행한 결과에 대해서 executeQuery를 해야 하므로 먼저
            // PreparedStatement pstmt = conn.prepareStatement(sql)을 try하고 그 후에
            // try (ResultSet rs = pstmt.executeQuery())를 하는 것이다.

            try (ResultSet rs = pstmt.executeQuery()) {  // 10개씩 가져온다.
                while (rs.next()) {
                    TravelVO travel = map(rs);
                    travels.add(travel);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    @Override
    public List<TravelVO> getTravels(String district) {
        List<TravelVO> travels = new ArrayList<TravelVO>();
        String sql = "select * from tbl_travel where district = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, district);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    TravelVO travel = map(rs);
                    travels.add(travel);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return travels;
    }

    private TravelImageVO mapImage(ResultSet rs) throws SQLException {
        return TravelImageVO.builder()
                .no(rs.getLong("tino"))
                .filename(rs.getString("filename"))
                .travelNo(rs.getLong("travel_no"))
                .build();
    }

    @Override
    public Optional<TravelVO> getTravel(Long no) {
        TravelVO travel = null;
        String sql = """
             select t.*, ti.no as tino, ti.filename, ti.travel_no
             from tbl_travel t
             left outer join tbl_travel_image ti
             on t.no = ti.travel_no
             where t.no = ?;
             """;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, no);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    travel = map(rs);
                    List<TravelImageVO> images = new ArrayList<>();
                    try {
                        do {
                            TravelImageVO image = mapImage(rs);
                            images.add(image);
                        } while (rs.next());
                    } catch (SQLException e) {
                        // 이미지가 없는 경우 발생
                    }
                    travel.setImages(images);
                    return Optional.of(travel);
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
