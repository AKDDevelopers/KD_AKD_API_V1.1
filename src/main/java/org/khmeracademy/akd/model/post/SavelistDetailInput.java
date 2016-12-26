package org.khmeracademy.akd.model.post;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SavelistDetailInput {
	@JsonProperty("LIST_ID")
	private int savelistID;

	
	@JsonProperty("CREATED_DATE")
	private String createdDate;


	@JsonProperty("DOC_ID")
	private String docID;

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


	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}



	
	
}
