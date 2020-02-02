package pl.coderslab.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
    private final static String USER = "admin";
    private final static String PASSWORD = "coderslab";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if (user.equals(USER) && pass.equals(PASSWORD)) {
            session.setAttribute("username", user);
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            request.setAttribute("message", "Nieprawidłowe dane logowania");
            getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }
}
