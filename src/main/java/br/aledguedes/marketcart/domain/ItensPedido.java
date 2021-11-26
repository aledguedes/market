package br.aledguedes.marketcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.aledguedes.marketcart.dto.ItensPedidoDTO;

@Entity
@Table(name = "tbl_itenspedido")
public class ItensPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_seq")
	private int numSeq;

	@Column(name = "qtde_itens")
	private int qtdeItem;

	@Column(name = "preco_unitario")
	private double precoUnitario;

	@Column(name = "preco_total")
	private double precoTotal;

	@ManyToOne
	@JoinColumn(name = "id_pedido")
//	@JsonIgnoreProperties("itensPedido")
	private Pedidos pedido;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produtos produto;

	public ItensPedido() {
		super();
		// TODO Auto-generated constructor stub
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

	public ItensPedido(ItensPedidoDTO itensDTO) {
		super();
		this.numSeq = itensDTO.getNumSeq();
		this.qtdeItem = itensDTO.getNumSeq();
		this.precoUnitario = itensDTO.getPrecoUnitario();
		this.precoTotal = itensDTO.getPrecoTotal();
		this.pedido = itensDTO.getPedido();
		this.produto = itensDTO.getProduto();
	}

}
