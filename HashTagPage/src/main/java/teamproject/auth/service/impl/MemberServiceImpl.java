package teamproject.auth.service.impl;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamproject.auth.service.MemberService;
import teamproject.auth.service.MemberVO;

@Service
public class MemberServiceImpl extends EgovAbstractServiceImpl  implements MemberService {
    @Autowired
    MemberMapper memberMapper;
	
	@Override
	public MemberVO authenticate(MemberVO loginVO) throws Exception {
		// 1) DB에 사용자가 있는지 확인 : loginVO(id,암호)
		MemberVO memberVO = memberMapper.authenticate(loginVO);
//		   2) 만약 회원이 없으면 -> 회원이 없습니다.(예외처리: 전자정부용)
//		=> 전자정부 : 1) EgovAbstractServiceImpl 상속
		if(memberVO==null) throw processException("errors.login");
//		   3) 회원이 있으면 암호체크 -> 암호틀림 (예외처리)
		if(memberVO!=null) {
			boolean isMatchedPassword = BCrypt.checkpw(loginVO.getUserPw(), memberVO.getUserPw());
		if(isMatchedPassword==false) throw processException("errors.loginp");
		}
//		   4) 모두 통과하면 마지막에 memberVO 리턴 
		return memberVO;
	}
//	회원가입
	@Override
	public void register(MemberVO memberVO) throws Exception {
		// 1) DB에 회원이 있는 지 확인 : 
		MemberVO cmemberVO = memberMapper.authenticate(memberVO);
//		   2)  있음(예외처리)
		if(cmemberVO != null) throw processException("errors.register");
//	       3) 입력된 암호를 -> 해싱암호화 처리합니다.
//		사용법: BCrypt.hashpw(암호,옵션);
		String hashedPassword = BCrypt.hashpw(memberVO.getUserPw(), BCrypt.gensalt());
//		   4) 암호를 memberVO에 저장 (setter)
		memberVO.setUserPw(hashedPassword);
//		   5) DB 저장
		memberMapper.register(memberVO);
		
	}
	


}
