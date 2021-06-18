package br.com.gamesdeloja.Loja.de.games.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gamesdeloja.Loja.de.games.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		Produto findById(long id);
}
