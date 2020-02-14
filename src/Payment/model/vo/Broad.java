package Payment.model.vo;

import java.sql.Date;

public class Broad {
	
	private int bCode;
	private Date bDate;
	private String bSeat;
	
	public Broad(int bCode, Date bDate, String bSeat) {
		super();
		this.bCode = bCode;
		this.bDate = bDate;
		this.bSeat = bSeat;
	}
	public int getbCode() {
		return bCode;
	}
	public void setbCode(int bCode) {
		this.bCode = bCode;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getbSeat() {
		return bSeat;
	}
	public void setbSeat(String bSeat) {
		this.bSeat = bSeat;
	}
	

}
