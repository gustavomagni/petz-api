package br.com.service.it.repositorio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_PRODUTO")
@Getter
@Setter
@NoArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "PET", nullable = false, length = 255)
	private String pet;
	@Column(name = "CODIGO", nullable = false, length = 255)
	private String codigo;
	@Column(name = "MARCA", nullable = false, length = 255)
	private String marca;
	@Column(name = "NOME_PRODUTO", nullable = false, length = 255)
	private String nome;
	@Column(name = "PRECO", scale = 2, precision = 2, nullable = false)
	private Double preco;
	@Column(name = "EM_ESTOQUE", nullable = false)
	private Boolean emEstoque;
	@Lob
	@Column(name = "ESPECIFICACOES", nullable = false)
	private String especificacoes;
}
