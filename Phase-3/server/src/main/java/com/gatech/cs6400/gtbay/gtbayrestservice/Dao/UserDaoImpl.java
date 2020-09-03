package com.gatech.cs6400.gtbay.gtbayrestservice.Dao;

import com.gatech.cs6400.gtbay.gtbayrestservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(User user) {
//        jdbcTemplate.update((Connection connection) -> {
//            PreparedStatement preparedStatement;
//            preparedStatement = connection.prepareStatement(
//                    "INSERT INTO REGULARUSER(USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES(?,?,?,?)");
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getFirstName());
//            preparedStatement.setString(4, user.getLastName());
//            return preparedStatement;
//        });
        String createRegularUserSQL = "INSERT INTO USER(USERNAME, PASSWORD, FIRSTNAME, LASTNAME) VALUES(?,?,?,?)";
        jdbcTemplate.update(createRegularUserSQL,
                user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName());
    }

    @Override
    public User getUserByUsername(String username) {
        String getUserSQL = "SELECT * FROM (User NATURAL LEFT JOIN Adminuser) WHERE username = '" + username + "'";
        Collection<Map<String, Object>>rows = jdbcTemplate.queryForList(getUserSQL);
        if (rows.size() == 0) return new User();
        ArrayList<User> users = getUserArrayFromSQLResult(rows);
        return users.get(0);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        String getUserSQL = "SELECT * FROM (User NATURAL LEFT JOIN Adminuser) " +
                "WHERE username = '" + username + "'" + "AND password = '" + password + "';";
        Collection<Map<String, Object>>rows = jdbcTemplate.queryForList(getUserSQL);
        if (rows.size() == 0) return new User();
        ArrayList<User> users = getUserArrayFromSQLResult(rows);
        return users.get(0);
    }

    private ArrayList<User> getUserArrayFromSQLResult(Collection<Map<String, Object>> rows) {
        ArrayList<User> users = new ArrayList<User>();
        for (Map<String, Object> row: rows) {
            User user = new User();
            users.add(user);
            user.setUsername((String)row.get("USERNAME"));
            user.setPassword((String)row.get("PASSWORD"));
            user.setFirstName((String)row.get("FIRSTNAME"));
            user.setLastName((String)row.get("LASTNAME"));
            user.setPosition((String)row.get("POSITION"));
        }
        return users;
    }
}
