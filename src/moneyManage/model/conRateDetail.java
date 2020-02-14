package moneyManage.model;

import java.util.Date;

public class conRateDetail {
	private String conrateNum;
	private String user_id;
	private Date condate;
	public conRateDetail() {
		super();
	}
	public conRateDetail(String conrateNum, String user_id, Date condate) {
		super();
		this.conrateNum = conrateNum;
		this.user_id = user_id;
		this.condate = condate;
	}
	public String getConrateNum() {
		return conrateNum;
	}
	public void setConrateNum(String conrateNum) {
		this.conrateNum = conrateNum;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getCondate() {
		return condate;
	}
	public void setCondate(Date condate) {
		this.condate = condate;
	}
	@Override
	public String toString() {
		return "conRateDetail [conrateNum=" + conrateNum + ", user_id=" + user_id + ", condate=" + condate + "]";
	}
	
}
