package Member.model.vo;

public class BoReport {
	private String writer;
	private String bnum;
	private String reporter;
	public BoReport() {
		super();
	}
	public BoReport(String writer, String bnum, String reporter) {
		super();
		this.writer = writer;
		this.bnum = bnum;
		this.reporter = reporter;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBnum() {
		return bnum;
	}
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	@Override
	public String toString() {
		return "BoReport [writer=" + writer + ", bnum=" + bnum + ", reporter=" + reporter + "]";
	}
	
	
}
