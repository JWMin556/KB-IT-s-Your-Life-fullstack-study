use sqldb;
select userid as '사용자 아이디', sum(amount) as '총 구매 개수' from buytbl group by userid;
select userid as '사용자 아이디', sum(price * amount) as '총 구매액' from buytbl group by userid;
select avg(amount) as '평균 구매 개수' from buytbl;
select userid as '사용자 아이디', avg(amount) as '평균 구매 개수' from buytbl group by userid;
select name, height from usertbl where height = (select min(height) from usertbl)
union
select name, height from usertbl where height = (select max(height) from usertbl);
select count(*) '휴대폰이 있는 사용자' from usertbl where mobile1 is not null and mobile2 is not null;
select userid as '사용자 아이디', sum(price * amount) as '총 구매액' from buytbl group by userid having sum(price * amount) > 1000;



use world;
select sum(population) '한국의 인구수 총합' from city where countrycode = 'KOR';
select name '도시명', population '최소값' from city where countrycode = 'KOR' order by population limit 1;
select avg(population) '인구평균' from city where countrycode = 'KOR';
select name '도시명', population '최소값' from city where countrycode = 'KOR' order by population desc limit 1;
select name ,char_length(name) 'name의 글자수' from country;
select concat(upper(substring(name, 1, 3)), lower(substring(name, 4))) AS '앞의 3글자만'  from country;
select name, round(LifeExpectancy, 1) from country;

