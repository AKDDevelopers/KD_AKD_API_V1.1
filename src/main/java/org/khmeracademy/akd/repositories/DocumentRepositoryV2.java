package org.khmeracademy.akd.repositories;

import org.apache.ibatis.annotations.*;
import org.khmeracademy.akd.entities.DocumentV2;
import org.khmeracademy.akd.repositories.provider.PageForm;
import org.khmeracademy.akd.repositories.provider.SQLProvider;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DocumentRepositoryV2 {
	
	public final static String SELECT = " * ";
	public final static String FROM = "view_user_cat_doc";
	
	public final static String SELECT_DOC_NAME  = "DISTINCT akd_documents.title";
	
	public final static String SELECT_COUN_DOC_NAME  = "COUNT(DISTINCT akd_documents.title)";
	
	public final static String FROM_DOC = "akd_documents";
	
	public final static String SELECT_COUNT_HISTRY_DOC_NAME  = "COUNT(DISTINCT akd_documents_title)";
	
	public final static String SELECT_HISTRY_DOC_NAME  = "akd_documents_title";
	
	public final static String FROM_HISTORY_DOC = "view_user_cat_doc_logs";
	
	public final static String FROM_SAVELIST_DOC = "view_user_cat_doc_savelist";
	
	public final static String UPDATE_DOCUMENT_VIEW = "UPDATE akd_documents SET view = view + 1 WHERE akd_documents.doc_id = #{docId}";
	
	@Update(UPDATE_DOCUMENT_VIEW)
	boolean updateDocumentView(String docId);
	
	
	/*
	akd_users.user_id AS akd_users_user_id,
    akd_users.name AS akd_users_name,
    akd_users.password AS akd_users_password,
    akd_users.email AS akd_users_email,
    akd_users.phone AS akd_users_phone,
    akd_users.created_date AS akd_users_created_date,
    akd_users.remark AS akd_users_remark,
    akd_users.status AS akd_users_status,
    akd_users.role AS akd_users_role,
    akd_users.profile AS akd_users_profile,
    akd_users.user_hash AS akd_users_user_hash,
    akd_documents.doc_id AS akd_documents_doc_id,
    akd_documents.title AS akd_documents_title,
    akd_documents.des AS akd_documents_des,
    akd_documents.embed_link AS akd_documents_embed_link,
    akd_documents.thumbnail_url AS akd_documents_thumbnail_url,
    akd_documents.export_link AS akd_documents_export_link,
    akd_documents.view AS akd_documents_view,
    akd_documents.share AS akd_documents_share,
    akd_documents.doc_type_num AS akd_documents_doc_type_num,
    akd_documents.status AS akd_documents_status,
    akd_documents.created_date AS akd_documents_created_date,
    akd_categories.cat_id AS akd_categories_cat_id,
    akd_categories.name AS akd_categories_name,
    akd_categories.created_date AS akd_categories_created_date,
    akd_categories.remark AS akd_categories_remark,
    akd_categories.parent_id AS akd_categories_parent_id,
    akd_categories.status AS akd_categories_status,
    akd_categories.icon AS akd_categories_icon,
    akd_categories.rang_order AS akd_categories_rang_order,
    akd_categories.level AS akd_categories_level,
    akd_categories.cat_img AS akd_categories_cat_img
    
    @JsonProperty("CAT_ID")
	private String catID;
	
	@JsonProperty("CAT_NAME")
	private String catName;
	
	@JsonProperty("IMAGE")
	private String catImage;
    
    public List<Room> getRoomCond(@Param("pageForm") com.somoun_dev.model.provider.PageForm pageForm,@Param("select") final String select, @Param("table") final String table);
	 
	 
	 @JsonProperty("PROFILE")
	private String profile;	
	
	@JsonProperty("ROLES")
	private List<Role> roles;
	
	@JsonProperty("USER_HASH")
	private String userHash;
	
	akd_users.user_id AS akd_users_user_id,
    akd_users.name AS akd_users_name,
    akd_users.password AS akd_users_password,
    akd_users.email AS akd_users_email,
    akd_users.phone AS akd_users_phone,
    akd_users.created_date AS akd_users_created_date,
    akd_users.remark AS akd_users_remark,
    akd_users.status AS akd_users_status,
    akd_users.role AS akd_users_role,
    akd_users.profile AS akd_users_profile,
    akd_users.user_hash AS akd_users_user_hash,
    
    */
	
	
	
	@SelectProvider(type=SQLProvider.class, method = "getSqlProviderSelect")
	@Results({
		@Result(property="user.userID", column="akd_users_user_id"),
		@Result(property="user.name", column="akd_users_name"),
		@Result(property="user.password", column="akd_users_password"),
		@Result(property="user.email", column="akd_users_email"),
		@Result(property="user.phone", column="akd_users_phone"),
		@Result(property="user.createdDate", column="akd_users_created_date"),
		@Result(property="user.remark", column="akd_users_remark"),
		@Result(property="user.status", column="akd_users_status"),		
		@Result(property="user.role", column="akd_users_role"),
		@Result(property="user.profile", column="akd_users_profile"),
		@Result(property="user.userHash", column="akd_users_user_hash"),
		
		@Result(property="docID", column="akd_documents_doc_id"),
		@Result(property="title", column="akd_documents_title"),
		@Result(property="des", column="akd_documents_des"),
		@Result(property="embedLink", column="akd_documents_embed_link"),
		@Result(property="thumbnailURL", column="akd_documents_thumbnail_url"),
		@Result(property="exportLink", column="akd_documents_export_link"),
		@Result(property="view", column="akd_documents_view"),
		@Result(property="share", column="akd_documents_share"),		
		@Result(property="createdDate", column="akd_documents_created_date"),
		@Result(property="docTypeNum", column="akd_documents_doc_type_num"),
		@Result(property="userID", column="akd_users_user_id"),
		@Result(property="catID", column="akd_categories_cat_id"),
		@Result(property="status", column="akd_documents_status"),
		
		@Result(property="category.catID", column="akd_categories_cat_id"),
		@Result(property="category.catName", column="akd_categories_name"),
		@Result(property="category.createdDate", column="akd_categories_created_date"),
		@Result(property="category.remark", column="akd_categories_remark"),
		@Result(property="category.parentID", column="akd_categories_parent_id"),
		@Result(property="category.status", column="akd_categories_status"),
		@Result(property="category.icon", column="akd_categories_icon")
	})
	public ArrayList<DocumentV2> getDocumentsV2(@Param("pageForm") PageForm pageForm, @Param("select") final String select, @Param("table") final String table);
	
	@Select(" SELECT * FROM view_user_cat_doc WHERE akd_documents_doc_id = #{docId}")
	@Results({
		@Result(property="user.userID", column="akd_users_user_id"),
		@Result(property="user.name", column="akd_users_name"),
		@Result(property="user.password", column="akd_users_password"),
		@Result(property="user.email", column="akd_users_email"),
		@Result(property="user.phone", column="akd_users_phone"),
		@Result(property="user.createdDate", column="akd_users_created_date"),
		@Result(property="user.remark", column="akd_users_remark"),
		@Result(property="user.status", column="akd_users_status"),		
		@Result(property="user.role", column="akd_users_role"),
		@Result(property="user.profile", column="akd_users_profile"),
		@Result(property="user.userHash", column="akd_users_user_hash"),
		
		@Result(property="docID", column="akd_documents_doc_id"),
		@Result(property="title", column="akd_documents_title"),
		@Result(property="des", column="akd_documents_des"),
		@Result(property="embedLink", column="akd_documents_embed_link"),
		@Result(property="thumbnailURL", column="akd_documents_thumbnail_url"),
		@Result(property="exportLink", column="akd_documents_export_link"),
		@Result(property="view", column="akd_documents_view"),
		@Result(property="share", column="akd_documents_share"),		
		@Result(property="createdDate", column="akd_documents_created_date"),
		@Result(property="docTypeNum", column="akd_documents_doc_type_num"),
		@Result(property="userID", column="akd_users_user_id"),
		@Result(property="catID", column="akd_categories_cat_id"),
		@Result(property="status", column="akd_documents_status"),
		
		@Result(property="category.catID", column="akd_categories_cat_id"),
		@Result(property="category.catName", column="akd_categories_name"),
		@Result(property="category.createdDate", column="akd_categories_created_date"),
		@Result(property="category.remark", column="akd_categories_remark"),
		@Result(property="category.parentID", column="akd_categories_parent_id"),
		@Result(property="category.status", column="akd_categories_status"),
		@Result(property="category.icon", column="akd_categories_icon")
	})
	public DocumentV2 getDocumentV2(String docId);
	
	@SelectProvider(type=SQLProvider.class, method = "getSqlProviderCount")
	public long countDocumentsV2(@Param("pageForm") PageForm pageForm, @Param("table") final String table);
	
	@SelectProvider(type=SQLProvider.class, method = "getSqlProviderSelect")
	public ArrayList<String> getSeggestionDocumentNames(@Param("pageForm") PageForm pageForm, @Param("select") final String select, @Param("table") final String table);
	
	@SelectProvider(type=SQLProvider.class, method = "getSqlProviderCount")
	public long countSeggestionDocumentNames(@Param("pageForm") PageForm pageForm, @Param("select") final String select, @Param("table") final String table);
	
	@SelectProvider(type=SQLProvider.class, method = "getSqlProviderSelect")
	public ArrayList<String> getHistoryDocumentNames(@Param("pageForm") PageForm pageForm, @Param("select") final String select, @Param("table") final String table);
	
	@SelectProvider(type=SQLProvider.class, method = "getSqlProviderCount")
	public long countHistoryDocumentNames(@Param("pageForm") PageForm pageForm, @Param("select") final String select, @Param("table") final String table);

}
