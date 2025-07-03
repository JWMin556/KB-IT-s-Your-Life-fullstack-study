package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;
import org.scoula.common.pagination.PageRequest;

import java.util.List;

public interface BoardMapper {
    int getTotalCount();
    List<BoardVO> getPage(PageRequest pageRequest);

    List<BoardVO> getList();  //리턴 타입이 List이기에 selelctList()가 된다.
    BoardVO get(Long no);
    void create(BoardVO board);  // 메서드의 매개변수는 일반적으로 하나만 쓸 수 있다.
                                        // 일반적으로 단일값, VO객체, Map을 파라미터로 넘겨준다
    int update(BoardVO board);  // 몇개 업데이트 되었니
    int delete(Long no);

    void createAttachment(BoardAttachmentVO attach);
    List<BoardAttachmentVO> getAttachmentList(Long bno);
    BoardAttachmentVO getAttachment(Long no);
    int deleteAttachment(Long no);
}
