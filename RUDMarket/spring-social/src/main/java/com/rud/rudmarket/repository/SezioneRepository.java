package com.rud.rudmarket.repository;

import com.rud.rudmarket.model.Sezione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SezioneRepository extends JpaRepository<Sezione, Long> {

}
