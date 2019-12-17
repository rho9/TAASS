package com.rud.rudmarket.repository;

import com.rud.rudmarket.model.Sconto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScontoRepository extends JpaRepository<Sconto, String> {

}
