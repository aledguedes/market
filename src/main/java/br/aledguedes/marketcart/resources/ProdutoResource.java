package br.aledguedes.marketcart.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import java.net.URI;

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

import br.aledguedes.marketcart.domain.Produtos;
import br.aledguedes.marketcart.dto.ProdutosDTO;
import br.aledguedes.marketcart.service.ProdutosService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	ProdutosService service;

	@GetMapping
	public ResponseEntity<List<ProdutosDTO>> listAllProdutos() {
		List<Produtos> Produtos = service.listAll();
		List<ProdutosDTO> ProdutosDTO = Produtos.stream().map(prod -> new ProdutosDTO(prod))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(ProdutosDTO);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProdutosDTO> listProdutosById(@PathVariable Integer id) {
		Produtos Produtos = service.listOfId(id);
		return ResponseEntity.ok().body(new ProdutosDTO(Produtos));
	}

	@PostMapping
	public ResponseEntity<ProdutosDTO> createNewProdutos(@Valid @RequestBody ProdutosDTO ProdutosDTO) {
		Produtos prod = service.createProdutos(ProdutosDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prod.getIdProduto())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ProdutosDTO> updateProdutos(@PathVariable Integer id,
			@Valid @RequestBody ProdutosDTO objDTO) {
		Produtos obj = service.updateProdutos(id, objDTO);

		return ResponseEntity.ok().body(new ProdutosDTO(obj));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ProdutosDTO> deletarTecnico(@PathVariable Integer id) {
		service.deleteProdutos(id);
		return ResponseEntity.noContent().build();
	}

}
