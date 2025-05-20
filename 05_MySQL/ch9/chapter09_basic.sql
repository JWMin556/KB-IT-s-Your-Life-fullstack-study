use sqldb;
create table tbl1(
	a int primary key,
    b int,
    c int
);
create table tbl2(
	a int primary key,
    b int unique,
    c int unique,
    d int
);
create table tbl3(
	a int unique,
    b int unique,
    c int unique,
    d int
);
create table tbl4(
	a int unique not null,
    b int unique,
    c int unique,
    d int
);
create table tbl5(
	a int unique not null,
    b int unique,
    c int unique,
    d int primary key
);

create table usertbl_ch6(
	userID CHAR(8) NOT NULL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    birthYear INT NOT NULL,
    addr NCHAR(2) NOT NULL
);
insert into usertbl_ch6 values 
	('LSG', '이승기', 1987, '서울'), 
    ('KBS', '김범수', 1979, '경남'), 
    ('KKH', '김경호', 1971, '전남'), 
    ('JYP', '조용필', 1950, '경기'), 
    ('S나', '성시경', 1979, '서울');
    
alter table usertbl_ch6 drop primary key;  -- 1. 기존 PRIMARY KEY 제거
alter table usertbl_ch6 add constraint pk_name primary key (name);  -- 2. name 컬럼에 새 PRIMARY KEY 설정 (제약조건명 pk_name은 MySQL에서는 무시됨)
