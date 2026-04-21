package dao;

import java.util.List;
import dao.Produit;

public interface ProduitDAO {
    void addProduit(Produit p);
    List<Produit> getAllProduits();
    Produit getProduitById(Long id);
    void deleteProduit(Long id);
    void updateProduit(Produit p);
}
