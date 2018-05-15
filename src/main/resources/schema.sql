-- MUST BE RUN MANUALLY AGAINST DATABASE
drop table if exists Alternative;
create table Alternative(
  IdAlt bigint(20) NOT NULL auto_increment primary key,
  AName varchar(255) NOT NULL,
);

drop table if exists lpr;
create table lpr (
  idLPR bigint(20) not null auto_increment primary key,
  LName varchar(255) not null,
  LRange smallint not null
);

drop table if exists Criterion;
create table Criterion (
  IdCrit bigint(20) not null auto_increment primary key ,
  CName varchar(255) not null,
  CRange int8 not null,
  CWeight int8 not null,
  CType varchar(255) not null,
  OptimType varchar(255) not null,
  EdIzmer varchar(255) not null,
  ScaleType varchar(255) not null
);