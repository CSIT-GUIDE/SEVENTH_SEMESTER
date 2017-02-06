CREATE OR REPLACE FUNCTION orders(
	schema_var IN VARCHAR2,
	table_var IN VARCHAR2
)
RETURN VARCHAR2
IS
  return_val VARCHAR2 (400);
BEGIN
  return_val := 'mgr_id = 205';
  RETURN return_val;
END orders;
/