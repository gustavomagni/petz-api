package br.com.service.it.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.service.it.repositorio.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	 Optional<Cliente> findByNumeroDocumento(String cpfCnpj);
}
