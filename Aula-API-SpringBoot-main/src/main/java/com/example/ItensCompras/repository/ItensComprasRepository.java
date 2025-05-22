package com.example.ItensCompras.repository;

import com.example.ItensCompras.model.ItensComprasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

@Repository
public class ItensComprasRepository extends JpaRepository <ItensComprasModel, Long> {

}
