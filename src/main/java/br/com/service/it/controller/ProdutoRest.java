package br.com.service.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.service.it.repositorio.entidades.Produto;
import br.com.service.it.servico.ProdutoService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/produto")
@Slf4j
@NoArgsConstructor
public class ProdutoRest {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Produto produto) {
		log.info("Criando novo produto");

		try {
			return new ResponseEntity<>(produtoService.save(produto), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/getFindByName/{nome}")
	public ResponseEntity<Object> findByNome(@PathVariable(value = "nome") String nome) {
		log.info("Buscando produto por nome... " + nome);

		try {
			return new ResponseEntity<>(produtoService.findByNome(nome), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/getFindByName/{codigo}")
	public ResponseEntity<Object> findByCodigo(@PathVariable(value = "codigo") String codigo) {
		log.info("Buscando produto por codigo... " + codigo);

		try {
			return new ResponseEntity<>(produtoService.findByCodigo(codigo), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		log.info("Buscando todos os produtos");

		try {
			return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
