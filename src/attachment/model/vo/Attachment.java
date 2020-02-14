package attachment.model.vo;

import java.sql.Date;

public class Attachment {
	
	private String fid;
	private String mCode;
	private String bId;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private String fileLevel;
	private String status;
	
	
	public Attachment() {
		super();
	}
	
	public Attachment(String fid, String mCode, String bId, String originName, String changeName, String filePath,
			Date uploadDate, String fileLevel, String status) {
		super();
		this.fid = fid;
		this.mCode = mCode;
		this.bId = bId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.fileLevel = fileLevel;
		this.status = status;
	}

	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getmCode() {
		return mCode;
	}
	public void setmCode(String mCode) {
		this.mCode = mCode;
	}
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getOriginName() {
		return originName;
	}
	public void setOriginName(String originName) {
		this.originName = originName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public String getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(String fileLevel) {
		this.fileLevel = fileLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Attachment [fid=" + fid + ", mCode=" + mCode + ", bId=" + bId + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate
				+ ", fileLevel=" + fileLevel + ", status=" + status + "]";
	}
	
	
	
}
