


CREATE TABLE member (
	memberid	VARCHAR2(30)	,
	memberpw	VARCHAR2(30)	NULL,
	name	VARCHAR2(30)	NULL,
	gender	VARCHAR2(30)	NULL,
	email	VARCHAR2(30)	NULL,
	phone	VARCHAR2(30)	NULL,
	birth	VARCHAR2(30)	NULL,
	profileimage	VARCHAR2(200)	NULL
);

CREATE TABLE business (
	businessid	VARCHAR2(20),
	businesspw	VARCHAR2(40)	NULL,
	businessname	VARCHAR2(40)	NULL,
	address	VARCHAR2(200)	NULL,
	salary	number	NULL,
	welfare	VARCHAR2(500)	NULL,
	ceo	VARCHAR2(40)	NULL,
	sales	number	NULL,
	employees	number	NULL,
	type	VARCHAR2(40)	NULL,
	industry	VARCHAR2(40)	NULL,
	detailindustry	VARCHAR2(40)	NULL,
	homepage	VARCHAR2(90)	NULL,
	content	CLOB	NULL
);

CREATE TABLE resume (
	resumeid	number,
	resumetitle	VARCHAR2(90)	NULL,
	profileimage	VARCHAR2(200)	NULL,
	name	VARCHAR2(90)	NULL,
	birth	VARCHAR2(90)	NULL,
	phone	VARCHAR2(90)	NULL,
	email	VARCHAR2(90)	NULL,
	registdate	DATE	NULL,
	selfinfo	VARCHAR2(40)	NULL,
	certification	VARCHAR2(90)	NULL,
	language	VARCHAR2(90)	NULL,
	address	VARCHAR2(90)	NULL,
	columnstage	number	NULL,
	evalustage	number	NULL,
	resumescore	number	NULL,
	memberid	VARCHAR2(40),
	businessid	VARCHAR2(40),
	annoid	number
);

CREATE TABLE anno (
	annoid	number	,
	businessname	VARCHAR2(90)	NULL,
	welfare	VARCHAR2(90)	NULL,
	annotitle	VARCHAR2(90)	NULL,
	annocareer	VARCHAR2(90)	NULL,
	annosalary	number	NULL,
	annoedu	VARCHAR2(90)	NULL,
	annograde	VARCHAR2(90)	NULL,
	annoworktype	VARCHAR2(90)	NULL,
	annoworkday	number	NULL,
	annoworkplace	VARCHAR2(90)	NULL,
	annocommon	VARCHAR2(90)	NULL,
	annoqualification	VARCHAR2(90)	NULL,
	annopicknum	number	NULL,
	annodate	DATE	NULL,
	annocontent	VARCHAR2(400)	NULL,
	businessid	number	,
	skillid	number	
);

CREATE TABLE skill (
	skillid	VARCHAR2(40)	,
	java	VARCHAR2(40)	NULL,
	jsp	VARCHAR2(40)	NULL,
	html	VARCHAR2(40)	NULL,
	css	VARCHAR2(40)	NULL,
	javascript	VARCHAR2(40)	NULL,
	react	VARCHAR2(40)	NULL,
	springframework	VARCHAR2(40)	NULL,
	springboot	VARCHAR2(40)	NULL,
	python	VARCHAR2(40)	NULL,
	typescript	VARCHAR2(40)	NULL,
	express	VARCHAR2(40)	NULL,
	oracle	VARCHAR2(40)	NULL,
	mysql	VARCHAR2(40)	NULL,
	mongodb	VARCHAR2(40)	NULL,
	memberid	number	,
	resumeid	number	,
	annoid	number	
);

CREATE TABLE edu (
	eduid	number	,
	schooltype	VARCHAR2(40)	NULL,
	schoolname	VARCHAR2(40)	NULL,
	admissiondate	VARCHAR2(40)	NULL,
	graduatedate	VARCHAR2(40)	NULL,
	graduatestate	VARCHAR2(40)	NULL,
	major	VARCHAR2(40)	NULL,
	score	VARCHAR2(40)	NULL,
	totalscore	VARCHAR2(40)	NULL,
	resumeid	number	
);

CREATE TABLE career (
	careerid	number	,
	companyname	VARCHAR2(40)	NULL,
	department	VARCHAR2(40)	NULL,
	workpart	VARCHAR2(40)	NULL,
	position	VARCHAR2(40)	NULL,
	worktype	VARCHAR2(40)	NULL,
	isworking	VARCHAR2(40)	NULL,
	workperiod	VARCHAR2(40)	NULL,
	resumeid	number	
);

CREATE TABLE memberproject (
	projectid	number	,
	projectname	VARCHAR2(40)	NULL,
	team	VARCHAR2(40)	NULL,
	isgoing	VARCHAR2(40)	NULL,
	projectperiod	VARCHAR2(40)	NULL,
	projectinfo	VARCHAR2(40)	NULL,
	resumeid	number	
);

CREATE TABLE memberportfolio (
	portfolioid	number	
	portfoliourl	VARCHAR2(200)	NULL,
	portfoliofile	VARCHAR2(200)	NULL,
	resumeid	number	
);

