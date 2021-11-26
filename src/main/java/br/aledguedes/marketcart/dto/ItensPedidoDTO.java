package br.aledguedes.marketcart.dto;

import br.aledguedes.marketcart.domain.ItensPedido;
import br.aledguedes.marketcart.domain.Pedidos;
import br.aledguedes.marketcart.domain.Produtos;

public class ItensPedidoDTO {

	private int numSeq;
	private int qtdeItem;
	private double precoUnitario;
	private double precoTotal;
	private Pedidos pedido;
	private Produtos produto;

	public ItensPedidoDTO() {
		super();
	}

	public ItensPedidoDTO(ItensPedido itens) {
		super();
		this.numSeq = itens.getNumSeq();
		this.qtdeItem = itens.getNumSeq();
		this.precoUnitario = itens.getPrecoUnitario();
		this.precoTotal = itens.getPrecoTotal();
		this.pedido = itens.getPedido();
		this.produto = itens.getProduto();
	}

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public int getQtdeItem() {
		return qtdeItem;
	}

	public void setQtdeItem(int qtdeItem) {
		this.qtdeItem = qtdeItem;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Pedidos getPedido() {
		return pedido;
	}

	public void setPedido(Pedidos pedido) {
		this.pedido = pedido;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

}
