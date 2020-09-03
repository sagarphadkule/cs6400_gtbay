DROP DATABASE IF EXISTS cs6400_spring2018_team011;
CREATE DATABASE cs6400_spring2018_team011;
USE cs6400_spring2018_team011;

-- create tables and constraints

CREATE TABLE `User`(    
		username VARCHAR(20) NOT NULL,    
		password VARCHAR(20) NOT NULL,    
		firstName VARCHAR(20) NOT NULL,    
		lastName VARCHAR(20) NOT NULL,    
		PRIMARY KEY (username));    


CREATE TABLE AdminUser(    
		username VARCHAR(20) NOT NULL,    
		position VARCHAR(20) NOT NULL,    
		PRIMARY KEY (username),    
		FOREIGN KEY (username) REFERENCES `User` (username));    

CREATE TABLE ItemCondition(    
		conditionName VARCHAR(20) NOT NULL UNIQUE,    
		conditionValue INT(1) NOT NULL,    
		PRIMARY KEY (conditionValue)    
		);    

CREATE TABLE Category(category VARCHAR(20) NOT NULL,     
		PRIMARY KEY (category));    

		CREATE TABLE Item(    
		id INT(16) UNSIGNED NOT NULL AUTO_INCREMENT,    
		name VARCHAR(40) NOT NULL,    
		description VARCHAR(80) NOT NULL,    
		startingBidPrice DECIMAL(10 , 2 ) NOT NULL,    
		minSalePrice DECIMAL(10 , 2 ) NOT NULL,    
		getItNowPrice DECIMAL(10 , 2 ),    
		finalSalePrice DECIMAL(10 , 2 ),    
		auctionLength INT(1) NOT NULL,    
		auctionEndTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,    
		returnable BOOLEAN NOT NULL,    
		listedByUser VARCHAR(20) NOT NULL,    
		winner VARCHAR(20),    
		category VARCHAR(20) NOT NULL,    
		itemCondition INT(1) NOT NULL,    
		PRIMARY KEY (id),    
		FOREIGN KEY (listedByUser) REFERENCES `User` (username),    
		FOREIGN KEY (winner) REFERENCES `User` (username),    
		FOREIGN KEY (category) REFERENCES Category (category),    
		FOREIGN KEY (itemCondition) REFERENCES ItemCondition (conditionValue),    
		check(getItNowPrice > startingBidPrice),    
		check(minSalePrice > startingBidPrice)    
		);    

CREATE TABLE Rating(    
		ratedItemId INT(16) UNSIGNED NOT NULL,    
		ratedByUser VARCHAR(20) NOT NULL,    
		comment VARCHAR(80),    
		stars INT(1) NOT NULL,    
		timestamp TIMESTAMP NOT NULL,    
		PRIMARY KEY (ratedItemId , ratedByUser),    
		FOREIGN KEY (ratedByUser) REFERENCES `User` (username),    
		FOREIGN KEY (ratedItemId) REFERENCES Item (id)    
		);    

CREATE TABLE Bid(    
		bidItemId INT(16) UNSIGNED NOT NULL,    
		bidByUser VARCHAR(20) NOT NULL,    
		amount DECIMAL(10 , 2 ) NOT NULL,    
		timestamp TIMESTAMP NOT NULL,    
		PRIMARY KEY (bidItemId, bidByUser, amount),    
		FOREIGN KEY (bidByUser) REFERENCES `User` (username),    
		FOREIGN KEY (bidItemId) REFERENCES Item (id)    
		);    
