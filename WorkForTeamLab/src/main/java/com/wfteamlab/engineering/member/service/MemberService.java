package com.wfteamlab.engineering.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfteamlab.engineering.member.dao.MemberDAO;
import com.wfteamlab.engineering.member.dao.MemberMapper;
import com.wfteamlab.engineering.member.vo.ShopMember;


@Service("memberService")
public class MemberService implements IMemberService {
	
	//DAO宣言
	@Autowired
	MemberDAO dao;
	
	//会員情報を取得
	@Override
	public ShopMember memberSearchOne(String id) {
		// TODO Auto-generated method stub
		ShopMember member = null;
		try{
			member = dao.selectOne(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return member;
	}
	//会員加入
	@Override
	public int insertMember(ShopMember shopmember) {
		// TODO Auto-generated method stub
		int result = 0;
		try{
			result = dao.insertMember(shopmember);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
