package egovframework.example.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : GGG
 * @fileName : Criteria
 * @since : 2024-04-02 description : 
 *      공통 클래스 
 *      페이징처리 목적
 *      전자정부 프레임워크에서 가져옴
 *      일부 수정
 */
@Getter
@Setter
@ToString
public class Criteria {
	/** 검색조건 */
	private String searchCondition = "";

	/** 검색Keyword */
	private String searchKeyword = "";

	/** 검색사용여부 */
	private String searchUseYn = "";

	/** 현재페이지 */
	private int pageIndex = 1;

	/** 페이지갯수: 화면에 보일 행 개수 */
	private int pageUnit = 3;

	/** firstIndex: 등차숫자 자동계산 */
	private int firstIndex = 1;

	private String insertTime;

	private String updateTime;
}
