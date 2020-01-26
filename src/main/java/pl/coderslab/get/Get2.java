package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Get2", urlPatterns = "/get2")
public class Get2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        for (String key : keys) {
            PrintWriter writer = response.getWriter();
            writer.append(key + "<br>");
            writer.append("<ul>");
            for (String value : parameterMap.get(key)) {
                writer.append("<li>" + value + "</li>");
            }
            writer.append("</ul>");
//            response.getWriter().append("Klucz: " + key + ", wartość: " + Arrays.toString(parameterMap.get(key)) + "<br>");
        }
    }
}
