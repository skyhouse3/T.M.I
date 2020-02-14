package Payment.model.vo;

import java.sql.Date;

public class Payment {
	private int pCode;
	private int money;
	private Date payDay;
	
	public Payment(int pCode, int money, Date payDay) {
		super();
		this.pCode = pCode;
		this.money = money;
		this.payDay = payDay;
	}
	public int getpCode() {
		return pCode;
	}
	public void setpCode(int pCode) {
		this.pCode = pCode;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getPayDay() {
		return payDay;
	}
	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}
	
	
	
	

}
