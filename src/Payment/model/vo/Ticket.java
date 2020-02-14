package Payment.model.vo;

public class Ticket {
	private String tNum;
	private String mCode;
	private String user_id;
	private String cCode;
	private String price;
	private String seat;
	
	public Ticket(String tNum, String mCode, String user_id, String cCode, String price, String seat) {
		super();
		this.tNum = tNum;
		this.mCode = mCode;
		this.user_id = user_id;
		this.cCode = cCode;
		this.price = price;
		this.seat = seat;
	}

	public String gettNum() {
		return tNum;
	}

	public void settNum(String tNum) {
		this.tNum = tNum;
	}

	public String getmCode() {
		return mCode;
	}

	public void setmCode(String mCode) {
		this.mCode = mCode;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
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


}
