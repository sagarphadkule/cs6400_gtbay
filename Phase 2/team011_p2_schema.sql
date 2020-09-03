CREATE USER IF NOT EXISTS gatechUser@localhost IDENTIFIED BY 'gatech123';
DROP DATABASE IF EXISTS `cs6400_spring2018_team011`;
SET default_storage_engine=InnoDB;
SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE DATABASE IF NOT EXISTS cs6400_spring2018_team011 
    DEFAULT CHARACTER SET utf8mb4 
    DEFAULT COLLATE utf8mb4_unicode_ci;
USE cs6400_spring2018_team011;

GRANT SELECT, INSERT, UPDATE, DELETE, FILE ON *.* TO 'gatechUser'@'localhost';
GRANT ALL PRIVILEGES ON `gatechuser`.* TO 'gatechUser'@'localhost';
GRANT ALL PRIVILEGES ON `cs6400_spring2018_team011`.* TO 'gatechUser'@'localhost';
FLUSH PRIVILEGES;

-- Tables 

CREATE TABLE RegularUser (
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE AdminUser (
    username VARCHAR(20) NOT NULL,
    position VARCHAR(20) NOT NULL,
    PRIMARY KEY (username),
    FOREIGN KEY (username)
        REFERENCES RegularUser (username)
);

CREATE TABLE Category (
    category VARCHAR(20) NOT NULL,
    PRIMARY KEY (category)
);

CREATE TABLE ItemCondition (
    condition_name VARCHAR(20) NOT NULL,
    condition_value INT(1) UNSIGNED NOT NULL,
    PRIMARY KEY (condition_value),
    UNIQUE (condition_name)
);


CREATE TABLE Item (
    item_id INT(16) UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    description VARCHAR(80) NOT NULL,
    starting_bid_price DECIMAL(10 , 2 ) NOT NULL,
    min_sale_price DECIMAL(10 , 2 ) NOT NULL,
    get_it_now_price DECIMAL(10 , 2 ),
    final_sale_price DECIMAL(10 , 2 ),
    auction_length INT(1) NOT NULL,
    auction_end_time DATETIME NOT NULL,
    returnable BOOLEAN NOT NULL,
    listed_by_user VARCHAR(20) NOT NULL,
    winner VARCHAR(20),
    category VARCHAR(20) NOT NULL,
    item_condition INT(1) UNSIGNED NOT NULL,
    PRIMARY KEY (item_id),
    FOREIGN KEY (listed_by_user)
        REFERENCES RegularUser (username),
    FOREIGN KEY (winner)
        REFERENCES RegularUser (username),
    FOREIGN KEY (category)
        REFERENCES Category (category),
    FOREIGN KEY (item_condition)
        REFERENCES ItemCondition (condition_value),
	check(get_it_now_price > starting_bid_price),
    check(min_sale_price > starting_bid_price)
);

CREATE TABLE Rating (
    rated_item_id INT(16) UNSIGNED NOT NULL,
    rated_by_user VARCHAR(20) NOT NULL,
    comment VARCHAR(80),
    stars INT(1) NOT NULL,
    timestamp DATETIME NOT NULL,
    PRIMARY KEY (rated_item_id , rated_by_user),
    FOREIGN KEY (rated_by_user)
        REFERENCES RegularUser (username),
    FOREIGN KEY (rated_item_id)
        REFERENCES Item (item_id)
);

CREATE TABLE Bid (
    bid_item_id INT(16) UNSIGNED NOT NULL,
    bid_by_user VARCHAR(20) NOT NULL,
    amount DECIMAL(10 , 2 ) NOT NULL,
    timestamp DATETIME NOT NULL,
    PRIMARY KEY (bid_item_id , bid_by_user , amount),
    FOREIGN KEY (bid_by_user)
        REFERENCES RegularUser (username),
    FOREIGN KEY (bid_item_id)
        REFERENCES Item (item_id)
);
