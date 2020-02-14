package moneyManage.model;

public class movRate {
	private String title;
	private int rate;
	public movRate() {
	}
	public movRate(String title, int rate) {
		super();
		this.title = title;
		this.rate = rate;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "movRate [title=" + title + ", rate=" + rate + "]";
	}
	
}
