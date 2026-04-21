package web;

import metier.ProduitMetier;
import metier.ProduitMetierImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SupprimerProduitServlet extends HttpServlet {
    public ProduitMetier metier = new ProduitMetierImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        metier.deleteProduit(id);
        res.sendRedirect("controller?controller=list");   }
}