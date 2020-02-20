/**
 *  PAGE_CONTROLLER 
 *  
 *  페이지 이동을 컨트롤하는 모듈
 *  <pre>
 *  viewStack : stack이 보관되는 id 저장소
 *  templateString : page navigation 식별코드
 *  viewAttrMap : stack에 따른 action할 저장소
 *  savePageId : 서블릿으로 통해 받아온 페이지를 보관하는 div ID
 *  viewPageId : savePageId에 보관된 페이지들을 실제로 보여주는 div ID
 *  viewContentsPageId : savePageId에 보관된 페이지들을 컨텐츠 페이지에 실제로 보여주는 div ID 
 *  1) init(pageArray) : 뷰페이지들을 로딩
 *  	pageArray (String[]): 로딩할 뷰페이지의 리스트
 *  
 *  2) goBack(isRefresh) : '뒤로 가기'
 *  	isRefresh (boolean): 이 값을 true로 하면 돌아가는 페이지의 controlFN() 을 다시 실행해서 페이지를 refresh 하게 된다 
 *  
 *  3) showPage(id, controlFN) : 함수로 페이지 전환하기 
 *  	id (String) : 뷰페이지의 ID , 최상단 div tag 에 id 속성으로 정의함,
 *  	controlFN : id 에 해당하는 페이지를 보여주기 위해, 데이터를 가져오고 데이터를 렌더링하는 함수
 *  
 *  4) cleanViewStack() : stack에 있는 데이터를 모두 지운다.
 *  
 *  5) pushPage() : stack의 push개념
 *  
 *  6) popPage() : stack의 pop개념
 *  
 *  7) getPrevPage() : stack이 바라보고 있는 전페이지의 div tag를 가져온다.
 *  
 *  8) getPrevPageId() : stack이 바라보고 있는 전페이지 div id값을 가져온다.
 *  
 *  9) getCurrentPage() : stack이 바라보고 있는 페이지의 div tag를 가져온다.
 *  
 *  10) getCurrentPageId() : stack이 바라보고 있는 페이지 div id값을 가져온다.
 *  
 *  11) getNewPage(id, page, isRefresh) : 서블릿으로부터 가져온 페이지를 임시저장 div tag 에다가 보관한다.
 *  	id (String) : 뷰페이지의 ID , 최상단 div tag 에 id 속성으로 정의함,
 *  	page(string) : 서블릿으로부터 가져온 html element tags
 *  	isRefresh(boolean) : 해당 페이지를 viewing할 경우 refresh 여부
 *  
 *  12) refreshPage(page) : html element tag들을 그려주는 역할을 한다.
 *  	page(string) : 서블릿으로부터 가져온 html element tags
 *  
 *  13) listingStack() : 현재 stack에 쌓여져 있는 정보를 console.log로 표시한다.
 *  </pre>
 */
var PAGE_CONTROLLER = {
	viewURL : "",
	viewStack : [],
	viewPage : [],
	templateString : "TEMPLATE_",
	viewAttrMap : {},
	viewLocation : "",
	savePageId : "body_pages",				// div를 보관할 div ID
	// viewPageId : "contents_details",

	/**
	 * targetViewId내에 topicType의 템플릿을 앞쪽에 삽입한다.
	 * @param {string} topicType topics.jsp에서 참고할 템플릿 ID
	 * @param {string} id 지명하고 싶은 ID
	 * @param {string} targetViewId 붙이고자 하는 ID
	 * @param {function} controlFN 콜백
	 */
	getTopicPagePrepend : function (topicType, id, targetViewId, controlFN) {
		if (controlFN == undefined) {
			controlFN = function() {};
		}

		var view = $("#" + PAGE_CONTROLLER.templateString + topicType);
		LOG(PAGE_CONTROLLER.templateString + topicType);
		LOG(view);
		var tempView = view.clone();
		var topicId = id;

		tempView.attr("id", topicId);
		$("#" + targetViewId).prepend(tempView);

		return $("#" + targetViewId).find("#" + tempView.attr("id"));
	},

	/**
	 * targetViewId내에 topicType의 템플릿을 뒤쪽에 삽입한다.
	 * @param {string} topicType topics.jsp에서 참고할 템플릿 ID
	 * @param {string} id 지명하고 싶은 ID
	 * @param {string} targetViewId 붙이고자 하는 ID
	 * @param {function} controlFN 콜백
	 */
	getTopicPageAppend : function (topicType, id, targetViewId, controlFN) {
		if (controlFN == undefined) {
			controlFN = function() {};
		}

		var view = $("#" + PAGE_CONTROLLER.templateString + topicType);
		LOG(PAGE_CONTROLLER.templateString + topicType);
		LOG(view);
		var tempView = view.clone();
		var topicId = id;

		tempView.attr("id", topicId);
		$("#" + targetViewId).append(tempView);
		controlFN();
		return tempView;
		// return $("#" + targetViewId).find("#" + tempView.attr("id"));
	},

	/**
	 * targetViewId를 기준으로 뒤에다가 topicType의 템플릿을 추가한다.
	 * @param {string} topicType topics.jsp에서 참고할 템플릿 ID
	 * @param {string} id 지명하고 싶은 ID
	 * @param {string} targetViewId 붙이고자 하는 ID
	 * @param {function} controlFN 콜백
	 */
	getTopicPageAfter : function (topicType, id, targetViewId, controlFN) {
		if (controlFN == undefined) {
			controlFN = function() {};
		}

		var view = $("#" + PAGE_CONTROLLER.templateString + topicType);
		LOG(PAGE_CONTROLLER.templateString + topicType);
		LOG(view);
		var tempView = view.clone();
		var topicId = id;

		if (topicId && topicId != "")
			tempView.attr("id", topicId);

		$("#" + targetViewId).after(tempView);

		return tempView;
	},

	/**
	 * targetViewId를 기준으로 앞에다가 topicType의 템플릿을 추가한다.
	 * @param {string} topicType topics.jsp에서 참고할 템플릿 ID
	 * @param {string} id 지명하고 싶은 ID
	 * @param {string} targetViewId 붙이고자 하는 ID
	 * @param {function} controlFN 콜백
	 */
	getTopicPageBefore : function (topicType, id, targetViewId, controlFN) {
		if (controlFN == undefined) {
			controlFN = function() {};
		}

		var view = $("#" + PAGE_CONTROLLER.templateString + topicType);
		LOG(PAGE_CONTROLLER.templateString + topicType);
		LOG(view);
		var tempView = view.clone();
		var topicId = id;

		tempView.attr("id", topicId);
		$("#" + targetViewId).before(tempView);

		return $("#" + tempView.attr("id"));
	},

	/**
	 * targetViewId를 기준으로 앞에다가 topicType의 템플릿을 추가한다.
	 * @param {string} topicType topics.jsp에서 참고할 템플릿 ID
	 * @param {string} id 지명하고 싶은 ID
	 * @param {string} targetViewId 붙이고자 하는 ID
	 * @param {function} controlFN 콜백
	 */
	getTopicPageReplaceWith : function (topicType, id, controlFN) {
		if (controlFN == undefined) {
			controlFN = function() {};
		}

		var view = $("#" + PAGE_CONTROLLER.templateString + topicType);
		LOG(PAGE_CONTROLLER.templateString + topicType);
		LOG(view);
		var tempView = view.clone();
		var topicId = $("#" + id).attr("id");

		tempView.attr("id", topicId);
		$("#" + id).replaceWith(tempView);

		return $("#" + tempView.attr("id"));
	},

	/**
	 * 템플릿을 인용하여 팝업창을 활성화한다.
	 * @param {string} topicType topics.jsp에서 참고할 템플릿 ID
	 * @param {function} controlFN 콜백
	 */
	showPopupPage : function (topicType, controlFN) {
		if (controlFN == undefined) {
			controlFN = function() {};
		}

		var view = $("#" + PAGE_CONTROLLER.templateString + topicType);
		var tempView = view.clone();
		tempView.removeAttr("id");
		$("#popupBody").html(tempView);
		$("#popupBody").show();

		return tempView;
	},

	/**
	 * 열린 팝업을 종료한다.
	 * @param {string} isClear 안에 있는 내용을 초기화시킬지 여부 default : true
	 */
	closePopupPage : function (isClear) {
		if (isClear === false) {
			$("#popupBody").hide();
		} else {
			$("#popupBody").empty();
			$("#popupBody").hide();
		}
	}
};