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

import br.com.pizzaDoChef.services.PizzaServices;
import br.com.pizzaDoChef.v1.dto.PizzaVo;

@RestController
@RequestMapping("/api/v1/sabores")
public class PizzaController {
	 
	@Autowired
	PizzaServices card;
	
	@GetMapping
	public List<PizzaVo> findAll() {
		
		return card.findAll();
	}
	@GetMapping(value ="/{id}")
	public PizzaVo findById(@PathVariable(value = "id") Long id) {
		
		return card.findById(id);
	}
	
	@PostMapping
	public PizzaVo create(@RequestBody PizzaVo pizza) {
		
		return card.savePizza(pizza);
	}
	
	@PutMapping
	public PizzaVo update(@RequestBody PizzaVo pizza) {
		return card.update(pizza);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		card.delete(id);
		return ResponseEntity.noContent().build();
	}
}
