package com.wfteamlab.engineering.member.service;

import com.wfteamlab.engineering.member.vo.ShopMember;

public interface IMemberService {
	ShopMember memberSearchOne(String id);
	int insertMember(ShopMember shopmember);
}
