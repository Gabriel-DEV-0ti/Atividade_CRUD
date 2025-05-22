package com.example.ItensCompras.Controller;


@RestController
@RequestMapping ("/api/itensCompras")
public class itensComprasController {
    @Autowired
    private ItensCompraService service;

    @GetMapping
    public List <ItensCompraModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <ItensCompraModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorID(id)
            .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ItensCompraModel salvarItens(@RequestBody ItensCompraModel itens){
        return service.salvatItens(itens);
    }
    @PutMapping ("/{id}")
    public ResponseEntity <ItensCompraModel> atualizarItens(@PathVariable Long id, @RequestBody ItensCompraModel itens){
        if(!service.buscarPorID(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        ItensCompraModel idItens = new ItensCompraModel();
        idItens.setId(id);

        return ResponseEntity.ok(service.salvatItens(itens));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        if(!service.buscarPorID(id).isPresent()){
            return ResponseEntity .notFound().build();
        }
        service.deletarItens(id);
        return ResponseEntity.noContent().build();
    }
}
