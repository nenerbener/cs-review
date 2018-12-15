package com.nenerbener.api;

import java.util.List;

public interface GetSetDataInterface {
	List<String> getList(String query);
	void addToList(String name);
}
