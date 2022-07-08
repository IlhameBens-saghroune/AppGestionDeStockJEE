/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackEntities;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ILHAM
 */
@Local
public interface ProduitFacadeLocal {

    Boolean creerProduit(String refProduit, Marque marqueProduit, float prix, float poids, float volume, String denomination);

    boolean modifierProduit(Produit p);

    void remove(Produit produit);

    List<Produit> findAll();
    
    List<Produit> trouverParMarque(String nomM);

    boolean supprimerProduit(String refProduit);
    
}
