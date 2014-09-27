INSERT INTO groups (`id`, `name`)
VALUES
('1', 'МН-08-1'),
('2', 'МН-08-2');

INSERT INTO student (`id`, `firstName`,`lastName`,`weekOfEntry`,`groups_id`)
	VALUES
('1', 'Дима','Вольный','2014-09-01','2'),
('2', 'Дима','Купер','2014-09-01','1'),
('3', 'Антон','Антонов','2014-09-01','2'),
('4', 'Петр','Петров','2014-09-01','1'),
('5', 'Лев','Толстой','2014-09-01','1');

INSERT INTO discipline (`id`, `name`)
VALUES
('1', 'Математика'),
('2', 'Физика'),
('3', 'История'),
('4', 'Физкультура');


INSERT INTO term (`id`, `numberTerm`,`week`)
VALUES
('1', '1','25'),
('2', '2','18');

INSERT INTO curriculum (`term_id`, `discipline_id`)
VALUES
('1', '1'),
('1', '3'),
('2', '2'),
('2', '4'),
('2', '1');


INSERT INTO studentprogress (`rating`, `curriculum_discipline_id`,`curriculum_term_id`,`student_id`)
VALUES
('75', '1','1','1'),
('60', '3','1','1'),
('75', '4','2','1'),
('72', '4', '2', '2'),
('85', '2','2','1');













