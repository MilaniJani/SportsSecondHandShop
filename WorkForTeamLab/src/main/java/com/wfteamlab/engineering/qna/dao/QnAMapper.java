package com.wfteamlab.engineering.qna.dao;

import java.util.ArrayList;

import com.wfteamlab.engineering.qna.vo.QnAContact;

public interface QnAMapper {
	//QnAにて問い合わせの内容をDBに保存
	public int insertQnAContact(QnAContact qnaContact);
	//DBからQnAの情報を取得する
	public ArrayList<QnAContact> getQnAList();
	
	
}
