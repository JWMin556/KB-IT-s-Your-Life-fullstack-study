package org.scoula.board.mapper;

import org.scoula.board.domain.BoardAttachmentVO;
import org.scoula.board.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    // 게시판을 정렬할 때, 본래는 order by reg_date desc로 해야하지만 오버헤드가 발생할 수 있다.
    // 이미 PK로 no가 정렬되었고 그 PK가 reg_date의 순서와 일치하기에 no로 정렬하는 것이다.
//    @Select("select * from tbl_board order by no desc")
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
