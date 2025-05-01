const registerForm = document.getElementById('registerForm');
const userIdInput = document.getElementById('userId');
const userPwInput = document.getElementById('userPw');
const userPwConfirmInput = document.getElementById('userPwConfirm');
const realNameInput = document.getElementById('realName');
const birthDateInput = document.getElementById('birthDate');
const userEmailInput1 = document.getElementById('userEmail');
const userEmailInput2 =document.getElementById('select_email1');


// 에러 메시지를 표시할 span 요소
const userIdError = document.getElementById('userIdError');
const userPwError = document.getElementById('userPwError');
const userPwConfirmError = document.getElementById('userPwConfirmError');
const realNameError = document.getElementById('realNameError');
const birthDateError = document.getElementById('birthDateError');
const userEmailError = document.getElementById('userEmailError');

registerForm.addEventListener('submit', function(event) {
    event.preventDefault();

    resetErrors();

    let isValid = true;

    const userEmail = (userEmailInput1.value+"@"+ userEmailInput2.value).trim();


    if (!validateUserId(userIdInput.value)) {
        isValid = false;
    }
    if (document.getElementById("idCheck").value !== "true") {
        alert("아이디 중복 확인을 해주세요.");
        isValid = false;
    }
    if (!validateUserPw(userPwInput.value)) {
        isValid = false;
    }
    if (!validateUserPwConfirm(userPwInput.value, userPwConfirmInput.value)) {
         isValid = false;
    }
    if (!validateRealName(realNameInput.value)) {
        isValid = false;
    }
    if (!validateBirthDate(birthDateInput.value)) {
        isValid = false;
    }
    if (!validateUserEmail(userEmail)) {
        isValid = false;
    }
    const codeConfirmValue = document.getElementById('codeConfirm').value;
    if (codeConfirmValue !== "true") {
        alert("이메일 인증을 완료해주세요.");
        isValid = false;
    }


    // 모든 유효성 검사를 통과했을 때
    if (isValid) {
         document.getElementById('hiddenEmail').value = userEmail;
         registerForm.submit();
    } else {
        console.log('다시 회원가입을 시도 해주세요');
    }
});

// 모든 에러 메시지를 비우는 함수
function resetErrors() {
    userIdError.textContent = '';
    userPwError.textContent = '';
    userPwConfirmError.textContent = '';
    realNameError.textContent = '';
    birthDateError.textContent = '';
    userEmailError.textContent = '';
}

// 아이디 검사
function validateUserId(id) {
    const trimmedId = id.trim();
    if (trimmedId === '') {
        userIdError.textContent = '아이디를 입력해주세요.';
        return false;
    }
    if (trimmedId.includes(' ')) {
        userIdError.textContent = '아이디에는 공백을 사용할 수 없습니다.';
        return false;
    }
    // 8자 이상 20자 이하 (19자까지)
    if (trimmedId.length < 8 || trimmedId.length >= 20) {
        userIdError.textContent = '아이디는 8자 이상 20자 미만이어야 합니다.';
        return false;
    }

    const regex = /^[a-z0-9]+$/;
    if (!regex.test(trimmedId)) {
        userIdError.textContent = '아이디는 영문 소문자와 숫자만 사용할 수 있습니다.';
        return false;
    }
    return true;
}

// 비밀번호 눈 아이콘 클릭시 비밀번호 표시 및 아이콘 변경
document.getElementById('togglePassword').addEventListener('click', function () {
    const passwordInput = document.getElementById('userPw');
    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
    passwordInput.setAttribute('type', type);
    this.textContent = type === 'password' ? '👁️' : '🙈'; // 아이콘 변경
});

// 비밀번호 검사
function validateUserPw(pw) {
    const trimmedPw = pw.trim();
    if (trimmedPw === '') {
        userPwError.textContent = '비밀번호를 입력해주세요.';
        return false;
    }
    if (trimmedPw.includes(' ')) {
        userPwError.textContent = '비밀번호에는 공백을 사용할 수 없습니다.';
        return false;
    }
    // 8자 이상 20자 이하 (19자까지)
    if (trimmedPw.length < 8 || trimmedPw.length >= 20) {
        userPwError.textContent = '비밀번호는 8자 이상 20자 미만이어야 합니다.';
        return false;
    }

    const hasLowercase = /[a-z]/.test(trimmedPw); // 영문 소문자 포함
    const hasNumber = /[0-9]/.test(trimmedPw); // 숫자 포함
    const hasSpecial = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/.test(trimmedPw); // 특수문자 포함

    if (!hasLowercase || !hasNumber || !hasSpecial) {
        userPwError.textContent = '비밀번호는 영문 소문자, 숫자, 특수문자를 모두 포함해야 합니다.';
        return false;
    }

    return true;
}

// 비밀번호 확인 검사
function validateUserPwConfirm(pw, pwConfirm) {
    const trimmedPwConfirm = pwConfirm.trim();
    if (trimmedPwConfirm === '') {
        userPwConfirmError.textContent = '비밀번호 확인을 입력해주세요.';
        return false;
    }
    if (trimmedPwConfirm.includes(' ')) {
        userPwConfirmError.textContent = '비밀번호 확인에는 공백을 사용할 수 없습니다.';
        return false;
    }

    if (pw !== trimmedPwConfirm) {
        userPwConfirmError.textContent = '비밀번호와 비밀번호 확인이 일치하지 않습니다.';
        return false;
    }
    return true;
}


// 이름 검사
function validateRealName(name) {
    const trimmedName = name.trim();
    if (trimmedName === '') {
        realNameError.textContent = '이름을 입력해주세요.';
        return false;
    }
    if (trimmedName.includes(' ')) {
        realNameError.textContent = '이름에는 공백을 사용할 수 없습니다.';
        return false;
    }

    if (trimmedName.length < 1 || trimmedName.length >= 10) {
        realNameError.textContent = '이름은 1자 이상 10자 미만이어야 합니다.';
        return false;
    }

    const regex = /^[가-힣]+$/;
    if (!regex.test(trimmedName)) {
        realNameError.textContent = '이름은 한글만 사용할 수 있습니다.';
        return false;
    }
    return true;
}

// 생년월일 검사
function validateBirthDate(date) {
    const trimmedDate = date.trim();
    if (trimmedDate === '') {
        birthDateError.textContent = '생년월일을 입력해주세요.';
        return false;
    }
    if (trimmedDate.includes(' ')) {
        birthDateError.textContent = '생년월일에는 공백을 사용할 수 없습니다.';
        return false;
    }

    // YYYY-MM-DD 형식인 졍규 표현식식
    // 실제 날짜 유효성 (예: 2월 30일 같은 잘못된 날짜)까지 검사
    const regex = /^\d{4}-\d{2}-\d{2}$/;
    if (!regex.test(trimmedDate)) {
        birthDateError.textContent = '생년월일을 YYYY-MM-DD 형식으로 입력해주세요.';
        return false;
    }

    // 추가: 실제 유효한 날짜인지 검사 (YYYY-MM-DD 형식은 맞지만 2월 30일 같은 경우)
    const [year, month, day] = trimmedDate.split('-').map(Number);
    const dateObj = new Date(year, month - 1, day); // 월은 0부터 시작하므로 month-1
    // Date 객체가 생성된 후, 원래 입력된 연/월/일과 같은지 확인하여 유효한 날짜인지 판별
    if (dateObj.getFullYear() !== year || dateObj.getMonth() !== month - 1 || dateObj.getDate() !== day) {
        birthDateError.textContent = '유효하지 않은 날짜입니다.';
        return false;
    }
    // 추가: 미래 날짜인지 검사 (보통 생년월일은 현재 날짜보다 이전이어야 함)
    const today = new Date();
    today.setHours(0, 0, 0, 0); // 시간 정보를 초기화하여 날짜만 비교
    if (dateObj > today) {
        birthDateError.textContent = '생년월일은 미래 날짜일 수 없습니다.';
        return false;
    }

    today.setHours(0, 0, 0, 0);
    if (dateObj > today) {
        birthDateError.textContent = '생년월일은 미래 날짜일 수 없습니다.';
        return false;
    }


    return true; // 모든 검사 통과
}

// 이메일 검사: 올바른 형식, 공백 불가
function validateUserEmail(userEmail) {
    const trimmedEmail = userEmail
    console.log(trimmedEmail + "이메일");
    if (trimmedEmail === '') {
        userEmailError.textContent = '이메일을 입력해주세요.';
        return false;
    }
    if (trimmedEmail.includes(' ')) {
        userEmailError.textContent = '이메일에는 공백을 사용할 수 없습니다.';
        return false;
    }
    // 기본적인 이메일 형식을 확인하는 정규표현식
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!regex.test(trimmedEmail)) {
        userEmailError.textContent = '올바른 이메일 형식이 아닙니다.';
         return false;
     }
    return true; // 모든 검사 통과
}

// 미래 날짜 선택 불가
var now_utc = Date.now()
var timeOff = new Date().getTimezoneOffset()*60000;
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("birthDate").setAttribute("max", today);

// 오늘 날짜를 YYYY-MM-DD 형식으로 가져오는 함수
function getTodayString() {
    const today = new Date();
    const year = today.getFullYear();
    const month = ('0' + (today.getMonth() + 1)).slice(-2); // 월은 0부터 시작하므로 1을 더하고 두 자리로 맞춤
    const day = ('0' + today.getDate()).slice(-2); // 일을 두 자리로 맞춤
    return `${year}-${month}-${day}`;
}

// 생년월일 입력 요소를 가져옵니다.
const birthDateInput1 = document.getElementById('birthDate');

// 생년월일 입력 요소가 있다면 (HTML에 해당 id의 요소가 있을 때)
if (birthDateInput1) {
    // 오늘 날짜를 계산해서 max 속성에 설정합니다.
    birthDateInput1.max = getTodayString();
}

document.getElementById("idVali").addEventListener("click", function () {
    const userIdInput = document.getElementById("userId");
    const userIdError = document.getElementById("userIdError");
    const idCheckHidden = document.getElementById("idCheck");

    const trimmedId = userIdInput.value.trim();
    userIdError.textContent = "";

    // 1. 공백 체크
    if (trimmedId.includes(" ")) {
        userIdError.textContent = "아이디에는 공백을 사용할 수 없습니다.";
        idCheckHidden.value = "";
        return;
    }

    // 2. 길이 체크
    if (trimmedId.length < 8 || trimmedId.length >= 20) {
        userIdError.textContent = "아이디는 8자 이상 20자 미만이어야 합니다.";
        idCheckHidden.value = "";
        return;
    }

    // 3. 형식 체크 (소문자, 숫자만)
    const regex = /^[a-z0-9]+$/;
    if (!regex.test(trimmedId)) {
        userIdError.textContent = "아이디는 영문 소문자와 숫자만 사용할 수 있습니다.";
        idCheckHidden.value = "";
        return;
    }

    // 4. 서버 중복 체크
    fetch("/member/checkId?id=" + encodeURIComponent(trimmedId))
        .then(response => response.text())
        .then(result => {
            if (result === "OK") {
                alert("사용 가능한 아이디입니다.");
                idCheckHidden.value = "true"; // 중복확인 통과 표시
            } else {
                userIdError.textContent = "이미 존재하는 아이디입니다.";
                idCheckHidden.value = ""; // 실패
            }
        })
        .catch(err => {
            alert("서버 오류가 발생했습니다.");
            console.error(err);
        });
});

let sendCode = "";

document.getElementById('emailCheck').addEventListener('click', function (e) {
    e.preventDefault();

    const emailId = document.getElementById('userEmail').value.trim();
    const emailSelect = document.getElementById('select_email1').value;
    let emailDomain = emailSelect;

    const emailError = document.getElementById('userEmailError');

    if (emailId === '' || emailDomain === '') {
        emailError.textContent = '이메일을 입력해주세요.';
        emailError.style.color = 'red';
        return;
    }

    const fullEmail = emailId + '@' + emailDomain;


    if (!emailError) {
        console.error("emailError 요소를 찾을 수 없습니다. HTML에 id='emailError'가 있어야 합니다.");
        return;
    }

    // 이메일 전송 요청
    fetch("/member/emailCheck?email=" + encodeURIComponent(fullEmail))
        .then(response => response.text())
        .then(response => {
            if (response.startsWith("success:")) {
                sendCode = response.split(":")[1];
                alert("이메일이 전송되었습니다. 코드 확인 후 입력 해주세요.");;
            } else if (response.startsWith("fail:")) {
                const errorMsg = response.split(":")[1];
                alert(errorMsg || "이메일 전송 실패. 다시 시도해주세요.");
            } else {
                alert("알 수 없는 서버 응답입니다.");
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("서버 통신 오류가 발생했습니다.");
        });

});

document.getElementById('codeCheck').addEventListener('click', function () {
    const userInput = document.getElementById('userCode').value.trim();
    if (userInput === sendCode) {
        document.getElementById('codeConfirm').value = true;
        alert("✅ 인증 성공!");
    } else {
        alert("❌ 인증 코드가 일치하지 않습니다.");
    }
});
