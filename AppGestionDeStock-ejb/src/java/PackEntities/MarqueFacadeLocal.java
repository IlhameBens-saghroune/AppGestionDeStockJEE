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
public interface MarqueFacadeLocal {

    boolean creerMarque(String nom, String origine);

    boolean supprimerMarque(String nom);
    
    List<Produit> listerProduits(String nom);
    
    void ajouterProduits(String nomMarque, Produit p);

    List<Marque> findAll();

    Marque trouverMarque(String nom);
    
}
