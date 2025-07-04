package org.scoula.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.board.domain.BoardVO;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j2
class BoardMapperTest {
    @Autowired
    private BoardMapper mapper;

    @Test
    void pageData() {
        // 총 130개의 게시글 더미 데이터 생성
        for (int i = 0; i < 130; i++) {
            BoardVO board = BoardVO.builder()
                    .title("페이지 데이터" + i)
                    .writer((i % 2 == 0) ? "admin" : "user0")
                    .content("페이지 내용" + i)
                    .build();
            mapper.create(board);
        }
    }
}