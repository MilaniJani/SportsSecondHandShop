package com.wfteamlab.engineering.qna.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfteamlab.engineering.qna.dao.QnADAO;
import com.wfteamlab.engineering.qna.vo.QnAContact;

@Service("qnaService")
public class QnAService implements IQnAService {
	
	@Autowired
	QnADAO dao;
	
	//QnAにて問い合わせの内容をDBに保存
	@Override
	public int insertQnAContact(QnAContact qnaContact) {
		// TODO Auto-generated method stub
		int result = 0; 
		try{
			result = dao.insertQnAContact(qnaContact);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	//DBからQnAの情報を取得する
	@Override
	public ArrayList<QnAContact> getQnAList() {
		// TODO Auto-generated method stub
		ArrayList<QnAContact> qnalist = null;
		try{
		qnalist = dao.getQnAList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return qnalist;
	}

}
