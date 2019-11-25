package it.rud.rudmarket.repository;

import it.rud.rudmarket.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdottoRepository extends JpaRepository<Prodotto, String> {

}
