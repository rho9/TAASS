/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author giovanna
 */
@Local
public interface BookManagerLocal {
    
    /*
        Interfaccia che deve essere implementata da tutti i BookManager
        Definisce le operazioni che possono essere effettuate da un BookManager
    */

    void addBook(String title, String author);

    List<Book> getBooks();
    
}
