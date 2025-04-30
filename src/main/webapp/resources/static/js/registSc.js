const registerForm = document.getElementById('registerForm');
const userIdInput = document.getElementById('userId');
const userPwInput = document.getElementById('userPw');
const userPwConfirmInput = document.getElementById('userPwConfirm');
const realNameInput = document.getElementById('realName');
const birthDateInput = document.getElementById('birthDate');
const userEmailInput = document.getElementById('userEmail');

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

    if (!validateUserId(userIdInput.value)) {
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
    if (!validateUserEmail(userEmailInput.value)) {
        isValid = false;
    }


    // 모든 유효성 검사를 통과했을 때
    if (isValid) {
        // 여기에 폼 제출이나 다음 단계로 넘어가는 코드를 작성합니다.
        // 예: 실제 폼 제출하기
        // registerForm.submit();

        // 예: AJAX로 데이터 전송하기
        // fetch('/register', { method: 'POST', body: new FormData(registerForm) })
        //   .then(response => response.json())
        //   .then(data => { console.log('Success:', data); })
        //   .catch((error) => { console.error('Error:', error); });

        // 간단하게 성공 메시지 보여주기
        alert('회원가입 성공! (실제 제출은 막았습니다)');
        console.log('폼 데이터:', {
            userId: userIdInput.value,
            userPw: userPwInput.value, // 실제로는 비밀번호를 콘솔에 찍지 마세요! 보안상 위험합니다.
            realName: realNameInput.value,
            birthDate: birthDateInput.value,
            userEmail: userEmailInput.value
        });
    } else {
        console.log('유효성 검사 실패');
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
function validateUserEmail(email) {
     const trimmedEmail = email.trim();
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