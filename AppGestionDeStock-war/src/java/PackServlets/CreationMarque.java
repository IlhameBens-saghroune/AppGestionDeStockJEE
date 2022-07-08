/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackServlets;

import PackEntities.MarqueFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ILHAM
 */
@WebServlet(name = "CreationMarquee", urlPatterns = {"/CreationMarquee"})
public class CreationMarque extends HttpServlet {
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
            out.println("<title>Servlet CreationMarquee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreationMarquee at " + request.getContextPath() + "</h1>");
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
        try {
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreationMarquee</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form  action = \"CreationMarque\" method = \"POST\"> ");
            out.println("Nom de la marque:");
            out.println("<input type=\"text\" name=\"NameM\" value =\"\" />");
            out.println("<br/>");            
            out.println("Pays d’origine:");
            out.println("<input type=\"text\" name=\"OrigineM\" value =\"\" />");
            out.println("<input type=\"submit\" value =\"Créer Marque\" />");
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
        try {
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Creation Marque</title>");            
            out.println("</head>");
            out.println("<body>"); 
            out.println("<form  action = \"CreationMarque\" method = \"GET\"> ");
            Boolean ret=marqueFacade.creerMarque(request.getParameter("NameM"), request.getParameter("OrigineM"));
            
            if(ret==true)
            {
                out.println("Marque créée avec succes <br/>");
            }
            else
            {
                out.println("Impossible de creer la marque <br/>");
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
