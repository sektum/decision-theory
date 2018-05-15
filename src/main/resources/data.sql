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
)
