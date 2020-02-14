package basket.model.vo;

public class SkBasket {

	private int sbsCode;
	private String skCode;
	private int skQuantity;
	private String User_Id;

	public SkBasket() {}

	public SkBasket(int sbsCode, String skCode, int skQuantity, String user_Id) {
		super();
		this.sbsCode = sbsCode;
		this.skCode = skCode;
		this.skQuantity = skQuantity;
		this.User_Id = user_Id;
	}

	public SkBasket(String skCode, int skQuantity, String User_Id) {
		super();
		this.skCode = skCode;
		this.skQuantity = skQuantity;
		this.User_Id = User_Id;
	}

	public int getSbsCode() {
		return sbsCode;
	}

	public void setSbsCode(int sbsCode) {
		this.sbsCode = sbsCode;
	}

	public String getSkCode() {
		return skCode;
	}

	public void setSkCode(String skCode) {
		this.skCode = skCode;
	}

	public int getSkQuantity() {
		return skQuantity;
	}

	public void setSkQuantity(int skQuantity) {
		this.skQuantity = skQuantity;
	}

	public String getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(String User_Id) {
		User_Id = User_Id;
	}

	@Override
	public String toString() {
		return "SkBasket [sbsCode=" + sbsCode + ", skCode=" + skCode + ", skQuantity=" + skQuantity + ", User_Id="
				+ User_Id + "]";
	}




	
	
	
	
	
	
	
}
