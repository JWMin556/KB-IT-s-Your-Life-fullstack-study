use sqldb;
create table stdtbl (
	stdName VARCHAR(10) NOT NULL PRIMARY KEY,
    addr CHAR(4) NOT NULL
);

CREATE TABLE clubtbl(
	clubName VARCHAR(10) NOT NULL PRIMARY KEY,
    roomNo CHAR(4) NOT NULL
);

CREATE TABLE stdclubtbl(
	num int AUTO_INCREMENT NOT NULL PRIMARY KEY,
    stdName VARCHAR(10) NOT NULL,
    clubName VARCHAR(10) NOT NULL,
    FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
    FOREIGN KEY(clubName) REFERENCES clubtbl(clubName)
);

INSERT INTO stdtbl VALUES ('김범수', '경남'), ('성시경', '서울'), ('조용필', '경기'), ('은지원', '경북'), ('바비킴', '서울');
INSERT INTO clubtbl VALUES ('수영', '101호'), ('바둑', '102호'), ('축구', '103호'), ('봉사', '104호');
INSERT INTO stdclubtbl VALUES (NULL, '김범수', '바둑'), (NULL, '조용필', '축구'), (NULL, '은지원', '축구'), (NULL, '은지원', '봉사'), (NULL, '바비킴', '봉사');
INSERT INTO empTbl 


SELECT S.stdName, S.addr, SC.clubName, C.roomNo
 FROM stdtbl S
 INNER JOIN stdclubtbl SC
 ON S.stdName = SC.stdName
 INNER JOIN clubtbl C
 ON SC.clubName = C.clubName
 ORDER BY S.stdName; 

SELECT C.clubName, C.roomNo, S.stdName, S.addr
 FROM stdtbl S
 INNER JOIN stdclubtbl SC
 ON SC.stdName = S.stdName
 INNER JOIN clubtbl C
 ON SC.clubName = C.clubName
 ORDER BY C.clubName;

 SELECT A.emp AS '부하직원', B.emp AS '직속상관', B.empTel AS '직속상관연락처'
	 FROM empTbl A
	 INNER JOIN empTbl B
	 ON A.manager = B.emp
	 WHERE A.emp = '우대리';






