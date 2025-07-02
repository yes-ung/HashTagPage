package egovframework.example.book.web;

import java.util.Comparator;
import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import egovframework.example.book.service.BookService;
import egovframework.example.book.service.BookVO;
import egovframework.example.common.Criteria;

@Controller
public class BookController {

	   @Autowired
	   private BookService bookService;

	//   전체조회
	   @GetMapping("book/book.do")
	   public String selectTop10Books(@ModelAttribute Criteria criteria,
	                  Model model) {
//	      1) 등차자동계산 클래스: PaginationInfo
//	         - 필요정보: (1) 현재페이지번호(pageIndex),(2) 보일 개수(pageUnit): 3
	      PaginationInfo paginationInfo=new PaginationInfo();
	      paginationInfo.setCurrentPageNo(criteria.getPageIndex());
	      paginationInfo.setRecordCountPerPage(criteria.getPageUnit());
//	      등차를 자동 계산: firstRecordIndex 필드에 있음
	      criteria.setFirstIndex(paginationInfo.getFirstRecordIndex());
	      
//	      top10 메소드 실행
//	      List<?> stbl=bookService.selectTopBookList(criteria);
//          stbl.sort(Comparator.comparingInt(BookVO::getRank));
//	      model.addAttribute("stbl", stbl);
          List<BookVO> topBooks = bookService.selectTop10Books(criteria);
          topBooks.sort(Comparator.comparingInt(BookVO::getRank));
          model.addAttribute("topBooks", topBooks);
	      
//	      트렌드 급상승 메소드 실행
	      List<?> sbtl=bookService.selectBookTrendList(criteria);
	      model.addAttribute("sbtl", sbtl);
	      
	      
//	      페이지 번호 그리기: 페이지 플러그인(전체테이블 행 개수 필요함)
	      int totCnt=bookService.selectBookListTotCnt(criteria);
	      paginationInfo.setTotalRecordCount(totCnt);
//	      페이지 모든 정보: paginationInfo
	      model.addAttribute("paginationInfo", paginationInfo);      
	      
	      return "book/book_all";
	   
	   }
	//   insert: 업로드
	//   @RequestParam(required = false) : 첨부파일 없어도 에러 발생 안하게 하는 옵션
	//   첨부파일 다루기: (필수) 예외처리 필수
	//   image.getBytes() : byte[] 배열로 변경
	   @PostMapping("/book/add.do")
	   public String insert(@RequestParam(defaultValue = "") String author_id,
	          @RequestParam(defaultValue = "0") String five_star_review,
	          @RequestParam(required = false) MultipartFile thumbnail_img,
	          @RequestParam(required = false) MultipartFile toon_img) throws Exception {
	   
		   BookVO bookVO=new BookVO(author_id,five_star_review,thumbnail_img.getBytes(),toon_img.getBytes());
//	      서비스의 insert 메소드 실행
	      bookService.insert(bookVO);
	      return "redirect:/book/book.do";
	   }
	//   다운로드 메소드: 사용자가 다운로드URL을 웹브라우저에서 실행하면 이 메소드가 첨부파일을 전달해줌
	//   @ResponseBody: JSON으로(JS 객체) 데이터를 JSP로 전달해줌
	//   JSON : 예) [{속성:값},{속성2:값2}...]
	   @GetMapping("/book/download.do")
	   @ResponseBody
	   public ResponseEntity<byte[]> fileDownload(@RequestParam(defaultValue = "") String uuid) {
//	      1) 상세조회: 첨부파일을 가져오려구
	      BookVO bookVO=bookService.selectBook(uuid);
//	      2) 헤더: 첨부파일을 보낼때(통신규칙) (1)첨부파일 보내요! (2)첨부파일 문서형식도 지정
//	      => HTML 문서: 헤더(문서형식,암호화등) + 바디(실제 데이터)
	      HttpHeaders headers=new HttpHeaders();
//	      첨부파일 보낸다는 의미: 1)attachment(첨부파일) 2)fileDbVO.getUuid()(첨부파일명)
	      headers.setContentDispositionFormData("attachment", bookVO.getUuid());
//	      첨부파일 문서형식(이진파일)
	      headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	      
//	      ResponseEntity: 데이터와 함께 신호도 같이 전송가능합니다.
//	      신호 예) HttpStatus.OK(200번), HttpStatus.NOT_FOUND(404번) 등
//	      사용법: new ResponseEntity<byte[]>(데이터, 헤더(생략가능),신호);
	      return new ResponseEntity<byte[]>(bookVO.getThumbnailImg(), 
	                                 headers, HttpStatus.OK); 
	   }
//	       @GetMapping("/book/book.do")
//	       public String showTop10Books(Model model) {
//	           List<BookVO> topBooks = bookService.selectTop10Books();
//	           topBooks.sort(Comparator.comparingInt(BookVO::getRank));
//	           model.addAttribute("topBooks", topBooks);
//	           return "book/book_all";  // top10.jsp로 이동
//	       }
	   
	   @GetMapping("/test.do")
	   public String selectTop10Books2(@ModelAttribute Criteria criteria,
	                  Model model) {
//	      1) 등차자동계산 클래스: PaginationInfo
//	         - 필요정보: (1) 현재페이지번호(pageIndex),(2) 보일 개수(pageUnit): 3
	      PaginationInfo paginationInfo=new PaginationInfo();
	      paginationInfo.setCurrentPageNo(criteria.getPageIndex());
	      paginationInfo.setRecordCountPerPage(criteria.getPageUnit());
//	      등차를 자동 계산: firstRecordIndex 필드에 있음
	      criteria.setFirstIndex(paginationInfo.getFirstRecordIndex());
	      
//	      top10 메소드 실행
	      List<?> stbl=bookService.selectTopBookList(criteria);          
	      model.addAttribute("stbl", stbl);
          List<BookVO> topBooks = bookService.selectTop10Books(criteria);
          topBooks.sort(Comparator.comparingInt(BookVO::getRank));
          model.addAttribute("topBooks", topBooks);
	     	      
//	      페이지 번호 그리기: 페이지 플러그인(전체테이블 행 개수 필요함)
	      int totCnt=bookService.selectBookListTotCnt(criteria);
	      paginationInfo.setTotalRecordCount(totCnt);
//	      페이지 모든 정보: paginationInfo
	      model.addAttribute("paginationInfo", paginationInfo);      
	      
	      return "book/book_all2";
	   
	   
	   
	   }
}