function showMenuPage(viewName) {
	var param = {};
	AMI_PROXY.invokeOpenAPI(viewName, "html", param, function(result, _params) {
		$("#mainBody").html(result);

		var view = $("#menu").find("li#" + viewName);
		$("#menu").find("li").removeClass("active");
		view.addClass("active");

		switch(viewName) {
		case "equipment":
			showSubMenuPage("equipmentDcu");
			break;
		case "meter":
			break;
		case "fault":
			break;
		case "tou":
			break;
		}
	});
}

function showSubMenuPage(viewName) {
	initSubMenu();

	AMI_PROXY.invokeOpenAPI(viewName, "html", {}, function(result, _params) {
		$("#contentsBody").html(result);

		// 설비 관리 서브메뉴
		switch(viewName) {
		case "equipmentDcu":
			getEquipmentDcuList();
			break;
		case "equipmentMeter":
			getEquipmentMeterList();
			break;
		case "equipmentTransformer":
			getEquipmentTransformerList();
			break;
		case "equipmentHierarchy":
			getEquipmentHierarchy();
			break;
		}

		// 검침 조회 서브메뉴
		switch(viewName) {
		case "":
			break;
		case "":
			break;
		case "":
			break;
		}

		// 장애 관리
		switch(viewName) {
		case "":
			break;
		case "":
			break;
		}

		// 버튼 활성화 조정
		var view = $("#subMenu");
		view.find("li").removeClass("active");
		view.find("#" + viewName).addClass("active");
		// 제목 삽입
		var title = $.trim(view.find(".active").text());
		$("#subTitle").html(title);
		// 네비 설정
		displayNavigator();
	});
}