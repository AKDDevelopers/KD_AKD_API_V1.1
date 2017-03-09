package org.khmeracademy.akd.services.impl;

import org.khmeracademy.akd.entities.DocumentV2;
import org.khmeracademy.akd.repositories.DocumentRepositoryV2;
import org.khmeracademy.akd.repositories.provider.PageForm;
import org.khmeracademy.akd.services.DocumentServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DocumentServiceV2Impl implements DocumentServiceV2 {

	@Autowired
	private DocumentRepositoryV2 dao;
	@Override
	public ArrayList<DocumentV2> getDocumentsV2(PageForm pageForm) {
		// TODO Auto-generated method stub
		
		try{
			implementPageForm(pageForm);
			long totalRecord = dao.countDocumentsV2(pageForm, DocumentRepositoryV2.FROM);
			int totalPage = (int) Math.ceil((double)totalRecord / pageForm.getLimit());
			pageForm.setTotalRecord(totalRecord);
			pageForm.setTotalPage(totalPage);
			//return pageForm;
			ArrayList<DocumentV2> arr = dao.getDocumentsV2(pageForm, DocumentRepositoryV2.SELECT, DocumentRepositoryV2.FROM);
			//System.out.println(arr);
			return arr;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void implementPageForm(PageForm pageForm){
		for(int row = 0; row < pageForm.getColumnName().size(); row++){
			if(pageForm.getColumnName().get(row).equals("akd_users_user_id")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::INTEGER");
			}else if(pageForm.getColumnName().get(row).equals("akd_users_name")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::VARCHAR");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_doc_id")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::INTEGER");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_title")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::VARCHAR");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_des")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::TEXT");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_view")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::INTEGER");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_share")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::INTEGER");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_doc_type_num")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::INTEGER");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_status")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::INTEGER");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_status")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::INTEGER");
			}else if(pageForm.getColumnName().get(row).equals("akd_documents_created_date")){
				pageForm.getColumnName().set(row, "to_timestamp(akd_documents_created_date, 'dd-MM-yyyy HH24:MI:SS')");
				pageForm.getConditionValue().set(row, "to_timestamp('" + pageForm.getConditionValue().get(row) + "', 'dd-MM-yyyy HH24:MI:SS')");
			}else if(pageForm.getColumnName().get(row).equals("akd_categories_cat_id")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::VARCHAR");
			}else if(pageForm.getColumnName().get(row).equals("akd_categories_status")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::INTEGER");
			}else if(pageForm.getColumnName().get(row).equals("akd_categories_name")){
				pageForm.getConditionValue().set(row, "'" + pageForm.getConditionValue().get(row) + "'::VARCHAR");
			}
		}
	}


	@Override
	public PageForm countDocumentsV2(PageForm pageForm) {
		try{
			implementPageForm(pageForm);
			long totalRecord = dao.countDocumentsV2(pageForm, DocumentRepositoryV2.FROM);
			int totalPage = (int) Math.ceil((double)totalRecord / pageForm.getLimit());
			pageForm.setTotalRecord(totalRecord);
			pageForm.setTotalPage(totalPage);
			return pageForm;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public ArrayList<String> getSeggestionDocumentNames(PageForm pageForm) {
		try{
			pageForm = countSeggestionDocumentNames(pageForm);
			return dao.getSeggestionDocumentNames(pageForm, DocumentRepositoryV2.SELECT_DOC_NAME, DocumentRepositoryV2.FROM_DOC);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public PageForm countSeggestionDocumentNames(PageForm pageForm) {
		try{
			long totalRecord = dao.countSeggestionDocumentNames(pageForm, DocumentRepositoryV2.SELECT_COUN_DOC_NAME ,DocumentRepositoryV2.FROM_DOC);
			int totalPage = (int) Math.ceil((double)totalRecord / pageForm.getLimit());
			pageForm.setTotalRecord(totalRecord);
			pageForm.setTotalPage(totalPage);
			return pageForm;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public ArrayList<String> getHistoryDocumentNames(PageForm pageForm) {
		try{
			pageForm = countHistoryDocumentNames(pageForm);
			return dao.getHistoryDocumentNames(pageForm, DocumentRepositoryV2.SELECT_HISTRY_DOC_NAME, DocumentRepositoryV2.FROM_HISTORY_DOC);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public PageForm countHistoryDocumentNames(PageForm pageForm) {
		try{
			long totalRecord = dao.countHistoryDocumentNames(pageForm, DocumentRepositoryV2.SELECT_COUNT_HISTRY_DOC_NAME, DocumentRepositoryV2.FROM_HISTORY_DOC);
			int totalPage = (int) Math.ceil((double)totalRecord / pageForm.getLimit());
			pageForm.setTotalRecord(totalRecord);
			pageForm.setTotalPage(totalPage);
			return pageForm;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public ArrayList<DocumentV2> getSaveListDocumentsV2(PageForm pageForm) {
		try{
			//implementPageForm(pageForm);
			ArrayList<DocumentV2> arr = dao.getDocumentsV2(pageForm, DocumentRepositoryV2.SELECT, DocumentRepositoryV2.FROM_SAVELIST_DOC);
			//System.out.println(arr);
			return arr;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public PageForm countSaveListDocumentsV2(PageForm pageForm) {
		try{
			implementPageForm(pageForm);
			long totalRecord = dao.countDocumentsV2(pageForm, DocumentRepositoryV2.FROM_SAVELIST_DOC);
			int totalPage = (int) Math.ceil((double)totalRecord / pageForm.getLimit());
			pageForm.setTotalRecord(totalRecord);
			pageForm.setTotalPage(totalPage);
			return pageForm;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public DocumentV2 getDocumentV2(String docId) {
		try{
			//implementPageForm(pageForm);
			DocumentV2 arr = dao.getDocumentV2(docId);
			if(arr != null){
				dao.updateDocumentView(arr.getDocID());
			}
			//System.out.println(arr);
			return arr;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
