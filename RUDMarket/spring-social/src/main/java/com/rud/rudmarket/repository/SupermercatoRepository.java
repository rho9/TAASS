package com.rud.rudmarket.repository;

import com.rud.rudmarket.model.Supermercato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermercatoRepository extends JpaRepository<Supermercato, Long> {
}
