package com.wfteamlab.engineering.qna.service;

import java.util.ArrayList;

import com.wfteamlab.engineering.qna.vo.QnAContact;

public interface IQnAService {
	//QnAにて問い合わせの内容をDBに保存
	int insertQnAContact(QnAContact qnaContact);
	//DBからQnAの情報を取得する
	ArrayList<QnAContact> getQnAList();
	
}
