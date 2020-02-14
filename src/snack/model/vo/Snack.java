package snack.model.vo;

import java.sql.Date;

public class Snack implements java.io.Serializable{
	
	private static final long serialVersionUID = -3797491615716827627L;
	
	private String skCode;
	private String Ccode;
	private String skName;
	private String skPrice;
	private String skcontent;
	private String picture;
	private String kinds;
	private int skQuantity;
	
	public Snack() {}
	
	

	public Snack(String skCode, String Ccode ,String skName, String skPrice, String skcontent, String picture, String kinds, int skQuantity) {
		super();
		this.skCode = skCode;
		this.Ccode = Ccode;
		this.skName = skName;
		this.skPrice = skPrice;
		this.skcontent = skcontent;
		this.picture = picture;
		this.kinds = kinds;
		this.skQuantity= skQuantity;
	}


	public Snack(String Ccode, String skCode ,String skName, String skPrice, String skcontent, String picture) {
		super();
		this.Ccode = Ccode;
		this.skCode = skCode;
		this.skName = skName;
		this.skPrice = skPrice;
		this.skcontent = skcontent;
		this.picture = picture;
	}
	public Snack(String Ccode, String skCode ,String skName, String skPrice, String skcontent, String picture, String kinds) {
		super();
		this.Ccode = Ccode;
		this.skCode = skCode;
		this.skName = skName;
		this.skPrice = skPrice;
		this.skcontent = skcontent;
		this.picture = picture;
		this.kinds = kinds;
	}

	
	
	public int getSkQuantity() {
		return skQuantity;
	}



	public void setSkQuantity(int skQuantity) {
		this.skQuantity = skQuantity;
	}




	public String getSkCode() {
		return skCode;
	}



	public void setSkCode(String skCode) {
		this.skCode = skCode;
	}



	public String getCcode() {
		return Ccode;
	}



	public void setCcode(String ccode) {
		Ccode = ccode;
	}



	public String getSkName() {
		return skName;
	}



	public void setSkName(String skName) {
		this.skName = skName;
	}



	public String getSkPrice() {
		return skPrice;
	}



	public void setSkPrice(String skPrice) {
		this.skPrice = skPrice;
	}



	public String getSkcontent() {
		return skcontent;
	}



	public void setSkcontent(String skcontent) {
		this.skcontent = skcontent;
	}



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public String getKinds() {
		return kinds;
	}



	public void setKinds(String kinds) {
		this.kinds = kinds;
	}



	@Override
	public String toString() {
		return "Snack [skCode=" + skCode + ", Ccode=" + Ccode + ", skName=" + skName + ", skPrice=" + skPrice
				+ ", skcontent=" + skcontent + ", picture=" + picture + ", kinds=" + kinds + "]";
	}

	

	

	
}
