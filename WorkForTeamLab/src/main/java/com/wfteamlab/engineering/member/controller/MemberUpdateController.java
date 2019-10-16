package com.wfteamlab.engineering.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wfteamlab.engineering.member.dao.MemberDAO;
import com.wfteamlab.engineering.member.vo.ShopMember;


@Controller
@RequestMapping(value="member")
@SessionAttributes("shopmember")
public class MemberUpdateController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberUpdateController.class);
	//DBコネクション宣言
	@Autowired
	MemberDAO dao;
	
	//DBからIDに該当するメンバーの情報を所得してUpdatePageに移動
	@RequestMapping(value="updateForm", method=RequestMethod.GET)
	public String updateForm(ShopMember shopMember, HttpSession session, Model model){
		String loginId = (String)session.getAttribute("loginId");
		shopMember = dao.selectOne(loginId);
		model.addAttribute("member", shopMember);
			
		return "member/updatePage";
	}
	//DB上にメンバーの情報をアップデートする。
	@RequestMapping(value="updateInfo", method=RequestMethod.POST)
	public String updateMember(@ModelAttribute("shopMember")ShopMember shopMember
			,Model model){
		logger.info("start update member info");
		int result = 0;
		result = dao.updateMember(shopMember);
		if(result != 1){
			//update fail
			model.addAttribute("errorMsg", "Fail_Update");
			return"member/updateForm";
		}
		logger.info("end update member info");
		return "redirect:/";
	}
	
}
