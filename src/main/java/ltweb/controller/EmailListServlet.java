package ltweb.controller;

import java.io.*;
import java.util.Date;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ltweb.model.Survey;
import ltweb.model.User;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException{
        String url = "index.html";
        String message = "";
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

            if (firstName == null || lastName == null || email == null || dateOfBirth == null
                    || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill all";
                url = "/index.html";
            } else {
                url = "/thanks.jsp";
            }

            User user = new User(firstName, lastName, email, dateOfBirth);
            Survey survey = new Survey(user, heardFrom, contactvia);
            //UserDB.insert(user);

            request.setAttribute("user", user);
            request.setAttribute("survey", survey);
            request.setAttribute("message", message);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
