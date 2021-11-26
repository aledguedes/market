package br.aledguedes.marketcart.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.aledguedes.marketcart.domain.Pedidos;
import br.aledguedes.marketcart.dto.PedidosDTO;
import br.aledguedes.marketcart.repository.PedidosRepository;
import br.aledguedes.marketcart.service.exceptions.ObjectnotFoundException;

@Service
public class PedidosService {

	@Autowired
	private PedidosRepository repository;
	
	public Pedidos listOfId(Integer id) {
		Optional<Pedidos> Pedidos = repository.findById(id);
		return Pedidos.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}

	public List<Pedidos> listAll() {
		return repository.findAll();
	}

	public Pedidos createPedidos(PedidosDTO cpmsDTO) {
		cpmsDTO.setIdPedido(null);
		Pedidos newCpms = new Pedidos();
		return repository.save(newCpms);
	}

	public Pedidos updatePedidos(Integer id, @Valid PedidosDTO cmpsDTO) {
		cmpsDTO.setIdPedido(id);
		Pedidos oldCpms = listOfId(id);
		oldCpms = new Pedidos(cmpsDTO);
		return repository.save(oldCpms);
	}

	public void deletePedidos(Integer id) {
		repository.deleteById(id);
	}
}
