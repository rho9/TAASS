package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Sconto;
import com.rud.rudmarket.model.Supermercato;
import com.rud.rudmarket.model.form.SupermercatoForm;
import com.rud.rudmarket.repository.ScontoRepository;
import com.rud.rudmarket.repository.SupermercatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sup")
public class SupermercatoController {

    @Autowired
    SupermercatoRepository supermercatoRepository;

    @RequestMapping("/getSupermercati")
    public List<Supermercato> getSupermercati() {
        return supermercatoRepository.findAll();
    }

    @RequestMapping("/addSupermercato")
    @PreAuthorize("hasRole('ADMIN')")
    public boolean addSupermercato(@RequestBody SupermercatoForm supermercatoForm) {
        System.out.println(supermercatoForm.getNomeSupermercato() + " " +
                supermercatoForm.getLat() + " " + supermercatoForm.getLng());

        Supermercato supermercato = new Supermercato();
        supermercato.setNome(supermercatoForm.getNomeSupermercato());
        supermercato.setLat(Float.parseFloat(supermercatoForm.getLat()));
        supermercato.setLng(Float.parseFloat(supermercatoForm.getLng()));

        supermercatoRepository.save(supermercato);

        return true;
    }
}
