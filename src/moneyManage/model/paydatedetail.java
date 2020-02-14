package moneyManage.model;

import java.util.Date;

public class paydatedetail {
	private int pcate;
	private Date payday;
	private String user_id;
	private int money;
	public paydatedetail() {
		super();
	}
	public paydatedetail(int pcate, Date payday, String user_id, int money) {
		super();
		this.pcate = pcate;
		this.payday = payday;
		this.user_id = user_id;
		this.money = money;
	}
	public int getPcate() {
		return pcate;
	}
	public void setPcate(int pcate) {
		this.pcate = pcate;
	}
	public Date getPayday() {
		return payday;
	}
	public void setPayday(Date payday) {
		this.payday = payday;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "paydatedetail [pcate=" + pcate + ", payday=" + payday + ", user_id=" + user_id + ", money=" + money
				+ "]";
	}

	
	
}
