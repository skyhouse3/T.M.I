package Board.model;

import java.sql.Date;

public class Boardman {
	private String Rnum;
	private String Mcode;
	private String Rtitle;
	private String rWriter;
	private String Rcontent;
	private String Rrate;
	private String charmingPoint;
	private String director_production;
	private String OST;
	private String action_acting;
	private String Story;
	private String Movie_beauty;
	private Date MrvDate;
	public Boardman() {
	}
	public Boardman(String rnum, String mcode, String rtitle, String rWriter, String rcontent, String rrate,
			String charmingPoint, String director_production, String oST, String action_acting, String story,
			String movie_beauty, Date mrvDate) {
		super();
		Rnum = rnum;
		Mcode = mcode;
		Rtitle = rtitle;
		this.rWriter = rWriter;
		Rcontent = rcontent;
		Rrate = rrate;
		this.charmingPoint = charmingPoint;
		this.director_production = director_production;
		OST = oST;
		this.action_acting = action_acting;
		Story = story;
		Movie_beauty = movie_beauty;
		MrvDate = mrvDate;
	}
	public Boardman(String rnum,String mcode, String rtitle, String rrate, Date mrvDate) {
		super();
		Rnum = rnum;
		Mcode = mcode;
		Rtitle = rtitle;
		Rrate = rrate;
		MrvDate = mrvDate;
	}
	public String getRnum() {
		return Rnum;
	}
	public void setRnum(String rnum) {
		Rnum = rnum;
	}
	public String getMcode() {
		return Mcode;
	}
	public void setMcode(String mcode) {
		Mcode = mcode;
	}
	public String getRtitle() {
		return Rtitle;
	}
	public void setRtitle(String rtitle) {
		Rtitle = rtitle;
	}
	public String getrWriter() {
		return rWriter;
	}
	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}
	public String getRcontent() {
		return Rcontent;
	}
	public void setRcontent(String rcontent) {
		Rcontent = rcontent;
	}
	public String getRrate() {
		return Rrate;
	}
	public void setRrate(String rrate) {
		Rrate = rrate;
	}
	public String getCharmingPoint() {
		return charmingPoint;
	}
	public void setCharmingPoint(String charmingPoint) {
		this.charmingPoint = charmingPoint;
	}
	public String getDirector_production() {
		return director_production;
	}
	public void setDirector_production(String director_production) {
		this.director_production = director_production;
	}
	public String getOST() {
		return OST;
	}
	public void setOST(String oST) {
		OST = oST;
	}
	public String getAction_acting() {
		return action_acting;
	}
	public void setAction_acting(String action_acting) {
		this.action_acting = action_acting;
	}
	public String getStory() {
		return Story;
	}
	public void setStory(String story) {
		Story = story;
	}
	public String getMovie_beauty() {
		return Movie_beauty;
	}
	public void setMovie_beauty(String movie_beauty) {
		Movie_beauty = movie_beauty;
	}
	public Date getMrvDate() {
		return MrvDate;
	}
	public void setMrvDate(Date mrvDate) {
		MrvDate = mrvDate;
	}
	@Override
	public String toString() {
		return "Boardman [Rnum=" + Rnum + ", Mcode=" + Mcode + ", Rtitle=" + Rtitle + ", rWriter=" + rWriter
				+ ", Rcontent=" + Rcontent + ", Rrate=" + Rrate + ", charmingPoint=" + charmingPoint
				+ ", director_production=" + director_production + ", OST=" + OST + ", action_acting=" + action_acting
				+ ", Story=" + Story + ", Movie_beauty=" + Movie_beauty + ", MrvDate=" + MrvDate + "]";
	}
	
	
	
}
