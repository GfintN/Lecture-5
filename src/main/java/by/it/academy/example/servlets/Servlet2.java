package by.it.academy.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet2 extends HttpServlet {
    private final String attributeOne = "numberOne";
    private final String attributeTwo = "numberTwo";
    private final String attributeSum = "sumNumber";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        synchronized (this){
            String numberOne = req.getParameter(attributeOne);
            String numberTwo = req.getParameter(attributeTwo);
            session.setAttribute(attributeOne, numberOne);
            session.setAttribute(attributeTwo, numberTwo);
        }
        if ((String.valueOf(session.getAttribute(attributeOne))).matches("[-+]?\\d+")&&
                (String.valueOf(session.getAttribute(attributeTwo))).matches("[-+]?\\d+")){
            session.setAttribute(attributeSum, String.valueOf(
                Long.parseLong(String.valueOf(session.getAttribute(attributeOne))) +
                Long.parseLong(String.valueOf(session.getAttribute(attributeTwo)))));
            out.write("Sum numbers " + session.getAttribute(attributeOne) + " and " +
                    session.getAttribute(attributeTwo) + " : " + session.getAttribute(attributeSum));
        }else {
            out.write("Enter parameter /sumNumbers?numberOne=(?)&numberTwo=(?)");
        }



    }
}