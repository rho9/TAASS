package com.rud.rudmarket.repository;

import com.rud.rudmarket.model.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {

}
