package Service.model;

import java.sql.Date;

public class Service {
	private String sNum;
	private String userId;
	private String stitle;
	private String scontent;
	private String sanswer;
	private Date sdate;
	private String status;
	public Service() {
		
	}
	public Service(String sNum, String userId, String stitle, String scontent, String sanswer, Date sdate,
			String status) {
		super();
		this.sNum = sNum;
		this.userId = userId;
		this.stitle = stitle;
		this.scontent = scontent;
		this.sanswer = sanswer;
		this.sdate = sdate;
		this.status = status;
	}
	public Service(String sNum, String stitle, Date sdate, String status) {
		super();
		this.sNum = sNum;
		this.stitle = stitle;
		this.sdate = sdate;
		this.status = status;
	}
	public String getsNum() {
		return sNum;
	}
	public void setsNum(String sNum) {
		this.sNum = sNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStitle() {
		return stitle;
	}
	public void setStitle(String stitle) {
		this.stitle = stitle;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public String getSanswer() {
		return sanswer;
	}
	public void setSanswer(String sanswer) {
		this.sanswer = sanswer;
	}
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Service [sNum=" + sNum + ", userId=" + userId + ", stitle=" + stitle + ", scontent=" + scontent
				+ ", sanswer=" + sanswer + ", sdate=" + sdate + ", status=" + status + "]";
	}
	
	
}
