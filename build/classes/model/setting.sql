CREATE TABLE member (
	memberid	number	NOT NULL,
	pw	VARCHAR2(30)	NULL,
	name	VARCHAR2(30)	NULL,
	birth	DATE	NULL,
	email	VARCHAR2(40)	NULL,
	phone	VARCHAR2(40)	NULL,
	gender	number	NULL
);

CREATE TABLE business (
	bid	number	NOT NULL,
	bpw	VARCHAR2(40)	NULL,
	bname	VARCHAR2(40)	NULL,
	address	VARCHAR2(40)	NULL,
	salary	number	NULL,
	welfare	VARCHAR2(40)	NULL,
	ceo	VARCHAR2(40)	NULL,
	sales	number	NULL,
	employees	number	NULL,
	type	VARCHAR2(40)	NULL,
	industry	VARCHAR2(40)	NULL,
	detailindustry	VARCHAR2(40)	NULL,
	homepage	VARCHAR2(90)	NULL,
	content	VARCHAR2(200)	NULL,
	resumeId	number	NOT NULL
);

CREATE TABLE resume (
	resumeid	number	NOT NULL,
	selfInfo	VARCHAR2(40)	NULL,
	skill	number	NULL,
	career	VARCHAR2(40)	NULL,
	project	VARCHAR2(90)	NULL,
	portfolio	VARCHAR2(200)	NULL,
	edu	VARCHAR2(90)	NULL,
	exactivity	VARCHAR2(200)	NULL,
	Certification	VARCHAR2(90)	NULL,
	language	VARCHAR2(90)	NULL,
	name	VARCHAR2(30)	NULL,
	birth	DATE	NULL,
	email	VARCHAR2(30)	NULL,
	phone	VARCHAR2(30)	NULL,
	gender	number	NULL,
	address	VARCHAR2(90)	NULL,
	memberid	number	NOT NULL,
	bid	number	NOT NULL,
	annoId	number	NOT NULL
);

CREATE TABLE anno (
	annoId	number	NOT NULL,
	bname	VARCHAR2(90)	NULL,
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
	bid	number	NOT NULL,
	resumeId	number	NOT NULL
);

CREATE TABLE anno2 (
	annoId	number	NOT NULL,
	annotitle	VARCHAR2(40)	NULL,
	bname	VARCHAR2(40)	NULL,
	annoworkplace	VARCHAR2(40)	NULL,
	annocareer	VARCHAR2(40)	NULL,
	annoedu	VARCHAR2(40)	NULL,
	annodate	DATE	NULL,
	annoskill	VARCHAR2(40)	NULL
);

CREATE TABLE skill (
	skillid	number	NOT NULL,
	java	number	NULL,
	jsp	number	NULL,
	html	number	NULL,
	css	number	NULL,
	javascript	number	NULL,
	react	number	NULL,
	springframeworl	number	NULL,
	springboot	number	NULL,
	python	number	NULL,
	typescript	number	NULL,
	express	number	NULL,
	oracle	number	NULL,
	mysql	number	NULL,
	mongodb	number	NULL,
	memberid	number	NOT NULL,
	resumeid	number	NOT NULL
);