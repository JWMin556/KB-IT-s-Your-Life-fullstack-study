-- 2 페이지
show databases;
use employees;
show tables;
desc employees;

-- 3 페이지
use employees;
select * from titles;
select first_name from employees;
select first_name, last_name, gender from employees;

-- 4 페이지
use employees;
select first_name '이름', gender '성별', hire_date '회사 입사일' from employees;

-- 6 페이지
use sqldb;
select * from usertbl where name = '김경호';
select userid, name from usertbl where birthyear >= 1970 AND height >= 182;

-- 7 페이지
use sqldb;
select name, height from usertbl where height between 180 and 183;
select name, addr from usertbl where addr in ('경남', '전남', '경북');
select name, height from usertbl where name like '김%';

-- 8 페이지
use sqldb;
select name, height from usertbl where height > (select height from usertbl where name = '김경호');

-- 9 페이지
use sqldb;
select name, mDate from usertbl order by mDate;
select name, mDate from usertbl order by mDate desc;
select name, height from usertbl order by height desc, name desc;

-- 10 페이지
use sqldb;
select distinct addr from usertbl;

-- 11 페이지
use world;
select name from city where countrycode = 'KOR' order by population desc; -- 1번
select countrycode, population from city order by countrycode, population desc; -- 2번
select count(*) AS '도시의 수' from city where countrycode = 'KOR';  -- 3번
select name from city where countrycode = 'KOR' or countrycode = 'CHN' or countrycode = 'JPN';  -- 4번
select name from city where countrycode = 'KOR' and population >= 1000000;  -- 5번
select name from city where countrycode = 'KOR' order by population desc limit 10;  -- 6번
select name from city where countrycode = 'KOR' and population between 1000000 and 5000000;  -- 7번


