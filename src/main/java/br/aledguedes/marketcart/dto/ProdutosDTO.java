package br.aledguedes.marketcart.dto;

import java.io.Serializable;

import br.aledguedes.marketcart.domain.Produtos;

public class ProdutosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idProduto;
	private String nomeProd;
//	private List<Itens> itens;

	public ProdutosDTO() {
		super();
	}

	public ProdutosDTO(Produtos produto) {
		super();
		this.idProduto = produto.getIdProduto();
		this.nomeProd = produto.getNomeProd();
//		this.itens = produtos.getItens();
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

//	public List<Itens> getItens() {
//		return itens;
//	}
//
//	public void setItens(List<Itens> itens) {
//		this.itens = itens;
//	}
}
