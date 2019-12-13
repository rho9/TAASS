package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Prodotto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {

    @RequestMapping("/getProdottiInCarrello")
    public List<Prodotto> getProdottiInCarrello() {
        List<Prodotto> prodotti = null;
        Prodotto test = new Prodotto();
        test.setNome("nome_test");
        test.setMarca("marca_test");
        test.setPrezzo(5);
        prodotti.add(test);
        return prodotti;
    }
}
