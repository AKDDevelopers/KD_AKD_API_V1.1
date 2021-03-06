package org.khmeracademy.akd.services;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.khmeracademy.akd.entities.Document;
import org.khmeracademy.akd.utilities.Pagination;
import org.khmeracademy.akd.utilities.Paging;

public interface DocumentService {	
	boolean delete(String id);
	
	boolean insert(Document doc);
	
	boolean update(Document doc);
	
	boolean countView(String docID);
	
	ArrayList<Object> findAll(Paging pagination);
	
	/*ArrayList<Document> getDocumentByCatID(String CatID);*/
	ArrayList<Document> getDocumentByCatID(String CatID,Paging pagination);
	ArrayList<Document> getDocumentByCatIDAndUserID(String CatID,int userID,Paging pagination);
	
	ArrayList<Document> getDocByUser(int userID, int docTypeNum);
	
	
	Document findOne(String id);
	
	ArrayList<Document> getDocumentAndUserAndCategoryAndCommentByDocID(String DocID);
	
	ArrayList<Document> getDocumentByPopular(Paging pagination);
	ArrayList<Document> getDocumentByPopularAndPagination(Paging pagination);
	
	ArrayList<Document> getDocumentByRecommended(int userID);
	ArrayList<Document> getDocumentByRecommendedAndPagination(int userID,Paging pagination);
	
	ArrayList<Document> getDocumentByNewPost();
	ArrayList<Document> getDocumentByNewPostAndPagination(Paging pagination);
	
	int getDocumentCount();
	
	ArrayList<Document> getDocumentByLikeTitle(String title);

	/*int getDocumentCountByCatID(String catID);*/

	boolean updateTotalDocByCatID(String catID);
	
	int countTotalDocByUserID(int userID);

	boolean updateShareAmount(String docID);
	
	boolean updateDocumentStatus(String docID,int status);
	
	ArrayList<Document> getAllDocumentByStatus(int status,Paging pagination);
	
	long getTotalDocumentByStatus(int status);
	
	
	// Tola - 02/02/2017
	public ArrayList<Document> getDocumentsByDocTitleOrCatID( String docTitle, String catID, Pagination pagination);
	public int countDocumentsByDocTitleOrCatID( String docTitle , String catID);

	
	
	
	
}
