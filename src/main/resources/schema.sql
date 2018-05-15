-- MUST BE RUN MANUALLY AGAINST DATABASE
drop table if exists Alternative;
create table Alternative(
  IdAlt bigint(20) NOT NULL primary key,
  AName varchar(255) NOT NULL,
);

drop table if exists lpr;
create table lpr (
  idLPR smallint not null primary key,
  LName varchar(255) not null,
  LRange smallint not null
);

drop table if exists Criterion;
create table Criterion (
  IdCrit bigint(20) not null primary key ,
  CName varchar(255) not null,
  CRange int8 not null,
  CWeight int8 not null,
  CType varchar(255) not null,
  OptimType varchar(255) not null,
  EdIzmer varchar(255) not null,
  ScaleType varchar(255) not null
);

drop table if exists Mark;
create table Mark (
  IdMark int8 not null primary key ,
  IdCrit bigint(20) not null,
  MName varchar(255) not null,
  MRange int8 not null,
  NumMark int8 not null,
  NormMark int8 not null,
  FOREIGN KEY (IdCrit) REFERENCES Criterion(IdCrit)
);

drop table if exists Vector;
create table Vector (
  idVect bigint(20) not null primary key ,
  idAlt bigint(20) not null ,
  idMark int8 not null ,
  FOREIGN KEY (idAlt) REFERENCES Alternative(idAlt),
  FOREIGN KEY (idMark) REFERENCES Mark(IdMark)
);

drop table if exists Result;
create table Result (
  idRes smallint not null primary key ,
  idLpr smallint not null ,
  idAlt smallint not null ,
  Range smallint not null ,
  AWeight smallint not null ,
  foreign key (idLpr) references lpr(idLPR),
  foreign key (idAlt) references Alternative(idAlt)
);