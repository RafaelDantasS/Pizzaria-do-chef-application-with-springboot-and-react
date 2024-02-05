package br.com.pizzaDoChef.services.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaDoChef.excepitions.ResourceNotFoundEXception;
import br.com.pizzaDoChef.mapper.Mapper;
import br.com.pizzaDoChef.models.pedido.PizzaPedido;
import br.com.pizzaDoChef.repositorys.pedido.PizzaPedidoRepository;
import br.com.pizzaDoChef.v1.dto.PizzaPedidoVo;

@Service
public class PizzaPedidoServices {
	
	@Autowired
	PizzaPedidoRepository repo;
	
	@Autowired
	Mapper mapper;
	
	public PizzaPedidoVo findById(Long id) {
		var dto= mapper.parseObject(repo.findById(id), PizzaPedidoVo.class);
		return dto;
	}
	public List<PizzaPedidoVo> findAll(){
		List<PizzaPedidoVo> pizzas = mapper.parseListObject(repo.findAll(), PizzaPedidoVo.class);
		return pizzas;
	}
	
	public PizzaPedidoVo save(PizzaPedidoVo pedidoVo){
		
		var entity = mapper.parseObject(pedidoVo, PizzaPedido.class);
		var dto = mapper.parseObject(repo.save(entity), PizzaPedidoVo.class);
		return dto;
	}
	
	public PizzaPedidoVo update(PizzaPedidoVo pedidoVo) {
		var entity = repo.findById(pedidoVo.getId())
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		entity.setName(pedidoVo.getName());
		entity.setMetade(pedidoVo.isMetade());
		entity.setPrice(pedidoVo.getPrice());
		entity.setRecheio(pedidoVo.isRecheio());
		
		var dto = mapper.parseObject(repo.save(entity), PizzaPedidoVo.class);
		return dto;
	}
	
	public void delete(Long id) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		repo.delete(entity);
	}
	
}
