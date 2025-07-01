/**
 * 
 */
package egovframework.example.gallery.service;

import org.springframework.web.multipart.MultipartFile;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author user
 * 퀴즈: 필드(MultipartFile image 추가)
 *     생성자 2개 추가
 *      1) String galleryTitle, byte[] galleryData
 *      2) String uuid, String galleryTitle, byte[] galleryData
 * 나머지는 TB_GALLERY 테이블 보고 만들어보기
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GalleryVO extends Criteria {
   private String uuid;            // 기본키(자바 코딩)
   private String galleryTitle;    // 제목
   private byte[] galleryData;     // 첨부파일
   private MultipartFile image;    // 내부 목적 사용
   private String galleryFileUrl;  // 이미지 다운로드를 위한 URL
   
//   필드 3개
   public GalleryVO(String uuid, String galleryTitle, byte[] galleryData) {
      super();
      this.uuid = uuid;
      this.galleryTitle = galleryTitle;
      this.galleryData = galleryData;
   }

//   필드 2개
   public GalleryVO(String galleryTitle, byte[] galleryData) {
      super();
      this.galleryTitle = galleryTitle;
      this.galleryData = galleryData;
   }
}





