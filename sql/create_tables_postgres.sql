DROP TYPE IF EXISTS place;
DROP TYPE IF EXISTS gas;
DROP TYPE IF EXISTS suit;

CREATE TYPE suit AS ENUM ('dry', 'wet');
CREATE TYPE gas AS ENUM ('nitrox', 'air');
CREATE TYPE place AS ENUM ('wreck', 'bio', 'mine');

CREATE TABLE diver
(
diver_id SERIAL PRIMARY KEY,
firstname VARCHAR(128) NOT NULL,
lastname VARCHAR(128) NOT NULL,
classification VARCHAR(128),
phonenumber VARCHAR(128),
email VARCHAR(128) NOT NULL,
pswd VARCHAR(512) NOT NULL
);

CREATE TABLE spot
(
spot_id SERIAL PRIMARY KEY,
name VARCHAR(256) NOT NULL,
location VARCHAR(256),
spottype place NOT NULL,
mindepth INT,
description VARCHAR(4096)
);

CREATE TABLE dive
(
dive_id SERIAL PRIMARY KEY,
diver_id INT NOT NULL REFERENCES diver(diver_id),
spot_id INT NOT NULL REFERENCES spot(spot_id),
divenumber INT NOT NULL,
divedate DATE NOT NULL,
divetime INT NOT NULL,
bottomtime INT NOT NULL,
maxdepth REAL NOT NULL,
visibility INT NOT NULL,
airtemp INT NOT NULL,
watertemp INT NOT NULL,
suittype suit NOT NULL,
tanksize INT NOT NULL,
startpressure INT NOT NULL,
endpressure INT NOT NULL,
gastype gas NOT NULL,
oxygen_percentage INT NOT NULL DEFAULT 21,
description VARCHAR(4096)
);
