package com.example.Compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Compras.model.ComprasModel;

@Repository
public class ComprasRepository extends JpaRepository <ComprasModel, Long> {

}
