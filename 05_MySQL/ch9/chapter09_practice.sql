create database job_platform;
use job_platform;

create table company(
	company_id int primary key auto_increment,
    company_name VARCHAR(100) NOT NULL,
    industry VARCHAR(50), 
    founded_year int check (founded_year >= 1900)
);
create index idx_company_industry on company(industry);

create table recruit_post(
	post_id int primary key auto_increment,
    company_id int,
    title VARCHAR(100) null,
    job_type VARCHAR(20) check(job_type in ('정규직', '계약직', '인턴')),
    deadline date null,
    is_active BOOLEAN default true,
    foreign key(company_id) references company(company_id)
);

INSERT INTO company (company_name, industry, founded_year) VALUES
('카카오', 'IT', 2010),
('현대자동차', '제조업', 1967),
('토스', '핀테크', 2015),
('쿠팡', '물류/유통', 2010),
('CJ ENM', '미디어', 1995),
('배달의민족', 'IT', 2011);

INSERT INTO recruit_post (company_id, title, job_type, deadline, is_active) VALUES
((SELECT company_id FROM company WHERE company_name = '카카오'), '백엔드 개발자', '정규직', '2025-06-15', true),
((SELECT company_id FROM company WHERE company_name = '현대자동차'), '생산관리 신입 모집', '정규직', '2025-06-20', true),
((SELECT company_id FROM company WHERE company_name = '토스'), '데이터 분석 인턴', '인턴', '2025-05-31', true),
((SELECT company_id FROM company WHERE company_name = '카카오'), 'UX 디자이너 계약직', '계약직', '2025-06-10', FALSE),
((SELECT company_id FROM company WHERE company_name = '쿠팡'), '물류센터 관리자 채용', '정규직', '2025-06-25', TRUE),
((SELECT company_id FROM company WHERE company_name = 'CJ ENM'), '콘텐츠 마케팅 인턴', '인턴', '2025-05-30', TRUE),
((SELECT company_id FROM company WHERE company_name = '배달의민족'), '앱 서비스 운영 계약직', '계약직', '2025-06-12', TRUE),
((SELECT company_id FROM company WHERE company_name = '배달의민족'), '데이터 엔지니어 채용', '정규직', '2025-06-18', TRUE),
((SELECT company_id FROM company WHERE company_name = '현대자동차'), '브랜드전략팀 계약직 채용', '계약직', '2025-06-08', FALSE),
((SELECT company_id FROM company WHERE company_name = '쿠팡'), '풀필먼트 혁신 프로젝트 인턴', '인턴', '2025-05-27', TRUE);


select post_id, title, job_type, deadline, is_active from recruit_post where is_active = true order by deadline;
select company_name, title, job_type, deadline, is_active from recruit_post join company on recruit_post.company_id = company.company_id order by company_name;
select company_name, industry, title, job_type, deadline, is_active
	from recruit_post join company on recruit_post.company_id = company.company_id 
    where industry = 'IT' or industry = '핀테크'
    order by deadline desc;

select company_name, title, job_type, deadline
	from recruit_post join company on recruit_post.company_id = company.company_id 
    where deadline >= '2025-05-25' and deadline <= '2025-06-01'
    order by deadline;

select company_name, title, job_type, deadline, is_active
	from recruit_post join company on recruit_post.company_id = company.company_id 
    where title like '%데이터%'
    order by deadline;
    
select company_name, count(*) as '공고수'
	from recruit_post join company on recruit_post.company_id = company.company_id 
    group by company_name
    order by count(*) desc;

select company_name, count(*) as '공고수'
	from recruit_post join company on recruit_post.company_id = company.company_id 
    group by company_name
    having count(*) >= 2
    order by count(*) desc;

select job_type, count(*) as '공고수'
	from recruit_post 
    group by job_type
    order by count(*) desc;
    
-- 11번
select company_name, title, job_type, deadline, is_active
	from recruit_post join company on recruit_post.company_id = company.company_id 
    where industry = 'IT' and job_type = '정규직'
    order by deadline;

-- 12번
INSERT INTO company (company_name, industry, founded_year)
VALUES ('네이버', 'IT', 1999);
select company_name, title, job_type, deadline
	from recruit_post right outer join company on recruit_post.company_id = company.company_id 
    order by company_name;
    
    
-- 13
select company_name, industry, founded_year
	from recruit_post right outer join company on recruit_post.company_id = company.company_id 
    where title is NULL
    order by company_name;    
    
    
-- 14
INSERT INTO recruit_post (company_id, title, job_type, deadline, is_active)
VALUES (
  (SELECT company_id FROM company WHERE company_name = '카카오'),
  'AI 연구원 채용',
  '정규직',
  '2025-06-28',
  TRUE
);
select company_name, industry, COUNT(*) as '공고수'
	from recruit_post join company on recruit_post.company_id = company.company_id 
    group by company_name, industry
    order by COUNT(*) desc
    limit 1;
    
    
-- 15
select company_name, count(*) as 공고수
	from recruit_post join company on recruit_post.company_id = company.company_id 
    group by company_name
    having sum(case when recruit_post.is_active = false then 1 else 0 end) = 0
    order by 공고수 desc;
   
-- 16
select company_name, industry, founded_year
	from company
    where company_id in (select company_id from recruit_post)
    order by company_name;
    
    
-- 17
INSERT INTO company (company_name, industry, founded_year)
VALUES ('삼성전자', '전자', 1969);
select company_name, industry, founded_year
	from company
    where company_id not in (select company_id from recruit_post)
    order by company_name;


-- 18
-- ① 외래키 제약 해제
SET FOREIGN_KEY_CHECKS = 0;

-- ② 존재하지 않는 company_id를 참조하는 테스트 공고 삽입
INSERT INTO recruit_post (company_id, title, job_type, deadline, is_active)
VALUES (999, '테스트용 유효하지 않은 공고', '정규직', '2025-07-01', TRUE);

-- ③ 외래키 제약 다시 활성화
SET FOREIGN_KEY_CHECKS = 1;
select title, company_id, deadline, is_active from recruit_post where company_id not in (select company_id from company);

-- 19
create index idx_post_deadline on recruit_post(deadline);
create index idx_post_jobtype on recruit_post(job_type);
show index from recruit_post;


-- 20
select industry, COUNT(*) as '공고수'
	from recruit_post join company on recruit_post.company_id = company.company_id 
    where job_type = '정규직'
    group by industry
    having count(*) >= 1
    order by count(*) desc;


-- 21
create user 'job_reader'@'localhost' identified by 'job1234';
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 22
grant select on job_platform.* to 'job_reader'@'localhost';
flush privileges;
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 23
revoke select on job_platform.* from 'job_reader'@'localhost';
SHOW GRANTS FOR 'job_reader'@'localhost';


-- 24
drop user 'job_reader'@'localhost';
SHOW GRANTS FOR 'job_reader'@'localhost';

-- 25
create view vw_active_post as (
	select post_id, title, job_type, deadline, is_active from recruit_post where is_active = true
);
select * from vw_active_post;


-- 26
select * from vw_active_post  where job_type = '정규직' order by deadline;



-- 27
-- 기존 뷰 삭제
DROP VIEW IF EXISTS vw_active_post;

-- company_id를 포함하여 뷰 재생성
CREATE VIEW vw_active_post AS
SELECT post_id, title, job_type, deadline, is_active, company_id
FROM recruit_post
WHERE is_active = TRUE;

select company_name, title, job_type, deadline from vw_active_post join company on company.company_id = vw_active_post.company_id order by deadline;



-- 28
start transaction;
update recruit_post set title = '🔥 실수로 수정된 제목 🔥' where post_id = 1;
select * from recruit_post;
rollback;
select * from recruit_post;



-- 29
start transaction;
update recruit_post set title = '백엔드 개발자 채용 (수정됨)' where post_id = 1;
select * from recruit_post;
COMMIT;
select * from recruit_post;



-- 30
select company_name, title, job_type, deadline
	from recruit_post join company on recruit_post.company_id = company.company_id
    where deadline >= '2025-06-25' and job_type = '정규직' and is_active = true
    order by deadline;