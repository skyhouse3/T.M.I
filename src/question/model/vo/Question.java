package question.model.vo;

import java.sql.Date;

public class Question implements java.io.Serializable{
	private static final long serialVersionUID = -7162437064279836877L;
	
	private String sNum;
	private String userId;
	private String sTitle;
	private String sContent;
	private String sAnswer;
	private Date sDate;
	private String Status;

	
	public Question() {}


	public Question(String sNum, String userId, String sTitle, String sContent, String sAnswer, Date sDate,
			String status) {
		super();
		this.sNum = sNum;
		this.userId = userId;
		this.sTitle = sTitle;
		this.sContent = sContent;
		this.sAnswer = sAnswer;
		this.sDate = sDate;
		Status = status;
	}
	
	public Question(String sNum, String userId, String sTitle, Date sDate) {
		super();
		this.sNum = sNum;
		this.userId = userId;
		this.sTitle = sTitle;
		this.sDate = sDate;
	}

	public Question(String userId, String sTitle, String sContent) {
		super();
		this.userId = userId;
		this.sTitle = sTitle;
		this.sContent = sContent;
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


	public String getsTitle() {
		return sTitle;
	}


	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}


	public String getsContent() {
		return sContent;
	}


	public void setsContent(String sContent) {
		this.sContent = sContent;
	}


	public String getsAnswer() {
		return sAnswer;
	}


	public void setsAnswer(String sAnswer) {
		this.sAnswer = sAnswer;
	}


	public Date getsDate() {
		return sDate;
	}


	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Question [sNum=" + sNum + ", userId=" + userId + ", sTitle=" + sTitle + ", sContent=" + sContent
				+ ", sAnswer=" + sAnswer + ", sDate=" + sDate + ", Status=" + Status + "]";
	}

}
