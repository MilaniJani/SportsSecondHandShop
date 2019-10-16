package com.wfteamlab.engineering.member.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.wfteamlab.engineering.member.service.MemberService;
import com.wfteamlab.engineering.member.vo.ShopMember;


@Controller
@RequestMapping(value="member")
public class MemberJoinController {
	
	//サービスの宣言
	@Resource(name="memberService")
    private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberJoinController.class);
	
	//会員加入ページに移動
	@RequestMapping(value="/joinFormPage", method=RequestMethod.GET)
	public String JoinForm(Model model){
		logger.info("会員加入ページに移動");
		ShopMember member = new ShopMember();
		model.addAttribute("mallmember", member);
		return "member/joinPage"; 
	}
	
	//IDの重複チェック(Ajax)
	@ResponseBody
	@RequestMapping(value="idCheck", method=RequestMethod.POST)
	public boolean idCheck(String id, ShopMember member){
		boolean idCheckflag = false;
		logger.info("start id check");
		member = memberService.memberSearchOne(id);
		if(member == null){
			idCheckflag = true;
		}
		logger.info("end id check");
		
		return idCheckflag;
	}
	
	//DB上に加入する会員の情報を保存
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(
			@ModelAttribute("ShopMember") ShopMember member){
		logger.info("会員加入 start");
		int result = memberService.insertMember(member);
		logger.info("sign in result:"+result);
		logger.info("会員加入 end");
		return "redirect:LoginPage";
	}
	
}
