package com.dnp.home.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <pre>
 * key 값을 기준으로 내림차순(DESC)으로 정렬한다.
 * 
 * add(1, o1)
 * add(2, o2)
 * add(3, o3)
 * add(1, o4)
 * add(3, o5)
 * 
 * getList()
 * return [o3,o5,o2,o1,o4]
 * 
 * size()
 * return 5
 * 
 * </pre>
 * @author pblee@cnuglobal.com
 */
public class Sorter {
	private Map<Integer, List<Object>> treeMap;
	
	public Sorter() {
		treeMap = new TreeMap<Integer, List<Object>>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
				});
	}
	
	public void add(int key, Object value) {
		List<Object> list = treeMap.get(key);
		if (list == null) {
			list = new ArrayList<Object>();
			list.add(value);
		} else {
			list.add(value);
		}
		treeMap.put(key, list);
	}
	
	public int size() {
		int size = 0;
		List<List<Object>> listOfList = new ArrayList<List<Object>>();
		listOfList.addAll(treeMap.values());
		for (List<Object> list : listOfList) {
			size += list.size();
		}
		return size;
	}
	
	public List<Object> getList() {
		List<Object> result = new ArrayList<Object>();
		List<List<Object>> listOfList = new ArrayList<List<Object>>();
		listOfList.addAll(treeMap.values());
		for (List<Object> list : listOfList) {
			result.addAll(list);
		}
		return result;
	}
}
