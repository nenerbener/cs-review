package com.nenerbener.api;

import java.util.List;
import java.util.ArrayList;

public class GetSetDataStub implements GetSetDataInterface {

	List<String> list = null;
	
	public GetSetDataStub() {
		list = new ArrayList<String>();
		list.add("marc");
		list.add("dawny");
		list.add("marc");
		list.add("dawny");
		list.add("marc");
		list.add("dawny");
		list.add("marc");
	}
	
	public List<String> getList(String query) {
		return list;
	}

	public void addToList(String newName) {
		list.add(newName);
	}
}
