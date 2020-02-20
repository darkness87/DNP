package com.dnp.home.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListVO extends ResponseDataVO {
	private static final long serialVersionUID = 1L;

	private int totalCount;
	private String lastViewId;
	private int beforeNday;
	private Date lastViewDate;

	private List<ResponseDataVO> dataList;

	public String getLastViewId() {
		return lastViewId;
	}
	
	public void setLastViewId(String lastViewId) {
		this.lastViewId = lastViewId;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalNum) {
		this.totalCount = totalNum;
	}
	
	public List<ResponseDataVO> getDataList() {
		if (dataList != null) {
			return new ArrayList<ResponseDataVO>(dataList);
		} else {
			return null;
		}
	}
	
	public void setDataList(List<ResponseDataVO> dataList) {
		this.dataList = dataList;
	}

	public int getBeforeNday() {
		return beforeNday;
	}

	public void setBeforeNday(int beforeNday) {
		this.beforeNday = beforeNday;
	}

	public Date getLastViewDate() {
		if (lastViewDate != null) {
			return (Date)lastViewDate.clone();
		} else {
			return null;
		}
	}

	public void setLastViewDate(Date lastViewDate) {
		this.lastViewDate = lastViewDate;
	}
}