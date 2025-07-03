package teamproject.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author user
 * @ControllerAdvice: 컨트롤러에서 에러가 발생하면 무조건 여기로 오게하는 어노테이션(클래스)
 * (전역 에러처리)
 * @ExceptionHandler(특정예외클래스): 특정예외클래스에 해당하는 에러가 발생하면 
 *                              밑에 메소드가 실행됩니다. 
 */

@Log4j
@ControllerAdvice
public class CommonException {

//  컨트롤러에서 어떤 에러가 발생하더라도 이 함수가 실행됨
    @ExceptionHandler(Exception.class)
    public String internalServerErrorException(Exception e
    		, Model model
    		) {
        String errors = e.getMessage();       // 에러 내용
        log.info("에러: " + errors);
        model.addAttribute("errors", errors); // 에러를 모델에 담기
        
        return "errors";                      // jsp명
    }
}