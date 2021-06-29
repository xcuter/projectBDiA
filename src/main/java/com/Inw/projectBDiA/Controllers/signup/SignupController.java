package com.Inw.projectBDiA.Controllers.signup;


import com.Inw.projectBDiA.Models.UserRegistration;
import com.Inw.projectBDiA.Services.UserRegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
    private final UserRegisterService  us = new UserRegisterService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserRegistration userRegistration = getUserData(request);
        UserRegisterService userRegisterService = new UserRegisterService();
        userRegisterService.register(userRegistration);
        response.sendRedirect(request.getContextPath());
    }

    private UserRegistration getUserData(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return new UserRegistration(firstName,lastName,email,password);
    }
}
