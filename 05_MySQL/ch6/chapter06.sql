USE employees;  
SELECT * FROM titles; -- 모든 칼럼

show databases;
show tables; -- 테이블의 목록 보이기
desc employees;

USE sqldb;
SELECT * FROM usertbl WHERE name = '김경호'; 

SELECT * FROM employees.employees WHERE first_name = 'georgi';


select count(*) from employees.employees;
