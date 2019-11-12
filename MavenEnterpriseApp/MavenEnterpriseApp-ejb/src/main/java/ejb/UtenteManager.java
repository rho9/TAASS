/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.mycompany.UtenteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Davide
 */
@Stateless
public class UtenteManager implements UtenteManagerLocal {

    @EJB
    private UtenteFacadeLocal utenteFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addUtente(String nome, String cognome, String email, String psw) {
        Utente u = new Utente();
        u.setNome(nome);
        u.setCognome(cognome);
        u.setEmail(email);
        u.setPsw(psw);
        utenteFacade.create(u);
    }

    @Override
    public List<Utente> getUtenti() {
        return utenteFacade.findAll();
    }

    @Override
    public String loginUtente(String email, String psw) {
        Utente u = utenteFacade.find(email);
        return u == null ? null : u.getNome();
    }
}
