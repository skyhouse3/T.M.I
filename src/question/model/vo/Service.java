package question.model.vo;

public class Service {
	private int sNum;
	private String sTitle;
	private String sContent;
	private String sAnswer;
	
	public Service() {}
	
	public Service(int sNum, String sTitle, String sContent, String sAnswer) {
		super();
		this.sNum = sNum;
		this.sTitle = sTitle;
		this.sContent = sContent;
		this.sAnswer = sAnswer;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsContent() {
		return sContent;
	}

	public void setsContent(String sContent) {
		this.sContent = sContent;
	}

	public String getsAnswer() {
		return sAnswer;
	}

	public void setsAnswer(String sAnswer) {
		this.sAnswer = sAnswer;
	}

	@Override
	public String toString() {
		return "Service [sNum=" + sNum + ", sTitle=" + sTitle + ", sContent=" + sContent + ", sAnswer=" + sAnswer + "]";
	}
	

}
