drop table myapp_users;

create table myapp_users (
  user_id int not null,
  name varchar(20) not null,
  email varchar(100) not null,
  pwd varchar(100) not null,
  tel varchar(20)
);

alter table myapp_users
  add constraint primary key (user_id),
  modify column user_id int not null auto_increment,
  add constraint myapp_users_uk unique (email);

insert into myapp_users(user_id, name, email, pwd) values
  (1, 'user1', 'user1@test.com', sha1('1111')),
  (2, 'user2', 'user2@test.com', sha1('1111')),
  (3, 'user3', 'user3@test.com', sha1('1111')),
  (4, 'user4', 'user4@test.com', sha1('1111')),
  (5, 'user5', 'user5@test.com', sha1('1111')),
  (6, 'user6', 'user6@test.com', sha1('1111')),
  (7, 'user7', 'user7@test.com', sha1('1111')),
  (8, 'user8', 'user8@test.com', sha1('1111')),
  (9, 'user9', 'user9@test.com', sha1('1111')),
  (10, 'user10', 'user10@test.com', sha1('1111'));
