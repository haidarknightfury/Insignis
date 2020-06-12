package com.insignis.apigateway.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tabs implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Tab> tabs = new ArrayList<Tab>();

	public Tabs(List<Tab> tabs) {
		super();
		this.tabs = tabs;
	}

	public Tabs() {
		super();
	}

	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}

}
