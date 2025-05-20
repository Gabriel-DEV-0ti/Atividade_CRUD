use estudo_pessoas;
SELECT * from produtos;

alter table produtos MODIFY COLUMN produtos(

)

use estudo_pessoas;
create TABLE Compras(
    id bigint(20) AUTO_INCREMENT PRIMARY KEY,
    dataCompra date,
    pessoa_id bigint,
    Foreign Key (pessoa_id) REFERENCES table_name (id)
)
select * from Compras;

use estudo_pessoas;
create TABLE ItensCompra(
    id bigint(20) AUTO_INCREMENT PRIMARY KEY,
    compra_id bigint,
    Foreign Key (compra_id) REFERENCES Compras(id),
    produto_id bigint,
    Foreign Key (produtos_id) REFERENCES produtos(id),
    quantidade int,
    precoUnitario decimal (10,2)
)

use estudo_pessoas;
drop COLUMN ItensCompra; 