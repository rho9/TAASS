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
 * @author Davide
 */
@Local
public interface UtenteManagerLocal {
    void addUtente(String nome, String cognome, String email, String psw);
    List<Utente> getUtenti();
    String loginUtente(String email, String psw);
}
