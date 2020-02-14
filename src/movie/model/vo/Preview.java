package movie.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Preview implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6523656731416098760L;
	private String yurl;
	private Date registration_date;
	private Date modifiedDate;
	private String status;
	public Preview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Preview(String yurl, Date registration_date, Date modifiedDate, String status) {
		super();
		this.yurl = yurl;
		this.registration_date = registration_date;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}
	public String getYurl() {
		return yurl;
	}
	public void setYurl(String yurl) {
		this.yurl = yurl;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Preview [yurl=" + yurl + ", registration_date=" + registration_date + ", modifiedDate=" + modifiedDate
				+ ", status=" + status + "]";
	}
	
}
