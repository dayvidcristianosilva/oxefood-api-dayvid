package br.com.ifpe.oxefood.modelo.produto;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {

        produto.setHabilitado(Boolean.TRUE);
        produto.setVersao(1L);
        produto.setDataCriacao(LocalDate.now());
        return repository.save(produto);
    }

    public List<Produto> findAll() {

        return repository.findAll();
    }

    public Produto findById(Long id) {

        return repository.findById(id).get();
    }

    public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

        List<Produto> listaProdutos = repository.findAll();

        if ((codigo != null && !"".equals(codigo)) &&
                (titulo == null || "".equals(titulo)) &&
                (idCategoria == null)) {
            listaProdutos = repository.consultarPorCodigo(codigo);
        } else if ((codigo == null || "".equals(codigo)) &&
                (titulo != null && !"".equals(titulo)) &&
                (idCategoria == null)) {
            listaProdutos = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
        } else if ((codigo == null || "".equals(codigo)) &&
                (titulo == null || "".equals(titulo)) &&
                (idCategoria != null)) {
            listaProdutos = repository.consultarPorCategoria(idCategoria);
        } else if ((codigo == null || "".equals(codigo)) &&
                (titulo != null && !"".equals(titulo)) &&
                (idCategoria != null)) {
            listaProdutos = repository.consultarPorTituloECategoria(titulo, idCategoria);
        }

        return listaProdutos;
    }

}
