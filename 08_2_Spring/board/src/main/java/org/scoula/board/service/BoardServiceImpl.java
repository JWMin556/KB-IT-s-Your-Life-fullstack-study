package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    final private BoardMapper mapper;  //여기서는 Autowired가 비권장

    @Override
    public List<BoardDTO> getList() {
        log.info("getList..........");

        return mapper.getList().stream()  //BoardVO의 스트림
                .map(BoardDTO::of)  // BoardDTO의 스트림
                .toList();  // List<BoardDTO> 변환
    }

    @Override
    public BoardDTO get(Long no) {
        log.info("get......" + no);
        BoardDTO board = BoardDTO.of(mapper.get(no));
        // Optional을 통해 null 안정성 체크
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new); // 데이터가 있으면 리턴, 없으면 예외를 던진다
                // 그런데 NoSuchElementException::new가 디폴트이기에, 그냥 orElseThrow()라고만 해도 됨
    }

    @Override
    public void create(BoardDTO board) {
        log.info("create......" + board);

        BoardVO vo = board.toVo();
        mapper.create(vo);
        board.setNo(vo.getNo());
    }

    @Override
    public boolean update(BoardDTO board) {
        log.info("update......" + board);
        return mapper.update(board.toVo()) == 1;
    }

    @Override
    public boolean delete(Long no) {
        log.info("delete...." + no);
        return mapper.delete(no) == 1;
    }
}
