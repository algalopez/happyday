DROP DATABASE IF EXISTS `happyday`;
CREATE DATABASE IF NOT EXISTS `happyday` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `happyday`;

DROP TABLE IF EXISTS quotes;
CREATE TABLE quotes (
    id int(11) NOT NULL AUTO_INCREMENT, 
    quote VARCHAR(600), 
    PRIMARY KEY (id),
    UNIQUE KEY quote (quote));