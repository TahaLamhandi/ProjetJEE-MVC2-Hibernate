package web;

import dao.Produit;
import metier.ProduitMetier;
import metier.ProduitMetierImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProduitServlet extends HttpServlet {
    public ProduitMetier metier = new ProduitMetierImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String nom = req.getParameter("nomprod");
        String description = req.getParameter("description");
        Double prix = Double.parseDouble(req.getParameter("prix"));

        Produit p = new Produit();
        p.setId(id);
        p.setNom(nom);
        p.setDescription(description);
        p.setPrix(prix);

        metier.updateProduit(p);

        req.setAttribute("produits", metier.getAllProduits());
        req.getRequestDispatcher("listproduits.jsp").forward(req, res);
    }
}