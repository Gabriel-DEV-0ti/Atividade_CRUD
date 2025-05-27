package com.example.ItensCompras.repository;

import com.example.ItensCompras.model.ItensComprasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensComprasRepository extends JpaRepository <ItensComprasModel, Long> {

}
