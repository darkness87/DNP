package com.dnp.home.vo;

import com.dnp.home.common.PropertyMessage;
import com.dnp.home.exception.DNPException;


public class ResponseVO {
	private ResponseHeadVO responseHead;
	private ResponseDataVO responseData;

	public ResponseVO() {
	}

	public ResponseVO(int resultCode) {
		this(new DNPException(resultCode));
	}

	public ResponseVO(String resultCode) {
		this(Integer.parseInt(resultCode));
	}

	public ResponseVO(DNPException e) {
		String resultCode = e.getFaultCode();
		String message = e.getMessage();

		if (resultCode == "0") {
			message = PropertyMessage.getCodeMessage(resultCode);
		}

		this.responseHead = new ResponseHeadVO(resultCode, message);
	}

	public ResponseVO(int resultCode, String resultMessage) {
		this(Integer.toString(resultCode), resultMessage);
	}

	public ResponseVO(String resultCode, String resultMessage) {
		this.responseHead = new ResponseHeadVO(resultCode, resultMessage);
	}

	public ResponseVO(int resultCode, ResponseDataVO responseData) {
		this(resultCode);
		this.responseData = responseData;
	}

	public ResponseVO(String resultCode, ResponseDataVO responseData) {
		this(resultCode);
		this.responseData = responseData;
	}

	public ResponseVO(int resultCode, String resultMessage, ResponseDataVO responseData) {
		this(resultCode, resultMessage);
		this.responseData = responseData;
	}

	public ResponseVO(String resultCode, String resultMessage, ResponseDataVO responseData) {
		this(resultCode, resultMessage);
		this.responseData = responseData;
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

	public ResponseDataVO getResponseData() {
		return responseData;
	}

	public void setResponseData(ResponseDataVO responseData) {
		this.responseData = responseData;
	}
}