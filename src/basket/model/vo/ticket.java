package basket.model.vo;

public class ticket {
	private String tnum;
	private String mcode;
	private String userid;
	private String ccode;
	private String price;
	private String seat;
	public ticket() {
		
	}
	public ticket(String tnum, String mcode, String userid, String ccode, String price, String seat) {
		super();
		this.tnum = tnum;
		this.mcode = mcode;
		this.userid = userid;
		this.ccode = ccode;
		this.price = price;
		this.seat = seat;
	}
	public String getTnum() {
		return tnum;
	}
	public void setTnum(String tnum) {
		this.tnum = tnum;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "ticket [tnum=" + tnum + ", mcode=" + mcode + ", userid=" + userid + ", ccode=" + ccode + ", price="
				+ price + ", seat=" + seat + "]";
	}
	
}
