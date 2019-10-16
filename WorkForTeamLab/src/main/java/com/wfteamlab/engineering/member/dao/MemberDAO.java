package com.wfteamlab.engineering.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wfteamlab.engineering.member.vo.ShopMember;

@Repository
public class MemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberDAO.class);
	
	//SQLsession宣言
	@Autowired
	SqlSession sqlsession;
	
	//メンバーの検索処理
	public ShopMember selectOne(String id) {
		ShopMember member = null;
		logger.info("会員情報閲覧_DAO_Start");
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		
		try{
			member = mapper.selectOne(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		logger.info("会員情報閲覧_DAO_End");
		return member;
	}
	//会員加入処理
	public int insertMember(ShopMember member) {
		int result = 0;
		logger.info("会員加入_DAO_Start");
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		try{
			result = mapper.insertMember(member);
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("会員加入_DAO_End");
		return result;
	}
	
	//会員情報の修正
	public int updateMember(ShopMember ShopMember) {
		// TODO Auto-generated method stub
		int result = 0;
		logger.info("会員情報修正_DAO_Start");
		MemberMapper mapper = sqlsession.getMapper(MemberMapper.class);
		try{
			result = mapper.updateMember(ShopMember);
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("会員情報修正_DAO_End");
		return result;
	}
	
	
}
