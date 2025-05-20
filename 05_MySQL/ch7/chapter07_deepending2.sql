use employees;
select employees.emp_no 'emp_no', first_name, last_name, title 
	from employees join titles on employees.emp_no = titles.emp_no 
    where to_date >= current_date();
    
select employees.*, title, salary
	from employees 
		join titles on employees.emp_no = titles.emp_no 
        join salaries on titles.emp_no = salaries.emp_no
    where salaries.to_date >= current_date();
    
select employees.emp_no, first_name, last_name, dept_name
	from employees 
		join dept_emp on employees.emp_no = dept_emp.emp_no 
        join departments on dept_emp.dept_no = departments.dept_no
    where dept_emp.to_date >= current_date()
    order by employees.emp_no;


select dept_emp.dept_no, dept_name, count(*)
	from dept_emp join departments on dept_emp.dept_no = departments.dept_no
    where dept_emp.to_date >= current_date()
    group by dept_emp.dept_no, dept_name
    order by dept_emp.dept_no;

select employees.emp_no, first_name, last_name, dept_name, from_date, to_date
 from employees 
	join dept_emp on employees.emp_no = dept_emp.emp_no
    join departments on dept_emp.dept_no = departments.dept_no
where employees.emp_no = 10209;



