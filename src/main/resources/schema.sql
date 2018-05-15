-- MUST BE RUN MANUALLY AGAINST DATABASE
drop table Alternative;
create table Alternative(
  IdAlt bigint(20) NOT NULL auto_increment,
  AName varchar(255) NOT NULL,
);