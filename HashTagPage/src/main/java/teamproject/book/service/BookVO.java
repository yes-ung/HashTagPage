package teamproject.book.service;

import java.time.LocalDate;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class BookVO extends Criteria {

	private String bookId;//단행본 식별번호 영문 숫자 혼합 사용
	private String categoryId;//형태(소설,만화)
	private String typeId;//장르(로맨스,무협 등등)
	private String authorId;//저자 식별번호
	private String publisherId;//예) PUB001
	private String bookOrder;//UNIQUE(book_id, book_order) DB 내부 정렬 / 재배치용
	private String bookTitle;//단행본 제목
	private String bookVolume;//기본값 : 1 (권)
	private String bookDescription;//단행본 소개
	private String bookPrice;//단행본 가격
	private LocalDate bookCreatedAt;//정렬, 통계, 추천용
	private String novelText;//소설내용글
	private String rank;//인기순위
	private String trend;//시간별 조회수(순위급상승용)
	private String starPoint;//별점
	private String viewCount;//총 조회수
	private byte[] thumbnailImg;//썸네일 이미지
	private byte[] toonImg;//웹툰 내용
	private String thumbnailImgUrl;//썸네일 이미지 호출용
	private String toonImgUrl;//웹툰 내용 호출용
	 // 업로드 받을 임시 MultipartFile (Setter 통해 byte[]로 변환 가능)
    private transient MultipartFile thumbnailFile;
    private transient MultipartFile toonFile;

	public BookVO(String bookTitle, String bookId, byte[] thumbnailImg) {
		super();
		this.bookTitle = bookTitle;
		this.bookId = bookId;
		this.thumbnailImg = thumbnailImg;
	}

	public BookVO(String bookId, String categoryId, String typeId, String authorId, String publisherId,
			String bookTitle, String bookDescription, String bookPrice, String novelText, byte[] thumbnailImg,
			byte[] toonImg) {
		super();
		this.bookId = bookId;
		this.categoryId = categoryId;
		this.typeId = typeId;
		this.authorId = authorId;
		this.publisherId = publisherId;
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
		this.novelText = novelText;
		this.thumbnailImg = thumbnailImg;
		this.toonImg = toonImg;
	}
	
	
	
}
