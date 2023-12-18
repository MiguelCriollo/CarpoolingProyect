CREATE TABLE IF NOT EXISTS users (
        id SERIAL,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL,
    cell_number VARCHAR(10),
    email VARCHAR(100) NOT NULL,
    password VARCHAR(30) NOT NULL,
    is_driver boolean NOT NULL DEFAULT FALSE,
    identification VARCHAR(10),
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS driver (
        id SERIAL,
    driver_licence VARCHAR(20) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)

    );

CREATE TABLE IF NOT EXISTS vehicle (
        id SERIAL,
    plate VARCHAR(10) NOT NULL,
    color VARCHAR(10) NOT NULL,
    model VARCHAR(10) NOT NULL,
    driver_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (driver_id) REFERENCES driver(id)
    );

CREATE TABLE IF NOT EXISTS route (
        id SERIAL,
    name VARCHAR(200) NOT NULL,
    start_date DATE NOT NULL,
    description VARCHAR(400) NOT NULL,
    driver_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (driver_id) REFERENCES driver(id)
    );

CREATE TABLE IF NOT EXISTS stop (
        id SERIAL,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(400) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS route_stop (
        id SERIAL,
    position INT NOT NULL DEFAULT 0,
    arrive_hour DATE NOT NULL,
    stop_id INT NOT NULL,
    route_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (stop_id) REFERENCES stop(id),
    FOREIGN KEY (route_id) REFERENCES route(id)
    );