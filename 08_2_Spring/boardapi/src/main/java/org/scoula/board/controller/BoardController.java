package org.scoula.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board") // 관례적으로 api/라는 것을 앞에 붙인다
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService service;

    @GetMapping("")
    public ResponseEntity<List<BoardDTO>> getList() {
        return ResponseEntity.ok(service.getList());
        // 실패할 경우 예외가 발생할 것이고 ControllerAdvice에서 일괄 처리할 것이기에 여기서는 성공했을 때만 가정하면 된다
    }

    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(@PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

    @PostMapping("")
    public ResponseEntity<BoardDTO> create(@RequestBody BoardDTO board) {
        // RequestBody가 있기에 JS에서 json인코딩해서 보낸 것을 DTO로 역직렬화 해주는 것이다
        return ResponseEntity.ok(service.create(board));
    }

    @PutMapping("/{no}")  // put은 몽땅 다 바꾼다는 뜻 (만약 특정 부분만 바꾸려면 fetch)
    public ResponseEntity<BoardDTO> update(@PathVariable Long no, @RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.update(board));
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(@PathVariable Long no) {
        return ResponseEntity.ok(service.delete(no));
    }
}
