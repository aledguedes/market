package br.aledguedes.marketcart.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.aledguedes.marketcart.domain.Users;
import br.aledguedes.marketcart.dto.UsersDTO;
import br.aledguedes.marketcart.repository.UsersRepository;
import br.aledguedes.marketcart.service.exceptions.ObjectnotFoundException;

@Service
public class UsersService {

	@Autowired
	UsersRepository repository;

	public Users listOfId(Integer id) {
		Optional<Users> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectnotFoundException("Erro! Objeto não encontrado! ID " + id));
	}

	public List<Users> listAll() {
		return repository.findAll();
	}

	public Users createUser(UsersDTO userDTO) {
		userDTO.setId(null);
		Users newUser = new Users(userDTO);
		
		return repository.save(newUser);
	}
	
	public Users updateUser(Integer id, @Valid UsersDTO userDTO) {
		userDTO.setId(id);
		Users oldUser = listOfId(id);
		oldUser = new Users(userDTO);
		
		return repository.save(oldUser);
	}
	
	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}


}
