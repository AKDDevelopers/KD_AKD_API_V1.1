package org.khmeracademy.akd.repositories;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.akd.entities.SavelistV2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SavelistRepositoryV2 {

	@Select("SELECT * FROM akd_save_lists WHERE user_id = #{userID} AND status = 1")
	
	@Results({
		@Result(property="savelistID", column="save_list_id"),
		@Result(property="name", column="name"),
		@Result(property="createdDate", column="created_date"),
		@Result(property="remark", column="remark"),
		@Result(property="status", column="status"),
		@Result(property="userID", column="user_id"),
		@Result(property="total_doc", column="save_list_id", one = @One(select = "countSaveListDocuments"))
	})
	ArrayList<SavelistV2> findSavelistByUserID(int userID);
	
	@Select("SELECT COUNT(*) FROM view_user_cat_doc_savelist WHERE save_list_id = #{saveListId}")
	int countSaveListDocuments(int saveListId);
	
}





