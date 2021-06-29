package com.Inw.projectBDiA.DAOs.User;


import com.Inw.projectBDiA.DAOs.BaseDao;
import com.Inw.projectBDiA.Models.User;
import com.Inw.projectBDiA.queries.Queries;

import java.sql.*;
import java.util.Random;

import static com.Inw.projectBDiA.DAOs.Account.AccountDAO.createAccount;
import static com.Inw.projectBDiA.queries.Queries.saveUserRoleQuery;

public class UserDao extends BaseDao {
    public void save(User user){
        saveUser(user);
        saveUserRole(user);
      //  createAccount();
    }

    private void saveUserRole(User user){
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(saveUserRoleQuery)) {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void saveUser(User user) {
        try(Connection connection = getConnection();
        PreparedStatement statement =connection.prepareStatement(Queries.saveUserQuery, Statement.RETURN_GENERATED_KEYS)) {
            System.out.println(Queries.saveUserQuery);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            //statement.setLong(3, user.getAccountID());
            Random rnd = new Random();
            statement.setLong(3, rnd.nextLong());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setInt(6,1);
            System.out.println(statement);
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if(generatedKeys.next()){
                user.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
