package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get1", urlPatterns = "/get1")
public class Get1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        String startParam = request.getParameter("start");
        String endParam = request.getParameter("end");
        if (startParam == null || endParam == null) {
            writer.append("BRAK");
        } else {
            try {
                int start = Integer.parseInt(startParam);
                int end = Integer.parseInt(endParam);
                for (int i = start; i <= end; i++) {
                    writer.append(i + "<br>");
                }
            } catch (NumberFormatException e) {
                writer.append("Podane parametry nie są liczbami");
            }
        }
    }
}
