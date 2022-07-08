/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackEntities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ILHAM
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {

    @PersistenceContext(unitName = "AppGestionDeStock-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFacade() {
        super(Produit.class);
    }
    
    public Boolean creerProduit(String refProduit, Marque marqueProduit, float prix, float poids, float volume, String denomination){
        Boolean retour = false;
        Produit pExist = em.find(Produit.class, refProduit);
        if (pExist != null){
            return retour;
        }
        else{
            Marque m = em.find(Marque.class, pExist.getMarqueProduit().getNomMarque());
            /*if(m!=null)*/
            Produit p = new Produit(refProduit, marqueProduit, prix, poids, volume, denomination);
            em.persist(p);
            return true;
        }
    
    }
    
    public boolean modifierProduit(Produit p){
        Produit pd = em.find(Produit.class, p.getRefProduit());
        if(pd!=null)
        {
            pd.setDenomination(p.getDenomination());
            pd.setMarqueProduit(p.getMarqueProduit());
            pd.setPoids(p.getPoids());
            pd.setVolume(p.getVolume());
            pd.setPrix(p.getPrix());
            em.persist(pd);
            return true;
        }
        return false;
    }
    
    public List<Produit> findAll(){
        return em.createQuery("select object(o) from Produit as o").getResultList();
    }
    
    public List<Produit> trouverParMarque(String nomM){
        return em.createQuery( "SELECT object(o) from Produit as o WHERE o.marqueProduit.nomMarque = :marque")
               .setParameter("marque", nomM)
               .getResultList();
    }
    
    public boolean supprimerProduit(String refProduit){
       Produit pExist=em.find(Produit.class, refProduit);
       if(pExist !=null){
           em.remove(pExist);
           return true;
       }else
           return false;
    }

    
}
