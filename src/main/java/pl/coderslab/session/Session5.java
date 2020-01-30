package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "Session5", urlPatterns = "/session5")
public class Session5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        String captchaParam = request.getParameter("captcha");
        if (!captchaParam.isEmpty()) {
            try {
                int captcha = Integer.parseInt(captchaParam);
                int sessionCaptcha = (int) session.getAttribute("captcha");
                if (sessionCaptcha == captcha) {
                    writer.append("Captcha jest prawidłowa");
                } else {
                    writer.append("Captcha jest nieprawidłowa");
                }
            } catch (NumberFormatException e) {
                writer.append("Parametr captcha musi być liczbą");
            }
        } else {
            writer.append("Brak parametru captcha");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random random = new Random();
        int firstNumber = random.nextInt(101) - 1;
        int secondNumber = random.nextInt(101) - 1;

        HttpSession session = request.getSession();
        session.setAttribute("captcha" , (firstNumber + secondNumber));

        PrintWriter writer = response.getWriter();
        writer.append("<form action='' method='POST'>");
        writer.append("<label>");
        writer.append("Imie:");
        writer.append("<input type='text' name='firstname'>");
        writer.append("</label><br>");
        writer.append("<label>");
        writer.append("Nazwisko:");
        writer.append("<input type='text' name='lastname'>");
        writer.append("</label><br>");
        writer.append("<label>");
        writer.append("Email:");
        writer.append("<input type='text' name='email'>");
        writer.append("</label><br>");
        writer.append("<label>");
        writer.append("Wpisz poniżej sumę " + firstNumber + " + " + secondNumber + ":<br>");
        writer.append("<input type='text' name='captcha'>");
        writer.append("</label><br>");
        writer.append("<input type='submit'>");
        writer.append("</form>");
    }
}
