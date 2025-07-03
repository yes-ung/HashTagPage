package teamproject.book.service;

import java.util.List;

import teamproject.common.Criteria;

public interface BookService {
	List<?> selectTopBookList(Criteria criteria);
	List<?> selectBookTrendList(Criteria criteria);
	int selectBookListTotCnt(Criteria criteria); // 총 개수 구하기
	BookVO selectBook(String book_id);
	int insert(BookVO bookVO);
	List<BookVO> selectTop10Books(Criteria criteria);//상위 10위권 조회
}
