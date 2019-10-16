package com.wfteamlab.engineering.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wfteamlab.engineering.member.service.MemberService;
import com.wfteamlab.engineering.member.vo.ShopMember;

@Controller
@RequestMapping(value="member")
public class MemberLoginController {
	
	//サービスの宣言
	@Resource(name="memberService")
    private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberJoinController.class);
	
	//Move to Login Page 
	@RequestMapping(value="/LoginPage", method=RequestMethod.GET)
	public String JoinForm(Model model){
		logger.info("로긴화면 이동 시작");
		logger.info("로긴화면 이동 종료");
		return "member/LoginPage"; 
	}
	
	//ログイン処理
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(ShopMember member, Model model, HttpSession session){
		
		//DBから入力したIDと一致するメンバ情報を取得する
		ShopMember vo = memberService.memberSearchOne(member.getMember_id());
	 
		//DBから取得したPWとログイン時に入力したPWと比較する
		if(vo !=null && vo.getPassword().equals(member.getPassword())){
			
			//セッションに必要な情報を保存
	  		session.setAttribute("loginId", vo.getMember_id());
			session.setAttribute("name", vo.getName());
			session.setAttribute("areYouManager", vo.getMemberAuth()); //管理者の確認のため
			
			//管理者の場合、管理者の専用ページに遷移
			if(vo.getMemberAuth()!=null && vo.getMemberAuth().equals("1")){
				System.out.println("move");
				return "member/managerPage";
			}
			//一般ユーザーの場合、メインページに遷移
			return "redirect:/";
		}
		else{ //ログインに失敗した場合
			model.addAttribute("errorMsg", "ログインに失敗しました");
			return "member/LoginPage";
		}
	}
	//ログアウトの処理
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logOut(HttpSession session){
		logger.info("Logout start");
		session.removeAttribute("loginId");
		session.removeAttribute("name");
		logger.info("Logout end");
		//ログアウト後、メインページに移動
		return "redirect:/";
	}
	
}
