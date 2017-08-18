package com.gms.web.proxy;

import java.util.HashMap;
import java.util.Map;

public class RowsHandler {
	public static int PAGE_SIZE = 5;
	public static int BLOCK_SIZE = 5;
	public Integer[] attr(Integer[] params) {
		Integer[]result=new Integer[2];
		int theNumberOfRows=params[0];//("theNumberOfAll");
		int pageNumber=params[1];//("pageNumber");
		Integer startRow = 0, endRow = 0;
		Integer[] rows = new Integer[2];
		if (pageNumber <= theNumberOfRows / PAGE_SIZE + 1) {
			if (pageNumber == 1) {
				startRow = 1;
				endRow = PAGE_SIZE;
			} else {
				startRow = (pageNumber - 1) * PAGE_SIZE + 1;
				endRow = pageNumber * PAGE_SIZE;
			}
		}
		result[0]=startRow;
		result[1]=endRow;
		return result;
	}
	
	
}
