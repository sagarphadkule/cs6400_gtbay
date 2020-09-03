package com.gatech.cs6400.gtbay.gtbayrestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;

import java.sql.Connection;
import java.sql.DriverManager;



@Component
public class DaoCommandLineRunner implements CommandLineRunner {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307", "root", "root");

        if (strings.length > 0 && strings[0].equals("generateSampleDB") ) {

            System.out.println("Generating Sample Database");

            // create database

            jdbcTemplate.update("DROP DATABASE IF EXISTS cs6400_spring2018_team011");
            jdbcTemplate.update("CREATE DATABASE cs6400_spring2018_team011");
            jdbcTemplate.update("USE cs6400_spring2018_team011");


            // create tables

            String createUserTableSql = "CREATE TABLE User(" +
                    "username VARCHAR(20) NOT NULL," +
                    "password VARCHAR(20) NOT NULL," +
                    "firstName VARCHAR(20) NOT NULL," +
                    "lastName VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (username));";
            jdbcTemplate.update(createUserTableSql);

            String createAdminUserTableSql = "CREATE TABLE AdminUser(" +
                    "username VARCHAR(20) NOT NULL," +
                    "position VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (username)," +
                    "FOREIGN KEY (username) REFERENCES User (username));";
            jdbcTemplate.update(createAdminUserTableSql);

            String createConditionTableSql = "CREATE TABLE ItemCondition(" +
                    "conditionName VARCHAR(20) NOT NULL UNIQUE," +
                    "conditionValue INT(1) UNSIGNED NOT NULL," +
                    "PRIMARY KEY (conditionValue)" +
                    ");";
            jdbcTemplate.update(createConditionTableSql);

            String createCategoryTableSql = "CREATE TABLE Category(category VARCHAR(20) NOT NULL, " +
                    "PRIMARY KEY (category));";
            jdbcTemplate.update(createCategoryTableSql);

            String createItemTableSql = "CREATE TABLE Item(" +
                    "id INT(16) UNSIGNED NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(40) NOT NULL," +
                    "description VARCHAR(80) NOT NULL," +
                    "startingBidPrice DECIMAL(10 , 2 ) NOT NULL," +
                    "minSalePrice DECIMAL(10 , 2 ) NOT NULL," +
                    "getItNowPrice DECIMAL(10 , 2 )," +
                    "finalSalePrice DECIMAL(10 , 2 )," +
                    "auctionLength INT(1) NOT NULL," +
                    "auctionEndTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                    "returnable BOOLEAN NOT NULL," +
                    "listedByUser VARCHAR(20) NOT NULL," +
                    "winner VARCHAR(20)," +
                    "category VARCHAR(20) NOT NULL," +
                    "itemCondition INT(1) UNSIGNED NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (listedByUser) REFERENCES User (username)," +
                    "FOREIGN KEY (winner) REFERENCES User (username)," +
                    "FOREIGN KEY (category) REFERENCES Category (category)," +
                    "FOREIGN KEY (itemCondition) REFERENCES ItemCondition (conditionValue)," +
                    "check(getItNowPrice > startingBidPrice)," +
                    "check(minSalePrice > startingBidPrice)" +
                    ");";
            jdbcTemplate.update(createItemTableSql);

            String createRatingTableSql = "CREATE TABLE Rating(" +
                    "ratedItemId INT(16) UNSIGNED NOT NULL," +
                    "ratedByUser VARCHAR(20) NOT NULL," +
                    "comment VARCHAR(80)," +
                    "stars INT(1) NOT NULL," +
                    "timestamp TIMESTAMP NOT NULL," +
                    "PRIMARY KEY (ratedItemId , ratedByUser)," +
                    "FOREIGN KEY (ratedByUser) REFERENCES User (username)," +
                    "FOREIGN KEY (ratedItemId) REFERENCES Item (id)" +
                    ");";
            jdbcTemplate.update(createRatingTableSql);

            String createBidTableSql = "CREATE TABLE Bid(" +
                    "bidItemId INT(16) UNSIGNED NOT NULL," +
                    "bidByUser VARCHAR(20) NOT NULL," +
                    "amount DECIMAL(10 , 2 ) NOT NULL," +
                    "timestamp TIMESTAMP NOT NULL," +
                    "PRIMARY KEY (bidItemId, bidByUser, amount)," +
                    "FOREIGN KEY (bidByUser) REFERENCES User (username)," +
                    "FOREIGN KEY (bidItemId) REFERENCES Item (id)" +
                    ");";
            jdbcTemplate.update(createBidTableSql);

            // insert values

            String insertConditionSql = "INSERT INTO ItemCondition(conditionName, conditionValue) " +
                    "VALUES(?,?);";
            jdbcTemplate.update(insertConditionSql, "Poor", 1);
            jdbcTemplate.update(insertConditionSql, "Fair", 2);
            jdbcTemplate.update(insertConditionSql, "Good", 3);
            jdbcTemplate.update(insertConditionSql, "Very Good", 4);
            jdbcTemplate.update(insertConditionSql, "New", 5);


            String insertCategorySql = " INSERT INTO Category(category) VALUES(?);";
            jdbcTemplate.update(insertCategorySql, "Art");
            jdbcTemplate.update(insertCategorySql, "Books");
            jdbcTemplate.update(insertCategorySql, "Electronics");
            jdbcTemplate.update(insertCategorySql, "Home & Garden");
            jdbcTemplate.update(insertCategorySql, "Sporting Goods");
            jdbcTemplate.update(insertCategorySql, "Toys");
            jdbcTemplate.update(insertCategorySql, "Others");

            String insertUserSql = "INSERT INTO User(username, password, firstname, lastname)" +
                    "VALUES(?,?,?,?);";
            jdbcTemplate.update(insertUserSql, "user1", "pass1", "Danite", "Kelor");
            jdbcTemplate.update(insertUserSql, "user2", "pass2", "Dodra", "Kiney");
            jdbcTemplate.update(insertUserSql, "user3", "pass3", "Peran", "Bishop");
            jdbcTemplate.update(insertUserSql, "user4", "pass4", "Randy", "Roran");
            jdbcTemplate.update(insertUserSql, "user5", "pass5", "Ashod", "Iankel");
            jdbcTemplate.update(insertUserSql, "user6", "pass6", "Cany", "Achant");
            jdbcTemplate.update(insertUserSql, "admin1", "opensesame", "Riley", "Fuiss");
            jdbcTemplate.update(insertUserSql, "admin2", "opensesayou", "Tonnis", "Kinser");


            String insertAdminUserSql = "INSERT INTO AdminUser(USERNAME, POSITION)" +
                    "VALUES(?,?);";
            jdbcTemplate.update(insertAdminUserSql, "admin1", "Technical Support");
            jdbcTemplate.update(insertAdminUserSql, "admin2", "Chief Techy");


            String insertItemSql = "INSERT INTO Item(name, description, startingBidPrice, minSalePrice, getItNowPrice," +
                    " finalSalePrice, auctionLength, auctionEndTime, returnable, listedByUSer, winner, category, itemCondition) " +
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";

            jdbcTemplate.update(insertItemSql, "Garmin GPS", "This is a great GPS.", 50.00, 70.00, 99.00, null, 1.00,
                    "2018-4-30 12:22:00", false, "user1", null, "Electronics", 3);
            jdbcTemplate.update(insertItemSql, "Canon Powershot", "Point and shoot!", 40.00, 60.00, 80.00, null, 1.00,
                    "2018-4-21 14:14:00", false, "user1", null, "Electronics", 2);
            jdbcTemplate.update(insertItemSql, "Nikon D3", "New and in box!", 1500.00, 1800.00, 2000.00, null, 3.00,
                    "2018-4-5 9:19:00", false, "user2", null, "Electronics", 4);
            jdbcTemplate.update(insertItemSql, "Danish Art Book", "Delicious Danish Art", 10.00, 10.00, 15.00, null, 5.00,
                    "2018-4-25 15:33:00", true, "user3", null, "Art", 3);
            jdbcTemplate.update(insertItemSql, "SQL in 10 Minutes", "Learn SQL really fast!", 5.00, 10.00, 12.00, null, 7.00,
                    "2018-4-25 16:48:00", false, "admin1", null, "Books", 1);
            jdbcTemplate.update(insertItemSql, "SQL in 8 Minutes", "Learn SQL even faster!", 5.00, 8.00, 10.00, null, 3.00,
                    "2018-4-18 10:01:00", false, "admin2", null, "Books", 2);
            jdbcTemplate.update(insertItemSql, "Pull-up Bar", "Works on any door frame.", 20.00, 25.00, 40.00, null, 5.00,
                    "2018-4-19 22:09:00", true, "user6", null, "Sporting Goods", 4);

            String insertBidSql = "INSERT INTO Bid(bidItemId, bidByUser, amount, timestamp) VALUES(?,?,?,?);";
            jdbcTemplate.update(insertBidSql, 1, "user4", 50.00, "2018-3-30 14:53:00");
            jdbcTemplate.update(insertBidSql, 1, "user5", 55.00, "2018-3-30 16:45:00");
            jdbcTemplate.update(insertBidSql, 1, "user4", 75.00, "2018-3-30 19:28:00");
            jdbcTemplate.update(insertBidSql, 1, "user5", 85.00, "2018-3-31 10:00:00");
            jdbcTemplate.update(insertBidSql, 2, "user6", 80.00, "2018-4-1 13:55:00");
            jdbcTemplate.update(insertBidSql, 3, "user1", 1500.00, "2018-4-4 8:37:00");
            jdbcTemplate.update(insertBidSql, 3, "user3", 1501.00, "2018-4-4 9:15:00");
            jdbcTemplate.update(insertBidSql, 3, "user1", 1795.00, "2018-4-4 12:27:00");
            jdbcTemplate.update(insertBidSql, 7, "user4", 20.00, "2018-4-8 20:20:00");
            jdbcTemplate.update(insertBidSql, 7, "user2", 25.00, "2018-4-9 21:15:00");

            String insertRatingSql = "INSERT Rating(ratedItemId, ratedByUser, comment, stars, timestamp) VALUES(?,?,?,?,?);";
            jdbcTemplate.update(insertRatingSql, 1, "user2", "Great GPS!", 5, "2018-3-30 17:00:00");
            jdbcTemplate.update(insertRatingSql, 1, "user3", "Not so great GPS!", 2, "2018-3-30 18:00:00");
            jdbcTemplate.update(insertRatingSql, 1, "user4", "A favorite of mine", 4, "2018-3-30 19:00");
            jdbcTemplate.update(insertRatingSql, 4, "user1", "Go for the Italian stuff instead.", 1, "2018-4-1 16:46");
            jdbcTemplate.update(insertRatingSql, 6, "admin1", "Not recommended.", 1, "2018-4-6 23:56:00");
            jdbcTemplate.update(insertRatingSql, 6, "user1", "This book is okay.", 3, "2018-4-7 13:32:00");
            jdbcTemplate.update(insertRatingSql, 6, "user2", "I learned SQL in 8 minutes!", 5, "2018-4-7 14:44:00");

        }
    }
}
