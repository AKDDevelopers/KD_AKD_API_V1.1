package org.khmeracademy.akd.services;

import org.khmeracademy.akd.entities.DocumentV2;
import org.khmeracademy.akd.repositories.provider.PageForm;

import java.util.ArrayList;

public interface DocumentServiceV2 {
	
	ArrayList<DocumentV2> getDocumentsV2(PageForm pageForm);
	PageForm countDocumentsV2(PageForm pageForm);
	
	ArrayList<DocumentV2> getSaveListDocumentsV2(PageForm pageForm);
	PageForm countSaveListDocumentsV2(PageForm pageForm);
	
	ArrayList<String> getSeggestionDocumentNames(PageForm pageForm);
	PageForm countSeggestionDocumentNames(PageForm pageForm);
	
	public ArrayList<String> getHistoryDocumentNames(PageForm pageForm);
	public PageForm countHistoryDocumentNames(PageForm pageForm);
	
	DocumentV2 getDocumentV2(String docId);

}
