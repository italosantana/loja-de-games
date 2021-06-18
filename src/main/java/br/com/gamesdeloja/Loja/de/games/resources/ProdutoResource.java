package br.com.gamesdeloja.Loja.de.games.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gamesdeloja.Loja.de.games.models.Produto;
import br.com.gamesdeloja.Loja.de.games.repository.ProdutoRepository;

// mapeando o end
@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produto") // procurar por todos os produtos no endpoint
	public List<Produto> ListaProdutos(){
			return produtoRepository.findAll();
	}
	@GetMapping("/produto/{id}") // procurar por um produto em específico
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
			return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto") // escolher o produto
	public Produto salvaProduto(@RequestBody Produto produto) {
			return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto") //excluir o produto
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto") // trocar o produto
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
