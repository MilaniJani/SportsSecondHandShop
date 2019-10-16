package com.wfteamlab.engineering.member.dao;

import com.wfteamlab.engineering.member.vo.ShopMember;

public interface MemberMapper {
	//会員情報を取得
	public ShopMember selectOne(String id);
	//会員加入
	public int insertMember(ShopMember member);
	//会員情報修正
	public int updateMember(ShopMember ShopMember);
}
