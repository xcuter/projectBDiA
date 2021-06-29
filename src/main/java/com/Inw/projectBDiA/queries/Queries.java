package com.Inw.projectBDiA.queries;

public class Queries {
    public static final String saveUserQuery = "INSERT INTO users (name, lastname, \"accountID\", email, password, \"userRole\") VALUES (?,?,?,?,?,?)";
    public static final String saveUserRoleQuery = "INSERT INTO user_role (username) VALUES (?)";
}
