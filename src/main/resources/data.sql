delete from ALTERNATIVE;
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (1, 'HP 2017 15.6" Full-HD IPS UWVA Laptop');
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (2, 'Dell Latitude E7470 Business Ultrabook');
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (3, 'Apple MacBook Pro MF839LL/A');
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (4, 'Lenovo Yoga');
INSERT INTO ALTERNATIVE (IDALT, ANAME) VALUES (5, 'ASUS K501UW-AB78');

delete from LPR;
insert into LPR (LNAME, LRANGE) values ('Иван Иванов', 1);
insert into LPR (LNAME, LRANGE) values ('Петр Петров', 1);
insert into LPR (LNAME, LRANGE) values ('Василий Сидоров', 1);

delete from CRITERION;
insert into CRITERION (CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE)
VALUES ('Диагональ экрана', 10, 10, 'Количественный', 'Неприменимо', 'Дюймы', 'Абсолютная');
insert into CRITERION (CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE) VALUES (
    'Вес', 5, 5, 'Количественный', 'Min', 'Килограммы', 'Абсолютная'
);
insert into CRITERION (CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE) VALUES (
    'Батарея', 10, 10, 'Количественный', 'Max', 'Часы', 'Абсолютная'
);
insert into CRITERION (CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE) VALUES (
    'Производитель', 2, 2, 'Качественный', 'Неприменимо', 'Неприменимо', 'Номинальная'
);
insert into CRITERION (CNAME, CRANGE, CWEIGHT, CTYPE, OPTIMTYPE, EDIZMER, SCALETYPE) VALUES (
    'Процессор', 5, 5, 'Качественный', 'Max', 'Неприменимо', 'Порядковая'
);
