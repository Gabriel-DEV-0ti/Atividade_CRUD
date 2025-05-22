package com.example.Compras.Controller;


@RestController
@RequestMapping ("/api/compras")
public class ComprasController {
    @Autowired
    private CompraService service;

    @GetMapping
    public List<ComprasModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity <ComprasModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)    
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComprasModel salvarCompras (@RequestBody ComprasModel compras){
        return service.salvarCompras(compras);
    }

    @PutMapping ("/{id}")
    public ResponseEntity <ComprasModel> atualizar (@PathVariable Long id, @RequestBody ComprasModel compras){
        if(!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        ComprasModel compra = new ComprasModel();
        compra.setId_compra(id);

    return ResponseEntity.ok(service.salvarCompras(compras));
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        if(!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        service.deletarCompras(id);
        return ResponseEntity.noContent().build();
    }
}
