package com.wfteamlab.engineering.qna.vo;

public class QnAContact {
	
	private int    qna_num; //qna number
	private String qna_ID; //Member ID
	private String qna_title; //title
	private String qna_contents; //contents
	private String qna_email;	//email address
	private String qna_writeDate; //date of written
	private String qna_status;  //qna status
	private String qna_resolveDate; //date of resolved
	
	public QnAContact() {
		super();
	}

	public QnAContact(int qna_num, String qna_ID, String qna_title, String qna_contents, String qna_email,
			String qna_writeDate, String qna_status, String qna_resolveDate) {
		super();
		this.qna_num = qna_num;
		this.qna_ID = qna_ID;
		this.qna_title = qna_title;
		this.qna_contents = qna_contents;
		this.qna_email = qna_email;
		this.qna_writeDate = qna_writeDate;
		this.qna_status = qna_status;
		this.qna_resolveDate = qna_resolveDate;
	}

	public int getQna_num() {
		return qna_num;
	}

	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}

	public String getQna_ID() {
		return qna_ID;
	}

	public void setQna_ID(String qna_ID) {
		this.qna_ID = qna_ID;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_contents() {
		return qna_contents;
	}

	public void setQna_contents(String qna_contents) {
		this.qna_contents = qna_contents;
	}

	public String getQna_email() {
		return qna_email;
	}

	public void setQna_email(String qna_email) {
		this.qna_email = qna_email;
	}

	public String getQna_writeDate() {
		return qna_writeDate;
	}

	public void setQna_writeDate(String qna_writeDate) {
		this.qna_writeDate = qna_writeDate;
	}

	public String getQna_status() {
		return qna_status;
	}

	public void setQna_status(String qna_status) {
		this.qna_status = qna_status;
	}

	public String getQna_resolveDate() {
		return qna_resolveDate;
	}

	public void setQna_resolveDate(String qna_resolveDate) {
		this.qna_resolveDate = qna_resolveDate;
	}

	@Override
	public String toString() {
		return "QnAContact [qna_num=" + qna_num + ", qna_ID=" + qna_ID + ", qna_title=" + qna_title + ", qna_contents="
				+ qna_contents + ", qna_email=" + qna_email + ", qna_writeDate=" + qna_writeDate + ", qna_status="
				+ qna_status + ", qna_resolveDate=" + qna_resolveDate + "]";
	}

}
