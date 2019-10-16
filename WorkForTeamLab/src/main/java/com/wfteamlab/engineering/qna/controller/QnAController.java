package com.wfteamlab.engineering.qna.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wfteamlab.engineering.qna.service.QnAService;
import com.wfteamlab.engineering.qna.vo.QnAContact;

@Controller
@RequestMapping(value="qnaContact")
public class QnAController {
	
	@Resource(name="qnaService")
    private QnAService qnaService;
	
	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);
	
	//QnAページに移動
	@RequestMapping(value="/QnAPage", method=RequestMethod.GET)
	public String JoinForm(Model model){
		logger.info("Q&Aページ 移動");
		QnAContact qnaContact = new QnAContact();
		model.addAttribute("qnaContact", qnaContact);
		return "qnaContact/qnaPage"; 
	}
	//QｎAの問い合わせ内容をDBに保存する処理
	@RequestMapping(value="/QnAInput", method=RequestMethod.POST)
	public String QnAInput(@ModelAttribute("qnaContact") QnAContact qnaContact){
		logger.info("inputQnA start");
		int result = qnaService.insertQnAContact(qnaContact);
		logger.info("inputQnA 成功有無:"+result);
		logger.info("inputQnA end");
		return "redirect:/"; 
	}
	//DBからQnAの情報を取得してQnAの掲示板に移動。
	@RequestMapping(value="/QnABoard", method=RequestMethod.GET)
	public String GoQnABoard(Model model, ArrayList<QnAContact> qnaLists){
		logger.info("Q&A Board start");
		qnaLists = qnaService.getQnAList();
		model.addAttribute("qnaLists", qnaLists);
		logger.info("Q&A Board end");
		return "qnaContact/qnaBoard"; 
	}
	
}
