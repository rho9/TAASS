/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import com.google.gson.Gson;
import ejb.Book;
import ejb.BookManagerLocal;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {

    /*
        Viene utilizzato un riferimento al BookManager locale per le
        operazioni sui Book
    */
    @EJB
    private BookManagerLocal bookManager;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd = null;
        String action = request.getParameter("action");
        
        if (action.equals("vis")) {
            rd = getServletContext().getRequestDispatcher("/addbook.jsp");
            rd.forward(request, response);
        } else if(action.equals("reg")) {
            bookManager.addBook(request.getParameter("titolo"), request.getParameter("autore"));
            rd = getServletContext().getRequestDispatcher("/addbook.jsp");
            rd.forward(request, response);
        } else if(action.equals("list")) {
             List<Book> lista = bookManager.getBooks();
            String gsonList = buildGson(lista);
            System.out.println("servlet buildGson: NOT NULL  " + gsonList);
            if (lista != null) {
                rd = getServletContext().getRequestDispatcher("/currbiblio.jsp");
                request.setAttribute("jsonObject", gsonList);
                rd.forward(request, response);
            } else {
                System.out.println("LISTA VUOTA in servlet biblio");
            }
        }
    }
    
    private String buildGson(List<Book> l) {

        Gson gson = new Gson();
        String json = gson.toJson(l);

        if (json == null) {
            System.out.println("servlet buildGson: NULL");
        } else {
            System.out.println("servlet buildGson: NOT NULL  " + json);
        }
        return json;
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
