package br.com.service.it.repositorio.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_ITEM_COMPRA")
@Getter
@Setter
@NoArgsConstructor
public class ItemCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_COMPRA", nullable = false)
	@JsonIgnore(value = true)
	private Compra compra;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PRODUTO", nullable = false)
	private Produto produto;
	@Column(name = "QUANTIDADE", nullable = false)
	private Integer quantidade;
	@Column(name = "VALOR", nullable = false, scale = 2, precision = 2)
	private Double valor;

	
}
