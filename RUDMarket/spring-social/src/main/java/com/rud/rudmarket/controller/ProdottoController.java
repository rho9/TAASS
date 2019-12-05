package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.form.ProdottoForm;
import com.rud.rudmarket.repository.ProdottoRepository;
import com.rud.rudmarket.repository.SezioneRepository;
import com.rud.rudmarket.security.CurrentUser;
import com.rud.rudmarket.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private SezioneRepository sezioneRepository;

    @PostMapping("/addProdotto")
    @PreAuthorize("hasRole('ADMIN')")
    public Prodotto addProdotto(@RequestBody ProdottoForm prodottoForm) throws Exception {
        if (prodottoForm.getSelectedSezione() != null) {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoForm.getNome());
            prodotto.setMarca(prodottoForm.getMarca());
            prodotto.setPrezzo(Integer.parseInt(prodottoForm.getPrezzo()));
            prodottoRepository.save(prodotto);

            Sezione sezione = sezioneRepository.findById(prodottoForm.getSelectedSezione()).get();
            List<Prodotto> prodottoList = sezione.getProdottoList();
            prodottoList.add(prodotto);
            sezione.setProdottoList(prodottoList);
            sezioneRepository.save(sezione);

            return prodotto;
        }

        throw new Exception("La sezione inserita non è corretta!");
    }
}
