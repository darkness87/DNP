/**
 * 페이지 네비게이션을 만듦
 * @param {int} totalCnt 해당 리스트의 전체 페이지
 * @param {int} pno 조회할 페이지 번호
 * @param {int} mLPP 페이지당 리스트 개수 
 * @param {string} pageActionType 페이지 타입
 */
function displayPagenation(totalCnt, pno, mLPP, pageActionType) {
	var pageRange = 10;
	var totalPage = (totalCnt <= parseInt(mLPP))? 0 : Math.floor(totalCnt / mLPP) + ((totalCnt % parseInt(mLPP)==0) ? 0:1);
	var nStart = (Math.floor((pno - 1)/pageRange) * pageRange) + 1;
	var nEnd = nStart + pageRange;
	var nBefore = nStart - 10 
	var nNext = nStart + 10;

	if (totalPage == 0) {
		totalPage = 1;
	}

	if (nEnd > totalPage) {
		nEnd = totalPage + 1;
	}

	if (nBefore > 0) {
		$("#firstPage").show();
		$("#firstPage").find("a").attr("onclick", "jvascript:displayPagenation(" + totalCnt + ", " + nBefore + ", " + mLPP + ", '" + pageActionType + "');");
	} else {
		$("#firstPage").hide();
	}

	if (pno > 1) {
		$("#prevPage").show();
		$("#prevPage").find("a").attr("onclick", "jvascript:displayPagenation(" + totalCnt + ", " + (pno-1) + ", " + mLPP + ", '" + pageActionType + "');");
	} else {
		$("#prevPage").hide();
	}

	if (pno < totalPage) {
		$("#nextPage").show();
		$("#nextPage").find("a").attr("onclick", "jvascript:displayPagenation(" + totalCnt + ", " + (pno+1) + ", " + mLPP + ", '" + pageActionType + "');");
	} else {
		$("#nextPage").hide();
	}

	if (nNext <= totalPage) {
		$("#lastPage").show();
		$("#lastPage").find("a").attr("onclick", "jvascript:displayPagenation(" + totalCnt + ", " + nNext + ", " + mLPP + ", '" + pageActionType + "');");
	} else {
		$("#lastPage").hide();
	}

	$("#pagenation").empty();

	for (; nStart<nEnd; nStart++) {
		var view = PAGE_CONTROLLER.getTopicPageAppend("pageNumber", "", "pagenation");

		if (pno == nStart) {
			view.addClass("active");
		}

		view.find("a").text(nStart);
	}

	$("#pagenation").show();
}

/**
 * [ 홈 > 설비 관리 > DCU ]와 같은 현재의 네비게이터를 구성해준다.
 */
function displayNavigator() {
	var menuView = $("#menu");
	var subMenuView = $("#subMenu");
	var home = AMI_RES.get("ami_menu_home");
	var menu = $.trim(menuView.find(".active").text());
	var subMenu = $.trim(subMenuView.find(".active").text());

	$("#navigator").text(home + " > " + menu + " > " + subMenu);
}