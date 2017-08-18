package com.gms.web.proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PageProxy implements Agency{
	private static PagesHandler ph=new PagesHandler();
	private static RowsHandler rh=new RowsHandler();
	
	@Override
	public void delegateTo(Map<?,?> map) {
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		List<?>list=(List<?>)map.get("list");
		Integer[]t1={list.size(),Integer.parseInt(map.get("pageNumber").toString())};
		Integer[]t2=ph.attr(t1);
		Integer[]t3=rh.attr(t1);
		int theNumberOfPages=
				(list.size()%5!=0)?
						list.size()/5+1
						:list.size()/5;
		System.out.println("페이지수"+theNumberOfPages);
		request.setAttribute("pageNumber", ph.attr(t1)[0]);
		request.setAttribute("prevBlock", ph.attr(t1)[1]);
		request.setAttribute("startPage",ph.attr(t1)[2]);
		request.setAttribute("theNumberOfPages", rh.attr(t1)[0]);
		request.setAttribute("endPage",rh.attr(t1)[1]);
		request.setAttribute("list", list);
	}
	
}
