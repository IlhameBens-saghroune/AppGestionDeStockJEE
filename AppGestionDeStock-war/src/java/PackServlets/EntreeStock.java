/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackServlets;

import PackEntities.StockFacadeLocal;
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
public class EntreeStock extends HttpServlet {
    @EJB
    private StockFacadeLocal stockFacade;
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
            out.println("<title>Servlet EntreeStock</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EntreeStock at " + request.getContextPath() + "</h1>");
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
            out.println("<title>Servlet Entree Stock</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form  action = \"EntreeStock\" method = \"POST\"> ");
            out.println("<label for=\"Marque\"> Nom du stock:</label>");
            out.println("<input type=\"text\" name=\"NomStock\"><br><br>");
            out.println("<label for=\"Marque\"> Réference du produit: </label>");
            out.println("<input type=\"text\" name=\"RefProduit\"><br><br>");
            out.println("<label for=\"Marque\">Quantité:</label>");
            out.println("<input type=\"text\" name=\"Quantite\"><br><br>");
            out.println("<input type=\"submit\" value=\"Valider\">");
            out.println("</form>");     
            out.println("</body>");
            out.println("</html>");
        }  
        catch(Exception e){
            System.out.println("Probleme dans la servlet d'entree");
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
            out.println("<title>Servlet Entree Stock</title>");            
            out.println("</head>");
            out.println("<body>"); 
            out.println("<form  action = \"EntreeStock\" method = \"GET\"> ");
            Boolean ret=stockFacade.EntreeStock(request.getParameter("NomStock"), request.getParameter("RefProduit"), Integer.parseInt(request.getParameter("Quantite")));

            if(ret==true)
            {
                out.println("Entree du stock valide <br/>");
                
            }
            else
            {
                out.println("Entree du stock non valide <br/>");
            }
            
            out.println("<input type=\"submit\" value =\"Retour\" />");
            out.println("</form>");        
            out.println("</body>");
            out.println("</html>");
        }  
        catch(Exception e){
            System.out.println("Probleme dans la servlet d'entree ");
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
