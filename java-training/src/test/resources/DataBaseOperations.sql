
-- Create Employee Table

create table Employee(
	employee_id int primary key,
	employee_name varchar(100),
	employee_salary double,
	dept_id int
);

-- drop table
drop table employee;

-- Create Department Table

create table Department(
	dept_id int,
	dept_name varchar(100),
	location varchar(100)	
);

-- Insert Data into both tables

insert into employee values(101, 'Ranjith', 25000, 111);
insert into employee values(102, 'Kumar', 25000, 112);
insert into employee values(103, 'Sunny', 28000, 113);
insert into employee values(104, 'Happy', 15000, 111);
insert into employee values(105, 'Ram', 35000, 111);
insert into employee values(106, 'Charan', 55000, 113);

insert into department values(111, 'Developer', 'Hyderabad');
insert into department values(112, 'IT Support', 'Hyderabad');
insert into department values(113, 'Manager', 'Bangalore');

-- Retrieve data from both tables

select * from employee order by employee_id;

select * from department order by dept_id;

-- Update details in tables

update employee set employee.employee_salary = 50000 where employee.employee_id = 103;

-- delete row from table and add new value

delete from employee where employee_id = 104;

insert into employee values(104, 'Nikki', 25000, 111);

-- group by and having examples

select employee_id, employee_name, avg(employee_salary) as salary from employee group by employee_id, employee_name
having count(employee_id) >= 1 order by employee_id;

-- Alter

alter table employee add role varchar(40);

update employee set role = 'Manager' where employee_id = 106;
update employee set role = 'Developer' where employee_id = 101;
update employee set role = 'IT Support' where employee_id = 102;

-- exists

select * from employee 
where exists (select * from department where department.dept_id = employee.dept_id and location in ('Hyderabad')) order by employee_id;

-- Joins

select * from employee inner join department on department.dept_id = employee.dept_id;

select * from employee left outer join department on department.dept_id = employee.dept_id order by employee_id;

select * from employee right outer join department on department.dept_id = employee.dept_id and department.dept_name = employee.role order by employee_id;

select * from employee full outer join department on department.dept_id = employee.dept_id order by employee_id;

-- self join
select employee_name as E1, employee_name as E2, dept_id, employee_salary from employee E1, employee E2 where E1.dept_id <> E2.dept_id and E1.employee_salary = E2.employee_salary
order by E1.employee_salary;

-- union

select dept_id from employee
union
select dept_id from department
order by dept_id;

select dept_id from employee
union all
select dept_id from department
order by dept_id;

-- select top examples
select TOP 3 * from employee;
select * from employee limit 3;
select * from employee fetch 4 rows only;
-- SELECT TOP 50 PERCENT * FROM employee; some how not working





