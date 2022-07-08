/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackServlets;

import PackEntities.Marque;
import PackEntities.MarqueFacadeLocal;
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
public class CreationProduit extends HttpServlet {
    
    @EJB
    private MarqueFacadeLocal marqueFacade;

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
            out.println("<title> Creation Produit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreationProduit at " + request.getContextPath() + "</h1>");
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
            out.println("<form  action = \"CreationProduit\" method = \"POST\"> ");
            out.println("Référence du produit:");
            out.println("<input type=\"text\" name=\"RefProduit\"><br><br>");
            out.println("La marque du produit:");
            List<Marque> ListMarque = marqueFacade.findAll();
            out.println("<select name=\"Marque\">");
            for (int i = 0; i < ListMarque.size(); i++){
            out.println("<option value="+ListMarque.get(i).getNomMarque()+">");
            out.println(ListMarque.get(i).getNomMarque());
            out.println("</option>");            
            }
            out.println("</select>");
            out.println("<br><br>");
            out.println(" Dénomination:");
            out.println("<input type=\"\" name=\"Denomination\"><br><br>");
            out.println("Prix:");
            out.println("<input type=\"text\" name=\"Prix\"><br><br>");
            out.println("Poids:");
            out.println("<input type=\"text\" name=\"Poids\"><br><br>");
            out.println("Volume:");
            out.println("<input type=\"text\" name=\"Volume\"><br><br>");
            out.println("<input type=\"submit\" value=\"Creer Produit\">");
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
            out.println("<title>Servlet CreationProduit</title>");            
            out.println("</head>");
            
            out.println("<body>");    
            out.println("<form  action = \"CreationProduit\" method = \"GET\"> ");
            
            Boolean ret=produitFacade.creerProduit(request.getParameter("RefProduit"),marqueFacade.trouverMarque(request.getParameter("Marque")) ,Float.parseFloat(request.getParameter("Prix")),Float.parseFloat(request.getParameter("Poids")), Float.parseFloat(request.getParameter("Volume")), request.getParameter("Denomination"));
            if(ret==true)
            {
                out.println("Produit créé avec succes <br/>");
                
            }
            else
            {
                out.println("Impossible de creer le produit <br/>");
            }
            
            out.println("<input type=\"submit\" value =\"Retour\" />");
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
