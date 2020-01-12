/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import ejb.Book;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author giovanna
 */
@Local // questa annotazione serve per indicare che vi è una implementazione locale (e non remota)
public interface BookFacadeLocal {
    
    /*
        Viene utilizzata questa interfaccia per riferisi ad un BookFacade
    */

    void create(Book book);

    void edit(Book book);

    void remove(Book book);

    Book find(Object id);

    List<Book> findAll();

    List<Book> findRange(int[] range);

    int count();
    
}
