package web;

import dao.User;
import metier.UserMetier;
import metier.UserMetierImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserMetier metier = new UserMetierImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User newUser = metier.register(name, email, password);

        if (newUser != null) {
            req.getSession().setAttribute("currentUser", newUser);
            res.sendRedirect("controller?controller=list");
        } else {
            req.setAttribute("error", "Email déjà utilisé");
            req.getRequestDispatcher("register.jsp").forward(req, res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, res);
    }
}