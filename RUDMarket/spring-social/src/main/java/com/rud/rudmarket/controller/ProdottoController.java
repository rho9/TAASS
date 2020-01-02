package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.ProdottoImage;
import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.form.ProdottoForm;
import com.rud.rudmarket.repository.ProdottoImageRepository;
import com.rud.rudmarket.repository.ProdottoRepository;
import com.rud.rudmarket.repository.SezioneRepository;
import com.rud.rudmarket.util.FileUtils;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/prodotto")
public class ProdottoController {

    @Autowired
    private ProdottoRepository prodottoRepository;

    @Autowired
    private ProdottoImageRepository prodottoImageRepository;

    @Autowired
    private SezioneRepository sezioneRepository;

    @RequestMapping(value = "/storeImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public Long storeImage(@RequestBody MultipartFile file) {
        File finalFile = FileUtils.moveAndStoreFile(file);
        ProdottoImage prodottoImage = new ProdottoImage();
        prodottoImage.setImage(BlobProxy.generateProxy(FileUtils.getImageBytes(finalFile)));
        prodottoImageRepository.save(prodottoImage);
        finalFile.delete();
        List<ProdottoImage> prodottoImages = prodottoImageRepository.findAll();

        return prodottoImages.get(prodottoImages.size() - 1).getId();
    }

    @PostMapping("/addProdotto")
    @PreAuthorize("hasRole('ADMIN')")
    public Prodotto addProdotto(@RequestBody ProdottoForm prodottoForm) throws Exception {
        if (prodottoForm.getSelectedSezione() != null) {
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoForm.getNome());
            prodotto.setMarca(prodottoForm.getMarca());
            prodotto.setPrezzo(Float.parseFloat(prodottoForm.getPrezzo()));
            prodotto.setAtKg(prodottoForm.getAtKg().equals("true"));
            prodotto.setIdImage(prodottoForm.getIdImage());
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

    @RequestMapping("/getImageProdottoByProdottoId")
    public byte[] getImageProdottoByProdottoId(@RequestBody String body) {
        Prodotto prodotto = prodottoRepository.findById(Long.parseLong(body)).get();
        ProdottoImage prodottoImage = prodottoImageRepository.findById(prodotto.getIdImage()).get();
        Blob blob = prodottoImage.getImage();
        byte[] bytes = new byte[0];
        try {
            bytes = prodottoImage.getImage().getBytes(1, (int) blob.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
