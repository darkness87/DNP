package com.dnp.home.vo;

import java.util.Date;

public class UserVO extends ResponseDataVO {
	private static final long serialVersionUID = 1L;
	public enum UTYPE{A, N};
	private String loginId;
	private String password;
	private UTYPE type = UTYPE.N;
	private String name;
	private long registDate;
	private long lastDate;

	public UserVO(String uId, String uPw) {
		super();
		this.loginId = uId;
		this.password = uPw;
	}

	public UserVO(String uId, String uPw, String uName) {
		super();
		Date currentDate = new Date();
		int currentInt = (int) (currentDate.getTime() / 1000);
		this.loginId = uId;
		this.password = uPw;
		this.type = UTYPE.N;
		this.name = uName;
		this.registDate = currentInt;
		this.lastDate = currentInt;
	}

	public UserVO(String loginId, String password, UTYPE type, String name, int registDate, int lastDate) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.type = type;
		this.name = name;
		this.registDate = registDate;
		this.lastDate = lastDate;
	}

	public UserVO(String loginId, String password, String type, String name, long registDate, long lastDate) {
		super();
		this.loginId = loginId;
		this.password = password;

		if (UTYPE.A.toString() == type) {
			this.type = UTYPE.A;
		} else {
			this.type = UTYPE.N;
		}
		this.name = name;
		this.registDate = registDate;
		this.lastDate = lastDate;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}

	public UTYPE getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public long getRegistDate() {
		return registDate;
	}

	public long getLastDate() {
		return lastDate;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setType(UTYPE type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegistDate(int registDate) {
		this.registDate = registDate;
	}

	public void setLastDate(int lastDate) {
		this.lastDate = lastDate;
	}

	public boolean isAdmin() {
		if (this.type != null && this.type == UTYPE.A)
			return true;

		return false;
	}
}