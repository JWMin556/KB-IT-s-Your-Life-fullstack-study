package org.scoula.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.board.dto.BoardDTO;
import org.scoula.board.mapper.BoardMapper;
import org.scoula.common.util.UploadFiles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper mapper;  //여기서는 Autowired가 비권장
    private final static String BASE_DIR = "c:/upload/board";

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
        log.info("========================" + board);
        // Optional을 통해 null 안정성 체크
        return Optional.ofNullable(board)
                .orElseThrow(NoSuchElementException::new); // 데이터가 있으면 리턴, 없으면 예외를 던진다
                // 그런데 NoSuchElementException::new가 디폴트이기에, 그냥 orElseThrow()라고만 해도 됨
    }

    // 2개 이상의 insert 문이 실행될 수 있으므로 트랜잭션 처리 필요
    // RuntimeException인 경우만 자동 rollback. 즉, 일반 Exception이 발생한다면, commit이 발생함 (몇개는 성공, 몇개는 실패) -> 불일치의 위험성
    // 그렇기에 Transactional는 exception에 대해서 RuntimeException으로 고쳐줘야 한다.
    // JDBC 예외인 경우, SQL exception이 발생하기에 RuntimeException으로 고쳐줘야 한다. 다만, MyBatis가 알아서 고쳐준다
    // 그런데 순수 업로드 과정에서 다른 예외가 발생할 수도 있기에 RuntimeException으로 교체해야 한다.
    @Transactional
    @Override
    public BoardDTO create(BoardDTO board) {
        log.info("create......" + board);
        BoardVO boardVO = board.toVo();
        mapper.create(boardVO);
        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if(files != null && !files.isEmpty()) { // 첨부 파일이 있는 경우
            upload(boardVO.getNo(), files);
        }
        return get(boardVO.getNo());
    }

    private void upload(Long bno, List<MultipartFile> files) {
        for(MultipartFile part: files) {
            if(part.isEmpty()) continue;
            try {
                String uploadPath = UploadFiles.upload(BASE_DIR, part);
                BoardAttachmentVO attach = BoardAttachmentVO.of(part, bno, uploadPath);
                mapper.createAttachment(attach);
            } catch (IOException e) {  // 기존 Exception을 runtimeException으로 바꿈. 왜? transactional은 언제나 runtime에서만 동작한다.
                throw new RuntimeException(e); //@Transactional에서 감지, 자동 rollback
            }
        }
    }

    @Override
    public BoardDTO update(BoardDTO board) {
        log.info("update......" + board);
        BoardVO boardVO = board.toVo();
        log.info("update...... " + boardVO);
        mapper.update(board.toVo());

        // 파일 업로드 처리
        List<MultipartFile> files = board.getFiles();
        if (files != null && !files.isEmpty()) {
            upload(boardVO.getNo(), files);
        }
        return get(board.getNo());
    }

    @Override
    public BoardDTO delete(Long no) {
        log.info("delete...." + no);
        BoardDTO board = get(no);

//        List<BoardAttachmentVO> attachList = mapper.getAttachmentList(no);
//        for (BoardAttachmentVO attach : attachList) {
//            mapper.deleteAttachment(attach.getNo());
//        }

        mapper.delete(no);
        return board;
    }

    // 첨부파일 한 개 얻기
    @Override
    public BoardAttachmentVO getAttachment(Long no) {
        return mapper.getAttachment(no);
    }

    // 첨부파일 삭제
    @Override
    public boolean deleteAttachment(Long no) {
        return mapper.deleteAttachment(no) == 1;
    }
}
