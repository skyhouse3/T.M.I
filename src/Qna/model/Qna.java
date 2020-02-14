package Qna.model;

import java.sql.Date;

public class Qna {
	private String Onum;
	private String UserId;
	private String Category;
	private String Otitle;
	private String Ocontent;
	private String Oanswer;
	private Date Odate;
	private String Ostatus;
	public Qna() {
		
	}
	public Qna(String onum, String otitle, Date odate, String ostatus) {
		super();
		Onum = onum;
		Otitle = otitle;
		Odate = odate;
		Ostatus = ostatus;
	}
	public Qna(String onum, String userId, String category, String otitle, String ocontent, String oanswer, Date odate,
			String ostatus) {
		super();
		Onum = onum;
		UserId = userId;
		Category = category;
		Otitle = otitle;
		Ocontent = ocontent;
		Oanswer = oanswer;
		Odate = odate;
		Ostatus = ostatus;
	}
	public String getOnum() {
		return Onum;
	}
	public void setOnum(String onum) {
		Onum = onum;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getOtitle() {
		return Otitle;
	}
	public void setOtitle(String otitle) {
		Otitle = otitle;
	}
	public String getOcontent() {
		return Ocontent;
	}
	public void setOcontent(String ocontent) {
		Ocontent = ocontent;
	}
	public String getOanswer() {
		return Oanswer;
	}
	public void setOanswer(String oanswer) {
		Oanswer = oanswer;
	}
	public Date getOdate() {
		return Odate;
	}
	public void setOdate(Date odate) {
		Odate = odate;
	}
	public String getOstatus() {
		return Ostatus;
	}
	public void setOstatus(String ostatus) {
		Ostatus = ostatus;
	}
	@Override
	public String toString() {
		return "Qna [Onum=" + Onum + ", UserId=" + UserId + ", Category=" + Category + ", Otitle=" + Otitle
				+ ", Ocontent=" + Ocontent + ", Oanswer=" + Oanswer + ", Odate=" + Odate + ", Ostatus=" + Ostatus + "]";
	}
	
}
