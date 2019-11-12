/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.UtenteManagerLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Davide
 */
@WebServlet(name = "UtenteServlet", urlPatterns = {"/UtenteServlet"})
public class UtenteServlet extends HttpServlet {

    @EJB
    private UtenteManagerLocal utenteManager;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd = null;
        String action = request.getParameter("action");
        
        if(action.equals("register")) {
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String email = request.getParameter("email");
            String psw = request.getParameter("psw");

            utenteManager.addUtente(nome, cognome, email, psw);
            
            rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        } else if(action.equals("signin")) {
            String email = request.getParameter("email");
            String psw = request.getParameter("psw");
            String nome = utenteManager.loginUtente(email, psw);
            if(nome != null) {
                rd = getServletContext().getRequestDispatcher("/index.jsp");
                request.setAttribute("nome", nome);
                rd.forward(request, response);
            }
        } else if(action.equals("registerVis")) {
            rd = getServletContext().getRequestDispatcher("/registrazione.jsp");
            rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
