/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;

/**
 *
 * @author Davide
 */
@WebService(serviceName = "BiblioService")
@Stateless()
public class BiblioService {
    
    // Questa classe rappresenta un Web Service

    @EJB
    private BookManagerLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    /*
        Viene definita una operazione che può essere richiamata dall'esterno:
        in questo caso, viene recuperata la lista dei libri presenti nel
        database
    */
 
    @WebMethod(operationName = "getBooks")
    public List<Book> getBooks() {
        return ejbRef.getBooks();
    }
    
}
