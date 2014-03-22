INSERT INTO diver (firstname, lastname, classification, phonenumber, email, pswd)
    VALUES ('Erkki', 'Esimerkki', 'NAUI MSD', '555-123456', 'testi1@testi.net', 'testi1');

INSERT INTO diver (firstname, lastname, classification, phonenumber, email, pswd)
    VALUES ('Sanna', 'Sukeltaja', 'CMAS P1', '123-227774', 'testi2@testi.net', 'testi2');
    
INSERT INTO spot (name, location, spottype, mindepth, description)
    VALUES('Coolaroo', 'Helsinki', 'wreck', 15, 'Kyljellään makaava teräslaivan hylky');
    
INSERT INTO spot (name, location, spottype, mindepth, description)
    VALUES('Paakkilan avolouhos', 'Tuusniemi', 'mine', 10, 'Vedellä täyttynyt kirkasvetinen vanha asbestiluohos');

INSERT INTO dive (diver_id, spot_id, divenumber, divedate, divetime, bottomtime, maxdepth, visibility, airtemp, watertemp, suittype, tanksize, startpressure, endpressure, gastype, oxygen_percentage)
    VALUES ((SELECT diver_id FROM diver WHERE firstname = 'Erkki'), (SELECT spot_id FROM spot WHERE name = 'Coolaroo'), 50, '2011-06-08', 40, 30, 22, 6, 18, 10, 'dry', 14, 210, 90, 'nitrox', 32);
    
INSERT INTO dive (diver_id, spot_id, divenumber, divedate, divetime, bottomtime, maxdepth, visibility, airtemp, watertemp, suittype, tanksize, startpressure, endpressure, gastype, oxygen_percentage)
    VALUES ((SELECT diver_id FROM diver WHERE firstname = 'Erkki'), (SELECT spot_id FROM spot WHERE name = 'Coolaroo'), 50, '2011-06-08', 50, 45, 28, 6, 18, 10, 'dry', 14, 210, 90, 'air', 21);
    
INSERT INTO dive (diver_id, spot_id, divenumber, divedate, divetime, bottomtime, maxdepth, visibility, airtemp, watertemp, suittype, tanksize, startpressure, endpressure, gastype, oxygen_percentage)
    VALUES ((SELECT diver_id FROM diver WHERE firstname = 'Erkki'), (SELECT spot_id FROM spot WHERE name = 'Paakkilan avolouhos'), 52, '2012-11-07', 60, 45, 37, 10, 14, 7, 'dry', 24, 210, 90, 'nitrox', 28);

INSERT INTO dive (diver_id, spot_id, divenumber, divedate, divetime, bottomtime, maxdepth, visibility, airtemp, watertemp, suittype, tanksize, startpressure, endpressure, gastype)
    VALUES ((SELECT diver_id FROM diver WHERE firstname = 'Sanna'), (SELECT spot_id FROM spot WHERE name = 'Paakkilan avolouhos'), 23, '2012-09-09', 45, 40, 16, 8, 16, 7, 'wet', 12, 280, 130, 'air');
