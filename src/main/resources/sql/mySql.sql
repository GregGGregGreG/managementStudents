INSERT INTO student_progress.groups (`id`, `name`)
VALUES
('1', 'MN-08-1'),
('2', 'MN-08-2');

INSERT INTO `student_progress`.`student` (`id`, `firstName`,`lastName`,`weekOfEntry`,`groups_id`)
	VALUES
('1', 'GreG','Ostapenko','2014-09-01','2'),
('2', 'Gustavo','Achong','2014-09-01','1'),
('3', 'Catherine','Abel','2014-09-01','2'),
('4', 'Humberto','Adams','2014-09-01','1'),
('5', 'Humberto','Achong','2014-09-01','1');

INSERT INTO `student_progress`.`discipline` (`id`, `name`)
VALUES
('1', 'Mathematics'),
('2', 'Physics'),
('3', 'History'),
('4', 'Physical Education');


INSERT INTO `student_progress`.`term` (`id`, `numberTerm`,`week`)
VALUES
('1', '1','25'),
('2', '2','18');

INSERT INTO `student_progress`.`curriculum` (`term_id`, `discipline_id`)
VALUES
('1', '1'),
('1', '3'),
('2', '2'),
('2', '4'),
('2', '1');


INSERT INTO `student_progress`.`studentprogress` (`rating`, `curriculum_discipline_id`,`curriculum_term_id`,`student_id`)
VALUES
('75', '1','1','1'),
('60', '3','1','1'),
('75', '4','2','1'),
('72', '4', '2', '2'),
('85', '2','2','1');



