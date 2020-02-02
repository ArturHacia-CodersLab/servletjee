package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc12", urlPatterns = "/mvc12")
public class Mvc12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startParam = request.getParameter("start");
        String endParam = request.getParameter("end");
        if (startParam != null && endParam != null) {
            try {
                int start = Integer.parseInt(startParam) + 10;
                int end = Integer.parseInt(endParam) + 10;
                request.setAttribute("start", start);
                request.setAttribute("end", end);
            } catch (NumberFormatException e) {

            }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/view/jsp2.jsp").forward(request, response);
    }
}
