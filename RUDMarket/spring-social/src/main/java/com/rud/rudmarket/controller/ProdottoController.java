package com.rud.rudmarket.controller;

import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.ProdottoImage;
import com.rud.rudmarket.model.Sezione;
import com.rud.rudmarket.model.form.ProdottoForm;
import com.rud.rudmarket.repository.ProdottoImageRepository;
import com.rud.rudmarket.repository.ProdottoRepository;
import com.rud.rudmarket.repository.SezioneRepository;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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

    @PostMapping("/addProdotto")
    @PreAuthorize("hasRole('ADMIN')")
    public Prodotto addProdotto(@RequestBody ProdottoForm prodottoForm) throws Exception {
        if (prodottoForm.getSelectedSezione() != null) {

            ProdottoImage prodottoImage = new ProdottoImage();
            prodottoImage.setImage(BlobProxy.generateProxy(getImage()));
            prodottoImageRepository.save(prodottoImage);

            List<ProdottoImage> prodottoImages = prodottoImageRepository.findAll();

            Long idImage = prodottoImages.get(prodottoImages.size() - 1).getId();

            Prodotto prodotto = new Prodotto();
            prodotto.setNome(prodottoForm.getNome());
            prodotto.setMarca(prodottoForm.getMarca());
            prodotto.setPrezzo(Float.parseFloat(prodottoForm.getPrezzo()));
            prodotto.setAtKg(prodottoForm.getAlKg().equals("true"));
            prodotto.setIdImage(idImage);

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
        System.out.println("ECCOMI");
        Prodotto prodotto = prodottoRepository.findById(Long.parseLong(body)).get();
        ProdottoImage prodottoImage = prodottoImageRepository.findById(prodotto.getIdImage()).get();
        Blob blob = prodottoImage.getImage();
        byte[] bytes = new byte[0];
        try {
            bytes = prodottoImage.getImage().getBytes(1, (int) blob.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return new String(bytes, StandardCharsets.UTF_8);
        return bytes;
    }

    private static byte[] getImage() {
        File file = new File("C:\\Users\\Davide\\Desktop\\cavolo-cappuccio-bianco-bio-per-smartbox.jpg");
        if(file.exists()){
            try {
                BufferedImage bufferedImage= ImageIO.read(file);
                ByteArrayOutputStream byteOutStream=new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", byteOutStream);
                return byteOutStream.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
