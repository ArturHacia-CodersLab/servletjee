package pl.coderslab.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Form4", urlPatterns = "/post4")
public class Form4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");
        String cParam = request.getParameter("c");
        try {
            double a = Double.valueOf(aParam);
            double b = Double.valueOf(bParam);
            double c = Double.valueOf(cParam);
            double delta = Math.pow(b, 2) - (4 * (a * c));

            if (delta >= 0) {
                double x1 = (-b - Math.sqrt(delta)) / (2 * a);
                double x2 = (-b + Math.sqrt(delta)) / (2 * a);
                if (x1 == x2) {
                    writer.append("Znaleziono 1 pierwiastek: ").append(String.valueOf(x1));
                } else {
                    writer.append("Znalezione pierwiastki to: x1 = ")
                            .append(String.valueOf(x1))
                            .append(", x2 = ")
                            .append(String.valueOf(x2));
                }
            } else {
                response.getWriter().append("Brak pierwiastków");
            }
        } catch (NumberFormatException e) {
            writer.append("Podane parametry nie są liczbami");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
