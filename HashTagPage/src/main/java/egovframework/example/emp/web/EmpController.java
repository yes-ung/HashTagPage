package egovframework.example.emp.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptVO;
import egovframework.example.emp.service.EmpService;
import egovframework.example.emp.service.EmpVO;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/emp/emp.do")
	public String name(@ModelAttribute Criteria criteria,
			Model model,@RequestParam(defaultValue = "") String searchKeyword) {
//        개인적으로 추가
		 model.addAttribute("searchKeyword", searchKeyword);
		
		//		1) 등차자동계산 클래스 : PaginationInfo
//      -필요정보: (1) 현재페이지번호(pageIndex),
//	(2)보일 개수(pageUnit) : 3
	PaginationInfo paginationInfo = new PaginationInfo();
	paginationInfo.setCurrentPageNo(criteria.getPageIndex());
	paginationInfo.setRecordCountPerPage(criteria.getPageUnit());
//	등차를 자동 계산 :  FirstRecordIndex 필드에 있음
	criteria.setFirstIndex(paginationInfo.getFirstRecordIndex());
	
	
	
		List<?> list = empService.selectEmpList(criteria);
		model.addAttribute("empVO",list);
		
//      페이지 번호 그리기 : 페이지 플러그인(전체테이블 행 갯수 필요)	
		int totCnt=empService.selectEmpListTotCnt(criteria);
		paginationInfo.setTotalRecordCount(totCnt);
		log.info("테스트 : "+totCnt);
//		페이지 모든 정보 : paginationInfo
		model.addAttribute("paginationInfo",paginationInfo);
		
		return "emp/emp_all";
	}
//	추가 페이지 열기
	@GetMapping("/emp/addition.do")
	public String creatdEmpView() {
		return "emp/add_emp";
	}
//  insert : 저장 버튼 클릭시
	@PostMapping("/emp/add.do")
	public String insert(@ModelAttribute EmpVO empVO) {
//		empVO 내용 확인
		log.info("테스트3 :" + empVO);
		empService.insert(empVO);
		return "redirect:/emp/emp.do";
	}
//  수정페이지 열기(상세조회)
  @GetMapping("/emp/edition.do")
  public String updateEmpView(@RequestParam int eno, Model model) {
//     서비스의 상세조회
     EmpVO empVO=empService.selectEmp(eno);
     model.addAttribute("empVO", empVO);
     return "emp/update_emp";
  }
//    수정: 버튼 클릭시 실행
  @PostMapping("/emp/edit.do")
  public String update(@RequestParam int eno,
         @ModelAttribute EmpVO empVO) {
//  	서비스의 수정 실행
  	empService.update(empVO);
     return "redirect:/emp/emp.do";
  }
//    삭제 : 버튼 클릭시 실행
  @PostMapping("/emp/delete.do")
  public String delete(@ModelAttribute EmpVO empVO) {
	  empService.delete(empVO);
	  return "redirect:/emp/emp.do";
	 
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
