package com.wfteamlab.engineering.qna.dao;

import java.util.ArrayList;

import com.wfteamlab.engineering.qna.vo.QnAContact;

public interface QnAMapper {

	public int insertQnAContact(QnAContact qnaContact);

	public ArrayList<QnAContact> getQnAList();
	
	
}
