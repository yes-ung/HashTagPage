/**
 * 
 */
package egovframework.example.emp.service;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author user
 * 사원 테이블과 닮은 VO 클래스를 만드세요
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class EmpVO extends Criteria {

	private int eno;         // 사원번호 (기본키,시퀀스)
	private String ename;    // 사원명
	private String job;      // 직위
	private int manager;     // 관리자 사원번호
	private String hiredate; // 입사일
	private int salary;      // 급여
	private int commission;  // 상여금
	private int dno;         // 부서번호
	

}
