package model;

public class Business {
	String bid;
	String bpw;
	String bname;
	String address;
	int salary;
	String welfare;
	String ceo;
	int sales;
	int employees;
	String type;
	String industry;
	String detailIndustry;
	String homepage;
	String content;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBpw() {
		return bpw;
	}

	public void setBpw(String bpw) {
		this.bpw = bpw;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getWelfare() {
		return welfare;
	}

	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getEmployees() {
		return employees;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getDetailIndustry() {
		return detailIndustry;
	}

	public void setDetailIndustry(String detailIndustry) {
		this.detailIndustry = detailIndustry;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Business [bid=" + bid + ", bpw=" + bpw + ", bname=" + bname + ", address=" + address + ", salary="
				+ salary + ", welfare=" + welfare + ", ceo=" + ceo + ", sales=" + sales + ", employees=" + employees
				+ ", type=" + type + ", industry=" + industry + ", detailIndustry=" + detailIndustry + ", homepage="
				+ homepage + ", content=" + content + "]";
	}

}
