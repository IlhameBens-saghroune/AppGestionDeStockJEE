/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackEntities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ILHAM
 */
@Entity
public class Marque implements Serializable {

    @Id
    private String nomMarque;
    
    private String origineFab;
    
    @OneToMany
    public List<Produit> listeDesProduits = new ArrayList<>();
    
    public Marque(){}
    
    public Marque(String nomMarque, String origineFab){
       this.nomMarque=nomMarque;
       this.origineFab=origineFab;
    }

    /**
     * Get the value of listeDesProduits
     *
     * @return the value of listeDesProduits
     */
    public List<Produit> getListeDesProduits() {
        return listeDesProduits;
    }

    /**
     * Set the value of listeDesProduits
     *
     * @param listeDesProduits new value of listeDesProduits
     */
    public void setListeDesProduits(List<Produit> listeDesProduits) {
        this.listeDesProduits = listeDesProduits;
    }


    /**
     * Get the value of origineFab
     *
     * @return the value of origineFab
     */
    public String getOrigineFab() {
        return origineFab;
    }

    /**
     * Set the value of origineFab
     *
     * @param origineFab new value of origineFab
     */
    public void setOrigineFab(String origineFab) {
        this.origineFab = origineFab;
    }


    /**
     * Get the value of nomMarque
     *
     * @return the value of nomMarque
     */
    public String getNomMarque() {
        return nomMarque;
    }

    /**
     * Set the value of nomMarque
     *
     * @param nomMarque new value of nomMarque
     */
    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }
    
}