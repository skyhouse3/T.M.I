package review.model.vo;

import java.sql.Date;

public class Reply implements java.io.Serializable{
	private static final long serialVersionUID = -8444244406263727436L;
	
	private String Rid;
	private String Rnum;
	private String Rcontent;
	private String Rwriter;
	private Date Create_date;
	private Date Modify_date;
	private String Status;
	
	public Reply() {}
	
	public Reply(String rcontent, String rwriter, Date modify_date) {
		super();
		Rcontent = rcontent;
		Rwriter = rwriter;
		Modify_date = modify_date;
	}
	public Reply(String rid, String rnum, String rcontent, String rwriter, Date create_date, Date modify_date,
			String status) {
		super();
		Rid = rid;
		Rnum = rnum;
		Rcontent = rcontent;
		Rwriter = rwriter;
		Create_date = create_date;
		Modify_date = modify_date;
		Status = status;
	}
	public String getRid() {
		return Rid;
	}
	public void setRid(String rid) {
		Rid = rid;
	}
	public String getRnum() {
		return Rnum;
	}
	public void setRnum(String rnum) {
		Rnum = rnum;
	}
	public String getRcontent() {
		return Rcontent;
	}
	public void setRcontent(String rcontent) {
		Rcontent = rcontent;
	}
	public String getRwriter() {
		return Rwriter;
	}
	public void setRwriter(String rwriter) {
		Rwriter = rwriter;
	}
	public Date getCreate_date() {
		return Create_date;
	}
	public void setCreate_date(Date create_date) {
		Create_date = create_date;
	}
	public Date getModify_date() {
		return Modify_date;
	}
	public void setModify_date(Date modify_date) {
		Modify_date = modify_date;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "Reply [Rid=" + Rid + ", Rnum=" + Rnum + ", Rcontent=" + Rcontent + ", Rwriter=" + Rwriter
				+ ", Create_date=" + Create_date + ", Modify_date=" + Modify_date + ", Status=" + Status + "]";
	}
	
}