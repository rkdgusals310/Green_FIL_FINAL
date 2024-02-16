
document.getElementById('btnJoin').addEventListener('click', function() {
    var email = document.getElementById('uemail').value;
    var id = document.getElementById('uid').value;
    var pswd1 = document.getElementById('upass').value;
    var pswd2 = document.getElementById('upass2').value;
    var name = document.getElementById('uname').value;
    var mobile = document.getElementById('umobile').value;

    // 이메일 유효성 검사 (간단한 형식 체크)
    var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (!emailRegex.test(email)) {
        alert('올바른 이메일 주소를 입력하세요.');
        return;
    }

    // 아이디 유효성 검사 (최소 4자리 이상)
    if (id.length < 4) {
        alert('아이디는 최소 4자리 이상이어야 합니다.');
        return;
    }

    // 비밀번호 일치 여부 확인
    if (pswd1 !== pswd2) {
        alert('비밀번호가 일치하지 않습니다.');
        return;
    }

    // 비밀번호 길이 체크 (최소 4자리 이상)
    if (pswd1.length < 4) {
        alert('비밀번호는 최소 4자리 이상이어야 합니다.');
        return;
    }

    // 이름 유효성 검사 (최소 3자리 이상)
    if (name.length < 3) {
        alert('이름은 최소 3자리 이상이어야 합니다.');
        return;
    }

    // 휴대전화 유효성 검사 (숫자로만 이루어져 있고 11자리)
    var mobileRegex = /^[0-9]{11}$/;
    if (!mobileRegex.test(mobile)) {
        alert('휴대전화 번호를 숫자로 입력하세요 (11자리).');
        return;
    }

    // 모든 유효성 검사 통과시 폼 제출
    console.log("회원가입 성공!");
    document.join.submit(); // 주석 처리: 직접 제출하지 않고 페이지 이동만 수행
});
