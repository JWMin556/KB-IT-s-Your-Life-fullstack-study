package org.scoula.board.controller;

import io.swagger.annotations.*;
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
@Api(tags = "게시글 관리")
public class BoardController {
    private final BoardService service;

    @ApiOperation(value = "게시글 목록", notes = "게시글 목록을 얻는 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping("")  //getMapping으로 완성되는 url이 엔드포인트라고 할 수 있다
    public ResponseEntity<List<BoardDTO>> getList() {
        return ResponseEntity.ok(service.getList());
        // 실패할 경우 예외가 발생할 것이고 ControllerAdvice에서 일괄 처리할 것이기에 여기서는 성공했을 때만 가정하면 된다
    }

    @ApiOperation(value = "상세정보 얻기", notes = "게시글 상제 정보를 얻는 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @GetMapping("/{no}")
    public ResponseEntity<BoardDTO> get(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no) {
        return ResponseEntity.ok(service.get(no));
    }

    @ApiOperation(value = "게시글 생성", notes = "게시글 생성 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @PostMapping("")
    public ResponseEntity<BoardDTO> create(
            @ApiParam(value = "게시글 객체", required = true)
            @RequestBody BoardDTO board) {
        // RequestBody가 있기에 JS에서 json인코딩해서 보낸 것을 DTO로 역직렬화 해주는 것이다
        return ResponseEntity.ok(service.create(board));
    }

    @ApiOperation(value = "게시글 수정", notes = "게시글 수정 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다.", response = BoardDTO.class),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @PutMapping("/{no}")  // put은 몽땅 다 바꾼다는 뜻 (만약 특정 부분만 바꾸려면 fetch)
    public ResponseEntity<BoardDTO> update(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no,
            @ApiParam(value = "게시글 객체", required = true)
            @RequestBody BoardDTO board) {
        return ResponseEntity.ok(service.update(board));
    }

    @ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 API")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다."),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    @DeleteMapping("/{no}")
    public ResponseEntity<BoardDTO> delete(
            @ApiParam(value = "게시글 ID", required = true, example = "1")
            @PathVariable Long no) {
        return ResponseEntity.ok(service.delete(no));
    }
}
