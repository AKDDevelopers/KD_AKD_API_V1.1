package org.khmeracademy.akd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentV2 {

	@JsonProperty("DOC_ID")
	private String docID;
	
	@JsonProperty("TITLE")
	private String title;
	
	@JsonProperty("DES")
	private String des;
	
	@JsonProperty("EMBEDED_LINK")
	private String embedLink;
	
	@JsonProperty("THUMBNAIL_URL")
	private String thumbnailURL;
	
	@JsonProperty("EXPORT_LINK")
	private String exportLink;
	
	@JsonProperty("VIEW")
	private int view;
	
	@JsonProperty("SHARE")
	private int share;
	
	@JsonProperty("CREATED_DATE")
	private String createdDate;
	
	@JsonProperty("DOC_TYPE_NUM")
	private int docTypeNum;
	
	@JsonProperty("USER_ID")
	private int userID;
	
	@JsonProperty("CAT_ID")
	private String catID;
	
	@JsonProperty("CAT_NAME")
	private String catName;
	
	@JsonProperty("STATUS")
	private int status;
	
//	@JsonProperty("USERS")
//	private User users;
	
	@JsonProperty("CATEGORY")
	private Category category;

	@JsonProperty("USERS")
	private User user;

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getEmbedLink() {
		return embedLink;
	}

	public void setEmbedLink(String embedLink) {
		this.embedLink = embedLink;
	}

	public String getThumbnailURL() {
		return thumbnailURL;
	}

	public void setThumbnailURL(String thumbnailURL) {
		this.thumbnailURL = thumbnailURL;
	}

	public String getExportLink() {
		return exportLink;
	}

	public void setExportLink(String exportLink) {
		this.exportLink = exportLink;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getDocTypeNum() {
		return docTypeNum;
	}

	public void setDocTypeNum(int docTypeNum) {
		this.docTypeNum = docTypeNum;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getCatID() {
		return catID;
	}

	public void setCatID(String catID) {
		this.catID = catID;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

//	public User getUsers() {
//		return users;
//	}
//
//	public void setUsers(User users) {
//		this.users = users;
//	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
