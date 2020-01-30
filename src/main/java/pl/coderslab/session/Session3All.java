package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "Session3All", urlPatterns = "/showAllSessions")
public class Session3All extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Enumeration<String> sessionAttributes = session.getAttributeNames();
        while (sessionAttributes.hasMoreElements()) {
            String attributeKey = sessionAttributes.nextElement();
            String attributeValue = (String) session.getAttribute(attributeKey);
            response.getWriter().append(attributeKey + " : " + attributeValue + "<br>");
        }

    }
}
