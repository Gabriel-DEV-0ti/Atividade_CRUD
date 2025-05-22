package com.example.Compras.model;
@Entity
@Table(name = "compras")
@Getter
@Setter
@NoArgsConstructor
public class ComprasModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_compra;

    @Column(nullable = false, updatable = false)
    private java.time.LocalDateTime dataCompra;

    @Column(nullable = false)
    private Long pessoa_ID;

     @PrePersist
    public void prePersist() {
        if (this.dataCompra == null) {
            this.dataCompra = java.time.LocalDateTime.now(); // Atribui apenas a data atual, sem hora
        }
    }
}
