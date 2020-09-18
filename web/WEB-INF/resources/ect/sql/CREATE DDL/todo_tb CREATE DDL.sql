 create table todo_tb 
 (
	todo_id int(10) not null auto_increment primary key,
    is_done char(1) not null default 'N',
    content varchar(100) not null,
    w_time datetime not null default current_timestamp,
    is_deleted char(1) not null default 'N'
)engine=innodb charset=utf8;