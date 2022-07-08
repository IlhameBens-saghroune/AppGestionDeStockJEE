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
import javax.persistence.ManyToOne;

/**
 *
 * @author ILHAM
 */
@Entity
public class Produit implements Serializable {

    @Id
    private String refProduit;
    
    @ManyToOne
    private Marque marqueProduit;
    
    private float prix;
    
    private float poids;
    
    private float volume;

    private String denomination;
    
    
      
    public Produit(){
        
    }
    
    public Produit(String refProduit, Marque marqueProduit, float prix, float poids, float volume, String denomination){
      this.refProduit=refProduit;
      this.marqueProduit=marqueProduit;
      this.poids=poids;
      this.volume=volume;
      this.denomination=denomination;
    }
    
    

    /**
     * Get the value of denomination
     *
     * @return the value of denomination
     */
    public String getDenomination() {
        return denomination;
    }

    /**
     * Set the value of denomination
     *
     * @param denomination new value of denomination
     */
    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }


    /**
     * Get the value of volume
     *
     * @return the value of volume
     */
    public float getVolume() {
        return volume;
    }

    /**
     * Set the value of volume
     *
     * @param volume new value of volume
     */
    public void setVolume(float volume) {
        this.volume = volume;
    }


    /**
     * Get the value of poids
     *
     * @return the value of poids
     */
    public float getPoids() {
        return poids;
    }

    /**
     * Set the value of poids
     *
     * @param poids new value of poids
     */
    public void setPoids(float poids) {
        this.poids = poids;
    }

    

    /**
     * Get the value of prix
     *
     * @return the value of prix
     */
    public float getPrix() {
        return prix;
    }

    /**
     * Set the value of prix
     *
     * @param prix new value of prix
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }


    /**
     * Get the value of marqueProduit
     *
     * @return the value of marqueProduit
     */
    public Marque getMarqueProduit() {
        return marqueProduit;
    }

    /**
     * Set the value of marqueProduit
     *
     * @param marqueProduit new value of marqueProduit
     */
    public void setMarqueProduit(Marque marqueProduit) {
        this.marqueProduit = marqueProduit;
    }

    

    /**
     * Get the value of refProduit
     *
     * @return the value of refProduit
     */
    public String getRefProduit() {
        return refProduit;
    }

    /**
     * Set the value of refProduit
     *
     * @param refProduit new value of refProduit
     */
    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }
}


 
