package ltweb.controller;

import java.io.*;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ltweb.model.User;

@WebServlet("/survey")
public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException{
        String url = "index.html";

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }
        if (action.equals("join")) {
            url = "/index.html";
        }  else if (action.equals("add")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirth = request.getParameter("dateOfBirth");
            String heardFrom = request.getParameter("heardFrom");
            String contactvia = request.getParameter("contactvia");

            User user = new User(firstName, lastName, email, dateOfBirth, heardFrom, contactvia);
            //UserDB.insert(user);

            request.setAttribute("user", user);
            url = "/thanks.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
