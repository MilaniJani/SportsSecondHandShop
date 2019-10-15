package com.wfteamlab.engineering.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfteamlab.engineering.member.dao.MemberDAO;
import com.wfteamlab.engineering.member.dao.MemberMapper;
import com.wfteamlab.engineering.member.vo.ShopMember;


@Service("memberService")
public class MemberService implements IMemberService {
	
	@Autowired
	MemberDAO dao;
	
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

	@Override
	public int insertMember(ShopMember shopmember) {
		// TODO Auto-generated method stub
		int result = 0;
		//logger.info("회원가입 DAO 시작");
		//MemberMapper mapper = null;
		try{
			result = dao.insertMember(shopmember);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		//logger.info("회원가입 DAO 종료");
		return result;
	}

}
