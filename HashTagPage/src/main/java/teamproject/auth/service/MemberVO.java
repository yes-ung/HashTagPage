package teamproject.auth.service;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import teamproject.common.Criteria;

/**
 * @author user
 *   VO == 테이블
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class MemberVO extends Criteria {
   
   private String userId      ;
   private String userEmail   ;
   private String userPw       ; 
   private String userName      ;
   private LocalDate joinDate      ;
   private LocalDate userDeletedAt ;
   private String userRole      ;
   private String userIsDeleted ;
                     
}
