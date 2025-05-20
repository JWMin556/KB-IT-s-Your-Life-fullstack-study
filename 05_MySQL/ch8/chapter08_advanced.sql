drop table if exists usertbl;  
create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null
);
drop table if exists buytbl;  
create table buytbl(
	num int not null AUTO_INCREMENT primary key,
    userID CHAR(8) not null,
    prodName CHAR(6) NOT NULL,
    foreign key(userID) references usertbl(userID)
);

drop table if exists usertbl;  
create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null,
    email char(30) null unique
);

drop table if exists usertbl;  
create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) null,
    birthyear int check (birthyear >= 1900 and birthyear <= 2023),
    mobile char(3) not null
);

drop table if exists usertbl;  
create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) null,
    birthyear int check (birthyear >= 1900 and birthyear <= 2023),
    mobile char(3) not null
);

drop table if exists usertbl;  
create table usertbl(
	userID char(8) not null primary key,
    name varchar(10) not null,
    birthyear int not null default -1,
    addr char(2) not null default '서울',
	mobile1 char(3) null,
    mobile2 char(8) null,
    height smallint null default 170,
    mDate Date null
);
insert into usertbl values ('LHL', '이혜리', default, default,'011', '1234567', default, '2023.12.12');


alter table usertbl
drop column mobile1;

alter table usertbl
change column name uName varchar(20) null;

-- usertbl의 기본 키인userID열은 buytbl에 외래 키로 연결되어 있기때문에 외래키를 제거한 후에 다시 기본키를 제거해야 오루없음
alter table usertbl
drop primary key; 



