create database atm;
use atm;
create table user(id int auto_increment primary key,password int,name text,account_balance int);
insert into user values(1,12,'vikas',10000);
select * from user;