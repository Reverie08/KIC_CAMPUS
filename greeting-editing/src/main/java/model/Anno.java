package model;

import java.util.Date;

public class Anno {
	int annoid;
	String bname;
	String welfare;
	String annoTitle;
	String annoCareer;
	int annoSalary;
	String annoEdu;
	String annoGrade;
	String annoWorkType;
	int annoWorkDay;
	String annoWorkPlace;
	String annoCommon;
	String annoQualification;
	int annoPickNum;
	Date annoDate;
	String annoContent;
	int bid;

	public int getAnnoid() {
		return annoid;
	}

	public void setAnnoid(int annoid) {
		this.annoid = annoid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getWelfare() {
		return welfare;
	}

	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}

	public String getAnnoTitle() {
		return annoTitle;
	}

	public void setAnnoTitle(String annoTitle) {
		this.annoTitle = annoTitle;
	}

	public String getAnnoCareer() {
		return annoCareer;
	}

	public void setAnnoCareer(String annoCareer) {
		this.annoCareer = annoCareer;
	}

	public int getAnnoSalary() {
		return annoSalary;
	}

	public void setAnnoSalary(int annoSalary) {
		this.annoSalary = annoSalary;
	}

	public String getAnnoEdu() {
		return annoEdu;
	}

	public void setAnnoEdu(String annoEdu) {
		this.annoEdu = annoEdu;
	}

	public String getAnnoGrade() {
		return annoGrade;
	}

	public void setAnnoGrade(String annoGrade) {
		this.annoGrade = annoGrade;
	}

	public String getAnnoWorkType() {
		return annoWorkType;
	}

	public void setAnnoWorkType(String annoWorkType) {
		this.annoWorkType = annoWorkType;
	}

	public int getAnnoWorkDay() {
		return annoWorkDay;
	}

	public void setAnnoWorkDay(int annoWorkDay) {
		this.annoWorkDay = annoWorkDay;
	}

	public String getAnnoWorkPlace() {
		return annoWorkPlace;
	}

	public void setAnnoWorkPlace(String annoWorkPlace) {
		this.annoWorkPlace = annoWorkPlace;
	}

	public String getAnnoCommon() {
		return annoCommon;
	}

	public void setAnnoCommon(String annoCommon) {
		this.annoCommon = annoCommon;
	}

	public String getAnnoQualification() {
		return annoQualification;
	}

	public void setAnnoQualification(String annoQualification) {
		this.annoQualification = annoQualification;
	}

	public int getAnnoPickNum() {
		return annoPickNum;
	}

	public void setAnnoPickNum(int annoPickNum) {
		this.annoPickNum = annoPickNum;
	}

	public Date getAnnoDate() {
		return annoDate;
	}

	public void setAnnoDate(Date annoDate) {
		this.annoDate = annoDate;
	}

	public String getAnnoContent() {
		return annoContent;
	}

	public void setAnnoContent(String annoContent) {
		this.annoContent = annoContent;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}


	@Override
	public String toString() {
		return "Anno [annoid=" + annoid + ", bname=" + bname + ", welfare=" + welfare + ", annoTitle=" + annoTitle
				+ ", annoCareer=" + annoCareer + ", annoSalary=" + annoSalary + ", annoEdu=" + annoEdu + ", annoGrade="
				+ annoGrade + ", annoWorkType=" + annoWorkType + ", annoWorkDay=" + annoWorkDay + ", annoWorkPlace="
				+ annoWorkPlace + ", annoCommon=" + annoCommon + ", annoQualification=" + annoQualification
				+ ", annoPickNum=" + annoPickNum + ", annoDate=" + annoDate + ", annoContent=" + annoContent + ", bid="
				+ bid + "]";
	}

}
