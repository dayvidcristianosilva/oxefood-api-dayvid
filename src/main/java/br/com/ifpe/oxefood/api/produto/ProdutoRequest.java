package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String titulo;

    private String codProduto;

    private String descricaoProduto;

    private String valorUnitario;

    private String entregaMin;

    private String entregaMax;

    public Produto build() {

        return Produto.builder()
                .titulo(titulo)
                .codProduto(codProduto)
                .descricaoProduto(descricaoProduto)
                .valorUnitario(valorUnitario)
                .entregaMin(entregaMin)
                .entregaMax(entregaMax)
                .build();
    }

}
