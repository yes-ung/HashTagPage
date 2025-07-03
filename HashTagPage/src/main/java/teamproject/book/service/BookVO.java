package teamproject.book.service;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import teamproject.common.Criteria;
@Getter
@Setter
@AllArgsConstructor //모든필드 생성자
@NoArgsConstructor  //모두없는 생성자
@ToString
@EqualsAndHashCode(callSuper = false)
public class BookVO extends Criteria {
	private String uuid;//단행본 식별번호 영문 숫자 혼합 사용
	private String categoryId;//카테고리
	private String typeId;// 타입
	private String authorId;//저자 식별번호
	private String publisherID;//예) PUB001
	private String bookOrder;//UNIQUE(book_id, book_order) DB 내부 정렬 / 재배치용
	private String bookTitle;//단행본 제목
	private String bookVolume;//기본값 : 1 (권)
	private String bookDescription;//단행본 소개
	private String bookPrice;//단행본 가격
	private String novelText;//단행본 text
	private String trend;//조회수
	private String fiveStarReview;//별점리뷰
	private String viewCount;//열람수
	private byte[] thumbnailImg;//첨부파일
	private byte[] toonImg;//웹툰 내용
	private int rank;//인기순위
	//내부 목적 사용
	private MultipartFile view_img_url;

	public BookVO(String bookTitle, String authorId, byte[] thumbnail_img
			) {
		super();
		this.bookTitle = bookTitle;
		this.authorId = authorId;
		this.thumbnailImg = thumbnail_img;		
	}
	
	public BookVO(String author_id, String five_star_review, byte[] thumbnail_img
			, byte[] toon_img) {
		super();
		this.authorId = author_id;
		this.fiveStarReview = five_star_review;
		this.thumbnailImg = thumbnail_img;
		this.toonImg = toon_img;
	}

	
}
