package com.example.ItensCompras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Itens_Compra")
@Getter
@Setter
@NoArgsConstructor
public class ItensComprasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private Long id_Compras;

    @Column (nullable = false)
    private Long id_Produtos;

    @Column (nullable = false, updatable = false)
    private int quantidade;
    @Column (nullable = false, updatable = false)
    private Double preco;
}
