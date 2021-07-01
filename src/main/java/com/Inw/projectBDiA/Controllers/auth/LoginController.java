package com.Inw.projectBDiA.Controllers.auth;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
@ServletSecurity(
        value = @HttpConstraint(rolesAllowed = {"USER", "ADMIN"}),
            httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {"USER", "ADMIN"}),
                @HttpMethodConstraint(value = "GET", rolesAllowed = {"USER", "ADMIN"})
                    }
                )
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath());
    }
}
