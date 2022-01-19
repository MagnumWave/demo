package com.softtek.labelling.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.softtek.labelling.demo.domain.Placa;

@Repository
public interface PlacaRepository extends JpaRepository<Placa, Long> {
	Placa findByMarkNumber(String markNumber);
	@Query(value = "SELECT top(1) ID from PLACA order by ID desc", nativeQuery = true)
	Long getLastPlaca();
}
