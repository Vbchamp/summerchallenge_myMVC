create table "APP".BLOGS
(
	MESSAGE VARCHAR(1000),
	DATE DATE,
	BLOGGER VARCHAR(30),
	BLOG_ID VARCHAR(150) default '1' not null primary key
);

create table "APP".LOGIN
(
	USERID VARCHAR(25) not null,
	PASSWORD VARCHAR(10) not null
)