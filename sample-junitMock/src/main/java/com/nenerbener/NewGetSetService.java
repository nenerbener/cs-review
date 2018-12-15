package com.nenerbener;

import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;

import com.nenerbener.api.GetSetDataInterface;

/**
 * This is a new GetSetService that is generalized to connect to any type of GET/SET api
 * including web applications, mysql DBs, flat files, etc and performs some additional
 * filtering on the data,
 *
 */
public class NewGetSetService 
{
   
	//connector interface
	private GetSetDataInterface gsService;

	/**
	 * constructor that encapsulates a GetSetDataInterface object
	 * @param gs - GetSetDataInterface object
	 */
	NewGetSetService(GetSetDataInterface gs) {
		this.gsService = gs;
	}
	
	/**
	 * Gets a list of ArrayList<String> based on query input
	 * @param query
	 * @return list object or throws a NullPointerException
	 * @throws NullPointerException
	 */
	public List<String> GetListBasedOnQuery(String query) throws NullPointerException {
		List<String> gsList = gsService.getList(query);
		if (gsList == null) throw new NullPointerException();
		else return gsList;
	}

	/** 
	 * return list that is queried and contains only name
	 * @param query - query to gsService
	 * @param name - name to filter
	 * @return list of filtered names
	 */
	public List<String> filterQueryListToReturnName(String query, String name) {
		List<String> result = GetListBasedOnQuery(query);
		Iterator<String> iterator = result.iterator();
		
		// create new filtered list without destroying original list
		List<String> filterList = new ArrayList<String>();
		
		//
		while (iterator.hasNext()) {
			String temStr = iterator.next();
			if (temStr.equals(name)) filterList.add(temStr);
		}
		return filterList;
	}

	/**
	 * return the count of the query
	 * @param query - query to gsService
	 * @return count of the query
	 */
	public Integer countQueryList(String query) {
		List<String> result = null;
		try {
			result = GetListBasedOnQuery(query);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		return result.size();
	}
}
