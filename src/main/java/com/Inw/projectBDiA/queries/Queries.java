package com.Inw.projectBDiA.queries;

public class Queries {
    public static final String saveUserQuery = "INSERT INTO users (name, lastname, \"account_id\", email, password) VALUES (?,?,?,?,?)";
    public static final String saveUserRoleQuery = "INSERT INTO user_role (email, role_name) VALUES (?,'USER')";
}
