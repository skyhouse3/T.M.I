package myPage.model.vo;

import java.sql.Date;

public class MyPage implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7162437064279836877L;
	private String User_Id; // 1. 사용자아이디
	private String User_Pw; // 2.사용자 비밀번호
	private String PW_HINT; // 3. 비밀번호 힌트
	private String HINT; // 4. 힌트
	private String User_name; // 5. 사용자 이름
	private String Birth; // 6. 생년월일
	private String Phone; // 7. 전화번호
	private String gender; // 8. 성별
	private String Email; // 9. 이메일
	private String Address; // 10. 주소
	private String Favorite; // 11. 관심장르
	private String Mvp; // 12. 회원등급
	private String Breakdown; // 13. 영화 관람내역
	private String basket; // 14. 장바구니
	private String status; // 15. 탈퇴여부
	private Date Punish; // 16. 회원 정지


	public MyPage() {
		
	}


	public MyPage(String user_Id, String user_Pw, String pW_HINT, String hINT, String user_name, String birth,
			String phone, String gender, String email, String address, String favorite, String mvp, String breakdown,
			String basket, String status, Date punish) {
		super();
		this.User_Id = user_Id;
		this.User_Pw = user_Pw;
		this.PW_HINT = pW_HINT;
		this.HINT = hINT;
		this.User_name = user_name;
		this.Birth = birth;
		this.Phone = phone;
		this.gender = gender;
		this.Email = email;
		this.Address = address;
		this.Favorite = favorite;
		this.Mvp = mvp;
		this.Breakdown = breakdown;
		this.basket = basket;
		this.status = status;
		this.Punish = punish;
	}
	
	public MyPage(String user_Id, String user_Pw, String pW_HINT, String hINT, String user_name, String birth,
			String phone, String gender, String email, String address, String favorite, String mvp, String breakdown,
			String status, Date punish) {
		super();
		this.User_Id = user_Id;
		this.User_Pw = user_Pw;
		this.PW_HINT = pW_HINT;
		this.HINT = hINT;
		this.User_name = user_name;
		this.Birth = birth;
		this.Phone = phone;
		this.gender = gender;
		this.Email = email;
		this.Address = address;
		this.Favorite = favorite;
		this.Mvp = mvp;
		this.Breakdown = breakdown;
		this.status = status;
		this.Punish = punish;
	}


	public String getUser_Id() {
		return User_Id;
	}


	public void setUser_Id(String user_Id) {
		this.User_Id = user_Id;
	}


	public String getUser_Pw() {
		return User_Pw;
	}


	public void setUser_Pw(String user_Pw) {
		this.User_Pw = user_Pw;
	}


	public String getPW_HINT() {
		return PW_HINT;
	}


	public void setPW_HINT(String pW_HINT) {
		this.PW_HINT = pW_HINT;
	}


	public String getHINT() {
		return HINT;
	}


	public void setHINT(String hINT) {
		this.HINT = hINT;
	}


	public String getUser_name() {
		return User_name;
	}


	public void setUser_name(String user_name) {
		this.User_name = user_name;
	}


	public String getBirth() {
		return Birth;
	}


	public void setBirth(String birth) {
		this.Birth = birth;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		this.Phone = phone;
	}


	public String getgender() {
		return gender;
	}


	public void setgender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		this.Email = email;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		this.Address = address;
	}


	public String getFavorite() {
		return Favorite;
	}


	public void setFavorite(String favorite) {
		this.Favorite = favorite;
	}


	public String getMvp() {
		return Mvp;
	}


	public void setMvp(String mvp) {
		this.Mvp = mvp;
	}


	public String getBreakdown() {
		return Breakdown;
	}


	public void setBreakdown(String breakdown) {
		this.Breakdown = breakdown;
	}


	public String getBasket() {
		return basket;
	}


	public void setBasket(String basket) {
		this.basket = basket;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getPunish() {
		return Punish;
	}


	public void setPunish(Date punish) {
		this.Punish = punish;
	}


	@Override
	public String toString() {
		return "MyPage [User_Id=" + User_Id + ", User_Pw=" + User_Pw + ", PW_HINT=" + PW_HINT + ", HINT=" + HINT
				+ ", User_name=" + User_name + ", Birth=" + Birth + ", Phone=" + Phone + ", gender=" + gender
				+ ", Email=" + Email + ", Address=" + Address + ", Favorite=" + Favorite + ", Mvp=" + Mvp
				+ ", Breakdown=" + Breakdown + ", basket=" + basket + ", status=" + status + ", Punish=" + Punish + "]";
	}


	

	

}