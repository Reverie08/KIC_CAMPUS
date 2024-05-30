package model;

import java.util.Date;

public class GmProduct {
	private int prodid;
	private String prodname;
	private int price;
	private String prodcontent;
	private Date prodregdate;
	private String category;
	private String file2;

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProdcontent() {
		return prodcontent;
	}

	public void setProdcontent(String prodcontent) {
		this.prodcontent = prodcontent;
	}

	public Date getProdregdate() {
		return prodregdate;
	}

	public void setProdregdate(Date prodregdate) {
		this.prodregdate = prodregdate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	@Override
	public String toString() {
		return "GmProduct [prodid=" + prodid + ", prodname=" + prodname + ", price=" + price + ", prodcontent="
				+ prodcontent + ", prodregdate=" + prodregdate + ", category=" + category + ", file2=" + file2 + "]";
	}

}
