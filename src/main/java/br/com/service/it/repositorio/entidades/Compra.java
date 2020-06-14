package br.com.service.it.repositorio.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "T_COMPRA")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", nullable = false)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	private Cliente cliente;
	@Column(name = "VALOR_TOTAL", nullable = false, scale = 2, precision = 2)
	private Double valorTotal;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_COMPRA", nullable = false)
	private Date data = new Date();
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "compra", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<ItemCompra> itensCompra = new ArrayList<>();
}
