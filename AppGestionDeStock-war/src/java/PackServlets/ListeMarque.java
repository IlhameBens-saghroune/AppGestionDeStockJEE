/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackServlets;

import PackEntities.Marque;
import PackEntities.MarqueFacadeLocal;
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
public class ListeMarque extends HttpServlet {

    @EJB
    private MarqueFacadeLocal marqueFacade;

   

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
            out.println("<title>Servlet ListingMarque</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListingMarque at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            List<Marque> ListMarque = marqueFacade.findAll();
            out.println("<h2>Les marques déjà existant</h2>");
             
            out.println("<table>"); 
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>");
            out.println("La marque");
            out.println("</th>");
            out.println("<th>");
            out.println("Origine de fabrication");
            out.println("</th>");
            out.println("<th>");
            out.println("Action");   
            out.println("</th>");
            out.println("<thead>");
            for (int i = 0; i < ListMarque.size(); i++){
            out.println("<tr>");
            out.println("<td>");
            out.println(ListMarque.get(i).getNomMarque());
            out.println("</td>");
            out.println("<td>");
             out.println(ListMarque.get(i).getOrigineFab());
            out.println("</td>");
            out.println("<td><a href=\"#\">Modifier </a> | <a href=\"#\">Supprimer </a></td>");
            out.println("</tr>");
             }
            out.println("</tbody>");               
            out.println("</table>");
            out.println("</form>"); 
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){ System.out.println(e);}
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
