package com.rud.rudmarket.repository;

import com.rud.rudmarket.model.Ordine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, String> {
}
