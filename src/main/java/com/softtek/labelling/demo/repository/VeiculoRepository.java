package com.softtek.labelling.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.labelling.demo.domain.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {

}
