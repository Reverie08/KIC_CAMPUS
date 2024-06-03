--회원가입용
create table kicmember (
id varchar(20) primary key, 
pass varchar(20), 
name varchar(20), 
gender number(1), 
tel varchar(20), 
email varchar(50), 
picture varchar(200) --이미지 이름
);


create table kicboard (
num int primary key,
name varchar(30),
pass varchar(20),
subject varchar(100),
content varchar(4000),
file1 varchar(100),
regdate date,
readcnt number(10),
boardid varchar(1)
);

create sequence kicboardseq;


--Comment
create table boardcomment (
ser int primary key,
num int,
content varchar(2000),
regdate date
);

create sequence boardcomseq;