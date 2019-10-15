package com.wfteamlab.engineering.member.vo;

public class ShopMember {
	private String member_id; //memberID
	private String password; //member Password
	private String email; //member Email
	private String name; //member name
	private String birthDate; //member birthdate
	private String phonenum; //member phone number
	private String postCode; //member address's post code
	private String address; //member address
	private String joindate; //join日付
	private String outdate;  //脱退日付
	private String memberAuth; //normal member or manager
	
	public ShopMember() {
		super();
	}

	public ShopMember(String member_id, String password, String email, String name, String birthDate, String phonenum,
			String postCode, String address, String joindate, String outdate, String memberAuth) {
		super();
		this.member_id = member_id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.birthDate = birthDate;
		this.phonenum = phonenum;
		this.postCode = postCode;
		this.address = address;
		this.joindate = joindate;
		this.outdate = outdate;
		this.memberAuth = memberAuth;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getOutdate() {
		return outdate;
	}

	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}

	public String getMemberAuth() {
		return memberAuth;
	}

	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}

	@Override
	public String toString() {
		return "ShopMember [member_id=" + member_id + ", password=" + password + ", email=" + email + ", name=" + name
				+ ", birthDate=" + birthDate + ", phonenum=" + phonenum + ", postCode=" + postCode + ", address="
				+ address + ", joindate=" + joindate + ", outdate=" + outdate + ", memberAuth=" + memberAuth + "]";
	}
	
	
}
