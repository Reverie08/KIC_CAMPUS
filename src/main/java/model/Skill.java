package model;

public class Skill {
	int skillId;
	String java;
	String jsp;
	String html;
	String css;
	String javascript;
	String react;
	String springframeworl;
	String springboot;
	String python;
	String typescript;
	String express;
	String oracle;
	String mysql;
	String mongodb;
	String memberId;
	int resumeId;
	int annoId;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getJava() {
		return java;
	}

	public void setJava(String java) {
		this.java = java;
	}

	public String getJsp() {
		return jsp;
	}

	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getJavascript() {
		return javascript;
	}

	public void setJavascript(String javascript) {
		this.javascript = javascript;
	}

	public String getReact() {
		return react;
	}

	public void setReact(String react) {
		this.react = react;
	}

	public String getSpringframeworl() {
		return springframeworl;
	}

	public void setSpringframeworl(String springframeworl) {
		this.springframeworl = springframeworl;
	}

	public String getSpringboot() {
		return springboot;
	}

	public void setSpringboot(String springboot) {
		this.springboot = springboot;
	}

	public String getPython() {
		return python;
	}

	public void setPython(String python) {
		this.python = python;
	}

	public String getTypescript() {
		return typescript;
	}

	public void setTypescript(String typescript) {
		this.typescript = typescript;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public String getOracle() {
		return oracle;
	}

	public void setOracle(String oracle) {
		this.oracle = oracle;
	}

	public String getMysql() {
		return mysql;
	}

	public void setMysql(String mysql) {
		this.mysql = mysql;
	}

	public String getMongodb() {
		return mongodb;
	}

	public void setMongodb(String mongodb) {
		this.mongodb = mongodb;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

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

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", java=" + java + ", jsp=" + jsp + ", html=" + html + ", css=" + css
				+ ", javascript=" + javascript + ", react=" + react + ", springframeworl=" + springframeworl
				+ ", springboot=" + springboot + ", python=" + python + ", typescript=" + typescript + ", express="
				+ express + ", oracle=" + oracle + ", mysql=" + mysql + ", mongodb=" + mongodb + ", memberId="
				+ memberId + ", resumeId=" + resumeId + ", annoId=" + annoId + "]";
	}

}