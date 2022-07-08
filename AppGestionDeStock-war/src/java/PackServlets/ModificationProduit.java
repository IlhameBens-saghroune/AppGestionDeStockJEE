/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackServlets;

import PackEntities.Marque;
import PackEntities.MarqueFacadeLocal;
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
public class ModificationProduit extends HttpServlet {
     @EJB
    private ProduitFacadeLocal produitFacade;
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
            out.println("<title>Servlet ModificationProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificationProduit at " + request.getContextPath() + "</h1>");
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
            out.println("<title>Servlet ModificationProduit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form  action = \"ModificationProduit\" method = \"POST\"> ");
            out.println("<label for=\"Marque\"> Référence du produit:</label>");
            List<Produit> ListProduit = produitFacade.findAll();
            out.println("<select name=\"RefProduit\">");
            for (int i = 0; i < ListProduit.size(); i++){
            out.println("<option value="+ListProduit.get(i).getRefProduit()+">");
            out.println(ListProduit.get(i).getRefProduit());
            out.println("</option>");            
            }
            out.println("</select>");
            out.println("<br><br>");
            out.println("<label for=\"Marque\"> La marque du produit</label>");
            List<Marque> ListMarque = marqueFacade.findAll();
            out.println("<select name=\"Marque\">");
            for (int i = 0; i < ListMarque.size(); i++){
            out.println("<option value="+ListMarque.get(i).getNomMarque()+">");
            out.println(ListMarque.get(i).getNomMarque());
            out.println("</option>");            
            }
            out.println("</select>");
            out.println("<br><br>");
            out.println("<label for=\"Marque\"> Dénomination </label>");
            out.println("<input type=\"\" name=\"Denomination\"><br><br>");
            out.println("<label for=\"Marque\"> Prix </label>");
            out.println("<input type=\"text\" name=\"Prix\"><br><br>");
            out.println("<label for=\"Marque\"> Poids </label>");
            out.println("<input type=\"text\" name=\"Poids\"><br><br>");
            out.println("<label for=\"Origine\">Volume:</label>");
            out.println("<input type=\"text\" name=\"Volume\"><br><br>");
            out.println("<input type=\"submit\" value=\"Modifier\">");
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
            out.println("<title>Servlet ModificationProduit</title>");            
            out.println("</head>");
            String reference = request.getParameter("RefProduit");
            String nomMarque= request.getParameter("marque");
            String denominationP= request.getParameter("denomination");
            float prixP= Float.parseFloat(request.getParameter("prix"));
            float poidsP= Float.parseFloat(request.getParameter("poids"));
            float volumeP= Float.parseFloat(request.getParameter("volume"));
            Marque marqueP = marqueFacade.trouverMarque(nomMarque);
            Produit p = new Produit(reference, marqueP, prixP, poidsP,volumeP, denominationP);
            out.println("<body>");
            out.println("<form  action = \"ModificationProduit\" method = \"GET\"> ");
            
            Boolean ret=produitFacade.modifierProduit(p);
            if(ret==true)
            {
                out.println("Produit Modifier avec succes <br/>");
                
            }
            else
            {
                out.println("Le nom du produit n'existe pas. Impossible de modifier le produit <br/>");
            }
            
            out.println("<input type=\"submit\" value =\"Retour\" />");
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
