package com.dnp.home.vo;

import com.google.gson.Gson;

public class ResponseToJson {
	
	private ResponseHeadVO responseHead;
	private Object responseData;

	public ResponseToJson(String resultCode, String resultMessage, Object responseDataObject) {
		this.responseHead = new ResponseHeadVO(resultCode, resultMessage);
		this.responseData = new Gson().toJson(responseDataObject);
	}
	
	public ResponseToJson(String resultCode, String resultMessage) {
		this.responseHead = new ResponseHeadVO(resultCode, resultMessage);
	}

	public ResponseHeadVO getResponseHead() {
		if (responseHead != null) {
			return (ResponseHeadVO)responseHead.clone();
		} else {
			return null;
		}
	}

	public void setResponseHead(ResponseHeadVO responseHead) {
		this.responseHead = responseHead;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
}
