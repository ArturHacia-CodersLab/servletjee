package pl.coderslab.session;

import com.sun.scenario.effect.impl.sw.java.JSWBrightpassPeer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Session2", urlPatterns = "/session2")
public class Session2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<Integer> oceny = (List<Integer>) session.getAttribute("oceny");
        if (oceny == null) {
            oceny = new ArrayList<>();
        }

        String ocenaParam = request.getParameter("ocena");
        try {
            Integer ocena = Integer.parseInt(ocenaParam);
            oceny.add(ocena);
            session.setAttribute("oceny", oceny);
        } catch (NumberFormatException e) {

        }

        PrintWriter writer = response.getWriter();
        writer.append("ąśęółćńżź");

        writer.append("<form action='' method='post'>");
        writer.append("<input type='text' name='ocena'><br>");
        writer.append("<input type='submit'>");
        writer.append("</form>");

        if (oceny.size() != 0) {
            int suma = 0;
            writer.append("Oceny: ");
            for (Integer ocena : oceny) {
                writer.append(ocena + ", ");
                suma += ocena;
            }
            writer.append("<br>");
            writer.append("Średnia: " + ((double) suma / oceny.size()));
        }
    }
}
