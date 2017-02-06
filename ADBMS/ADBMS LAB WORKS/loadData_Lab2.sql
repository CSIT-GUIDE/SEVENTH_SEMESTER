CREATE TABLE PERIOD(id int,first_name varchar(20),last_name varchar(20),email varchar(40),gender  varchar(10),ip_address varchar(12));

DESC PERIOD;
drop table PERIOD;
select * from PERIOD;

select max(length(id)) from PERIOD;

load data local infile 'MOCK_DATA.csv' into table PERIOD fields terminated by ',' enclosed by '"' lines terminated by '\n';


#write a script to find maximum length of of data in each column of a table.

DELIMITER //
CREATE PROCEDURE maxLength
(IN con CHAR(20))
BEGIN
  SELECT email FROM PERIOD WHERE email = con;
END //
DELIMITER ;