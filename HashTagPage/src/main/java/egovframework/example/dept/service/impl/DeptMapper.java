package egovframework.example.dept.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptVO;

/**
 * 
 * @author user
 * Mybatis(마이바티스) : 1) 인터페이스(메소드명) 2)xml: sql 문 작성
 * sql 작성할 인터페이스
 *
 */

@Mapper
public interface DeptMapper {
	public List<?> selectDeptList(Criteria criteria);   // 전체 조회
	public int selectDeptListTotCnt(Criteria criteria); // 총 개수 구하기
	public int insert(DeptVO deptVO);                   // 부서 insert
	public DeptVO selectDept(int dno);                  // 상세조회
    public int update(DeptVO deptVO);                   // update 메소드
    public int delete(DeptVO deptVO);                   // delete 메소드
}
