package org.scoula.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final PasswordEncoder passwordEncoder;  // 이것은 SecurityConfig에 이미 등록이 되어있다.
    final MemberMapper mapper;

    @Override
    public boolean checkDuplicate(String username) {
        MemberVO member = mapper.findByUsername(username);
        return member != null ? true : false;
    }

    @Override
    public MemberDTO get(String username) {
        MemberVO member = Optional.ofNullable(mapper.get(username))
                .orElseThrow(NoSuchElementException::new);  //데이터가 있으면 그것을 리턴하고 없으면 예외를 발생시킨다. 
                                                            // orElseThrow의 디폴트가 NoSuchElementException::new이기에 생략가능
        return MemberDTO.of(member);
    }

    private void saveAvatar(MultipartFile avatar, String username) {
        // 아바타 업로드
        if (avatar != null && !avatar.isEmpty()) {
            File dest = new File("c:/upload/avatar", username + ".png");  // File메서드의 첫 인자는 부모 디렉토리, 두 번째 인자는 파일명이다.
            try {
                avatar.transferTo(dest);  //transferTo를 통해 저장한다.
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Transactional  // RuntimeException에 대해서만 반응한다. 여튼 Transactional을 통해 아래의 모든 과정 속에서 하나라도 실패할 경우, 즉시 예외처리 되도록 진행한다.
    @Override
    public MemberDTO join(MemberJoinDTO dto) {
        MemberVO member = dto.toVo();

        member.setPassword(passwordEncoder.encode(member.getPassword()));  // 비밀번호 암호화
        mapper.insert(member);

        AuthVO auth = new AuthVO();
        auth.setUsername(member.getUsername());
        auth.setAuth("ROLE_MEMBER");
        mapper.insertAuth(auth);

        saveAvatar(dto.getAvatar(), member.getUsername());

        return get(member.getUsername());
    }
}
