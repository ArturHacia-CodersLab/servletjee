package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie3", urlPatterns = "/cookie3")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String timeParam = request.getParameter("time");
        if (!key.isEmpty()) {
            try {
                int time = Integer.parseInt(timeParam);
                Cookie cookie = new Cookie(key, value);
                cookie.setMaxAge(60*60*time);
                response.addCookie(cookie);
            } catch (NumberFormatException e) {
                response.getWriter().append("Czas podany musi być w liczbach");
            }

        } else {
            response.getWriter().append("Brak klucza");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
