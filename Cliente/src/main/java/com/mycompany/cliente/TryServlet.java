/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Davide
 */
@WebServlet(name = "TryServlet", urlPatterns = {"/TryServlet"})
public class TryServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/BiblioService/BiblioService.wsdl")
    private com.mycompany.cliente.BiblioService_Service service;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TryServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TryServlet at " + request.getContextPath() + "</h1>");
            try { // Call Web Service Operation
                com.mycompany.cliente.BiblioService port = service.getBiblioServicePort();
                // TODO process result here
                java.util.List<com.mycompany.cliente.Book> result = port.getBooks();
                out.println("<table>");
                out.println("<tr>");
                out.println("<td><b>Titolo</b></td><td><b>Autore</b></td>");
                out.println("</tr>");
                for(com.mycompany.cliente.Book b : result) {
                    out.println("<tr>");
                    out.println("<td>" + b.getTitle() + "</td><td>" + b.getAuthor() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
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
