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

