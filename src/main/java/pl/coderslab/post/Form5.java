package pl.coderslab.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Form5", urlPatterns = "/post5")
public class Form5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("convertionType");
        String degrees = request.getParameter("degrees");

        try {
            double value = Double.valueOf(degrees);
            if (type != null && type.equals("celcToFahr")) {
                double f = value * 9.0 / 5.0 + 32.0;
                response.getWriter().append("Stopnie Celcjusza: ").append(degrees).append(" to ").append(String.format("%.2f", f)).append(" stopni Farenheita");
            } else if (type != null && type.equals("FahrToCelc")) {
                double c = (value - 32.0) * 5.0 / 9.0;
                response.getWriter().append("Stopnie Farenheita: ").append(degrees).append(" to ").append(String.format("%.2f", c)).append(" stopni Celcjusza");
            } else {
                response.getWriter().append("Nieprawidłowy typ");
            }
        }catch (NumberFormatException e){
            response.getWriter().append("Podana wartość musi być liczbą");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
