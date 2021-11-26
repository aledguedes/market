package br.aledguedes.marketcart.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.aledguedes.marketcart.domain.Produtos;
import br.aledguedes.marketcart.dto.ProdutosDTO;
import br.aledguedes.marketcart.repository.ProdutosRepository;
import br.aledguedes.marketcart.service.exceptions.ObjectnotFoundException;

@Service
public class ProdutosService {

	@Autowired
	private ProdutosRepository repository;
	
	public Produtos listOfId(Integer id) {
		Optional<Produtos> Produtos = repository.findById(id);
		return Produtos.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}

	public List<Produtos> listAll() {
		return repository.findAll();
	}

	public Produtos createProdutos(ProdutosDTO prodDTO) {
		prodDTO.setIdProduto(null);
		Produtos newprod = new Produtos();

		return repository.save(newprod);
	}

	public Produtos updateProdutos(Integer id, @Valid ProdutosDTO prodDTO) {
		prodDTO.setIdProduto(id);
		Produtos oldprod = listOfId(id);
		oldprod = new Produtos(prodDTO);

		return repository.save(oldprod);
	}

	public void deleteProdutos(Integer id) {
		repository.deleteById(id);
	}
}
