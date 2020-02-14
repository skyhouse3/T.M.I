package Board.model;

import java.sql.Date;

public class Reply {
	private String Rid;
	private String Rnum;
	private String mcode;
	private String Rcontent;
	private String Rwriter;
	private String reply_level;
	private Date Create_date;
	private Date Modify_date;
	private String Status;
	public Reply() {
		super();
	}
	public Reply(String rid, String rnum, String mcode, String rcontent, String rwriter, String reply_level,
			Date create_date, Date modify_date, String status) {
		super();
		Rid = rid;
		Rnum = rnum;
		this.mcode = mcode;
		Rcontent = rcontent;
		Rwriter = rwriter;
		this.reply_level = reply_level;
		Create_date = create_date;
		Modify_date = modify_date;
		Status = status;
	}
	
	public Reply(String rnum, String rcontent, Date modify_date) {
		super();
		Rnum = rnum;
		Rcontent = rcontent;
		Modify_date = modify_date;
	}
	public Reply(String rid,String rnum, String rcontent, Date modify_date) {
		super();
		Rid = rid;
		Rnum = rnum;
		Rcontent = rcontent;
		Modify_date = modify_date;
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
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
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
	public String getReply_level() {
		return reply_level;
	}
	public void setReply_level(String reply_level) {
		this.reply_level = reply_level;
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
		return "Reply [Rid=" + Rid + ", Rnum=" + Rnum + ", mcode=" + mcode + ", Rcontent=" + Rcontent + ", Rwriter="
				+ Rwriter + ", reply_level=" + reply_level + ", Create_date=" + Create_date + ", Modify_date="
				+ Modify_date + ", Status=" + Status + "]";
	}
	
	
}
