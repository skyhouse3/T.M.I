package Payment.model.vo;

public class MovieRoom {
	private int cCode;
	private String cName;
	private String cAddress;
	
	
	public MovieRoom(int cCode, String cName, String cAddress) {
		super();
		this.cCode = cCode;
		this.cName = cName;
		this.cAddress = cAddress;
	}
	public int getcCode() {
		return cCode;
	}
	public void setcCode(int cCode) {
		this.cCode = cCode;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	

}
