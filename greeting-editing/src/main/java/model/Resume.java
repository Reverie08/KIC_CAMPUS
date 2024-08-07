package model;

import java.util.Date;

public class Resume {
	int resumeid;
	String selfInfo;
	String career;
	String project;
	String portfolio;
	String edu;
	String exactivity;
	String certification;
	String language;
	String name;
	Date birth;
	String email;
	String phone;
	String gender;
	String address;
	int step;
	int memberid;
	int bid;
	int annoid;

	public int getResumeid() {
		return resumeid;
	}

	public void setResumeid(int resumeid) {
		this.resumeid = resumeid;
	}

	public String getSelfInfo() {
		return selfInfo;
	}

	public void setSelfInfo(String selfInfo) {
		this.selfInfo = selfInfo;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getExactivity() {
		return exactivity;
	}

	public void setExactivity(String exactivity) {
		this.exactivity = exactivity;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getAnnoid() {
		return annoid;
	}

	public void setAnnoid(int annoid) {
		this.annoid = annoid;
	}

	@Override
	public String toString() {
		return "Resume [resumeid=" + resumeid + ", selfInfo=" + selfInfo + ", career=" + career + ", project=" + project
				+ ", portfolio=" + portfolio + ", edu=" + edu + ", exactivity=" + exactivity + ", certification="
				+ certification + ", language=" + language + ", name=" + name + ", birth=" + birth + ", email=" + email
				+ ", phone=" + phone + ", gender=" + gender + ", address=" + address + ", step=" + step + ", memberid="
				+ memberid + ", bid=" + bid + ", annoid=" + annoid + "]";
	}

}
