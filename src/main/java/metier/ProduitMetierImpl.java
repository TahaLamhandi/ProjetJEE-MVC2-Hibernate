package metier;

import dao.Produit;
import dao.ProduitDAO;
import dao.ProduitImpl;

import java.util.List;

public class ProduitMetierImpl implements ProduitMetier {
    public ProduitDAO produitDAO;

    public ProduitMetierImpl() {
        this.produitDAO = new ProduitImpl();
    }

    @Override
    public void addProduit(Produit p) {
        produitDAO.addProduit(p);
    }

    @Override
    public void deleteProduit(Long id) {
        produitDAO.deleteProduit(id);
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitDAO.getAllProduits();
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitDAO.getProduitById(id);
    }

    @Override
    public void updateProduit(Produit p) {
        produitDAO.updateProduit(p);
    }
}