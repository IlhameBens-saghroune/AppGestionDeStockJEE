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
public interface StockFacadeLocal {

    Boolean creerStock(String NomStock);
    
    Boolean EntreeStock(String nomStock, String refProduit, int quantite);
    
    Boolean SortieStock(String nomStock, String refProduit, int quantite);
    
    Boolean modifierElementStock(String nomStock, String refProduit, int quantite);
    
}
