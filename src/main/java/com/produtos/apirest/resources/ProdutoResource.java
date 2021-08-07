package com.produtos.apirest.resources;

// Controller que recebe as requisições do HTTP, como adição de dados etc;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*") // libera todos os domínios de acessar essa API (se for um só, vai ter tipo /http:dominio...
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    // lista todos os produtos salvos no BD
    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de todos os produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    // lista somente um produto através de seu id
    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna somente determinado produto ao especificar seu id")
    public Produto listProdutoUnico(@PathVariable(value="id") long id) {
        return produtoRepository.findById(id);
    }

    // método post para salvar um produto que precisa ser enviado via Postman no formato Json
    @PostMapping("/produto")
    @ApiOperation(value="Salva um novo produto")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // método delete
    @DeleteMapping("/produto")
    @ApiOperation(value="Deleta um produto")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    // para atualizar um produto através de seu id;
    @PutMapping("/produto")
    @ApiOperation(value="Atualiza os dados de um produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}
