package pl.coderslab.mvc;

import pl.coderslab.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc13", urlPatterns = "/mvc13")
public class Mvc13 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty()) {
            Book book = new Book(title, author, isbn);
            request.setAttribute("book", book);
        } else {
            request.setAttribute("message", "Brak wszystkich wymaganych parametrów");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/jsp3.jsp").forward(request, response);
    }
}
