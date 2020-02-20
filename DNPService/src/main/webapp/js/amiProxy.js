var AMI_PROXY = {
	xhrPool : [],
	// 공통
	duplicateAPI : {},
	alertCode : {"0000x":true, "00001x":true},		//alertCode -> boolean형은 사용할지 여부
	confirmCode : {"0000x":true, "00001x":true},	//confirmCode -> boolean형은 사용할지 여부

	// 메인&로그인
	main : "/ami/main",
	dashboard : "/ami/dashboard",
	login : "/ami/login",
	authenticate : "/ami/authenticate",
	addAccount : "/ami/addAccount",
	equipment : "/ami/equipment/",
	equipmentDcu : "/ami/equipment/dcu",
	equipmentMeter : "/ami/equipment/meter",
	equipmentTransformer : "/ami/equipment/transformer",
	equipmentHierarchy : "/ami/equipment/hierarchy",
	meter : "/ami/meter/",
	meterFixedMeter : "/ami/meter/fixedMeter",
	meterMaximumDemand : "/ami/meter/maximumDemand",

	prefixUrl : "",

	// 메뉴

	// 유저

	// 관리자

	invokeDownloadOpenAPI : function (attachId) {
		var reqParam = AMI_PROXY.prefixUrl + AMI_PROXY.downloadAttach + "?" +"attachId=" + attachId;
		var url = reqParam;

		window.open(url, "_self");
	},
	invokeOpenAPI : function (apiCode, dataType, params, successCallBack, errorCallBack) {
		var url = AMI_PROXY[apiCode];
		var ajaxAsync = true;
		var successCallBack2 = null;
		var errorCallBack2 = null;

		if (AMI_PROXY[apiCode] == undefined || AMI_PROXY[apiCode] == "") {
			// alert(SQUARE_RES.get("msg_invalid_apicode"));
			alert("유효하지 않은 API코드");
			return ;
		}
		
		//메뉴 클릭하여 그룹의 컨텐츠 처음 호출되는 ajax 콜인 경우, 이미 요청된 ajax가 존재한다면 해당 ajax을 abort 하도록 처리함.
		if (apiCode == "workGroup" || apiCode == "workfeed" || apiCode == "workFavorite" 
				|| apiCode == "workMention" || apiCode == "workConfig") {
			AMI_PROXY.abortOpenApi();
		}
		
		if(dataType == "json") {
			params["dataType"] = "json";
			var d = new Date();
			var t = new Date(d.getFullYear(), d.getMonth(), d.getDay(), d.getHours(), d.getMinutes(), d.getMilliseconds());
			time = Date.parse(t.toISOString()) + ((1000*60*60*24) - 1);
			params["timestamp"] = time;
			params["apiCode"] = apiCode;
			FINAL_TIME_STAMP = time;
		}

		if (AMI_PROXY["duplicateAPI"][apiCode] != undefined) {
			if (apiCode != "getInputMemberCount" && apiCode != "getSquareMemberCount") {
				if (apiCode != "getWorkfeedContentsList" && apiCode != "searchResult") {
					// systemMessage(SQUARE_RES.get("msg_try_again_later"));
					alert("잠시후 다시 사용해주세요");
				}
ㄴ
				return ;
			}
		}

		AMI_PROXY["duplicateAPI"][apiCode] = true;

		// successCallBack이 없을 경우
		if(successCallBack == undefined || successCallBack == null) {
			successCallBack2 = function (response, status, request) {
				LOG("::::::::::SUCCESS START");
				LOG(response);
				LOG(status);
				LOG(request);
				LOG("::::::::::SUCCESS END ");
			};
		} else {
			successCallBack2 = successCallBack;
		}

		// errorCallBack이 없을 경우
		if (errorCallBack == undefined || errorCallBack == null) {
			errorCallBack2 = function (request, status, error) {
				LOG("::::::::::ERROR START");
				LOG(request);
				LOG(status);
				LOG(error);
				LOG("::::::::::ERROR END ");
			};
		} else {
			errorCallBack2 = errorCallBack;
		}

		if (AMI_CONST.AJAX_SYNC_MODE == params["ajaxMode"]) {
			ajaxAsync = false;
		}

		$.ajax ({
			type : "POST",
			async : ajaxAsync,
			url : url,
			dataType : dataType,
			timeout : TIME_OUT,
			cache : false,
			data : params,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",

			error : function (_request, _status, _error) {
				delete AMI_PROXY["duplicateAPI"][apiCode];

				errorCallBack2();
			},

			success : function (response, status, request) {
				delete AMI_PROXY["duplicateAPI"][apiCode];

				if(dataType == "json") {
					LOG(":::::::::Response:::::::::");
					LOG(response);
					if (response.responseHead == null || response.responseHead == undefined) {	// AMI api 콜이 아닌 경우
						successCallBack2(response, params, status, request);
					} else if (AMI_PROXY.isAlertCode(response.responseHead.resultCode) == true) {		// exception 정의 코드 유무 확인 (AMI_PROXY.alertCode)
						alert(response.responseHead.resultMessage);
					} else if (AMI_PROXY.isConfirmCode(response.responseHead.resultCode) == true) {		// exception 정의 코드 유무 확인 (AMI_PROXY.confirmCode)
						if (confirm(response.responseHead.resultMessage)) {
							// if (AMI_PROXY.PIMS_DETECT_FOUND == response.responseHead.resultCode) {
							// } else if (AMI_PROXY.OVER_LIMITED_MEMBERS == response.responseHead.resultCode) {
							// } else if (AMI_PROXY.SOME_FILES_NOT_EXISIS == response.responseHead.resultCode) {
							// }
						}
					} else if (response.responseHead.resultCode != 0) {
						systemMessage(response.responseHead.resultMessage);
						errorCallBack2();
					} else if (response.responseData != null && response.responseData != undefined) {	//json형식이면서 Data가 있을때
						successCallBack2(response.responseData, response.responseHead, params, status, request);
					} else {	//json형식이면서 Data가 없을경우 (즐겨찾기 등록 성공 여부 등등)
						successCallBack2(response, params, status, request);
					}
				} else {
					successCallBack2(response, params, status, request);
				}
			},

			beforeSend: function(request, _settings) {
				AMI_PROXY.xhrPool.push(request);
			},

			complete: function(request, _status) {
				AMI_PROXY.xhrPool = $.grep(AMI_PROXY.xhrPool, function(xhr) {
					return xhr != request;
				});

				if (request.getResponseHeader("Status") == "302") {
					location.href = request.getResponseHeader("Location");
				}
			}
		});
	},
	abortOpenApi : function () {
		$.each(AMI_PROXY.xhrPool, function(_idx, jqXHR) {
			jqXHR.abort();
		});
	},
	isAlertCode : function (resultCode) {
		if (AMI_PROXY["alertCode"].hasOwnProperty(resultCode)) {
			if (AMI_PROXY["alertCode"][resultCode]) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	},
	isConfirmCode : function (resultCode) {
		if (AMI_PROXY["confirmCode"].hasOwnProperty(resultCode)) {
			if (AMI_PROXY["confirmCode"][resultCode]) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
};