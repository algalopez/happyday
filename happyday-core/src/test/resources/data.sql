DROP TABLE IF EXISTS quotes;
CREATE TABLE quotes (
    id int(11) NOT NULL AUTO_INCREMENT, 
    quote VARCHAR(600), 
    PRIMARY KEY (id),
    UNIQUE KEY quote (quote));
    
INSERT INTO quotes (id, quote) VALUES (1, 'quote 1');
INSERT INTO quotes (id, quote) VALUES (2, 'quote 2');
INSERT INTO quotes (id, quote) VALUES (3, 'quote 3');
INSERT INTO quotes (id, quote) VALUES (4, 'quote 4');
INSERT INTO quotes (id, quote) VALUES (5, 'quote 5');
INSERT INTO quotes (id, quote) VALUES (6, 'quote 6');
INSERT INTO quotes (id, quote) VALUES (7, 'quote 7');
INSERT INTO quotes (id, quote) VALUES (8, 'quote 8');