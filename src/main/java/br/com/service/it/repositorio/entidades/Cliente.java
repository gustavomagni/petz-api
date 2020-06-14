package br.com.service.it.repositorio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_CLIENTE")
@Getter
@Setter
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TIPO", nullable = false, length = 20)
	private String tipo;
	@Column(name = "NUMERO_DOCUMENTO", nullable = false, length = 20)
	private String numeroDocumento;
	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;
	@Column(name = "DATA_NASCIMENTO", nullable = false, length = 10)
	private String dataNascimento;
	@Column(name = "SEXO", nullable = false, length = 1)
	private String sexo;
	@Column(name = "TELEFONE", nullable = false, length = 20)
	private String telefone;
}
