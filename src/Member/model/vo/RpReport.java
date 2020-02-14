package Member.model.vo;

public class RpReport {
	private String writer;
	private String rnum;
	private String reporter;
	public RpReport() {
		super();
	}
	public RpReport(String writer, String rnum, String reporter) {
		super();
		this.writer = writer;
		this.rnum = rnum;
		this.reporter = reporter;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRnum() {
		return rnum;
	}
	public void setRnum(String rnum) {
		this.rnum = rnum;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	@Override
	public String toString() {
		return "RpReport [writer=" + writer + ", rnum=" + rnum + ", reporter=" + reporter + "]";
	}
	
}
