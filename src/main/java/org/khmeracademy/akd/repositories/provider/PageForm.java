package org.khmeracademy.akd.repositories.provider;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PageForm {
	
	@JsonProperty("COLUMNNAME")
	private List<String> columnName;
	@JsonProperty("CONDITIONVALUE")
	private List<String> conditionValue;
	@JsonProperty("COPARESYMBOL")
	private List<String> compareSymbol;
	@JsonProperty("LOGICALSYMBOL")
	private List<String> logicalSymbol;
	
	@JsonProperty("LIMIT")
	private int limit;
	@JsonProperty("PAGE")
	private int page;
	
	@JsonProperty("TOTALRECORD")
	private long totalRecord;
	
	@JsonProperty("TOTALPAGE")
	private int totalPage;
	
	
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<String> getColumnName() {
		return columnName;
	}
	public void setColumnName(List<String> columnName) {
		this.columnName = columnName;
	}
	public List<String> getConditionValue() {
		return conditionValue;
	}
	public void setConditionValue(List<String> conditionValue) {
		this.conditionValue = conditionValue;
	}
	public List<String> getCompareSymbol() {
		return compareSymbol;
	}
	public void setCompareSymbol(List<String> compareSymbol) {
		this.compareSymbol = compareSymbol;
	}
	public List<String> getLogicalSymbol() {
		return logicalSymbol;
	}
	public void setLogicalSymbol(List<String> logicalSymbol) {
		this.logicalSymbol = logicalSymbol;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	
}
