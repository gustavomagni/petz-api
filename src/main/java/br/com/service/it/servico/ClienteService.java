package br.com.service.it.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.service.it.exceptions.ValidationException;
import br.com.service.it.repositorio.ClienteRepository;
import br.com.service.it.repositorio.entidades.Cliente;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) throws ValidationException {
		Optional<Cliente> optionalCpfCnpj = clienteRepository.findByNumeroDocumento(cliente.getNumeroDocumento());
		
		
		if(optionalCpfCnpj.isPresent()) {
			throw new ValidationException("Cliente já existente");
		}
		
		return clienteRepository.save(cliente);
    }
	
	public Optional<Cliente> findByNumeroDocumento(String cpfCnpj) {
        return clienteRepository.findByNumeroDocumento(cpfCnpj);
    }
	
	public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
