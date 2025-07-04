package teamproject.auth.service;

public interface MemberService {
	MemberVO authenticate(MemberVO loginVO) throws Exception; // 로그인
	void register(MemberVO memberVO) throws Exception;         // 회원가입
}
