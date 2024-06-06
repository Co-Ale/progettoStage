CREATE TABLE IF NOT EXISTS customer (
	id int AUTO_INCREMENT,
	email varchar(45) DEFAULT NULL UNIQUE,
	addr varchar(45) DEFAULT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE customer_seq (
  next_val bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
insert into customer_seq VALUES(2);


CREATE TABLE IF NOT EXISTS shipment (
	id int  AUTO_INCREMENT,
	customer_id int NOT NULL ,
	description varchar(45) DEFAULT NULL,
	shipment_date varchar(45) DEFAULT NULL,
	status varchar(45) DEFAULT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE shipment_seq (
  next_val bigint(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
insert into shipment_seq VALUES(2);


CREATE TABLE IF NOT EXISTS shipment_det (
	pallet_id int NOT NULL ,
	shipment_id  int NOT NULL 
);

CREATE TABLE IF NOT EXISTS pallet (
	id int AUTO_INCREMENT,
	 
	description varchar(45) DEFAULT NULL,
	max_packages int NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE pallet_seq (
  next_val bigint(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
insert into Pallet_seq VALUES(2);


CREATE TABLE IF NOT EXISTS package (
	id int AUTO_INCREMENT,
	pallet_id int NOT NULL,
	description varchar(45) DEFAULT NULL,
	weight float NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE package_seq (
  next_val bigint(20) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
insert into package_seq VALUES(2);

