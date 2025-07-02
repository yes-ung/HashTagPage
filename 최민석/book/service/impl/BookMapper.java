package egovframework.example.book.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.book.service.BookVO;
import egovframework.example.common.Criteria;

@Mapper
public interface BookMapper {
	public List<?> selectTopBookList(Criteria criteria);//top10
	public List<?> selectBookTrendList(Criteria criteria);//급상승
	public int selectBookListTotCnt(Criteria criteria); // 총 개수 구하기
	public BookVO selectBook(String book_id);//상세조회
	public int insert(BookVO bookVO);//insert
	public List<BookVO> selectTop10Books(Criteria criteria);//상위 10위권 조회
}
