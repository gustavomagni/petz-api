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

import br.com.service.it.repositorio.entidades.Cliente;
import br.com.service.it.servico.ClienteService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/cliente")
@Slf4j
@NoArgsConstructor
public class ClienteRest {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody Cliente cliente) {
		log.info("Criando novo cliente");

		try {
			return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{numeroDocumento}")
	public ResponseEntity<Object> findByDocumento(@PathVariable(value = "numeroDocumento") String cpfCnpj) {
		log.info("Buscando produto por documento... " + cpfCnpj);

		try {
			return new ResponseEntity<>(clienteService.findByNumeroDocumento(cpfCnpj), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		log.info("Buscando todos os clientes");

		try {
			return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
