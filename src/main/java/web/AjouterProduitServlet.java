package web;

import dao.Produit;
import metier.ProduitMetier;
import metier.ProduitMetierImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjouterProduitServlet extends HttpServlet {
    public ProduitMetier metier = new ProduitMetierImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String nom = req.getParameter("nomprod");
        String description = req.getParameter("description");
        Double prix = Double.parseDouble(req.getParameter("prix"));

        Produit nouveauproduit = new Produit();
        nouveauproduit.setNom(nom);
        nouveauproduit.setDescription(description);
        nouveauproduit.setPrix(prix);
        metier.addProduit(nouveauproduit);
        res.sendRedirect("controller?controller=list");
    }
}