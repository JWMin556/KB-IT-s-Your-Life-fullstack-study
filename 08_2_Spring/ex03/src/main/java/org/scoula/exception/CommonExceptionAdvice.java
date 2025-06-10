package org.scoula.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice  // 모든 컨트롤러에서 발생하는 예외 처리
@Log4j2
public class CommonExceptionAdvice {
    @ExceptionHandler(Exception.class)  // 모든 예외 처리
    public String except(Exception ex, Model model){
        log.error("Exception......."+ex.getMessage());
        
        // 모델로 예외 객체를 뷰에 전달
        model.addAttribute("exception",ex);
        log.error(model);
        return "error_page";  //jsp파일명이다
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, HttpServletRequest request, Model model){
        log.error(ex);
        model.addAttribute("uri", request.getRequestURI());
        return"custom404";
    }
}
