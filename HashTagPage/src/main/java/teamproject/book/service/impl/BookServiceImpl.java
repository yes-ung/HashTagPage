package teamproject.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import teamproject.book.service.BookService;
import teamproject.book.service.BookVO;
import teamproject.common.Criteria;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<?> selectBookList(Criteria criteria) {
		// TODO Auto-generated method stub
		return bookMapper.selectBookList(criteria);
	}

	@Override
	public List<?> selectTop10List(Criteria criteria) {
		// TODO Auto-generated method stub
		return bookMapper.selectTop10List(criteria);
	}

	@Override
	public List<?> selectTrendList(Criteria criteria) {
		// TODO Auto-generated method stub
		return bookMapper.selectTrendList(criteria);
	}

	@Override
	public int selectBookListTotCnt(Criteria criteria) {
		// TODO Auto-generated method stub
		return bookMapper.selectBookListTotCnt(criteria);
	}

	@Override
	public BookVO selectBook(String bookId) {
		// TODO Auto-generated method stub
		return bookMapper.selectBook(bookId);
	}

	@Override
	public int insert(BookVO bookVO) {
		// TODO Auto-generated method stub
		String downloadURL = generateDownloadUrl(bookVO.getBookId());
		String contentURL = generateContentDownloadUrl(bookVO.getBookId());
		bookVO.setThumbnailImgUrl(downloadURL);
		bookVO.setToonImgUrl(contentURL);
		return bookMapper.insert(bookVO);
	}
	 public String generateDownloadUrl(String bookId) {
//		 인터넷 주소 체계 : http://localhost:8080/경로(path)?쿼리스트링
//		 기본 주소(ContextPath) : http://localhost:8080
//		 URL 만들어주는 자바 클래스 : ServletUriComponentsBuilder
	        return ServletUriComponentsBuilder      
	          .fromCurrentContextPath()    // 스프링 기본주소 가져옴: http://localhost:8080
 	          .path("/book/download.do") // 경로 붙이기 : /fileDb/download.do
	          .query("bookId="+bookId+"&type=thumbnail")         // 쿼리스트링 붙이기 : ?uuid=uuid
	          .toUriString();              // 위에꺼 조합해줌
//	최종형태 :  http://localhost:8080/fileDb/download.do?uuid=uuid    
	   }
	 public String generateContentDownloadUrl(String bookId) {
//		 인터넷 주소 체계 : http://localhost:8080/경로(path)?쿼리스트링
//		 기본 주소(ContextPath) : http://localhost:8080
//		 URL 만들어주는 자바 클래스 : ServletUriComponentsBuilder
	        return ServletUriComponentsBuilder      
	          .fromCurrentContextPath()    // 스프링 기본주소 가져옴: http://localhost:8080
 	          .path("/book/download.do") // 경로 붙이기 : /fileDb/download.do
	          .query("bookId="+bookId+"&type=content")         // 쿼리스트링 붙이기 : ?uuid=uuid
	          .toUriString();              // 위에꺼 조합해줌
//	최종형태 :  http://localhost:8080/fileDb/download.do?uuid=uuid    
	   }
	
	
	
	@Override
	public String update(BookVO bookVO) {
		// TODO Auto-generated method stub
		return bookMapper.update(bookVO);
	}

	@Override
	public int delete(BookVO bookVO) {
		// TODO Auto-generated method stub
		return bookMapper.delete(bookVO);
	}
}