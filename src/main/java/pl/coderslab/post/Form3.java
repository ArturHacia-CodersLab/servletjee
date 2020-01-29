package pl.coderslab.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Form3", urlPatterns = "/getForm3")
public class Form3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String pageParam = request.getParameter("page");
        if (!pageParam.isEmpty()) {
            try {
                int page = Integer.parseInt(pageParam);
                for (int i = 1; i <= page; i++) {
                    if (page % i == 0) {
                        writer.append(i + ", ");
                    }
                }
            } catch (NumberFormatException e) {
                writer.append("Podany parametr nie jest liczbą");
            }
        } else {
            writer.append("Brak parametru");
        }
    }
}
