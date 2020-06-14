package br.com.service.it.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.service.it.repositorio.ProdutoRepository;
import br.com.service.it.repositorio.entidades.Produto;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
    }
	
	public Optional<Produto> findByCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo);
    }
	
	public Optional<Produto> findByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }
	
	public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

}
