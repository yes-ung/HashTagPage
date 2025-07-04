/**
 *
 */ 
$("#addForm").validate({
  rules: {
    // 유효성 검사 규칙
    email: {          // id별명
      required: true, // 필수 입력
      email: true,    // 이메일 형식 검증
    },
    password: {       // id별명
      required: true, // 필수 입력
      minlength: 6,   // 최소 입력 길이
    }
  },
  messages: {
    // 오류값 발생시 출력할 메시지 수동 지정
    email: {   // id별명
      required: "필수 입력 항목입니다.",
      email: "올바른 이메일 형식으로 입력하세요.",
    },
    password: {
      required: "필수 입력 항목입니다.",
      minlength: "최소 {0}글자 이상 입력하세요.",
    }
  }
});
