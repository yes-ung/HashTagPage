package teamproject.auth.service.impl;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import teamproject.auth.service.MemberVO;

/**
 * @author user
 * 1) 로그인 메소드 2) 회원가입 메소드
 */
@Mapper
public interface MemberMapper {
	   public MemberVO authenticate(MemberVO memberVO); // 로그인
	   public void register(MemberVO memberVO);         // 회원가입
}   
