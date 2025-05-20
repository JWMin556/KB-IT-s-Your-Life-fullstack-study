create database recruitDB;
use recruitDB;
drop table if exists departments;
create table departments(
	dept_id int not null primary key,
    dept_name varchar(30) not null
);

drop table if exists applicants;
create table applicants(
	applicant_id int primary key,
    name VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    phone VARCHAR(15),
    dept_id INT,
    apply_date DATE,
    
    foreign key(dept_id) references departments(dept_id)
);

alter table applicants modify apply_date timestamp default current_timestamp;

alter table applicants add check(char_length(name) >= 2 and char_length(name) <= 20);
alter table applicants add check(char_length(phone) >= 10 and char_length(name) <= 13);


insert into departments values (1, '개발팀'), (2, '인사팀'), (3, '마케팅팀');

insert into applicants  values (101, '김지은', 'jkim@example.com', '01012345678', 1, default), (102, '이현수', 'hyunlee@example.com', '01098765432', 2, default);

-- insert into applicants  values (103, '최은비', 'eunbi@example.com', '01022223333', 99, default); --에러발생

-- insert into applicants  values (104, '강민수', 'jkim@example.com', '01044445555', 1, default); -- 에러발생

update applicants set name = '강지혜' where applicant_id = 101;

update departments set dept_name = '연구개발팀' where dept_id = 1;



alter table applicants add is_interviewed boolean default false;

alter table applicants drop check applicants_chk_2; 
alter table applicants drop column phone;

alter table applicants drop check applicants_chk_1;
alter table applicants change column name applicant_name varchar(100);
alter table applicants add check(char_length(applicant_name) >= 2 and char_length(applicant_name) <= 20);

alter table applicants drop FOREIGN KEY applicants_ibfk_1;

create view vw_applicant_summary as ( select applicant_id, applicant_name, email, dept_id, apply_date from applicants );
select * from vw_applicant_summary;

create view vw_dev_applicants as (
	select applicant_name, email, dept_name from applicants join departments on applicants.dept_id = departments.dept_id where dept_name = '연구개발팀'
);
select * from vw_dev_applicants;

create view vw_h_email_applicants as (
	select applicant_name, email, apply_date from applicants where email like 'h%'
);
select * from vw_h_email_applicants;

select applicant_name, apply_date from vw_applicant_summary;


update vw_applicant_summary set applicant_name = '김수진' where email = 'jkim@example.com';
select * from vw_applicant_summary; -- 이처럼 뷰도 수정 및 삭제가 가능하지만, 안될 확률이 더 높다.

insert into vw_applicant_summary values (999, '박지현', 'jhpark@example.com', 1, default);