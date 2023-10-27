package br.com.ifpe.oxefood.api.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public class EntregadorController {
   @Autowired
   private EntregadorService entregadorService;

   @ApiOperation(value = "Serviço responsável por salvar um entregador no sistema.")

   @PostMapping
   public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {

       Entregador entregador = entregadorService.save(request.build());
       return new ResponseEntity<Entregador>(entregador, HttpStatus.CREATED);
   }
   @ApiOperation(value = "Serviço responsável por listar todos os entregadores do sistema.")

       @GetMapping
    public List<Entregador> findAll() {
  
        return entregadorService.findAll();
    }
    @ApiOperation(value = "Serviço responsável por obter um entregador referente ao Id passado na URL.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna  o entregador."),
        @ApiResponse(code = 401, message = "Acesso não autorizado."),
        @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
        @ApiResponse(code = 404, message = "Não foi encontrado um registro para o Id informado."),
        @ApiResponse(code = 500, message = "Foi gerado um erro no servidor."),
    })
 

    @GetMapping("/{id}")
    public Entregador findById(@PathVariable Long id) {

        return entregadorService.findById(id);
    }
 
}
