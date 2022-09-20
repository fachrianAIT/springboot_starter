CREATE TABLE res_order (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   no_reff VARCHAR(255) NOT NULL,
   total INTEGER NOT NULL,
   status VARCHAR(255) NOT NULL,
   create_date TIMESTAMP with time zone,
   write_date TIMESTAMP with time zone,
   CONSTRAINT pk_res_order PRIMARY KEY (id)
);

ALTER TABLE res_order ADD CONSTRAINT uc_res_order_no_reff UNIQUE (no_reff);