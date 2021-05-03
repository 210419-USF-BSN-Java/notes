-- This is a single line comment

/*
This is a multi line
comment.

Naming convention is snake_case, due to lack of case sensitivity
keywords such as datatypes and constraints should be uppercased
*/

-- How to create/drop a schema
--create schema company;
--drop schema company;

create table departments(
	dept_id SERIAL primary key,
	dept_name VARCHAR(50) not null,
	monthly_budget NUMERIC(6,2) -- 9999.99
);

create table if not exists employees(
	empl_id SERIAL primary key,
	empl_name VARCHAR(50),
	monthly_salary NUMERIC(6,2),
	empl_position VARCHAR(50),
	manager_id INTEGER references employees(empl_id),
	dept_id INTEGER references departments(dept_id)
);

-- Have to drop in a specific order/ or on cascade 
--drop table employees;
--drop table departments;

alter table departments 
	alter column monthly_budget type numeric(7,2);

insert into departments (dept_name, monthly_budget) values ('HR', 3000);
insert into departments (dept_name, monthly_budget) values ('Rhyzio', 7165.5);
insert into departments (dept_name, monthly_budget) values ('Wordify', 6130.4);
insert into departments (dept_name, monthly_budget) values ('Oyoloo', 5988.7);
--insert into departments (dept_name, monthly_budget) values ('Zooxo', 3538.8);
--insert into departments (dept_name, monthly_budget) values ('Jetwire', 3505.7);
insert into departments (dept_name, monthly_budget) values
			('Zooxo', 3538.8),
			('Jetwire', 3505.7);
			
update departments set dept_name = 'Finance' where dept_id = 4;
-- Don't forget where clause or applies to every record
update departments set monthly_budget = 3000;

delete from departments where dept_id = 3;

-- where clause is a condition which "evaluates to a boolean" 
delete from departments where dept_id = 1 or dept_id =4;

select * from departments;
select dept_name, monthly_budget from departments;
select dept_name, monthly_budget from departments where dept_id > 2;
select dept_name, monthly_budget from departments where dept_id > 2 order by dept_name;

insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values('Kevin T', 3000, 'Trainer', default, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Sonair', 1217.84, 'Cogidoo', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Wrapsafe', 1609.14, 'Vinte', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Quo Lux', 867.8, 'Photobug', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Cardify', 523.49, 'Wikivu', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Voltsillam', 652.61, 'Browsebug', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Bitwolf', 1606.97, 'Quatz', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Stim', 951.51, 'Mycat', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Asoka', 999.3, 'Skiptube', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Job', 1738.36, 'Dabtype', 2, 2);
insert into employees (empl_name, monthly_salary, empl_position, manager_id, dept_id) values ('Hatity', 854.47, 'Quatz', 2, 2);

select * from employees;

-- left outer join/ right join/ full outer join
select employees.empl_name as name, departments.dept_name as department from employees 
join departments
on employees.dept_id = departments.dept_id; 

select e.empl_name "Employee name", m.empl_name "Manager name"
from employees e 
join employees m 
on e.manager_id = m.empl_id 
order by m.empl_name;
