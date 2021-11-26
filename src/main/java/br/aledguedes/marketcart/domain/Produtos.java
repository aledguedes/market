package br.aledguedes.marketcart.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.aledguedes.marketcart.dto.ProdutosDTO;

@Entity
@Table(name = "tbl_produtos")
public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer idProduto;

	@Column(name = "nome_produto", length = 100, nullable = false)
	private String nomeProd;
	
	@Column(name = "preco_produto")
	private double preco_produto;

	public Produtos() {
		super();
	}

	public Produtos(ProdutosDTO prodDTO) {
		super();
		this.idProduto = prodDTO.getIdProduto();
		this.nomeProd = prodDTO.getNomeProd();
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
