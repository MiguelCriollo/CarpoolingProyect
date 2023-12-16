CREATE TABLE IF NOT EXISTS route(
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    start_date DATE NOT NULL,
    description VARCHAR(400) NOT NULL,
    driver_id SERIAL NOT NULL,
    FOREIGN KEY(driver_id) REFERENCES route(id)
);

CREATE TABLE IF NOT EXISTS stop(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(400) NOT NULL
);

CREATE TABLE IF NOT EXISTS route_stop(
    id SERIAL PRIMARY KEY,
    position INT NOT NULL,
    arrive_hour DATE NOT NULL,
    stop_id SERIAL NOT NULL,
    route_id SERIAL NOT NULL,
    FOREIGN KEY(stop_id) REFERENCES stop(id),
    FOREIGN KEY(route_id) REFERENCES route(id)
);