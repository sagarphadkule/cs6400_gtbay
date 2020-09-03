-- Seed Data from "Copy of gtbay_sample_data.xls";

USE cs6400_spring2018_team011;

INSERT INTO ItemCondition(conditionName, conditionValue) VALUES('Poor',1);
INSERT INTO ItemCondition(conditionName, conditionValue) VALUES('Fair',2);
INSERT INTO ItemCondition(conditionName, conditionValue) VALUES('Good',3);
INSERT INTO ItemCondition(conditionName, conditionValue) VALUES('Very Good',4);
INSERT INTO ItemCondition(conditionName, conditionValue) VALUES('New',5);

INSERT INTO Category(category) VALUES('Art');
INSERT INTO Category(category) VALUES('Books');
INSERT INTO Category(category) VALUES('Electronics');
INSERT INTO Category(category) VALUES('Home & Garden');
INSERT INTO Category(category) VALUES('Sporting Goods');
INSERT INTO Category(category) VALUES('Toys');
INSERT INTO Category(category) VALUES('Others');

INSERT INTO `User`(username, password, firstname, lastname)VALUES('user1','pass1','Danite','Kelor');
INSERT INTO `User`(username, password, firstname, lastname)VALUES('user2','pass2','Dodra','Kiney');
INSERT INTO `User`(username, password, firstname, lastname)VALUES('user3','pass3','Peran','Bishop');
INSERT INTO `User`(username, password, firstname, lastname)VALUES('user4','pass4','Randy','Roran');
INSERT INTO `User`(username, password, firstname, lastname)VALUES('user5','pass5','Ashod','Iankel');
INSERT INTO `User`(username, password, firstname, lastname)VALUES('user6','pass6','Cany','Achant');
INSERT INTO `User`(username, password, firstname, lastname)VALUES('admin1','opensesame','Riley','Fuiss');
INSERT INTO `User`(username, password, firstname, lastname)VALUES('admin2','opensesayou','Tonnis','Kinser');

INSERT INTO AdminUser(username, position)VALUES('admin1','Technical Support');
INSERT INTO AdminUser(username, position)VALUES('admin2','Chief Techy');

INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) VALUES('Garmin GPS','This is a great GPS.',50.0,70.0,99.0,null,1.0,'2018-3-31 12:22:00',0,'user1',null,'Electronics',3);
INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) VALUES('Canon Powershot','Point and shoot!',40.0,60.0,80.0,null,1.0,'2018-4-1 14:14:00',0,'user1',null,'Electronics',2);
INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) VALUES('Nikon D3','New and in box!',1500.0,1800.0,2000.0,null,3.0,'2018-4-5 9:19:00',0,'user2',null,'Electronics',4);
INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) VALUES('Danish Art Book','Delicious Danish Art',10.0,10.0,15.0,null,5.0,'2018-4-5 15:33:00',1,'user3',null,'Art',3);
INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) VALUES('SQL in 10 Minutes','Learn SQL really fast!',5.0,10.0,12.0,null,7.0,'2018-4-5 16:48:00',0,'admin1',null,'Books',1);
INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) VALUES('SQL in 8 Minutes','Learn SQL even faster!',5.0,8.0,10.0,null,3.0,'2018-4-8 10:01:00',0,'admin2',null,'Books',2);
INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) VALUES('Pull-up Bar','Works on any door frame.',20.0,25.0,40.0,null,5.0,'2018-4-9 22:09:00',1,'user6',null,'Sporting Goods',4);

INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(1,'user4',50.0,'2018-3-30 14:53:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(1,'user5',55.0,'2018-3-30 16:45:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(1,'user4',75.0,'2018-3-30 19:28:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(1,'user5',85.0,'2018-3-31 10:00:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(2,'user6',80.0,'2018-4-1 13:55:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(3,'user1',1500.0,'2018-4-4 8:37:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(3,'user3',1501.0,'2018-4-4 9:15:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(3,'user1',1795.0,'2018-4-4 12:27:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(7,'user4',20.0,'2018-4-8 20:20:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(7,'user2',25.0,'2018-4-9 21:15:00');

INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) VALUES(1,'user2','Great GPS!',5,'2018-3-30 17:00:00');
INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) VALUES(1,'user3','Not so great GPS!',2,'2018-3-30 18:00:00');
INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) VALUES(1,'user4','A favorite of mine',4,'2018-3-30 19:00');
INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) VALUES(4,'user1','Go for the Italian stuff instead.',1,'2018-4-1 16:46');
INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) VALUES(6,'admin1','Not recommended.',1,'2018-4-6 23:56:00');
INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) VALUES(6,'user1','This book is okay.',3,'2018-4-7 13:32:00');
INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) VALUES(6,'user2','I learned SQL in 8 minutes!',5,'2018-4-7 14:44:00');

-- 

INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) 
		VALUES('Garmin GPS', 'Cool GPS with voice', 25.0, 50.0,75.0,null,7.0,'2018-4-23 03:15:00',0,'admin2',null,'Electronics',2);
		
INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) 
		VALUES('MacBook Pro', 'White MacBook Pro, works flawlessly. No scratches.', 1000.0, 1500.0,null,null,7.0,'2018-4-23 01:01:00',0,'user4',null,'Electronics',4);

INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice, finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) 
		VALUES('Microsoft Surface', 'Surface Pro4 with WiFi. Includes blue keyboard and pen.', 500.0, 750.0,899.0,null,7.0,'2018-4-23 06:00:00',0,'user5',null,'Electronics',3);		

INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(8,'user4',30.0,'2018-4-17 21:15:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(8,'user5',31.0,'2018-4-18 11:00:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(8,'user3',33.0,'2018-4-18 12:15:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(8,'user4',40.0,'2018-4-19 15:15:00');
INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(8,'user6',45.0,'2018-4-19 17:00:00');

INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) 
		VALUES(9,'user5','Great for getting OMSCS coursework done.',5,'2018-4-19 15:15:00');
		
INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) 
		VALUES(10,'user4','Looks nice but underpowered.',2,'2018-4-17 15:15:00');

INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) 
		VALUES(10,'user3',null,3,'2018-4-19 15:15:00');