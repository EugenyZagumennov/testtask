drop table if exists user;

create table user (
   id bigint not null auto_increment,
	username varchar(100) not null,
	password varchar(255) not null,
	first_name varchar(200) not null,
	last_name varchar(200) not null,
	role varchar(255) not null,
	status varchar(255) not null,
	primary key (id)
) engine=MyISAM;