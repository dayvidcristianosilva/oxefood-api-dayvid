package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String cpf;

    private String rg;

    private String foneCelular;

    private String foneFixo;

    private String qtndEntregas;

    private String frete;

    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String cep;

    public Entregador build() {

        return Entregador.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .rg(rg)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .qtndEntregas(qtndEntregas)
                .frete(frete)
                .rua(rua)
                .numero(numero)
                .bairro(bairro)
                .cidade(cidade)
                .cep(cep)
                .build();

    }

}
