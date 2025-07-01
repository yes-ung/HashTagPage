package egovframework.example.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@Log4j
@ControllerAdvice
public class CommonException {

//  컨트롤러에서 어떤 에러가 발생하더라도 이 함수가 실행됨
    @ExceptionHandler(Exception.class)
    public String internalServerErrorException(Exception e
    		, Model model
    		) {
        String errors = e.getMessage();
        log.info("에러: " + errors);
        model.addAttribute("errors", errors);
        
        return "errors";
    }
}