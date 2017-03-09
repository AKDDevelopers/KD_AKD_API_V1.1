package org.khmeracademy.akd.repositories;

import org.apache.ibatis.annotations.*;
import org.khmeracademy.akd.entities.LogV2;
import org.khmeracademy.akd.repositories.provider.PageForm;
import org.khmeracademy.akd.repositories.provider.SQLProvider;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface LogRepositoryV2 {

	public final static String SELECT = " * ";
	public final static String FROM = "view_user_cat_doc_logs";
	
	@Delete("DELETE FROM akd_logs WHERE user_id = #{user_id} AND doc_id = #{doc_id}")
	boolean delete(@Param("user_id") int user_id, @Param("doc_id") String doc_id);
	
	@Delete("DELETE FROM akd_logs WHERE user_id = #{user_id}")
	boolean deletes(int user_id);
    
	@SelectProvider(type=SQLProvider.class, method = "getSqlProviderSelect")
	@Results({
		
		@Result(property="logID", column="log_id"),
		@Result(property="date", column="date"),
		@Result(property="remark", column="remark"),
		@Result(property="userID", column="user_id"),
		@Result(property="docID", column="doc_id"),
		@Result(property="status", column="status"),
		
		@Result(property="document.user.userID", column="akd_users_user_id"),
		@Result(property="document.user.name", column="akd_users_name"),
		@Result(property="document.user.password", column="akd_users_password"),
		@Result(property="document.user.email", column="akd_users_email"),
		@Result(property="document.user.phone", column="akd_users_phone"),
		@Result(property="document.user.createdDate", column="akd_users_created_date"),
		@Result(property="document.user.remark", column="akd_users_remark"),
		@Result(property="document.user.status", column="akd_users_status"),		
		@Result(property="document.user.role", column="akd_users_role"),
		@Result(property="document.user.profile", column="akd_users_profile"),
		@Result(property="document.user.userHash", column="akd_users_user_hash"),
		
		@Result(property="document.docID", column="akd_documents_doc_id"),
		@Result(property="document.title", column="akd_documents_title"),
		@Result(property="document.des", column="akd_documents_des"),
		@Result(property="document.embedLink", column="akd_documents_embed_link"),
		@Result(property="document.thumbnailURL", column="akd_documents_thumbnail_url"),
		@Result(property="document.exportLink", column="akd_documents_export_link"),
		@Result(property="document.view", column="akd_documents_view"),
		@Result(property="document.share", column="akd_documents_share"),		
		@Result(property="document.createdDate", column="akd_documents_created_date"),
		@Result(property="document.docTypeNum", column="akd_documents_doc_type_num"),
		@Result(property="document.userID", column="akd_users_user_id"),
		@Result(property="document.catID", column="akd_categories_cat_id"),
		@Result(property="document.status", column="akd_documents_status"),
		
		@Result(property="document.category.catID", column="akd_categories_cat_id"),
		@Result(property="document.category.catName", column="akd_categories_name"),
		@Result(property="document.category.createdDate", column="akd_categories_created_date"),
		@Result(property="document.category.remark", column="akd_categories_remark"),
		@Result(property="document.category.parentID", column="akd_categories_parent_id"),
		@Result(property="document.category.status", column="akd_categories_status"),
		@Result(property="document.category.icon", column="akd_categories_icon")
	})
	public ArrayList<LogV2> getLogV2(@Param("pageForm") PageForm pageForm, @Param("select") final String select, @Param("table") final String table);
	
	@SelectProvider(type=SQLProvider.class, method = "getSqlProviderCount")
	public long countLogV2(@Param("pageForm") PageForm pageForm, @Param("table") final String table);
}
