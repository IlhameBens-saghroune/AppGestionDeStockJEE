/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackServlets;

import PackEntities.Produit;
import PackEntities.ProduitFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ILHAM
 */
public class ListeProduitsParMarque extends HttpServlet {
    
     @EJB
    private ProduitFacadeLocal produitFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListeProduitsParMarque</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListeProduitsParMarque at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Creation Produit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form  action = \"ListeProduitsParMarque\" method = \"POST\"> ");
            out.println("Nom de la marque:");
            out.println("<input type=\"text\" name=\"NameM\" value =\"\" />");
            out.println("<br/>");            
            out.println("<input type=\"submit\" value =\"Afficher Produits\" />");
            out.println("</form>"); 
            out.println("</body>");
            out.println("</html>");
        }  
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Creation Produit</title>");            
            out.println("</head>");
            out.println("<body>");
            List<Produit> ListProduit = produitFacade.trouverParMarque(request.getParameter("NameM"));
             out.println("<h2>Les Produits déjà existant</h2>");      
            out.println("<table>"); 
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>");
            out.println("Réference produit");
            out.println("</th>");
            out.println("<th>");
            out.println("Dénomination");
            out.println("</th>");
            out.println("<th>");
            out.println("Prix");   
            out.println("</th>");
            out.println("<th>");
            out.println("Poix");
            out.println("</th>");
            out.println("<th>");
            out.println("Volume");
            out.println("</th>");
            out.println("<th>");
            out.println("Action");   
            out.println("</th>");
            out.println("</tr>");
            out.println("<thead>"); 
            out.println("<tbody>");
            for (int i = 0; i < ListProduit.size(); i++){          
            out.println("<tr>");
            out.println("<td>");
            out.println(ListProduit.get(i).getRefProduit());
            out.println("</td>");
            out.println("<td>");
             out.println(ListProduit.get(i).getDenomination());
            out.println("</td>");
            out.println("<td>");
             out.println(ListProduit.get(i).getPrix());
            out.println("</td>");
            out.println("<td>");
             out.println(ListProduit.get(i).getPoids());
            out.println("</td>");
            out.println("<td>");
             out.println(ListProduit.get(i).getVolume());
            out.println("</td>");
            out.println("<td><a href=\"#\">Modifier </a> | <a href=\"SuppressionProduit\">Supprimer </a></td>");
            out.println("</tr>");
             }
            out.println("</tbody>");               
            out.println("</table>");
            out.println("</form>");     
             out.println("</body>");
            out.println("</html>");
        }  
        catch(Exception e){
            System.out.println("Probleme dans la servlet creation");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
