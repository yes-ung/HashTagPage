/**
 * 
 */
package teamproject.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author user
 * 1) 인터셉터 클래스 만들기
 * 2) 그 클래스를 실행할 메뉴를 등록하는 일
 *    -> 로그인이 필요없는 메뉴 : 회원가입, 로그인 등
 *    -> 로그인이 필요한 메뉴  : 부서,사원 등
 */
public class AuthenticInterceptor extends HandlerInterceptorAdapter {

//	우리 회원인지 판단해서(세션에 있는지) 아니면 로그인페이지로 강제이동
//	맞으면 해당 메뉴 사용 가능
//	preHandle 오버라이딩
//	용어: request(jsp->컨트롤러로 정보 전송)
//	     response(컨트롤러->jsp 정보 전송)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		TODO: 로그인 체크
		// 1) 세션 가져오기
//		사용법: request.getSession(옵션) - false(세션이 없으면 만들지 않음)
		HttpSession session = request.getSession(false);
//		   2) 세션에 memberVO 가 없으면 강제이동(로그인 페이지)
		if(session == null || session.getAttribute("memberVO") == null) {
			response.sendRedirect("/login.do"); // 로그인 강제이동
			return false;
		}
		
//		TODO: 보안코딩: POST(입력/수정/삭제) 일때만
//		사용법: request.getMethod() : POST, GET 인지 가져오는 메소드
		if("POST".equals(request.getMethod())) {
//			1) 세션에서 CSRF_TOKEN 을 가져오기
			String sessionToken = (String) session.getAttribute("CSRF_TOKEN");
//			2) JSP에서 csrf 이름으로 쿼리스트링 정보 가져오기
			String requestToken = request.getParameter("csrf");
//			3) 1,2를 같은 지 비교: 다르면 에러처리
            if (sessionToken == null || !sessionToken.equals(requestToken)) {
            	throw new Exception("csrf 위반입니다.");
            }
		}
		
		return true;  // 통과(클릭한 메뉴를 볼수 있음)
	}

	
}





