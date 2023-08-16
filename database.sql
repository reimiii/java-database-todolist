show databases;

create database java_todolist;

use java_todolist;

create table todolist
(
    id   int          not null auto_increment,
    todo varchar(225) not null,
    primary key (id)
) engine = innodb;

show tables;

desc todolist;

select *
from todolist;