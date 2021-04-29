create table if not exists users(
	id SERIAL primary key,
	first_name VARCHAR(15) not null,
	last_name VARCHAR(15) check (length(last_name) > 3)
);

insert into users (first_name, last_name) values ('Shae', 'Mabone');
insert into users (first_name, last_name) values ('Nerta', 'Faraday');
insert into users (first_name, last_name) values ('Meir', 'Fasse');
--insert into users (first_name, last_name) values ('Dani', 'Boc');
insert into users (first_name, last_name) values ('Dacie', 'Darkins');
insert into users (first_name, last_name) values ('Thibaud', 'Kenney');
insert into users (first_name, last_name) values ('Lorrayne', 'Carrigan');
insert into users (first_name, last_name) values ('Nettie', 'Pratten');

insert into users (first_name, last_name) values ('Vinny', 'Heminsley');

insert into users (first_name, last_name) values ('Cheston', 'Lynam');

select upper(first_name) from users;

-- A junction table can be used to illustrate a many to many relationship
create table friends( 
	friend1 INTEGER references users(id),
	friend2 INTEGER references users(id),
	primary key (friend1, friend2)
);

insert into friends (friend1, friend2) values (1,2), (2,3), (2,5), (5,7);