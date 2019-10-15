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
	
	@RequestMapping(value="/QnAPage", method=RequestMethod.GET)
	public String JoinForm(Model model){
		logger.info("Q&A 이동 시작");
		QnAContact qnaContact = new QnAContact();
		model.addAttribute("qnaContact", qnaContact);
		return "qnaContact/qnaPage"; 
	}
	
	
	@RequestMapping(value="/QnAInput", method=RequestMethod.POST)
	public String QnAInput(@ModelAttribute("qnaContact") QnAContact qnaContact){
		logger.info("Q&A 이동 시작");
		
		int result = qnaService.insertQnAContact(qnaContact);
		logger.info("inputQnA result:"+result);
		logger.info("Q&A 이동 종료");
		
		return "redirect:/"; 
	}
	
	@RequestMapping(value="/QnABoard", method=RequestMethod.GET)
	public String GoQnABoard(Model model, ArrayList<QnAContact> qnaLists){
		logger.info("Q&A Board 이동 시작");
		
		qnaLists = qnaService.getQnAList();
		
		model.addAttribute("qnaLists", qnaLists);
		logger.info("Q&A Board 이동 종료");
		return "qnaContact/qnaBoard"; 
	}
	
	
	
}
