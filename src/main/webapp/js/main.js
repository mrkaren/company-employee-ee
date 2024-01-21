// document.getElementById("testBtn").onmouseover = function () {
//     let elementById = document.getElementById("test");
//     elementById.style.backgroundColor = "blue";
// }

document.getElementById("loginBtn").onclick = function (e) {
    let loginInput = document.getElementById("loginEmail");
    let loginPass = document.getElementById("loginPass");

    let message = "";

    if (loginInput.value == null || loginInput.value.length < 3) {
        message += "Email is required";
    }
    if (loginPass.value == null || loginPass.value.length < 5) {
        message += "Password is invalid";
    }

    if (message !== "") {
        e.preventDefault()
        document.getElementById("errorMessage").innerHTML = message;
    }

}

