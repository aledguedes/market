package br.aledguedes.marketcart.dto;

import java.io.Serializable;
import java.util.List;

import br.aledguedes.marketcart.domain.ItensPedido;
import br.aledguedes.marketcart.domain.Pedidos;
import br.aledguedes.marketcart.domain.Users;

public class PedidosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idPedido;
	private String nomePedido;
	private Users users;
	private List<ItensPedido> itensPedido;

	public PedidosDTO() {
		super();
	}

	public PedidosDTO(Pedidos pedido) {
		super();
		this.idPedido = pedido.getIdPedido();
		this.nomePedido = pedido.getNomePedido();
		this.users = pedido.getUsers();
		this.itensPedido = pedido.getItensPedido();
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getNomePedido() {
		return nomePedido;
	}

	public void setNomePedido(String nomePedido) {
		this.nomePedido = nomePedido;
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

}
