package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Session3Add", urlPatterns = "/addToSession")
public class Session3Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        if (!key.isEmpty() && !value.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute(key, value);
            response.getWriter().append("Atrybut dodany do sesji");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.append("<form action='' method='POST'>");
        writer.append("<label>");
        writer.append("Klucz:");
        writer.append("<input type='text' name='key'>");
        writer.append("</label>");
        writer.append("<label>");
        writer.append("Wartość:");
        writer.append("<input type='text' name='value'>");
        writer.append("</label>");
        writer.append("<input type='submit'>");
        writer.append("</form>");
    }
}
