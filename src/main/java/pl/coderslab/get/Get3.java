package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/get3")
public class Get3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        int width = 5;
        int height = 10;

        String widthParam = request.getParameter("width");
        if (widthParam != null) {
            try {
                width = Integer.parseInt(widthParam);
            } catch (NumberFormatException e) {
                // nic nie zrobimy i parametr będzie miał wartość domyślną
            }
        }
        String heightParam = request.getParameter("height");
        if (heightParam != null) {
            try {
                height = Integer.parseInt(heightParam);
            } catch (NumberFormatException e) {
                // nic nie zrobimy i parametr będzie miał wartość domyślną
            }
        }

        writer.append("<table border=1>");
        for (int i = 0; i <= height; i++) {
            writer.append("<tr>");
            for (int j = 0; j <= width; j++) {
                writer.append("<td>");
                if (i == 0 && j == 0) {
                    writer.append("&nbsp;");
                } else if (i != 0 && j == 0) {
                    writer.append("<b>" + i + "</b>");
                } else if (i == 0 && j != 0) {
                    writer.append("<b>" + j + "</b>");
                } else {
                    writer.append(Integer.toString(i * j));
                }
                writer.append("</td>");
            }
            writer.append("</tr>");
        }
        writer.append("</table>");
    }
}
