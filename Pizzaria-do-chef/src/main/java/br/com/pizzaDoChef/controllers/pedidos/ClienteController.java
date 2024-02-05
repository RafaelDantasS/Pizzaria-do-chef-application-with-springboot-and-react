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

import br.com.pizzaDoChef.services.ClienteServices;
import br.com.pizzaDoChef.v1.dto.BebidasPedidoVo;
import br.com.pizzaDoChef.v1.dto.ClienteVo;
import br.com.pizzaDoChef.v1.dto.PizzaPedidoVo;

@RestController
@RequestMapping("api/v1/pedido/Cliente")
public class ClienteController {
	
	@Autowired
	ClienteServices req;
	
	@GetMapping("/{id}")
	public ClienteVo findById(@PathVariable(value = "id") Long id) {
		
		return req.findById(id);
	}
	
	@GetMapping("/{id}/pizzas")
	public List<PizzaPedidoVo> findAllPizzasByCliente(@PathVariable(value = "id") Long id){
		
		return req.findAllPizzasByCliente(id);
	}
	
	@GetMapping("/{id}/bebidas")
	public List<BebidasPedidoVo> findAllBebidasByCliente(@PathVariable(value = "id") Long id){
		
		return req.findAllBebidasByCliente(id);
	}
	
	@GetMapping
	public List<ClienteVo> findAll(){
		
		return req.findAll();
	}
	
	@PostMapping
	public ClienteVo create(@RequestBody ClienteVo cliente) {
		return req.save(cliente);
	}
	
	@PutMapping
	public ClienteVo update(@RequestBody ClienteVo cliente) {
		
		return req.update(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		req.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
