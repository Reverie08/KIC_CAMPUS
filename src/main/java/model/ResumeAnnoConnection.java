package model;


public class ResumeAnnoConnection {

	int resumeId;
	int annoId;
	String resume_register_date ;
	String resume_check_date ;
	
	
	
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public int getAnnoId() {
		return annoId;
	}
	public void setAnnoId(int annoId) {
		this.annoId = annoId;
	}

	
	public String getResume_register_date() {
		return resume_register_date;
	}
	public void setResume_register_date(String resume_register_date) {
		this.resume_register_date = resume_register_date;
	}
	public String getResume_check_date() {
		return resume_check_date;
	}
	public void setResume_check_date(String resume_check_date) {
		this.resume_check_date = resume_check_date;
	}
	@Override
	public String toString() {
		return "ResumeAnnoConnection [resumeId=" + resumeId + ", annoId=" + annoId + ", resume_register_date="
				+ resume_register_date + ", resume_check_date=" + resume_check_date + "]";
	}
	
	
}
