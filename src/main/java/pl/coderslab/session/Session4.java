package pl.coderslab.session;

import pl.coderslab.model.CartItem;

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

@WebServlet(name = "Session4", urlPatterns = "/session4")
public class Session4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        String name = request.getParameter("name");
        String quantityParam = request.getParameter("quantity");
        String priceParam = request.getParameter("price");
        if (!name.isEmpty() && !quantityParam.isEmpty() && !priceParam.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityParam);
                double price = Double.valueOf(priceParam);
                CartItem cartItem = new CartItem(name, quantity, price);
                cart.add(cartItem);
                session.setAttribute("cart", cart);
            } catch (NumberFormatException e) {

            }
        } else {

        }

        double cartSum = 0;
        if (cart.size() > 0) {
            writer.append("<table>");
            for (CartItem cartItem : cart) {
                double cartItemSum = cartItem.getQuantity() * cartItem.getPrice();
                cartSum += cartItemSum;
                writer.append("<tr>");
                writer.append("<td>" + cartItem.getName()
                        + "</td><td>" + cartItem.getQuantity()
                        + "</td><td> x </td><td>" + cartItem.getPrice()
                        + "zł</td><td>" + cartItemSum
                        + "zł</td>");
                writer.append("</tr>");
            }
            writer.append("<tr>");
            writer.append("<td></td><td></td><td></td><td>Suma</td><td>" + cartSum + "zł</td>");
            writer.append("</tr>");
            writer.append("</table>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
