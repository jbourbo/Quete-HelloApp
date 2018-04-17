package org.wcs.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleHelloServlet", urlPatterns = {"/simple-hello"})
public class SimpleHelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameterMap().containsKey("firstName") && request.getParameterMap().containsKey("lastName") && request.getParameterMap().containsKey("datetime")) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String dateTime = request.getParameter("datetime");
            int time = Integer.parseInt(dateTime.substring(0, 2));
            String message ;
            if( time < 12 ){
                message = "Good morning " + firstName + " " + lastName + ".";
            }
            else if (time < 21){
                message = "Good afternoon " + firstName + " " + lastName + ".";
            }else {
                message = "Good night " + firstName + " " + lastName + ".";
            }
            request.setAttribute("message", message);

            request.getRequestDispatcher("/custom-hello.jsp").forward(request, response);

        } else{
            request.getRequestDispatcher("/hello-form.jsp").forward(request, response);
        }


    }
}
