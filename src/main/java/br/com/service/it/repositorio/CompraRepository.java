package br.com.service.it.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.service.it.repositorio.entidades.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
