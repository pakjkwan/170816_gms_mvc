package com.gms.web.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.domain.MemberBean;
import com.gms.web.factory.DatabaseFactory;
public class MemberDAOImpl implements MemberDAO{
	public static MemberDAOImpl getInstance() {return new MemberDAOImpl();}
	private MemberDAOImpl(){}
	@Override
	public String insert(MemberBean bean) {
		String rs="";
		try {PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_INSERT);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getPassword());
			rs =String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean>list=new ArrayList<>();
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
			MemberBean member=null;
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPassword(rs.getString(DB.MEMBER_PASS));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean>list=new ArrayList<>();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
			MemberBean member=null;
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPassword(rs.getString(DB.MEMBER_PASS));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	@Override
	public MemberBean selectById(String id) {
		MemberBean member=null;
		System.out.println("$ ID"+id);
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement("select * from member where member_id like ?");
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPassword(rs.getString(DB.MEMBER_PASS));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	@Override
	public String count() {
		String count="";
		
		try {
			ResultSet rs=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT).executeQuery();
			if(rs.next()){
				count=rs.getString("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String update(MemberBean bean) {
		String rs="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, bean.getPassword());
			pstmt.setString(2, bean.getId());
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}

	@Override
	public String delete(String id) {
		String rs="";
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME,DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
