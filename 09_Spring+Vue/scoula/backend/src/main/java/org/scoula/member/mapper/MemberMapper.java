package org.scoula.member.mapper;

import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;

public interface MemberMapper {
    MemberVO get(String username);  // join을 통해 전체 정보 추출
    MemberVO findByUsername(String username);  // id 중복 체크시 (이떄, join은 하지 않음)
    int insert(MemberVO member);  // 회원 정보 추가
    int insertAuth(AuthVO auth);  // 회원 권한 정보 추가
}
