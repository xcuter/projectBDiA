package com.Inw.projectBDiA.Controllers.SecuredServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_context")
@ServletSecurity( value = @HttpConstraint(rolesAllowed = {"USER"}),
        httpMethodConstraints = {
        @HttpMethodConstraint(value = "GET" , rolesAllowed = {"USER", "ADMIN"}),
        @HttpMethodConstraint(value = "POST", rolesAllowed = {"USER", "ADMIN"})
})
public class UserSecuredController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath()+"/protected/user_context.jsp");
    }
}
