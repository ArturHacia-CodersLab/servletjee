package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get4")
public class Get4 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        String company = request.getParameter("company");
        String[] learnTab = request.getParameterValues("learn");

        if (company != null) {
            writer.append("Company:<br>");
            writer.append("<ul>");
            writer.append("<li>" + company + "</li>");
            writer.append("</ul>");
        }

        if (learnTab != null && learnTab.length > 0) {
            writer.append("Learn:<br>");
            writer.append("<ul>");
            for (String learn : learnTab) {
                writer.append("<li>" + learn + "</li>");
            }
            writer.append("</ul>");
        }
    }

}
