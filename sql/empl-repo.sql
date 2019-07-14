
CREATE TABLE employee (
	id 			varchar2(254)	NOT NULL,
	password 		varchar2(254)	NULL,
	PRIMARY KEY(id)
);

CREATE TABLE employee_details (
	id 			varchar2(254)	NOT NULL REFERENCES employee(id),
	name 			varchar2(254)	NULL,
	address 		varchar2(254)	NULL,
	city 			varchar2(254)	NULL,
	phone_number 		varchar2(254)	NULL,
	date_of_birth 		varchar2(254)	NULL,
	PRIMARY KEY(id)
);

CREATE INDEX employee_details_idx ON employee_details(id);

CREATE TABLE employee_accRelation (
	id 			varchar2(254)	NOT NULL REFERENCES employee(id),
	account_id 		varchar2(254)	NOT NULL REFERENCES employee_accInfo(account_id),
	PRIMARY KEY(id, account_id)
);

CREATE INDEX employee_accRelation_idx ON employee_accRelation(id, account_id);

CREATE TABLE employee_accInfo (
	account_id 		varchar2(254)	NOT NULL,
	bank_name 		varchar2(254)	NULL,
	account_balance 	varchar2(254)	NULL,
	PRIMARY KEY(account_id)
);