package by.it.academy.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        String[] name;
        synchronized (this){
            name = req.getParameterValues("name");
            session.setAttribute("name", name);
        }
        if (session.getAttribute("name") != null) {
            out.write("Your Name: " + session.getAttribute("name"));
        }else {
            out.write("Enter parameter /setName?name=(?)");
        }
    }

}

