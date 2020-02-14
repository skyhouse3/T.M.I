package Member.model.vo;

import java.sql.Date;

public class Member {
	private String MemId;
	private String MemPw;
	private Date Birth;
	private String Phone;
	private String Addnum;
	private String Address;
	private String Favorite;
	private String gender;
	private String Mvp;
	private String Breakdown;
	private String Basket;
	private char Status;
	private Date Punish;
	public Member() {
		
	}
	
	public Member(String memId, String mvp) {
		super();
		MemId = memId;
		Mvp = mvp;
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Member(String memId, String mvp, Date punish) {
		super();
		MemId = memId;
		Mvp = mvp;
		Punish = punish;
	}

	public Member(String memId, String memPw, Date birth, String phone, String addnum, String address, String favorite,
			String breakdown, String basket, char status) {
		super();
		MemId = memId;
		MemPw = memPw;
		Birth = birth;
		Phone = phone;
		Addnum = addnum;
		Address = address;
		Favorite = favorite;
		Breakdown = breakdown;
		Basket = basket;
		Status = status;
	}
	public Member(String memId, String memPw, Date birth, String phone, String addnum, String address, String favorite,
			String mvp, String breakdown, String basket, char status, Date punish) {
		super();
		MemId = memId;
		MemPw = memPw;
		Birth = birth;
		Phone = phone;
		Addnum = addnum;
		Address = address;
		Favorite = favorite;
		Mvp = mvp;
		Breakdown = breakdown;
		Basket = basket;
		Status = status;
		Punish = punish;
	}
	public String getMemId() {
		return MemId;
	}
	public void setMemId(String memId) {
		MemId = memId;
	}
	public String getMemPw() {
		return MemPw;
	}
	public void setMemPw(String memPw) {
		MemPw = memPw;
	}
	public Date getBirth() {
		return Birth;
	}
	public void setBirth(Date birth) {
		Birth = birth;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddnum() {
		return Addnum;
	}
	public void setAddnum(String addnum) {
		Addnum = addnum;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getFavorite() {
		return Favorite;
	}
	public void setFavorite(String favorite) {
		Favorite = favorite;
	}
	public String getMvp() {
		return Mvp;
	}
	public void setMvp(String mvp) {
		Mvp = mvp;
	}
	public String getBreakdown() {
		return Breakdown;
	}
	public void setBreakdown(String breakdown) {
		Breakdown = breakdown;
	}
	public String getBasket() {
		return Basket;
	}
	public void setBasket(String basket) {
		Basket = basket;
	}
	public char getStatus() {
		return Status;
	}
	public void setStatus(char status) {
		Status = status;
	}
	public Date getPunish() {
		return Punish;
	}
	public void setPunish(Date punish) {
		Punish = punish;
	}
	@Override
	public String toString() {
		return "Member [MemId=" + MemId + ", MemPw=" + MemPw + ", Birth=" + Birth + ", Phone=" + Phone + ", Addnum="
				+ Addnum + ", Address=" + Address + ", Favorite=" + Favorite + ", Mvp=" + Mvp + ", Breakdown="
				+ Breakdown + ", Basket=" + Basket + ", Status=" + Status + ", Punish=" + Punish + "]";
	}

}
