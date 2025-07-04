package teamproject.book.service;

import java.util.List;

import teamproject.common.Criteria;

public interface BookService {
	List<?> selectBookList(Criteria criteria); // 전체조회 
	List<?> selectTop10List(Criteria criteria); // top10 
	List<?> selectTrendList(Criteria criteria); // 급상승 트렌드 
	int selectBookListTotCnt(Criteria criteria);
	BookVO selectBook(String bookId);               // 상세조회
	int insert(BookVO bookVO);                // 추가 
	String update(BookVO bookVO);                // 수정 
	int delete(BookVO bookVO);					//삭제
}
