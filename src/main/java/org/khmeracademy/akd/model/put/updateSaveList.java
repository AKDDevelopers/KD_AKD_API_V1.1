package org.khmeracademy.akd.model.put;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class updateSaveList {
	@JsonProperty("LIST_ID")
	private int savelistID;

	@JsonProperty("LIST_NAME")
	private String name;
	
	@JsonProperty("CREATED_DATE")
	private String createdDate;
	
	@JsonProperty("REMARK")
	private String remark;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@JsonProperty("USER_ID")
	private int userID;
	
	
	@JsonProperty("STATUS")
	private int status;


	public int getSavelistID() {
		return savelistID;
	}
	public void setSavelistID(int savelistID) {
		this.savelistID = savelistID;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}






	
	
}
