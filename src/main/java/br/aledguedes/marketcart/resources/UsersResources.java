package br.aledguedes.marketcart.resources;

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

import java.net.URI;

import br.aledguedes.marketcart.domain.Users;
import br.aledguedes.marketcart.dto.UsersDTO;
import br.aledguedes.marketcart.service.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {

	
	@Autowired
	UsersService service;
	
	@GetMapping
	public ResponseEntity<List<UsersDTO>> listAllUsers(){
		List<Users> users = service.listAll();
		List<UsersDTO> userDTO = users.stream()
				.map(user -> new UsersDTO(user)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(userDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsersDTO> listUserById(@PathVariable Integer id) {
		Users user = service.listOfId(id);
		return ResponseEntity.ok().body(new UsersDTO(user));
	}
	
	@PostMapping
	public ResponseEntity<UsersDTO> createNewUser(@Valid @RequestBody UsersDTO userDTO) {
		Users user = service.createUser(userDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsersDTO> updateUser(@PathVariable Integer id,@Valid @RequestBody UsersDTO objDTO){
		Users obj = service.updateUser(id, objDTO);
		
		return ResponseEntity.ok().body(new UsersDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UsersDTO> deletarTecnico(@PathVariable Integer id){
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
