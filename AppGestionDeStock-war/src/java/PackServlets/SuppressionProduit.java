/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackServlets;

import PackEntities.ProduitFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ILHAM
 */
public class SuppressionProduit extends HttpServlet {
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
            out.println("<title>Servlet SuppressionProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SuppressionProduit at " + request.getContextPath() + "</h1>");
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
        try  {
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form  action = \"SuppressionProduit\" method = \"POST\"> ");
            out.println("Référence du produit que vous voulez supprimer: ");
            out.println("<input type=\"text\" name=\"RefProduit\" value =\"\" />");
            out.println("<br/>");            
            out.println("<input type=\"submit\" value =\"Supprimer\" />");
            out.println("</form>"); 
            out.println("</body>");
            out.println("</html>");
    }
        catch(Exception e){}
        
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
        try  {
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form  action = \"SuppressionProduit\" method = \"GET\"> ");
            
            Boolean ret=produitFacade.supprimerProduit(request.getParameter("RefProduit"));
            if(ret==true)
            {
                out.println("Produit supprimer avec succes <br/>");
            }
            else
            {
                out.println("Le nom du produit n'existe pas. Impossible de supprimer le produit <br/>");
            }
            
            out.println("<input type=\"submit\" value =\"Retour\" />");
            out.println("</form>");  
            out.println("</body>");
            out.println("</html>");
    }
        catch(Exception e){}

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
