package joinPage.model.vo;

import java.sql.Date;

public class Join implements java.io.Serializable {
   /**
    * 
    */
   private static final long serialVersionUID = -4484931821129498981L;
   private String User_Id; // 1. 사용자아이디
   private String User_pw; // 2.사용자 비밀번호
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
   private String status; // 14. 탈퇴여부
   private Date Punish; // 15. 회원 정지
   
   public Join() {
      
   }


   public Join(String user_Id, String user_pw, String pW_HINT, String hINT, String user_name, String birth, String phone,
         String gender, String email, String address, String favorite, String mvp, String breakdown, String status, Date punish) {
      super();
      this.User_Id = user_Id;
      this.User_pw = user_pw;
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

   public Join(String user_Id, String user_pw, String pW_HINT, String hINT, String user_name, String birth, String phone,
         String gender, String email, String address, String favorite, String mvp, String breakdown, String status) {
      super();
      this.User_Id = user_Id;
      this.User_pw = user_pw;
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
   }

   
   public Join(String user_Id, String user_pw, String pW_HINT, String hINT, String user_name, String gender,String birth, String phone,
          String email, String address, String favorite) {
      super();
      this.User_Id = user_Id;
      this.User_pw = user_pw;
      this.PW_HINT = pW_HINT;
      this.HINT = hINT;
      this.User_name = user_name;
      this.gender = gender;
      this.Birth = birth;
      this.Phone = phone;
      this.Email = email;
      this.Address = address;
      this.Favorite = favorite;
   
   }


   public String getUser_Id() {
      return User_Id;
   }


   public void setUser_Id(String user_Id) {
      User_Id = user_Id;
   }


   public String getUser_pw() {
      return User_pw;
   }


   public void setUser_pw(String user_pw) {
      User_pw = user_pw;
   }


   public String getPW_HINT() {
      return PW_HINT;
   }


   public void setPW_HINT(String pW_HINT) {
      PW_HINT = pW_HINT;
   }


   public String getHINT() {
      return HINT;
   }


   public void setHINT(String hINT) {
      HINT = hINT;
   }


   public String getUser_name() {
      return User_name;
   }


   public void setUser_name(String user_name) {
      User_name = user_name;
   }


   public String getBirth() {
      return Birth;
   }


   public void setBirth(String birth) {
      Birth = birth;
   }


   public String getPhone() {
      return Phone;
   }


   public void setPhone(String phone) {
      Phone = phone;
   }


   public String getGender() {
      return gender;
   }


   public void setGender(String gender) {
      gender = gender;
   }


   public String getEmail() {
      return Email;
   }


   public void setEmail(String email) {
      Email = email;
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
      Punish = punish;
   }


@Override
public String toString() {
	return "Join [User_Id=" + User_Id + ", User_pw=" + User_pw + ", PW_HINT=" + PW_HINT + ", HINT=" + HINT
			+ ", User_name=" + User_name + ", Birth=" + Birth + ", Phone=" + Phone + ", gender=" + gender + ", Email="
			+ Email + ", Address=" + Address + ", Favorite=" + Favorite + ", Mvp=" + Mvp + ", Breakdown=" + Breakdown
			+ ", status=" + status + ", Punish=" + Punish + "]";
}  
}