package org.scoula.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.common.util.UploadFiles;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    final MemberService service;  //final이기에 생성자 주입

    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username){ // ResponseEntity는 body의 타입과 일치해야 한다.
        return ResponseEntity.ok().body(service.checkDuplicate(username));  // body에 들어갈 내용 담기
    }

    @PostMapping("")
    public ResponseEntity<MemberDTO> join(@ModelAttribute  MemberJoinDTO member) {
        return ResponseEntity.ok(service.join(member));  // ok메서드를 하면 200응답. 그런데 일반적으로 생성은 201로 처리하니까, 201응답을 원할시 따로 작업을 해야 함
    }

    @GetMapping("/{username}/avatar")
    public void getAvatar(@PathVariable String username,  HttpServletResponse response) {
        String avatarPath = "c:/upload/avatar/" + username + ".png";
        File file = new File(avatarPath);
        if(!file.exists()){ // 아바타 등록이 없는 경우, 디폴트 아바타 이미지 사용
            file = new File("C:/upload/avatar/unknown.png");
        }
        UploadFiles.downloadImage(response,file);
    }
}
