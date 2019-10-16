package com.wfteamlab.engineering.product.vo;

public class Product {
	
	private int prod_num;  //商品Number
	private String prod_sellId; //member ID 
	private String prod_category; //商品カテゴリー
	private String prod_name; //商品名前
	private String prod_price; //商品金額
	private String prod_info; //商品説明
	private String prod_DeliType; //商品郵便タイプ(1:無料, 2:送料込み, 3:送料抜き)
	private String prod_Deliplace; //発送地
	private String prod_inputDate; //商品登録日付
	private String prod_originalfile; //商品イメージ(元本先)
	private String prod_savedfile; //商品イメージ(保存先)
	
	public Product() {
		super();
	}

	public Product(int prod_num, String prod_sellId, String prod_category, String prod_name, String prod_price,
			String prod_info, String prod_DeliType, String prod_Deliplace, String prod_inputDate,
			String prod_originalfile, String prod_savedfile) {
		super();
		this.prod_num = prod_num;
		this.prod_sellId = prod_sellId;
		this.prod_category = prod_category;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_info = prod_info;
		this.prod_DeliType = prod_DeliType;
		this.prod_Deliplace = prod_Deliplace;
		this.prod_inputDate = prod_inputDate;
		this.prod_originalfile = prod_originalfile;
		this.prod_savedfile = prod_savedfile;
	}

	public int getProd_num() {
		return prod_num;
	}

	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}

	public String getProd_sellId() {
		return prod_sellId;
	}

	public void setProd_sellId(String prod_sellId) {
		this.prod_sellId = prod_sellId;
	}

	public String getProd_category() {
		return prod_category;
	}

	public void setProd_category(String prod_category) {
		this.prod_category = prod_category;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_price() {
		return prod_price;
	}

	public void setProd_price(String prod_price) {
		this.prod_price = prod_price;
	}

	public String getProd_info() {
		return prod_info;
	}

	public void setProd_info(String prod_info) {
		this.prod_info = prod_info;
	}

	public String getProd_DeliType() {
		return prod_DeliType;
	}

	public void setProd_DeliType(String prod_DeliType) {
		this.prod_DeliType = prod_DeliType;
	}

	public String getProd_Deliplace() {
		return prod_Deliplace;
	}

	public void setProd_Deliplace(String prod_Deliplace) {
		this.prod_Deliplace = prod_Deliplace;
	}

	public String getProd_inputDate() {
		return prod_inputDate;
	}

	public void setProd_inputDate(String prod_inputDate) {
		this.prod_inputDate = prod_inputDate;
	}

	public String getProd_originalfile() {
		return prod_originalfile;
	}

	public void setProd_originalfile(String prod_originalfile) {
		this.prod_originalfile = prod_originalfile;
	}

	public String getProd_savedfile() {
		return prod_savedfile;
	}

	public void setProd_savedfile(String prod_savedfile) {
		this.prod_savedfile = prod_savedfile;
	}

	@Override
	public String toString() {
		return "Product [prod_num=" + prod_num + ", prod_sellId=" + prod_sellId + ", prod_category=" + prod_category
				+ ", prod_name=" + prod_name + ", prod_price=" + prod_price + ", prod_info=" + prod_info
				+ ", prod_DeliType=" + prod_DeliType + ", prod_Deliplace=" + prod_Deliplace + ", prod_inputDate="
				+ prod_inputDate + ", prod_originalfile=" + prod_originalfile + ", prod_savedfile=" + prod_savedfile
				+ "]";
	}


	
}
