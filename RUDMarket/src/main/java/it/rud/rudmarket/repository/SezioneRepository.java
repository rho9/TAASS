package it.rud.rudmarket.repository;


import it.rud.rudmarket.model.Sezione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CatalogoRepository extends JpaRepository<Sezione, String> {

}
