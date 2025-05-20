drop database tabledb;
create database tabledb;
use tabledb;

drop table if exists usertbl;  
create table usertbl(
	-- 일반적으로 한줄단위로 컬럼정의
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthYear int not null,
    addr char(2) not null,
    mobile1 char(3) null,
    mobile2 char(8) null,
    height smallint null,
    mDate Date null
);

drop table if exists buytbl;
create table buytbl(
	num int auto_increment not null primary key,
    userId char(8) not null,
    prodName char(8) not null,
    groupName char(4) null,
    price int not null,
    amount smallint not null,
    foreign key(userID) references usertbl(userID)
);

insert into usertbl
values
('LSG', '이승기', 1987, '서울', '011', '11111111', 182, '2008-8-8'),
('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4'),
('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
-- jyp라는 id는 넣을 수 없음. 왜냐하면 회원테이블에 없기에


DROP TABLE IF EXISTS usertbl2;
 CREATE TABLE usertbl2 (
 userID CHAR(8) NOT NULL,
 name VARCHAR(10) NOT NULL,
 birthYear INT NOT NULL,
 CONSTRAINT PRIMARY KEY PK_userTBL_userID(userID)
 );
 -- 만약 다른 것과 참조된 키가 기존의 usertbl2에 있다면...
 -- alter table buytbl drop foreign key buytbl_ibfk_1;


drop table if exists prodtbl;
create table prodtbl(
	prodCode char(3) not null,
    prodID CHAR(4) NOT NULL,
	prodDate DATETIME NOT NULL,
	prodCur CHAR(10) NULL,
    constraint PK_prodtbl_proCode_prodID PRIMARY KEY (prodCode, prodID)
);
SHOW INDEX FROM prodtbl;


use sqldb;
create view v_userbuytbl as 
	(select u.userid, u.name, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as '연락처' 
		from usertbl u inner join buytbl b on u.userid = b.userid
	);
select * from v_userbuytbl where name = '김범수';