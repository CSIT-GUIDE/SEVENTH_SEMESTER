DELIMITER $$
CREATE PROCEDURE findMaxLen_1()
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE colName VARCHAR(50);
	DECLARE tblName VARCHAR(50);
	DECLARE query1 VARCHAR(1000) DEFAULT ' ';
	DECLARE query2 VARCHAR(1000) DEFAULT 'select ';
	-- DECLARE query3 VARCHAR(1000) DEFAULT ' ';
DECLARE cur1 CURSOR FOR
SELECT column_name,table_name FROM information_schema.`COLUMNS` WHERE table_schema='rishi' AND table_name='rishi';

DECLARE CONTINUE HANDLER FOR NOT FOUND SET done=TRUE;

OPEN cur1;

read_loop: LOOP
FETCH NEXT FROM cur1 INTO colName,tblName;


IF done THEN
	LEAVE read_loop;
-- -------------------------------------------------------
ELSE
SET query1=CONCAT('max(length(',colName,')),');
SET query2=CONCAT(query2,query1);
-- -------------------------------------------------------
ITERATE read_loop;

END IF;

END LOOP;
SET @query3=CONCAT(LEFT(query2,(LENGTH(query2)-1)),' from ', tblName);
SELECT (@query3);
PREPARE stmt FROM @query3;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

CLOSE cur1;
END$$
