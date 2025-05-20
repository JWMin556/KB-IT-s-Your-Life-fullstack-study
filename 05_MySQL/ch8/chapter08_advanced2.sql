use employees;
create view EMPLOYEES_INFO as 
	(select e.*, t.title, t.from_date as 't_from', t.to_date as 't_to', s.salary, s.from_date as 's_from', s.to_date as 's_to'
     from employees e 
		join titles t on e.emp_no = t.emp_no
        join salaries s on t.emp_no = s.emp_no
	);
select * from EMPLOYEES_INFO;

select * from EMPLOYEES_INFO where s_to >= current_date;

create view EMP_DEPT_INFO as 
	( 
    select dept_emp.emp_no, departments.dept_no, departments.dept_name, dept_emp.from_date, dept_emp.to_date
    from dept_emp left outer join departments on dept_emp.dept_no = departments.dept_no
    );
select * from EMP_DEPT_INFO where to_date >= current_date;

