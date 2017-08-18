package com.gms.web.service;

import java.util.List;
import java.util.Map;

import com.gms.web.domain.MemberBean;

public interface MemberService {
	public String add(Map<String,Object> map);
	public List<?> list();
	public List<?> findByName(String name);
	public MemberBean findById(String id);
	public String count();
	public String modify(MemberBean bean);
	public String remove(String id);
	public Map<String,Object> login(MemberBean bean);
}
