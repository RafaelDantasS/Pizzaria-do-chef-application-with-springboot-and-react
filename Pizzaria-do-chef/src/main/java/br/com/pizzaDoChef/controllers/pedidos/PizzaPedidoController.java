package br.com.pizzaDoChef.controllers.pedidos;

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

import br.com.pizzaDoChef.services.pedido.PizzaPedidoServices;
import br.com.pizzaDoChef.v1.dto.PizzaPedidoVo;

@RestController
@RequestMapping("api/v1/pedido/pizza")
public class PizzaPedidoController {
	
	@Autowired
	PizzaPedidoServices req;
	
	@GetMapping("/{id}")
	public PizzaPedidoVo findById(@PathVariable(name = "id") Long id) {
		
		return req.findById(id);
	}
	
	@GetMapping
	public List<PizzaPedidoVo> findAll(){
		
		return req.findAll();
	}
	
	@PostMapping
	public PizzaPedidoVo create(@RequestBody PizzaPedidoVo pizza) {
		return req.save(pizza);
	}
	
	@PutMapping
	public PizzaPedidoVo update(@RequestBody PizzaPedidoVo pizza) {
		
		return req.update(pizza);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		req.delete(id);
		return ResponseEntity.noContent().build();
	}
}
