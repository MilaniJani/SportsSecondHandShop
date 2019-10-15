package com.wfteamlab.engineering.member.dao;

import com.wfteamlab.engineering.member.vo.ShopMember;

public interface MemberMapper {

	public ShopMember selectOne(String id);

	public int insertMember(ShopMember member);

	public int updateMember(ShopMember ShopMember);

	
	
	
}
