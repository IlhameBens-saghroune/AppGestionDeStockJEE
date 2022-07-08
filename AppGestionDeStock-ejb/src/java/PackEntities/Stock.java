/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackEntities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ILHAM
 */
@Entity
public class Stock implements Serializable {

   
    @Id
    private String nomStock;
    private ListeDeStock listeStock;

    public Stock(String nomStock) {
        this.nomStock = nomStock;
    }

    public Stock() {
    }
    
    public Stock(String nomStock, ListeDeStock listeStock) {
        this.nomStock = nomStock;
        this.listeStock = listeStock;
    }

   
    public void setNomStock(String nomStock) {
        this.nomStock = nomStock;
    }
    
    public String getNomStock() {
        return nomStock;
    }

    public void setListeStock(ListeDeStock listeStock) {
        this.listeStock = listeStock;
    }

    public ListeDeStock getListeStock() {
        return listeStock;
    } 
    
    
    
}
