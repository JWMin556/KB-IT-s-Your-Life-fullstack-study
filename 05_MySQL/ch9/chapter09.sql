create database scoula_db;
drop user if exists 'scoula'@'%'; -- 있으면 지워라
create user 'scoula'@'%' identified by '1234';
grant all privileges on scoula_db.* to 'scoula'@'%';
grant all privileges on sqldb.* to 'scoula'@'%';
flush privileges;

use sqldb;
select * from buytbl;

start transaction;
delete from buytbl where num = 1;
delete from buytbl where num = 2;
select * from buytbl;
rollback;
select * from buytbl;