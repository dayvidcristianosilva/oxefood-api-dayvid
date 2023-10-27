package br.com.ifpe.oxefood.api.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public class ProdutoController {
       @Autowired
   private ProdutoService produtoService;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

       Produto produto = produtoService.save(request.build());
       return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
   }
   @ApiOperation(value = "Serviço responsável por listar todos os produtos do sistema.")

       @GetMapping
    public List<Produto> findAll() {
  
        return produtoService.findAll();
    }
    @ApiOperation(value = "Serviço responsável por obter um produtos referente ao Id passado na URL.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna  o produtos."),
        @ApiResponse(code = 401, message = "Acesso não autorizado."),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
        @ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
    })
 
    @GetMapping("/{id}")
    public Produto findById(@PathVariable Long id) {

        return produtoService.findById(id);
    }
}
