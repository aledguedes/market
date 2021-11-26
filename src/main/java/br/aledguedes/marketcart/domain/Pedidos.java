package br.aledguedes.marketcart.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.aledguedes.marketcart.dto.PedidosDTO;

@Entity
@Table(name = "tbl_pedidos")
public class Pedidos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer idPedido;

	@Column(name = "nome_pedido")
	private String nomePedido;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private Users users;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("pedido")
	private List<ItensPedido> itensPedido;
	
	public Pedidos() {
		super();
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public String getNomePedido() {
		return nomePedido;
	}

	public void setNomePedido(String nomePedido) {
		this.nomePedido = nomePedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public List<ItensPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItensPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Pedidos(PedidosDTO cmps) {
		super();
		this.idPedido = cmps.getIdPedido();
		this.nomePedido = cmps.getNomePedido();
		this.users = cmps.getUsers();
		this.itensPedido = cmps.getItensPedido();
	}

}
