USE divelog

CREATE TABLE diver
(
diver_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
firstname VARCHAR(128) NOT NULL,
lastname VARCHAR(128) NOT NULL,
classification VARCHAR(128),
phonenumber VARCHAR(128),
email VARCHAR(128) NOT NULL,
pswd VARCHAR(512) NOT NULL
);

CREATE TABLE spot
(
spot_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(256) NOT NULL,
location VARCHAR(256),
spottype ENUM('wreck', 'bio', 'mine') NOT NULL,
mindepth INT,
description TEXT(4096)
);

CREATE TABLE dive
(
dive_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
diver_id INT NOT NULL,
spot_id INT NOT NULL,
divenumber INT NOT NULL,
divedate DATE NOT NULL,
divetime INT NOT NULL,
bottomtime INT NOT NULL,
maxdepth DECIMAL(4,1) NOT NULL,
visibility INT NOT NULL,
airtemp INT NOT NULL,
watertemp INT NOT NULL,
suittype ENUM('wet', 'dry') NOT NULL,
tanksize INT NOT NULL,
startpressure INT NOT NULL,
endpressure INT NOT NULL,
gastype ENUM('nitrox', 'air') NOT NULL,
oxygen_percentage INT NOT NULL DEFAULT 21,
description TEXT(4096) NOT NULL
);

ALTER TABLE dive
ADD CONSTRAINT diveToDiver_fk
FOREIGN KEY (diver_id)
REFERENCES diver (diver_id);

ALTER TABLE dive
ADD CONSTRAINT diveToSpot_fk
FOREIGN KEY (spot_id)
REFERENCES spot (spot_id);


