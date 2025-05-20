use employees;
select * 
from departments join dept_manager on departments.dept_no = dept_manager.dept_no
where dept_manager.to_date > curdate();

select * 
from dept_manager join employees on dept_manager.emp_no = employees.emp_no
where dept_manager.dept_no = 'd005';

select * from employees order by hire_date desc limit 140, 20;  -- 8페이지부터

select count(*) '재직자 수'
from employees join dept_emp on employees.emp_no = dept_emp.emp_no
where dept_emp.to_date = '9999-01-01';

select avg(salary) '재직자의 평균급여' from salaries where to_date = '9999-01-01';

select first_name, last_name, salary
from salaries join employees on salaries.emp_no = employees.emp_no
where to_date = '9999-01-01' and salary > (
	  SELECT AVG(salary)
	  FROM salaries
	  WHERE to_date = '9999-01-01'
);

select dept_no, count(employees.emp_no)
from employees join dept_emp on employees.emp_no = dept_emp.emp_no
group by dept_no;