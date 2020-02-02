package pl.coderslab.mvc;

import pl.coderslab.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Mvc14", urlPatterns = "/mvc14")
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Book book  = new Book("Książka " + i, "Autor " + i, "ISBN-" + i);
            books.add(book);
        }
        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/WEB-INF/view/resultList.jsp").forward(request, response);
    }
}
