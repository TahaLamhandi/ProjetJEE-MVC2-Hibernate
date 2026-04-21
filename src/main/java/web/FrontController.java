package web;

import utils.HibernateUtil;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class FrontController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("=== FRONT CONTROLLER: Initializing Hibernate ===");
        try {
            HibernateUtil.getSessionFactory();
            System.out.println("=== FRONT CONTROLLER: Hibernate Initialized ===");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Hibernate initialization failed", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        process(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        process(req, res);
    }

    private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String action = req.getParameter("controller");

        if (action == null) action = "login";

        switch (action) {

            case "login":
                req.getRequestDispatcher("/login").forward(req, res);
                break;

            case "register":
                req.getRequestDispatcher("/register").forward(req, res);
                break;

            case "list":
                req.getRequestDispatcher("/list").forward(req, res);
                break;

            case "ajouter":
                req.getRequestDispatcher("/ajouter").forward(req, res);
                break;

            case "supprimer":
                req.getRequestDispatcher("/supprimer").forward(req, res);
                break;

            case "modifier":
                req.getRequestDispatcher("/modifier").forward(req, res);
                break;

            case "update":
                req.getRequestDispatcher("/update").forward(req, res);
                break;

            case "logout":
                req.getRequestDispatcher("/logout").forward(req, res);
                break;

            default:
                req.getRequestDispatcher("login.jsp").forward(req, res);
        }
    }
}