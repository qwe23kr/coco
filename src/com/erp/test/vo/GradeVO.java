package com.erp.test.vo;

public class GradeVO {
	private int grdNo;
	private String grdName;
	private String grdDesc;
	public int getGrdNo() {
		return grdNo;
	}
	public void setGrdNo(int grdNo) {
		this.grdNo = grdNo;
	}
	public String getGrdName() {
		return grdName;
	}
	public void setGrdName(String grdName) {
		this.grdName = grdName;
	}
	public String getGrdDesc() {
		return grdDesc;
	}
	public void setGrdDesc(String grdDesc) {
		this.grdDesc = grdDesc;
	}
	@Override
	public String toString() {
		return "GradeVO [grdNo=" + grdNo + ", grdName=" + grdName + ", grdDesc=" + grdDesc + "]";
	}
	
}
