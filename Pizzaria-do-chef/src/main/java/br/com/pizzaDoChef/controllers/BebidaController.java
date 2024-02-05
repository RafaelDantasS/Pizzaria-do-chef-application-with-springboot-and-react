package br.com.pizzaDoChef.controllers;

import java.util.List;

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

import br.com.pizzaDoChef.services.BebidaServices;
import br.com.pizzaDoChef.v1.dto.BebidasVo;

@RestController
@RequestMapping("/api/v1/bebida")
public class BebidaController {
	 
	@Autowired
	BebidaServices card;
	
	//para todos
	@GetMapping
	public List<BebidasVo> findAll() {
		
		return card.findAll();
	}
	@GetMapping(value ="/{id}")
	public BebidasVo findById(@PathVariable(value = "id") Long id) {
		
		return card.findById(id);
	}
	
	//adimin e funcionários.
	@PostMapping
	public BebidasVo create(@RequestBody BebidasVo bebida) {
		
		return card.save(bebida);
	}
	
	@PutMapping(value = "/{id}")
	public BebidasVo update(@RequestBody BebidasVo bebida) {
		return card.update(bebida);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		card.delete(id);
		return ResponseEntity.noContent().build();
	}
}
