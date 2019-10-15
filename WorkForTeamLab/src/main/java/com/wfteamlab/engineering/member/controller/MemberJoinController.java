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
	
	@Resource(name="memberService")
    private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberJoinController.class);
	
	@RequestMapping(value="/joinFormPage", method=RequestMethod.GET)
	public String JoinForm(Model model){
		logger.info("회원가입 폼 이동 시작");
		ShopMember member = new ShopMember();
		model.addAttribute("mallmember", member);
		return "member/joinPage"; 
	}
	
	@ResponseBody
	@RequestMapping(value="idCheck", method=RequestMethod.POST)
	public boolean idCheck(String id, ShopMember member){
		boolean idCheckflag = false;
		logger.info("아이디체크 이동 시작");
		//member = memberService.memberSearchOne(id);
		
		if(member == null){
			idCheckflag = true;
		}
		
		logger.info("아이디체크 이동 종료");
		
		//return idCheckflag;
		return true;
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(
			@ModelAttribute("ShopMember") ShopMember member){
		logger.info("회원가입 이동 시작");
		//System.out.println(member);
		int result = memberService.insertMember(member);
		logger.info("sign in result:"+result);
		logger.info("회원가입 이동 종료");
		//return "redirect:joinComplete";LoginPage
		return "redirect:LoginPage";
	}
	
	/*@RequestMapping(value="joinComplete", method=RequestMethod.GET)
	public String joinComplete(SessionStatus session,
			Model model,
			@ModelAttribute("ShopMember") ShopMember member){
		logger.info("회원가입 성공 폼 이동 시작");
		model.addAttribute("id", member.getMember_id());
		//위 작업(id를 넣는 작업)을 하지 않더라도, joinComplete에 일반적인 루트를 타지 않고 들어 오는 것을
		//막기 위해서, @ModelAttribute를 한번 더 써준 것이다.
		session.setComplete(); //위의 model에 id를 넣고 난 뒤에 setComplete를 해주어야 한다!
		logger.info("회원가입 성공 폼 이동 종료");
		return"member/joinComplete";
	}*/
	
}
