package movie.model.vo;

import java.io.Serializable;

public class MovieCharmingPoint implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7634912346553069802L;
	private float Rrate;
	private float charmingPoint;
	private float director_production;
	private float OST;
	private float action_acting;
	private float Story;
	private float Movie_beauty;
	
	public MovieCharmingPoint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieCharmingPoint(float rrate, float charmingPoint, float director_production, float oST,
			float action_acting, float story, float movie_beauty) {
		super();
		Rrate = rrate;
		this.charmingPoint = charmingPoint;
		this.director_production = director_production;
		OST = oST;
		this.action_acting = action_acting;
		Story = story;
		Movie_beauty = movie_beauty;
	}
	public float getRrate() {
		return Rrate;
	}
	public void setRrate(float rrate) {
		Rrate = rrate;
	}
	public float getCharmingPoint() {
		return charmingPoint;
	}
	public void setCharmingPoint(float charmingPoint) {
		this.charmingPoint = charmingPoint;
	}
	public float getDirector_production() {
		return director_production;
	}
	public void setDirector_production(float director_production) {
		this.director_production = director_production;
	}
	public float getOST() {
		return OST;
	}
	public void setOST(float oST) {
		OST = oST;
	}
	public float getAction_acting() {
		return action_acting;
	}
	public void setAction_acting(float action_acting) {
		this.action_acting = action_acting;
	}
	public float getStory() {
		return Story;
	}
	public void setStory(float story) {
		Story = story;
	}
	public float getMovie_beauty() {
		return Movie_beauty;
	}
	public void setMovie_beauty(float movie_beauty) {
		Movie_beauty = movie_beauty;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "MovieCharmingPoint [Rrate=" + Rrate + ", charmingPoint=" + charmingPoint + ", director_production="
				+ director_production + ", OST=" + OST + ", action_acting=" + action_acting + ", Story=" + Story
				+ ", Movie_beauty=" + Movie_beauty + "]";
	}
	
	
}
