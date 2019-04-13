DROP TABLE IF EXISTS customer_trip, customer, trip, destination;

CREATE TABLE customer (
    id INT NOT NULL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50) NOT NULL
);

CREATE TABLE destination (
    id INT NOT NULL PRIMARY KEY,
    country VARCHAR(50) NOT NULL
);

CREATE TABLE trip (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    transport_type VARCHAR(20) NOT NULL,
    duration INT NOT NULL,
    price DECIMAL(10, 2),
    destination_id INT NOT NULL,

    CONSTRAINT fk_t_destination FOREIGN KEY (destination_id) REFERENCES destination (id)
);

CREATE TABLE customer_trip (
    id INT NOT NULL PRIMARY KEY,
    customer_id INT NOT NULL,
    trip_id INT NOT NULL,
    start_date DATE NOT NULL,
    insertion_time TIMESTAMP NOT NULL,

    CONSTRAINT fk_ct_customer FOREIGN KEY (customer_id) REFERENCES customer (id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_ct_trip FOREIGN KEY (trip_id) REFERENCES trip (id)
);