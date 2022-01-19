package com.softtek.labelling.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.labelling.demo.domain.Despacho;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho,Long> {

}
