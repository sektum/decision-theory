delete from ALTERNATIVE;
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (1, 'HP 2017 15.6" Full-HD IPS UWVA Laptop');
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (2, 'Dell Latitude E7470 Business Ultrabook');
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (3, 'Apple MacBook Pro MF839LL/A');
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (4, 'Lenovo Yoga');
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (5, 'ASUS K501UW-AB78');

delete from LPR;
insert into LPR (IDLPR, LNAME, LRANGE) values (1, 'Иван Иванов', 1);
insert into LPR (IDLPR, LNAME, LRANGE) values (2, 'Петр Петров', 1);
insert into LPR (IDLPR, LNAME, LRANGE) values (3, 'Василий Сидоров', 1);

delete from CRITERION;
insert into CRITERION (IDCRIT, CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE)
VALUES (1, 'Диагональ экрана', 10, 10, 'Количественный', 'Неприменимо', 'Дюймы', 'Абсолютная');
insert into CRITERION (IDCRIT,CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE) VALUES (
    2, 'Вес', 5, 5, 'Количественный', 'Min', 'Килограммы', 'Абсолютная'
);
insert into CRITERION (IDCRIT,CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE) VALUES (
    3, 'Батарея', 10, 10, 'Количественный', 'Max', 'Часы', 'Абсолютная'
);
insert into CRITERION (IDCRIT,CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE) VALUES (
    4, 'Производитель', 2, 2, 'Качественный', 'Неприменимо', 'Неприменимо', 'Номинальная'
);
insert into CRITERION (IDCRIT,CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE) VALUES (
    5, 'Процессор', 5, 5, 'Качественный', 'Max', 'Неприменимо', 'Порядковая'
);

delete from Mark;
insert into MARK (IDMARK, IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    1, 1, '13.5', 1, 13, 13
);
insert into MARK (IDMARK, IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    2, 1, '15.3', 1, 15, 15,
);
insert into MARK (IDMARK, IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    3, 1, '17.1', 1, 17, 17
);
insert into MARK (IDMARK, IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    4, 2, '1.29', 1, 29, 29
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    5, 2, '1.37', 1, 37, 37
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    6, 2, '1.25', 1, 25, 25
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) values (
    7, 3, '13', 1, 13, 13
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    8, 3, '10', 1, 10, 10
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    9, 3, '14.5', 1, 14, 14
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    10, 4, 'Dell', 1, 1, 1
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    11, 4, 'Apple', 1, 1, 1
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    12, 4, 'Lenovo', 1, 1, 1
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    13, 4, 'Asus', 1, 1, 1
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    14, 4, 'HP', 1, 1, 1
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    15, 5, 'Intel i5', 1, 5, 5
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    16, 5, 'Intel i7', 1, 7, 7
);
insert into MARK (IDMARK,IDCRIT, MNAME, MRANGE, NUMMARK, NORMMARK) VALUES (
    17, 5, 'Intel i3', 1, 3, 3
);

delete from VECTOR;
INSERT INTO VECTOR (IDVECT, IDALT, IDMARK) VALUES (1, 1, 1);
INSERT INTO VECTOR (IDVECT, IDALT, IDMARK) VALUES (2, 2, 1);
INSERT INTO VECTOR (IDVECT, IDALT, IDMARK) VALUES (3, 3, 2);
INSERT INTO VECTOR (IDVECT, IDALT, IDMARK) VALUES (4, 4, 3);
INSERT INTO VECTOR (IDVECT, IDALT, IDMARK) VALUES (5, 5, 2);
insert into vector (IDVECT, IDALT, IDMARK) VALUES (6, 1, 5);
insert into vector (IDVECT, IDALT, IDMARK) VALUES (7, 2, 4);
insert into vector (IDVECT, IDALT, IDMARK) VALUES (8, 3, 6);
insert into vector (IDVECT, IDALT, IDMARK) VALUES (9, 4, 6);
insert into vector (IDVECT, IDALT, IDMARK) VALUES (10, 5, 4);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (11, 1, 7);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (12, 2, 9);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (13, 3, 9);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (14, 4, 8);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (15, 5, 7);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (16, 1, 14);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (17, 2, 10);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (18, 3, 11);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (19, 4, 12);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (20, 5, 13);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (21, 1, 15);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (22, 2, 16);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (23, 3, 17);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (24, 4, 15);
insert into VECTOR (IDVECT, IDALT, IDMARK) VALUES (25, 5, 15);
