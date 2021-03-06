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
public class MarqueFacade extends AbstractFacade<Marque> implements MarqueFacadeLocal {

    @PersistenceContext(unitName = "AppGestionDeStock-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarqueFacade() {
        super(Marque.class);
    }
    
    public boolean creerMarque(String nom, String origine){
        Marque mExist=em.find(Marque.class, nom);
        if(mExist==null){
            Marque m = new Marque(nom,origine);
            em.persist(m);
            return true;
        }else 
           return false;
    }
    
    public boolean supprimerMarque(String nom){
       Marque mExist=em.find(Marque.class, nom);
       if(mExist!=null){
          em.remove(mExist);
          return true;
       }else 
           return false;   
    }
    
     public List<Produit> listerProduits(String nom){
        Marque m = em.find(Marque.class, nom);
        List<Produit> L = m.getListeDesProduits();
        return L ;
    }
    
    public void ajouterProduits(String nomMarque, Produit p){
        Marque m = em.find(Marque.class, nomMarque);
        m.getListeDesProduits().add(p);
        em.merge(m);
    }
    
    public List<Marque> findAll(){
        return em.createQuery("select object(o) from Marque as o").getResultList();
    }
    
    public Marque trouverMarque(String nom) {
        Marque m = em.find(Marque.class, nom);
        return m;
    }
}
