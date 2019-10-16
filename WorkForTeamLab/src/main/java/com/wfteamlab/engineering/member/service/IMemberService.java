package com.wfteamlab.engineering.member.service;

import com.wfteamlab.engineering.member.vo.ShopMember;

public interface IMemberService {
	//会員情報を取得
	ShopMember memberSearchOne(String id);
	//会員加入
	int insertMember(ShopMember shopmember);
}
