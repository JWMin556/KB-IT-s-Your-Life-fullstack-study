package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // Model: Spring에서 제공하는 데이터 전달 객체
        // addAttribute를 통해 request scope에 데이터가 저장됨
        model.addAttribute("name", "홍길동");
        return "index"; // View의 이름
    }
}
