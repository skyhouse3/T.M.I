package moneyManage.model;

public class paydate {
	private String pdnum;
	private int category;
	private int money;
	public paydate() {
	}
	public paydate(String pdnum, int category, int money) {
		super();
		this.pdnum = pdnum;
		this.category = category;
		this.money = money;
	}
	
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getPdnum() {
		return pdnum;
	}
	public void setPdnum(String pdnum) {
		this.pdnum = pdnum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "paydate [pdnum=" + pdnum + ", category=" + category + ", money=" + money + "]";
	}
	
}
