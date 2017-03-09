package org.khmeracademy.akd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.khmeracademy.akd.repositories.provider.PageForm;

import java.util.ArrayList;

public class DocumentSeggestionTitle {

	@JsonProperty("DOCUMENT_TITLE")
	private ArrayList<String> documentTitle;
	
	@JsonProperty("PAGEFORM")
	private PageForm pageForm;

	public ArrayList<String> getDocumentTitle() {
		return documentTitle;
	}

	public void setDocumentTitle(ArrayList<String> documentTitle) {
		this.documentTitle = documentTitle;
	}

	public PageForm getPageForm() {
		return pageForm;
	}

	public void setPageForm(PageForm pageForm) {
		this.pageForm = pageForm;
	}
	
	
}
