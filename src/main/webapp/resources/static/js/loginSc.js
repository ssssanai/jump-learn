const inputs = document.querySelectorAll(".input");

function addcl() {
    let parent = this.parentNode.parentNode;
    // 입력 필드에 값이 있거나 포커스가 있을 때 'focus' 클래스를 추가
    if (this.value !== "") {
        parent.classList.add("focus");
    } else {
        parent.classList.add("focus");
    }
}

function remcl(){
    let parent = this.parentNode.parentNode;
    if(this.value == ""){
        parent.classList.remove("focus");
    }
}

inputs.forEach(input => {
    input.addEventListener("focus", addcl);
    input.addEventListener("blur", remcl);
});

// 비밀번호 눈 아이콘 클릭시 비밀번호 표시 및 아이콘 변경
document.getElementById('togglePassword').addEventListener('click', function () {
    const passwordInput = document.getElementById('password');
    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
    passwordInput.setAttribute('type', type);
    this.textContent = type === 'password' ? '😍' : '😴'; // 아이콘 변경
});