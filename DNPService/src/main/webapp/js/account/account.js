function addAccount() {
	if (!checkAddAccount()) {
		return;
	}

	var loginId = $("#loginId").val();
	var password = $("#password").val();
	var rsaPublicKeyModulus = $("#rsaPublicKeyModulus").val();
	var rsaPublicKeyExponent = $("#rsaPublicKeyExponent").val();
	var name = $("#name").val();
	var rsa = new RSAKey();
	rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);

	// 사용자ID와 비밀번호를 RSA로 암호화한다.
	var securedLoginId = rsa.encrypt(loginId);
	var securedPassword = rsa.encrypt(password);
	var param = {};
	param["loginId"] = securedLoginId;
	param["password"] = securedPassword;
	param["name"] = name;

	// POST 로그인 폼에 값을 설정하고 발행(submit) 한다.
	AMI_PROXY.invokeOpenAPI("addAccount", "json", param, renderAddAccount, function(){
		window.location.reload();
	});
}

function renderAddAccount(_result, head, _param, _status, request) {
	if (head.resultCode == "0") {
		alert("성공하였습니다.");
		window.location.href = request.getResponseHeader("Location");
	}
}

function checkAddAccount() {
	var password = $("#password").val();
	var passwordCheck = $("#passwordCheck").val();

	if (!valueCheck("loginId")) {
		alert("ID를 확인해주세요");
		return false;
	} else if (!valueCheck("password") || !valueCheck("passwordCheck")) {
		alert("비밀번호를 확인해주세요");
		return false;
	} else if (!valueCheck("name")) {
		alert("이름을 확인해주세요");
		return false;
	} else if (password != passwordCheck) {
		alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
		$("#password").focus();
		return false;
	}

	return true;
}

function valueCheck(id) {
	if ($.trim($("#" + id).val()) == "") {
		$("#" + id).focus();
		return false;
	}

	return true;
}

function login() {
	var loginId = $("#loginId").val();
	var password = $("#password").val();
	var rsaPublicKeyModulus = $("#rsaPublicKeyModulus").val();
	var rsaPublicKeyExponent = $("#rsaPublicKeyExponent").val();
	var rsa = new RSAKey();
	rsa.setPublic(rsaPublicKeyModulus, rsaPublicKeyExponent);

	// 사용자ID와 비밀번호를 RSA로 암호화한다.
	var securedLoginId = rsa.encrypt(loginId);
	var securedPassword = rsa.encrypt(password);
	var param = {};
	param["loginId"] = securedLoginId;
	param["password"] = securedPassword;

	AMI_PROXY.invokeOpenAPI("authenticate", "json", param, renderAuthenticate);
}

function renderAuthenticate(response, param, status, request) {
	if (response.resultCode == "0") {
		alert("성공하였습니다.");
		// window.location.href = request.getResponseHeader("Location");
	}
	// console.trace(response);
	// console.log(param);
	// console.log(status);
	// console.log(request);
	// console.log(request.getResponseHeader("Location"));
}