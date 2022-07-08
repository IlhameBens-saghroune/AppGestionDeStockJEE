/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackEntities;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ILHAM
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> implements StockFacadeLocal {

    @PersistenceContext(unitName = "AppGestionDeStock-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }
    
    public Boolean creerStock(String NomStock) {
       boolean retour=false;
       Stock St=(Stock) em.find(Stock.class, NomStock);
       if(St!=null){
           return(retour);
        }
       else {
           St=new Stock(NomStock);
           em.persist(St);
       }
       return(true);
    }  
    
    public Boolean EntreeStock(String nomStock, String refProduit, int quantite) {
        Stock s=em.find(Stock.class, nomStock);
        if(s!=null)
        {
           if(s.getListeStock()==null)
           {
               ElementDeStock ei = new ElementDeStock(refProduit, quantite);
               List<ElementDeStock> l = new ArrayList<ElementDeStock>()  ;
               l.add(ei);
               ListeDeStock listStck = new ListeDeStock(l);
               s.setListeStock(listStck);
               return true;
           }else {
               ElementDeStock e = s.getListeStock().contient(refProduit);
                if(e==null)
                {
                    ElementDeStock newE = new ElementDeStock(refProduit, quantite);
                    s.getListeStock().getListElementStock().add(newE);
                }else
                {
                    e.setQuantite(e.getQuantite() + quantite);
                }
                return true;
           }
             
        }
        
         return false;
    }
    
    public Boolean SortieStock(String nomStock, String refProduit, int quantite) {
      Stock s=em.find(Stock.class, nomStock);
        if(s!=null)
        {
           
               ElementDeStock e = s.getListeStock().contient(refProduit);
                if(e==null || (e.getQuantite()<quantite))
                {
                    return false;
                }else
                { 
                    e.setQuantite(e.getQuantite() - quantite);
                }
                return true;
           }
             
        
        return false;
    }
    
    public Boolean modifierElementStock(String nomStock, String refProduit, int quantite) {
    Stock s=em.find(Stock.class, nomStock);
        if(s!=null)
        {
           if(s.getListeStock()==null || s.getListeStock().contient(refProduit)==null )
           {
               
               return false;
           }else {
               ElementDeStock e = s.getListeStock().contient(refProduit);
                    e.setRefProduit(refProduit);
                    e.setQuantite(quantite);
                
                return true;
           }
             
        }
        
        return false; 
        
    }   

    
}
