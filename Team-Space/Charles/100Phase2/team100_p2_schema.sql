------------
-- Tables --
------------
-- User Table
CREATE TABLE `User` (
  `username` varchar(45) COLLATE ascii_bin NOT NULL,
  `password` varchar(40) COLLATE ascii_bin NOT NULL,
  `first_name` varchar(45) COLLATE ascii_bin NOT NULL,
  `last_name` varchar(45) COLLATE ascii_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- AdminUser Table
CREATE TABLE `AdminUser` (
  `username` varchar(45) COLLATE ascii_bin NOT NULL,
  `position` varchar(45) COLLATE ascii_bin NOT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `fk_AdminUsers_username_Users_username` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- AuctionLength Table
CREATE TABLE `AuctionLength` (
  `length` int(11) NOT NULL,
  PRIMARY KEY (`length`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- Condition Table
CREATE TABLE `Condition` (
  `name` varchar(9) COLLATE ascii_bin NOT NULL,
  `value` int(11) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `value_UNIQUE` (`value`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- Category Table
CREATE TABLE `Category` (
  `name` varchar(14) COLLATE ascii_bin NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- Item Table
CREATE TABLE `Item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE ascii_bin NOT NULL,
  `name` varchar(45) COLLATE ascii_bin NOT NULL,
  `description` tinytext COLLATE ascii_bin NOT NULL,
  `returnable` tinyint(1) NOT NULL DEFAULT '0',
  `starting_bid` decimal(15,2) NOT NULL,
  `get_it_now_price` decimal(15,2) DEFAULT NULL,
  `minimum_sale_price` decimal(15,2) NOT NULL,
  `category` varchar(14) COLLATE ascii_bin NOT NULL,
  `condition` varchar(9) COLLATE ascii_bin NOT NULL,
  `length` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`),
  KEY `fk_Item_condition_Condition_name_idx` (`condition`),
  KEY `fk_Item_length_AuctionLength_length_idx` (`length`),
  KEY `fk_Item_category_Category_name_idx` (`category`),
  KEY `fk_Item_username_Users_username_idx` (`username`),
  CONSTRAINT `fk_Item_category_Category_name` FOREIGN KEY (`category`) REFERENCES `Category` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_condition_Condition_name` FOREIGN KEY (`condition`) REFERENCES `Condition` (`name`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_length_AuctionLength_length` FOREIGN KEY (`length`) REFERENCES `AuctionLength` (`length`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_username_Users_username` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- Bid Table
CREATE TABLE `Bid` (
  `item_id` int(11) NOT NULL,
  `username` varchar(45) COLLATE ascii_bin NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `bid_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`,`username`,`price`),
  KEY `fk_Bids_username_Users_username_idx` (`username`),
  CONSTRAINT `fk_Bids_item_id_Item_item_id` FOREIGN KEY (`item_id`) REFERENCES `Item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bids_username_Users_username` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;

-- Rating Table
CREATE TABLE `Rating` (
  `item_id` int(11) NOT NULL,
  `username` varchar(45) COLLATE ascii_bin NOT NULL,
  `rate_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `number_of_stars` int(11) NOT NULL,
  `comment` text COLLATE ascii_bin,
  PRIMARY KEY (`item_id`,`username`),
  KEY `fk_Rating_username_Users_username_idx` (`username`),
  CONSTRAINT `fk_Rating_item_id_Item_item_id` FOREIGN KEY (`item_id`) REFERENCES `Item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rating_username_Users_username` FOREIGN KEY (`username`) REFERENCES `User` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=ascii COLLATE=ascii_bin;
