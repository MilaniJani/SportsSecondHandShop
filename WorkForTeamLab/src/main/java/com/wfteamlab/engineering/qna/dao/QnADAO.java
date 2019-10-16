package com.wfteamlab.engineering.qna.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wfteamlab.engineering.qna.vo.QnAContact;


@Repository
public class QnADAO {
	
	private static final Logger logger = LoggerFactory.getLogger(QnADAO.class);

	@Autowired
	SqlSession sqlsession;
	
	//QnAにて問い合わせの内容をDBに保存
	public int insertQnAContact(QnAContact qnaContact) {
		QnAMapper mapper = sqlsession.getMapper(QnAMapper.class);
		int result = 0; 
		logger.info("QnA insert DAO start");
		try{
			result = mapper.insertQnAContact(qnaContact);
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("QnA insert DAO end");
		return result;
	}
	
	//DBからQnAの情報を取得する
	public ArrayList<QnAContact> getQnAList() {
		QnAMapper mapper = sqlsession.getMapper(QnAMapper.class);
		ArrayList<QnAContact> qnalist = null;
		logger.info("QnA get DAO start");
		try{
		qnalist = mapper.getQnAList();
		}catch(Exception e){
			e.printStackTrace();
		}
		logger.info("QnA get DAO end");
		return qnalist;
	}
	
}
