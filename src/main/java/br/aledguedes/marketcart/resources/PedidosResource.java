package br.aledguedes.marketcart.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.aledguedes.marketcart.domain.Pedidos;
import br.aledguedes.marketcart.dto.PedidosDTO;
import br.aledguedes.marketcart.service.PedidosService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosResource {

	@Autowired
	PedidosService service;
	
	@GetMapping
	public ResponseEntity<List<PedidosDTO>> listAllPedidos() {
		List<Pedidos> Pedidos = service.listAll();
		List<PedidosDTO> cpmsDTO = Pedidos.stream()
				.map(cpms -> new PedidosDTO(cpms)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(cpmsDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PedidosDTO> listUserById(@PathVariable Integer id) {
		Pedidos cpms = service.listOfId(id);
		return ResponseEntity.ok().body(new PedidosDTO(cpms));
	}
	
	@PostMapping
	public ResponseEntity<PedidosDTO> createNewPedido(@RequestBody PedidosDTO cpmsDTO) {
		
		Pedidos cmps = service.createPedidos(cpmsDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cmps.getIdPedido()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PedidosDTO> updatePedidos(@PathVariable Integer id, @Valid @RequestBody PedidosDTO cpmsDTO) {
		Pedidos cmps = service.updatePedidos(id, cpmsDTO);
		
		return ResponseEntity.ok().body(new PedidosDTO(cmps));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PedidosDTO> deletePedidos(@PathVariable Integer id) {
		service.deletePedidos(id);
		return ResponseEntity.noContent().build();
	}
}
