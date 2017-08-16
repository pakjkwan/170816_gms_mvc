package com.gms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController 진입");
		Separator.init(request);
		MemberBean member=new MemberBean();
		MemberService service=MemberServiceImpl.getInstance();
		
		switch (request.getParameter("action")) {
		case "move":DispatcherServlet.send(request, response);break;
		case "join": 
			System.out.println("=== join 진입 ===");	
			Map<?,?> map=ParamsIterator.execute(request);
			member.setId((String)map.get("id"));
			member.setPassword((String)map.get("password"));
			member.setName((String)map.get("name"));
			member.setBirthday((String)map.get("birthday"));
			member.setGender((String)map.get("gender"));
			member.setEmail((String)map.get("email"));
			member.setPhone((String)map.get("phone"));
			member.setMajor((String)map.get("major"));
			member.setProfile("profile.jpg");
			String[] subjects=((String)map.get("subject")).split(",");
			List<MajorBean> list=new ArrayList<>();
			MajorBean major=null;
			for(int i=0;i<subjects.length;i++){
				major=new MajorBean();
				major.setMajorId(String.valueOf((int)((Math.random() * 9999) + 1000)));
				major.setId((String)map.get("id"));
				major.setTitle((String)map.get("name"));
				major.setSubjId(subjects[i]);
				list.add(major);
			}
			Map<String,Object>tempMap=new HashMap<>();
			tempMap.put("member", member);
			tempMap.put("major", list);
			service.add(tempMap);
			DispatcherServlet.send(request, response);
			break;
		default:System.out.println("FAIL..");break;
		}
	}
	//id=&password=1&name=이길동&birthday=&gender=male&email=leegd%40test.com&major=computer&subject=java&subject=c&
	//subject=html&action=join&page=main
}
