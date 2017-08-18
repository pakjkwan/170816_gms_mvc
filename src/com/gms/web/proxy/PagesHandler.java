package com.gms.web.proxy;

import java.util.Map;

public class PagesHandler {
	public static int PAGE_SIZE = 5;
	public static int BLOCK_SIZE = 5;
	public Integer[] attr(Integer[] params){
		Integer[]result=new Integer[3];
		int theNumberOfAll=params[0];//("theNumberOfAll");
		int pageNumber=params[1];//("pageNumber");
		
		Integer startPage = 0, endPage = 0, theNumberOfPages = 0;
		Integer[] pages = new Integer[3];
		theNumberOfPages = (theNumberOfAll % PAGE_SIZE) == 0 ? theNumberOfAll / PAGE_SIZE : theNumberOfAll / PAGE_SIZE + 1;
		startPage = pageNumber - ((pageNumber - 1) % BLOCK_SIZE);
		endPage = (startPage + BLOCK_SIZE - 1 <= theNumberOfPages) ? startPage + BLOCK_SIZE - 1 : theNumberOfPages;
		result[0]=theNumberOfPages;
		result[1]=startPage;
		result[2]=endPage;
		return result;
	}
}
