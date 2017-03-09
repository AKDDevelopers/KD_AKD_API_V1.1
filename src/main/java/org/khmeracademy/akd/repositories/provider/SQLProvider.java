package org.khmeracademy.akd.repositories.provider;

import java.util.Map;

public class SQLProvider {

	public static final String SELECT = " SELECT ";
	public static final String FROM = " FROM ";
	public static final String WHERE = " WHERE ";
	public static final String COUNT_PAGE = " ceil( count(*)::NUMERIC / #{pageForm.limit} ) ";
	public static final String COUNT_RECORD = " count(*) ";
	public static final String LIMIT = " LIMIT #{pageForm.limit} OFFSET #{pageForm.limit} * #{pageForm.page}";
	public static final String VARCHAR = "::VARCHAR";
	public static final String INTEGER = "::INTEGER";
	public static final String NUMERIC = "::NUMERIC";
	public static final String TIMESTAMP = "::TIMESTAMP WITH TIME ZONE";
	
	public String getSqlProviderSelect(Map<String, Object>params) {
		PageForm pageForm = (PageForm) params.get("pageForm");
		final String select = (String) params.get("select");
		final String table = (String) params.get("table");
		return getSelectStatement(pageForm, select, table);
	}
	
	public String getSqlProviderCount(Map<String, Object>params) {
		PageForm pageForm = (PageForm) params.get("pageForm");
		final String table = (String) params.get("table");
		if(params.size() == 3){
			final String select = (String)params.get("select");
			if(select == null){
				return getCountStatement(pageForm, table);
			}else{
				return getCountStatement(pageForm, select, table);
			}
		}else{
			return getCountStatement(pageForm, table);
		}
		
	}
	
	public String getSelectStatement(PageForm pageForm, final String select, final String table){
		
		if(pageForm.getColumnName() == null || pageForm.getConditionValue() == null || pageForm.getCompareSymbol() == null){
			return SELECT + select + FROM + table + LIMIT;
		}else{
			if(pageForm.getColumnName().size() <= 0 || pageForm.getConditionValue().size() <= 0 || pageForm.getCompareSymbol().size() <= 0){
				return SELECT + select + FROM + table + LIMIT;
			}else if(pageForm.getColumnName().size() == 1 && pageForm.getConditionValue().size() == 1 && pageForm.getCompareSymbol().size() == 1){
				return SELECT + select + FROM + table + WHERE + pageForm.getColumnName().get(0) + pageForm.getCompareSymbol().get(0) + pageForm.getConditionValue().get(0) + LIMIT;
			}else{
				if(pageForm.getLogicalSymbol().size() <= 0){
					return SELECT + select + FROM + table + LIMIT;
				}
				String tmp = "";
				for(int row = 0; row < pageForm.getColumnName().size(); row++){
					tmp += pageForm.getColumnName().get(row) + pageForm.getCompareSymbol().get(row) + pageForm.getConditionValue().get(row);
					if(row < pageForm.getLogicalSymbol().size()){
						tmp += " " + pageForm.getLogicalSymbol().get(row) + " ";
					}
				}
				tmp += LIMIT;
				return SELECT + select + FROM + table + WHERE + tmp;
			}
		}
		
	}
	
	public String getCountStatement(PageForm pageForm, final String table){
		
		if(pageForm.getColumnName() == null || pageForm.getConditionValue() == null || pageForm.getCompareSymbol() == null){
			return SELECT + COUNT_RECORD + FROM + table;
		}else{
			if(pageForm.getColumnName().size() <= 0 || pageForm.getConditionValue().size() <= 0 || pageForm.getCompareSymbol().size() <= 0){
				return SELECT + COUNT_RECORD + FROM + table;
			}else if(pageForm.getColumnName().size() == 1 && pageForm.getConditionValue().size() == 1 && pageForm.getCompareSymbol().size() == 1){
				return SELECT + COUNT_RECORD + FROM + table + WHERE + pageForm.getColumnName().get(0) + pageForm.getCompareSymbol().get(0) + pageForm.getConditionValue().get(0);
			}else{
				if(pageForm.getLogicalSymbol().size() <= 0){
					return SELECT + COUNT_RECORD + FROM + table;
				}
				String tmp = "";
				for(int row = 0; row < pageForm.getColumnName().size(); row++){
					tmp += pageForm.getColumnName().get(row) + pageForm.getCompareSymbol().get(row) + pageForm.getConditionValue().get(row);
					if(row < pageForm.getLogicalSymbol().size()){
						tmp += " " + pageForm.getLogicalSymbol().get(row) + " ";
					}
				}
				//tmp += LIMIT;
				return SELECT + COUNT_RECORD + FROM + table + WHERE + tmp;
			}
		}
		
	}
	
	public String getCountStatement(PageForm pageForm, final String select, final String table){
		
		if(pageForm.getColumnName() == null || pageForm.getConditionValue() == null || pageForm.getCompareSymbol() == null){
			return SELECT + select + FROM + table;
		}else{
			if(pageForm.getColumnName().size() <= 0 || pageForm.getConditionValue().size() <= 0 || pageForm.getCompareSymbol().size() <= 0){
				return SELECT + select + FROM + table;
			}else if(pageForm.getColumnName().size() == 1 && pageForm.getConditionValue().size() == 1 && pageForm.getCompareSymbol().size() == 1){
				return SELECT + select + FROM + table + WHERE + pageForm.getColumnName().get(0) + pageForm.getCompareSymbol().get(0) + pageForm.getConditionValue().get(0);
			}else{
				if(pageForm.getLogicalSymbol().size() <= 0){
					return SELECT + select + FROM + table;
				}
				String tmp = "";
				for(int row = 0; row < pageForm.getColumnName().size(); row++){
					tmp += pageForm.getColumnName().get(row) + pageForm.getCompareSymbol().get(row) + pageForm.getConditionValue().get(row);
					if(row < pageForm.getLogicalSymbol().size()){
						tmp += " " + pageForm.getLogicalSymbol().get(row) + " ";
					}
				}
				//tmp += LIMIT;
				return SELECT + select + FROM + table + WHERE + tmp;
			}
		}
		
	}
	
	public static String bindSQLValue(String value, final String Type){
		return "'" + value + "'" + Type;
	}
}

