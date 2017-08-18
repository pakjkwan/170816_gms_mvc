package com.gms.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gms.web.dao.MemberDAO;
import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl(){}
	@Override
	public String add(Map<String,Object> map) {
		System.out.println("member service 진입");
		MemberBean m=(MemberBean)map.get("member");
		System.out.println("넘어온 회원 정보:"+m.toString());
		@SuppressWarnings("unchecked")
		List<MajorBean>list=(List<MajorBean>)map.get("major");
		System.out.println("넘어온 수강과목:"+list);
		String rs=MemberDAOImpl.getInstance().insert(map);
		System.out.println("서비스 RS :"+rs);
		return rs;
	}
	@Override
	public List<?> list() {
		return MemberDAOImpl.getInstance().selectAll();
	}
	@Override
	public List<?> findByName(String name) {
		
		return MemberDAOImpl.getInstance().selectAll();
	}

	@Override
	public MemberBean findById(String id) {
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public String count() {
		return MemberDAOImpl.getInstance().count();
	}

	@Override
	public String modify(MemberBean bean) {		
		String msg="";
		return msg;
	}

	@Override
	public String remove(String id) {
		String msg="";
		
		return msg;
	}
	@Override
	public Map<String,Object> login(MemberBean bean) {
		Map<String,Object> map=new HashMap<>();
		MemberBean m=findById(bean.getId());
		String page=
		 (m!=null)?
				(bean.getPassword().equals(m.getPassword()))?
						"main":"login_fail":"join";
		map.put("page", page);
		map.put("user", m);
		return map;
		
	}
}











