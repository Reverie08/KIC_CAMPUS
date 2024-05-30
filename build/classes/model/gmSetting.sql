-- 회원가입용
create table gmmember (
id varchar(20) primary key,
trader number(1), 
pass varchar(20),
name varchar(20),
tel varchar(20),
email varchar(50)
);

create table gmboard (
num int primary key,
name varchar(30),
pass varchar(100),
subject varchar(100),
content varchar(4000),
file1 varchar(100),
regdate date,
readcnt number(10),
boardid varchar(1)
);

create sequence gmboardseq;


-- 상품 등록(소비자와 판매자 중 판매자일 경우)
CREATE TABLE gmproduct (
    prodid int primary key,
    prodname VARCHAR2(50),
    price NUMBER,
    prodcontent VARCHAR2(4000),
    prodregdate DATE,
    category VARCHAR2(30),
    file2 VARCHAR2(100)
);


create sequence gmprodseq;
