package teamproject.book.web;

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

import teamproject.book.service.BookService;
import teamproject.book.service.BookVO;
import teamproject.common.Criteria;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/admin.do")
	public String selectBookList(@ModelAttribute Criteria criteria,
			Model model) {
//		criteria.setPageUnit(10);
		PaginationInfo paginationInfo=new PaginationInfo();
		paginationInfo.setCurrentPageNo(criteria.getPageIndex());
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit());
		criteria.setFirstIndex(paginationInfo.getFirstRecordIndex());
		List<?> books=bookService.selectBookList(criteria);
		model.addAttribute("books", books);
		List<?> topBooks=bookService.selectTop10List(criteria);
		model.addAttribute("topBooks", topBooks);
		List<?> trendyBooks=bookService.selectTrendList(criteria);
		model.addAttribute("trendyBooks", trendyBooks);
		int totCnt=bookService.selectBookListTotCnt(criteria);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);		
		return "admin/main";
	}
	@GetMapping("/admin/additionBook.do")
	public String createBookView() {
		return "admin/add_book";
	}
	
	@PostMapping("/book/add.do")
	public String insert(@ModelAttribute BookVO bookVO,
			@RequestParam(required = false) MultipartFile toonFile,
			 @RequestParam(required = false) MultipartFile thumbnailFile) throws Exception {
//		예외 처리
		byte[] thumbnailData = (thumbnailFile != null && !thumbnailFile.isEmpty())
		        ? thumbnailFile.getBytes() : null;

		   byte[] toonData = (toonFile != null && !toonFile.isEmpty())
		        ? toonFile.getBytes() : null;
		BookVO insertBookVO=new BookVO(bookVO.getBookId(),bookVO.getCategoryId(),bookVO.getTypeId(),bookVO.getAuthorId(),bookVO.getPublisherId(),bookVO.getBookTitle(),bookVO.getBookDescription(),bookVO.getBookPrice(),bookVO.getNovelText(),thumbnailData,toonData);
		bookService.insert(insertBookVO);
		return "redirect:/admin.do";
	}
	@GetMapping("/book/download.do")
	@ResponseBody
	public ResponseEntity<byte[]> fileDownload(@RequestParam(defaultValue = "") String bookId,
	        @RequestParam(defaultValue = "thumbnail") String type) {
		BookVO bookVO=bookService.selectBook(bookId);
		
		byte[] imageData;
	    String fileName;
	    
	    if ("content".equalsIgnoreCase(type)) {
	        imageData = bookVO.getToonImg(); // 새로 추가된 이미지
	        fileName = bookVO.getBookId() + "_content.jpg";
	    } else {
	        imageData = bookVO.getThumbnailImg(); // 기존 썸네일
	        fileName = bookVO.getBookId() + "_thumbnail.jpg";
	    }
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<>(imageData, headers, HttpStatus.OK); 
	}
	@PostMapping("/book/delete.do")
	public String delete(@ModelAttribute BookVO bookVO) {
		bookService.delete(bookVO);
		return "redirect:/admin.do";
	}
	@PostMapping("/book/edit.do")
	public String update(@ModelAttribute BookVO bookVO) {
		bookService.update(bookVO);
		return "redirect:/admin.do";
	}
}