package org.khmeracademy.akd.repositories.provider;

import org.khmeracademy.akd.utilities.Pagination;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentSqlBuilder {
	
	public static String getDocumentsByDocTitleOrCatID(String docTitle, String catID , Pagination pagination){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT"
			+ "	d.doc_id ,"
			+ "	d.title,"
			+ "	d.des,"
			+ "	d.embed_link,"
			+ "	d.thumbnail_url,"
			+ "	d.export_link,"
			+ "	d.view,"
			+ "	d.share,"
			+ "	d.doc_type_num,"
			+ "	d.user_id,"
			+ "	u.name,"
			+ "	d.cat_id,"
			+ "	d.status,"
			+ "	d.created_date,"
			+ "	d.id"
			+ "	FROM"
			+ "	akd_documents d LEFT JOIN akd_users u ON d.user_id = u.user_id"
			+ "	WHERE"
			+ "	d.status = 1 ");
			
			if(!catID.equals("")){
				buffer.append(" AND d.cat_id= #{catID}");
			}
			
			if(!docTitle.equals("")){
				buffer.append(" AND LOWER(d.title) LIKE LOWER('%'||#{docTitle}||'%')  ");
			}
			
			buffer.append(" ORDER BY "
			+ "	d.id DESC"
			+ "	LIMIT #{pagination.limit} OFFSET #{pagination.offset}");

			return buffer.toString();
	}
	
	
	public static String countDocumentsByDocTitleOrCatID(String docTitle,  String catID){
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT"
			+ "	COUNT(doc_id)"
			+ "	FROM"
			+ "	akd_documents d LEFT JOIN akd_users u ON d.user_id = u.user_id"
			+ "	WHERE"
			+ "	d.status = 1 ");
		
			if(!catID.equals("")){
				buffer.append(" AND d.cat_id= #{catID}");
			}
			return buffer.toString();
	}

}
