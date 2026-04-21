package web;

import dao.Produit;
import metier.ProduitMetier;
import metier.ProduitMetierImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListProduitsServlet extends HttpServlet {
    public ProduitMetier metier = new ProduitMetierImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        List<Produit> list = new ArrayList<>();
        String id = req.getParameter("id");

        HttpSession session = req.getSession();

        if (session.getAttribute("error") != null) {
            session.removeAttribute("error");
        }

        if (id != null) {
            Long idProduit = Long.parseLong(id);
            Produit p = metier.getProduitById(idProduit);
            if (p != null) {
                list.add(p);
                req.setAttribute("produits", list);
                req.getRequestDispatcher("listproduits.jsp").forward(req, res);
                return;
            } else {
                req.setAttribute("error", "Ce ID n'existe pas");
                req.setAttribute("produits", metier.getAllProduits());
                req.getRequestDispatcher("listproduits.jsp").forward(req, res);
                return;
            }
        } else {
            req.setAttribute("produits", metier.getAllProduits());
            req.getRequestDispatcher("listproduits.jsp").forward(req, res);
        }
    }
}