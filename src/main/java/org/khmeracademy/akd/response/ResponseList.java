package org.khmeracademy.akd.response;



import java.util.ArrayList;
import java.util.List;

import org.khmeracademy.akd.repositories.provider.PageForm;
import org.khmeracademy.akd.utilities.Paging;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseList<T> extends Response {
//	@JsonProperty("DATA")
//	public List<T> data;
//
//	@JsonProperty("PAGING")
//	public Paging paging;
//
//
//	public List<T> getData()
//	{
//		return data;
//	}
//
//	public void setData(ArrayList doc)
//	{
//		this.data=doc;
//	}
//
//	public Paging getPaging()
//	{
//		return paging;
//	}
//	public void setPaging(Paging paging) {
//		this.paging = paging;
//	}
@JsonProperty("DATA")
public List<T> data;

	@JsonProperty("PAGING")
	public Paging paging;

	@JsonProperty("PAGEFORM")
	private PageForm pageForm;


	public PageForm getPageForm() {
		return pageForm;
	}

	public void setPageForm(PageForm pageForm) {
		this.pageForm = pageForm;
	}

	public List<T> getData()
	{
		return data;
	}

	public void setData(ArrayList doc)
	{
		this.data=doc;
	}

	public Paging getPaging()
	{
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
}
