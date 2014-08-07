insert into user_(first_name, login, pass, second_name, surname) values ('vitya', 'vitya', '111', 'sidorov', 'vottak');
insert into user_(first_name, login, pass, second_name, surname) values ('Denis', 'denis', '111', 'Sidorov', 'aga');
insert into user_(first_name, login, pass, second_name, surname) values ('Vlad', 'vlad', '111', 'Belskiy', 'fe');
insert into user_(first_name, login, pass, second_name, surname) values ('John', 'john', '111', 'john', 'fe');
insert into user_(first_name, login, pass, second_name, surname) values ('Jack', 'charlie', '111', 'Belskiy', 'fe');
insert into user_(first_name, login, pass, second_name, surname) values ('Vitaliy', 'vit', '111', 'Vitya', 'fe');
insert into user_(first_name, login, pass, second_name, surname) values ('Anastasiya', 'an', '111', 'Mezenceva', 'fe');
insert into user_(first_name, login, pass, second_name, surname) values ('Pavel', 'pvl', '111', 'azaza', 'fe');
insert into user_(first_name, login, pass, second_name, surname) values ('Igor', 'igr', '111', 'zhora', 'fe');
insert into user_(first_name, login, pass, second_name, surname) values ('Aleksandr', 'alksndr', '111', 'knaz', 'fe');
insert into user_(first_name, login, pass, second_name, surname) values ('admin', 'admin', 'admin', 'admin', 'admin');
insert into user_(first_name, login, pass, second_name, surname) values ('Timofey', 'tim', 'tim', 'Sakharchuk', 'cur');
insert into user_(first_name, login, pass, second_name, surname) values ('Sergey', 'curter', 'curter', 'Terehov', 'cur');
insert into user_(first_name, login, pass, second_name, surname) values ('hr', 'hr', 'hr', 'hr', 'hr');
insert into user_(first_name, login, pass, second_name, surname) values ('feed', 'feed', 'feed', 'feed', 'feed');
insert into user_(first_name, login, pass, second_name, surname) values ('cur', 'cur', 'cur', 'cur', 'cur');
insert into feedbackable (id) values(11), (12), (14), (16), (25);
insert into joanna (id) values (11);
insert into curator(id) values (12), (14);
insert into feedbacker(id) values (16);
insert into personneldepartment(id) values (15);
insert into project(id, title) values (1, 'Oscar'), (2, 'ExadelProbation'), (3, 'Emerica'), (4,'belskiy');
INSERT INTO student (email, english, phone, skype, state, course_group, faculty, graduate_year, specialty, university, id, curator, curator_id)
VALUES ('em1', 'elementary', 12352345, 'skype', 'PROBATION', '2/3', 'FAMCS', 2031, 'programmer', 'BSU', 8,12,12),
('em2@mail.com', 'preintermediate', 254123, 'skype', 'PROBATION', '2/3', 'FAMCS', 2018, 'programmer', 'BSU', 9,12,12),
  ('em3@mail.com', 'intermediate', 123123, 'skype', 'PROBATION', '1/3', 'FAMCS', 2019, 'programmer', 'BSU', 10,14,14),
  ('em4@mail.com', 'preintermediate', 12345, 'skype', 'PROBATION', '3/3', 'FAMCS', 2017, 'programmer', 'BSU', 17,14,14),
  ('em5@mail.com', 'intermediate', 56456, 'skype', 'PROBATION', '1/3', 'FAMCS', 2017, 'programmer', 'BSU', 18,14,14),
  ('em6@mail.com', 'preintermediate', 45633456, 'skype', 'PROBATION', '4/3', 'FAMCS', 2017, 'programmer', 'BSU', 19,14,14),
  ('em7@mail.com', 'elementary', 3456, 'skype', 'PROBATION', '1/3', 'FAMCS', 2017, 'programmer', 'BSU', 21,14,14),
  ('em8@mail.com', 'preintermediate', 123345, 'skype', 'PROBATION', '2/3', 'FAMCS', 2017, 'programmer', 'BSU', 22,14,14),
  ('em9@mail.com', 'advanced', 1234345, 'skype', 'PROBATION', '4/3', 'FAMCS', 2017, 'programmer', 'BSU', 23,14,14),
  ('em11@mail.com', 'beginner', 1112345, 'skype', 'PROBATION', '6/3', 'FAMCS', 2017, 'programmer', 'BSU', 24,14,14);
insert into technology (id, name) values (2,'java'), (3,'python'), (4, 'ruby'), (5, 'php'), (6,'javascript'), (7, 'spring'), (8, 'hibernate');
