package com.rud.rudmarket.repository;


import com.rud.rudmarket.model.Prodotto;
import com.rud.rudmarket.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

}