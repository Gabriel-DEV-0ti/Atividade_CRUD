package com.example.ItensCompras.model;

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
