package com.merchant.ui.tests.data;

public class SearchCriteria {
	
	private String select;
	private String text;
	private String type;
	
	

	public SearchCriteria(String select, String text, String type) {
		super();
		this.select = select;
		this.text = text;
		this.type = type;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SearchCriteria [select=" + select + ", text=" + text + ", type=" + type + "]";
	}
	
	
	

}
