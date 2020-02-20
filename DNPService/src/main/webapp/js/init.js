var DEBUG_MODE = false;
var TIME_OUT = 15000;

/**
 * main페이지를 구성하기전에 필요한 필수요소들을 정리한다.
 */
function initMain() {
	//팝업 닫기
	PAGE_CONTROLLER.closePopupPage();
}
/**
 * 메뉴에 따른 history back을 구축한다.
 */
function initMenu() {
	$.history.on("load change push", function(_event, url, _type) {
		$("#mainBody").removeClass("container-dashboard");
		$("#mainBody").removeClass("container-control");

		if (url == "") {
			$("#mainBody").addClass("container-dashboard");
			url = "dashboard";
		} else {
			$("#mainBody").addClass("container-control");
		}

		initMain();
		showMenuPage(url);
	}).listen("hash");
	$("#menu").on("click", "a", function(event) {
		var view = $(this);
		$.history.push(view.attr("href"));
		event.preventDefault();
	});
}

/**
 * 서브 메뉴 이동시 초기화 되야하는 것들 정리 
 */
function initSubMenu() {
	var view = $("#pageBody");
	view.find("#firstPage").hide();
	view.find("prevPage").hide();
	view.find("#pagenation").hide();
	view.find("#nextPage").hide();
	view.find("#lastPage").hide();
}

/**
 * 공통적으로 표기되야하는 방식 지정 에러방식이나 처리 결과에 대한 내용을 담아서 공통 출력한다.
 * @param {string} message 출력할 메시지내용
 */
function systemMessage(message) {
	alert(message);
}

//로그
function LOG(msg){
	if (DEBUG_MODE && window.console) {
		console.log(msg);
	}
}