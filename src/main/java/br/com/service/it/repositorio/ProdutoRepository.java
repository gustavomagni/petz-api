package br.com.service.it.repositorio;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.service.it.repositorio.entidades.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Optional<Produto> findByNome(String cpfCnpj);
	
	Optional<Produto> findByCodigo(String codigoProduto);
}
