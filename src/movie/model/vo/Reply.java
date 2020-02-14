package movie.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Reply implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3172873436001043622L;
	private String rid; //댓글 코드
	private String rnum; //영화 리뷰 게시글번호
	private String mcode; //영화 코드
	private String rcontent; //댓글 내용
	private String rwriter; //작성자 이름
	private String reply_level;//댓글 구분(0 : 리뷰 게시글, 1 : 영화 디테일 게시글)
	private Date create_date; //작성일
	private Date modify_date; //수정일
	private String status; //삭제 여부
	public Reply() {
		super();
	}
	public Reply(String rid, String rnum, String mcode, String rcontent, String rwriter, String reply_level,
			Date create_date, Date modify_date, String status) {
		super();
		this.rid = rid;
		this.rnum = rnum;
		this.mcode = mcode;
		this.rcontent = rcontent;
		this.rwriter = rwriter;
		this.reply_level = reply_level;
		this.create_date = create_date;
		this.modify_date = modify_date;
		this.status = status;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRwriter() {
		return rwriter;
	}
	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}
	public String getReply_level() {
		return reply_level;
	}
	public void setReply_level(String reply_level) {
		this.reply_level = reply_level;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModify_date() {
		return modify_date;
	}
	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", rnum=" + rnum + ", mcode=" + mcode + ", rcontent=" + rcontent + ", rwriter="
				+ rwriter + ", reply_level=" + reply_level + ", create_date=" + create_date + ", modify_date="
				+ modify_date + ", status=" + status + "]";
	}
	
	
	
	
	
}
