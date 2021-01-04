-- noinspection SqlNoDataSourceInspectionForFile

CREATE DATABASE doctor;
USE doctor;

-- DROP TABLE  doctorlist;
CREATE TABLE doctorlist (
    id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(45) NOT NULL,
    gender boolean,
	nationality NVARCHAR(45) NOT NULL,
    address NVARCHAR(100) DEFAULT 'xxx',
    phone VARCHAR(20) DEFAULT '+84xxx',
    education NVARCHAR(100) NOT NULL,
    position NVARCHAR(255) NOT NULL,
    specialized NVARCHAR(255) NOT NULL,
    hospital NVARCHAR(100) NOT NULL
);

-- DROP TABLE doctorinfo;
CREATE TABLE doctorinfo (
    id INT(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name NVARCHAR(45),
    address NVARCHAR(100),
    phone VARCHAR(20),
    education NVARCHAR(100),
    position NVARCHAR(255),
    hospital NVARCHAR(100),
    reward NVARCHAR(1000),
    experience NVARCHAR(1000),
    FOREIGN KEY (id) REFERENCES doctorlist(id)
);

CREATE TABLE account (
    username NVARCHAR(45) PRIMARY KEY,
    password NVARCHAR(45) not null,
    permission int
);


-- DROP TRIGGER INFO ;
DELIMITER //
CREATE TRIGGER INFO AFTER
INSERT ON doctorlist
FOR EACH ROW
BEGIN
	INSERT INTO doctorinfo (name,address,phone,education,position,hospital)
		VALUES (new.name, new.address, NEW.phone,NEW.education,NEW.position,NEW.hospital);
END//
#DELIMITER;