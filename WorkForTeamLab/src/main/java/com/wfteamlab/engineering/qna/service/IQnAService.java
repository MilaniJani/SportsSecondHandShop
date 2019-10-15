package com.wfteamlab.engineering.qna.service;

import java.util.ArrayList;

import com.wfteamlab.engineering.qna.vo.QnAContact;

public interface IQnAService {
	int insertQnAContact(QnAContact qnaContact);
	ArrayList<QnAContact> getQnAList();
	
}
