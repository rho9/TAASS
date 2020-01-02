package com.rud.rudmarket.repository;


import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.ProdottoImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoImageRepository extends JpaRepository<ProdottoImage, Long> {

}