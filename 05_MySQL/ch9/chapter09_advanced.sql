use sqldb;

select * from usertbl;
show index from usertbl;
SELECT 
    table_schema AS `Database`,
    table_name AS `Table`,
    ROUND(data_length / 1024 / 1024, 2) AS `Data Size (MB)`,
    ROUND(index_length / 1024 / 1024, 2) AS `Index Size (MB)`,
    ROUND((data_length + index_length) / 1024 / 1024, 2) AS `Total Size (MB)`
FROM 
    information_schema.TABLES
WHERE 
    table_schema = 'sqldb'
    AND table_name = 'usertbl';
    
create index idx_usertbl_addr on usertbl(addr);
show index from usertbl;
show table status LIKE 'usertbl';
analyze table usertbl;
show table status LIKE 'usertbl';


create unique index idx_usertbl_birthYear on usertbl(birthYear); -- 중복값이 있어서 인덱스 에러 발생
create unique index idx_usertble_name on usertbl(name);
show index from usertbl;


drop index idx_usertble_name on usertbl;
create unique index idx_usertbl_name_birthYear on usertbl(name, birthYear);
show index from usertbl;

drop index idx_usertbl_name_birthYear on usertbl;
drop index idx_usertbl_addr on usertbl;