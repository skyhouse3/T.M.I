package movie.model.vo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Movie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4898967951380429337L;
	private String mcode;
	private String mbcode;
	private String mtitle; // 1
	private String mtitleEng; // 2
	private String mtitlePlot; // 3
	private String plot; // 4
	private String Category; // 5
	private String mDirector; // 6
	private String mActor; // 7
	private String kinds; // 8
	private String info; // 9
	private String ageCut; // 10
	private Date release; // 11
	private int mCount;
	private String change_name;// 바뀐이름
	private String Rrate;//평점
	private String reservationrate;//예매율
	
	private float rate;

	private Preview p;

	private ArrayList<Preview> plist = new ArrayList<>();
	
	public Movie() {
		super();
	}

	public Movie(String mcode, String mbcode, String mtitle, String mtitleEng, String mtitlePlot, String plot,
			String category, String mDirector, String mActor, String kinds, String info, String ageCut, Date release,
			int mCount, ArrayList<Preview> plist) {
		super();
		this.mcode = mcode;
		this.mbcode = mbcode;
		this.mtitle = mtitle;
		this.mtitleEng = mtitleEng;
		this.mtitlePlot = mtitlePlot;
		this.plot = plot;
		Category = category;
		this.mDirector = mDirector;
		this.mActor = mActor;
		this.kinds = kinds;
		this.info = info;
		this.ageCut = ageCut;
		this.release = release;
		this.mCount = mCount;
		this.plist = plist;
	}

	// 3사 CHARTLIST
			public Movie(String mtitle,String change_name, Date release ,String kinds,String mDirector, String mActor,String Rrate,String reservationrate) {
				super();
				this.mtitle = mtitle;
				this.mDirector = mDirector;
				this.mActor = mActor;
				this.kinds = kinds;
				this.release = release;
				this.change_name=change_name;
				this.Rrate = Rrate;
				this.reservationrate= reservationrate;
				
				}
	
	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public String getMbcode() {
		return mbcode;
	}

	public void setMbcode(String mbcode) {
		this.mbcode = mbcode;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMtitleEng() {
		return mtitleEng;
	}

	public void setMtitleEng(String mtitleEng) {
		this.mtitleEng = mtitleEng;
	}

	public String getMtitlePlot() {
		return mtitlePlot;
	}

	public void setMtitlePlot(String mtitlePlot) {
		this.mtitlePlot = mtitlePlot;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getmDirector() {
		return mDirector;
	}

	public void setmDirector(String mDirector) {
		this.mDirector = mDirector;
	}

	public String getmActor() {
		return mActor;
	}

	public void setmActor(String mActor) {
		this.mActor = mActor;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAgeCut() {
		return ageCut;
	}

	public void setAgeCut(String ageCut) {
		this.ageCut = ageCut;
	}

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public int getmCount() {
		return mCount;
	}

	public void setmCount(int mCount) {
		this.mCount = mCount;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Preview getP() {
		return p;
	}

	public void setP(Preview p) {
		this.p = p;
	}

	public ArrayList<Preview> getPlist() {
		return plist;
	}

	public void setPlist(ArrayList<Preview> plist) {
		this.plist = plist;
	}
	
	public String getChange_name() {
		return change_name;
	}

	public void setChange_name(String change_name) {
		this.change_name = change_name;
	}

	public String getRrate() {
		return Rrate;
	}

	public void setRrate(String rrate) {
		Rrate = rrate;
	}

	public String getReservationrate() {
		return reservationrate;
	}

	public void setReservationrate(String reservationrate) {
		this.reservationrate = reservationrate;
	}

	@Override
	public String toString() {
		return "Movie [mcode=" + mcode + ", mbcode=" + mbcode + ", mtitle=" + mtitle + ", mtitleEng=" + mtitleEng
				+ ", mtitlePlot=" + mtitlePlot + ", plot=" + plot + ", Category=" + Category + ", mDirector="
				+ mDirector + ", mActor=" + mActor + ", kinds=" + kinds + ", info=" + info + ", ageCut=" + ageCut
				+ ", release=" + release + ", mCount=" + mCount + ", rate=" + rate + ", p=" + p + ", plist=" + plist
				+ "]";
	}
	

}
