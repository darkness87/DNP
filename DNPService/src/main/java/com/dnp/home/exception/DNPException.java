package com.dnp.home.exception;

import com.dnp.home.common.PropertyMessage;

public class DNPException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4276715518711291345L;

	protected String faultCode;

	public DNPException(String msg) {
		super(msg);
	}
	// code와 message가 동일 할 경우
	public DNPException(int faultCode) {
		super(PropertyMessage.getCodeMessage(faultCode));
		this.faultCode = Integer.toString(faultCode);
	}
	// code가 일치하지 않으나, Property message를 그대로 사용할 경우
	public DNPException(int faultCode, int messageCode) {
		super(PropertyMessage.getCodeMessage(messageCode));
		this.faultCode = Integer.toString(faultCode);
	}

	public DNPException(int faultCode, String msg) {
		super(msg);
		this.faultCode = Integer.toString(faultCode);
	}

	public DNPException(String faultCode, String msg) {
		super(msg);
		this.faultCode = faultCode;
	}
	// code와 message code가 동일 할경우
	public DNPException(int faultCode, Throwable cause) {
		super(PropertyMessage.getCodeMessage(faultCode), cause);
		this.faultCode = Integer.toString(faultCode);
	}
	// code가 일치하지 않으나, Property message를 그대로 사용할 경우 throwable 추가
	public DNPException(int faultCode, int messageCode, Throwable cause) {
		super(PropertyMessage.getCodeMessage(messageCode));
		this.faultCode = Integer.toString(faultCode);
	}

	public DNPException(String faultCode, String msg, Throwable cause) {
		super(msg, cause);
		this.faultCode = faultCode;
	}

	public DNPException(int faultCode, String msg, Throwable cause) {
		super(msg, cause);
		this.faultCode = Integer.toString(faultCode);
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

	public String getFaultCode() {
		return this.faultCode;
	}

	public String getMessage() {
		String message = super.getMessage();

		if (this.faultCode != null) {
			if (message != null) {
				message = new StringBuilder(message.length() + 16)
						.append("[").append(this.faultCode).append("] ")
						.append(message)
						.toString();
			} else {
				message = new StringBuffer(16).append("[").append(
						this.faultCode).append("]").toString();
			}
		}

		return message;
	}
}