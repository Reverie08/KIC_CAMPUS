
CREATE TABLE  member  (
         memberId         VARCHAR2(30)        NOT NULL,
         pw         VARCHAR2(30)        NULL,
         name         VARCHAR2(30)        NULL,
         gender         number        NULL,
         email         VARCHAR2(40)        NULL,
         phone         VARCHAR2(40)        NULL,
         birth         VARCHAR2(30)        NULL,
         profileimage  VARCHAR2(200)        NULL
);

CREATE TABLE  business  (
         bid         VARCHAR2(20)         NOT NULL,
         bpw         VARCHAR2(40)        NULL,
         bname         VARCHAR2(40)        NULL,
         address         VARCHAR2(40)        NULL,
         salary         number        NULL,
         welfare         VARCHAR2(40)        NULL,
         ceo         VARCHAR2(40)        NULL,
         sales         number        NULL,
         employees         number        NULL,
         type         VARCHAR2(40)        NULL,
         industry         VARCHAR2(40)        NULL,
         detailindustry         VARCHAR2(140)        NULL,
         homepage         VARCHAR2(90)        NULL,
         content         CLOB        NULL
);

CREATE TABLE  resume  (
         resumeid         number        NOT NULL,
         selfinfo         VARCHAR2(40)        NULL,
         career         VARCHAR2(40)        NULL,
         project         VARCHAR2(90)        NULL,
         portfolio         VARCHAR2(200)        NULL,
         edu         VARCHAR2(90)        NULL,
         exactivity         VARCHAR2(200)        NULL,
         certification         VARCHAR2(90)        NULL,
         language         VARCHAR2(90)        NULL,
         name         VARCHAR2(30)        NULL,
         birth         DATE        NULL,
         email         VARCHAR2(30)        NULL,
         phone         VARCHAR2(30)        NULL,
         gender         number        NULL,
         address         VARCHAR2(90)        NULL,
         step        number        NULL,
         memberid         number        NOT NULL,
         bid         number        NOT NULL,
         annoid         number        NOT NULL
);

CREATE TABLE  anno  (
         annoid         number        NOT NULL,
         bname         VARCHAR2(90)        NULL,
         welfare         VARCHAR2(90)        NULL,
         annotitle         VARCHAR2(90)        NULL,
         annocareer         VARCHAR2(90)        NULL,
         annosalary         VARCHAR2(90)        NULL,
         annoedu         VARCHAR2(90)        NULL,
         annograde         VARCHAR2(90)        NULL,
         annoworktype         VARCHAR2(90)        NULL,
         annoworkday         number        NULL,
         annoworkplace         VARCHAR2(90)        NULL,
         annocommon         VARCHAR2(90)        NULL,
         annoqualification         VARCHAR2(90)        NULL,
         annopicknum         number        NULL,
         annodate         DATE        NULL,
         annocontent         VARCHAR2(400)        NULL,
         bid         number        NOT NULL,
         skillid         number        NOT NULL       
);

CREATE TABLE  skill  (
         skillid         number        NOT NULL,
         java         VARCHAR2(40)        NULL,
         jsp         VARCHAR2(40)        NULL,
         html         VARCHAR2(40)        NULL,
         css         VARCHAR2(40)        NULL,
         javascript         VARCHAR2(40)        NULL,
         react         VARCHAR2(40)        NULL,
         springframeworl         VARCHAR2(40)        NULL,
         springboot         VARCHAR2(40)        NULL,
         python         VARCHAR2(40)        NULL,
         typescript         VARCHAR2(40)        NULL,
         express         VARCHAR2(40)        NULL,
         oracle         VARCHAR2(40)        NULL,
         mysql         VARCHAR2(40)        NULL,
         mongodb         VARCHAR2(40)        NULL,
         memberid         number        NOT NULL,
         resumeid         number        NOT NULL
);
