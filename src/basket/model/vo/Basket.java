package basket.model.vo;

public class Basket {
private int Bcode;
private int skCode;

public Basket() {}

public Basket(int bcode, int skCode) {
	super();
	Bcode = bcode;
	this.skCode = skCode;
}

public int getBcode() {
	return Bcode;
}

public void setBcode(int bcode) {
	Bcode = bcode;
}

public int getSkCode() {
	return skCode;
}

public void setSkCode(int skCode) {
	this.skCode = skCode;
}

@Override
public String toString() {
	return "Basket [Bcode=" + Bcode + ", skCode=" + skCode + "]";
}


}
