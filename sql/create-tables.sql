DROP TYPE IF EXISTS PAIKKA;
DROP TYPE IF EXISTS KAASU;
DROP TYPE IF EXISTS PUKU;

CREATE TYPE PUKU AS ENUM ('DRY', 'WET');
CREATE TYPE KAASU AS ENUM ('NITROX', 'AIR');
CREATE TYPE PAIKKA AS ENUM ('WRECK', 'BIO', 'MINE');

CREATE TABLE SUKELTAJA
(
SUKELTAJA_ID SERIAL PRIMARY KEY,
ETUNIMI VARCHAR(64) NOT NULL,
SUKUNIMI VARCHAR(64) NOT NULL,
LUOKITUS VARCHAR(64),
PUHELINNUMERO VARCHAR(64),
EMAIL VARCHAR NOT NULL(64)
);

CREATE TABLE KOHDE
(
KOHDE_ID SERIAL PRIMARY KEY,
NIMI VARCHAR(128) NOT NULL,
SIJAINTI VARCHAR(128),
KOHDETYYPPI PAIKKA NOT NULL,
MINIMISYVYYS INT,
KUVAUS VARCHAR(2048)
);

CREATE TABLE SUKELLUS
(
SUKELLUS_ID SERIAL PRIMARY KEY,
SUKELTAJA_ID INT NOT NULL REFERENCES SUKELTAJA(SUKELTAJA_ID),
KOHDE_ID INT NOT NULL REFERENCES KOHDE(KOHDE_ID),
NUMERO INT NOT NULL,
PVM DATE NOT NULL,
SUKELLUSAIKA TIME NOT NULL,
POHJA_AIKA INT NOT NULL,
SUURIN_SYVYYS REAL NOT NULL,
NAKYVYYS INT NOT NULL,
ILMAN_LAMPOTILA INT NOT NULL,
VEDEN_LAMPOTILA INT NOT NULL,
PUKUTYYPPI PUKU NOT NULL,
LAITTEEN_KOKO INT NOT NULL,
ALKUPAINE INT NOT NULL,
LOPPUPAINE INT NOT NULL,
KAASUTYYPPI KAASU NOT NULL,
KAASUN_HAPPIPROSENTTI INT NOT NULL DEFAULT 21,
KUVAUS VARCHAR(2048)
);




