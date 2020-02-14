package moneyManage.model;

public class conRate {
	private int month;
	private int conNum;
	public conRate() {
		
	}
	public conRate(int month, int conNum) {
		super();
		this.month = month;
		this.conNum = conNum;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getConNum() {
		return conNum;
	}
	public void setConNum(int conNum) {
		this.conNum = conNum;
	}
	@Override
	public String toString() {
		return "conRate [month=" + month + ", conNum=" + conNum + "]";
	}
	
}
