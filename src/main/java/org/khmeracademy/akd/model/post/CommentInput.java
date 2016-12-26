package org.khmeracademy.akd.model.post;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentInput {
	
	@JsonProperty("CREATED_DATE")
	private String createdDate;
	
	@JsonProperty("REMARK")
	private String remark;
	
	@JsonProperty("USER_ID")
	private int userID;
	
	@JsonProperty("DOC_ID")
	private String docID;
	
	@JsonProperty("STATUS")
	private int status;
	
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}


}
