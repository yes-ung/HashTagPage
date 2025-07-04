/**
 *
 */
$("#addForm").validate({
  rules: {
    // 유효성 검사 규칙
    username: {       // id별명
      required: true, // 필수 입력
      minlength: 2,   // 최소 입력 길이
    },
    password: {
      // 비밀번호 필드
      required: true, // 필수 입력
      minlength: 6, // 최소 입력 길이
    },
    password_confirm: {
      // 비밀번호 재확인 필드
      required: true, // 필수 입력
      minlength: 6, // 최소 입력 길이,
      equalTo: password, // 비밀번호 필드와 동일한 값을 가지도록
    },
    email: {
      // 이메일 필드
      required: true, // 필수 입력
      email: true, // 이메일 형식 검증
    },
    tel: {
      // 연락처 필드
      required: true, // 필수 입력
      digits: true, // 숫자 형태로만 입력 가능하도록 설정
    },
    chk_agree: {
      // 약관 동의 체크박스
      required: true, // 필수 체크
    },
    hiredate: {
      required: true,     // 필수 입력
      date: true,         // 날짜 포맷(yyyy-MM-dd)
    }
  },
  messages: {
    // 오류값 발생시 출력할 메시지 수동 지정
    username: {   // id별명
      required: "필수 입력 항목입니다.",
      minlength: "최소 {0}글자 이상 입력하세요.",
    },
    password: {
      required: "필수 입력 항목입니다.",
      minlength: "최소 {0}글자 이상 입력하세요.",
    },
    password_confirm: {
      required: "필수 입력 항목입니다.",
      minlength: "최소 {0}글자 이상 입력하세요.",
      equalTo: "동일한 비밀번호를 입력해 주세요.",
    },
    email: {
      required: "필수 입력 항목입니다.",
      email: "올바른 이메일 형식으로 입력하세요.",
    },
    tel: {
      required: "필수 입력 항목입니다.",
      digits: "반드시 숫자만 입력하세요.",
    },
    chk_agree: {
      required: "필수 체크 항목입니다.",
    },
    hiredate: {
      required: "필수 입력 항목입니다.",
      date: "날짜 포맷(yyyy-MM-dd)만 입력하세요.",
    }
  },
});
