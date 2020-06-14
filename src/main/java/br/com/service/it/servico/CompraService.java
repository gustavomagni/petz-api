package br.com.service.it.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.service.it.exceptions.ValidationException;
import br.com.service.it.repositorio.CompraRepository;
import br.com.service.it.repositorio.entidades.Cliente;
import br.com.service.it.repositorio.entidades.Compra;
import br.com.service.it.repositorio.entidades.ItemCompra;
import br.com.service.it.repositorio.entidades.Produto;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;

	public Compra efetuarCompra(Compra compra) throws ValidationException {
		validarDadosCompra(compra);

		calcularPedido(compra);

		Optional<Cliente> optionalCliente = clienteService.findByNumeroDocumento(compra.getCliente().getNumeroDocumento());

		if (optionalCliente.isPresent()) {
			compra.setCliente(optionalCliente.get());
		}

		return compraRepository.save(compra);
	}
	

	public List<Compra> findAll() {
		return compraRepository.findAll();
	}

	public Optional<Compra> findCompraPorId(Integer id) {
		return compraRepository.findById(id);
	}

	private void validarDadosCompra(Compra compra) throws ValidationException {
		validarCliente(compra.getCliente());
		validarItensCompra(compra.getItensCompra());
	}

	private void calcularPedido(Compra compra) {
		Double valorTotal = Double.valueOf(0);

		for (ItemCompra item : compra.getItensCompra()) {
			Optional<Produto> optionalProduto = produtoService.findByCodigo(item.getProduto().getCodigo());

			item.setCompra(compra);
			
			if (optionalProduto.isPresent()) {
				item.setProduto(optionalProduto.get());
			}

			item.setValor(item.getProduto().getPreco() * item.getQuantidade());

			valorTotal += item.getValor();
		}

		compra.setValorTotal(valorTotal);
	}

	private void validarCliente(Cliente cliente) throws ValidationException {

		if (cliente == null) {
			throw new ValidationException("Cliente não enviado no pedido");
		}

		Optional<Cliente> optionalCliente = clienteService.findByNumeroDocumento(cliente.getNumeroDocumento());

		if (!optionalCliente.isPresent()) {
			throw new ValidationException("Cliente informado não existe");
		}
	}

	private void validarItensCompra(List<ItemCompra> itensCompra) throws ValidationException {

		if (itensCompra.isEmpty()) {
			throw new ValidationException("Itens inexistentes no pedido");
		}

		for (ItemCompra item : itensCompra) {

			if (item.getProduto() == null) {
				throw new ValidationException("Produto não enviado no pedido");
			}

			if (item.getQuantidade() == null || item.getQuantidade() == 0) {
				throw new ValidationException("Quantidade não informada no produto");
			}

			Optional<Produto> optionProduto = produtoService.findByCodigo(item.getProduto().getCodigo());

			if (!optionProduto.isPresent()) {
				throw new ValidationException("Produto informado não existe");
			}
		}
	}
}
