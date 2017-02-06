BEGIN 
  DBMS_RLS.ADD_POLICY(
	object_schema => 'system',
	object_name => 'customer',
	policy_name => 'secure',
	policy_function => 'orders',
	statement_types => 'SELECT');
END;
/