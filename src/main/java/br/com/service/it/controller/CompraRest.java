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

import br.com.service.it.repositorio.entidades.Compra;
import br.com.service.it.servico.CompraService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/compra")
@Slf4j
@AllArgsConstructor
public class CompraRest {

	@Autowired
	private CompraService compraService;

	@PostMapping
	public ResponseEntity<Object> efetuarCompra(@RequestBody(required = true) Compra compra) {
		log.info("Efetuando um novo pedido de compra");

		try {
			return new ResponseEntity<>(compraService.efetuarCompra(compra), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> findByCompra(@PathVariable(value = "id") Integer id) {
		log.info("Buscando compra por identificador... " + id);

		try {
			return new ResponseEntity<>(compraService.findCompraPorId(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<Object> findAll() {
		log.info("Buscando todas as compras");

		try {
			return new ResponseEntity<>(compraService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
