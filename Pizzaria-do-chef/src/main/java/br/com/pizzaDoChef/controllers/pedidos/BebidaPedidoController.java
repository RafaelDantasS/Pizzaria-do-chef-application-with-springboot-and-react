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

import br.com.pizzaDoChef.services.pedido.BebidaPedidoServices;
import br.com.pizzaDoChef.util.MediaType;
import br.com.pizzaDoChef.v1.dto.BebidasPedidoVo;

@RestController
@RequestMapping("api/v1/pedido/bebida")
public class BebidaPedidoController {
	
	@Autowired
	BebidaPedidoServices req;
	
	@GetMapping(value = "/{id}", 
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public BebidasPedidoVo findById(@PathVariable(name = "id") Long id) {
		
		return req.findById(id);
	}
	
	@GetMapping(
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public List<BebidasPedidoVo> findAll(){
		
		return req.findAll();
	}
	
	@PostMapping(
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}
			)
	public BebidasPedidoVo create(@RequestBody BebidasPedidoVo bebida) {
		return req.save(bebida);
	}
	
	@PutMapping(
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}
			)
	public BebidasPedidoVo update(@RequestBody BebidasPedidoVo bebida) {
		
		return req.update(bebida);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		req.delete(id);
		return ResponseEntity.noContent().build();
	}
}
