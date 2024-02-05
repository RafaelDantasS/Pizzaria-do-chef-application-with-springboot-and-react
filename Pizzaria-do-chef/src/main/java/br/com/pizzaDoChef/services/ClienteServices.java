package br.com.pizzaDoChef.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaDoChef.excepitions.ResourceNotFoundEXception;
import br.com.pizzaDoChef.mapper.Mapper;
import br.com.pizzaDoChef.models.pedido.Cliente;
import br.com.pizzaDoChef.repositorys.pedido.BebidaPedidoRepository;
import br.com.pizzaDoChef.repositorys.pedido.ClienteRepository;
import br.com.pizzaDoChef.repositorys.pedido.PizzaPedidoRepository;
import br.com.pizzaDoChef.v1.dto.BebidasPedidoVo;
import br.com.pizzaDoChef.v1.dto.ClienteVo;
import br.com.pizzaDoChef.v1.dto.PizzaPedidoVo;

@Service
public class ClienteServices {
	
	@Autowired
	ClienteRepository repo;
	@Autowired
	PizzaPedidoRepository repoPizzas;
	@Autowired
	BebidaPedidoRepository repoBebidas;
	
	@Autowired
	Mapper mapper;
	
	public ClienteVo findById(Long id) {
		var dto= mapper.parseObject(repo.findById(id), ClienteVo.class);
		return dto;
	}
	public List<ClienteVo> findAll(){
		List<ClienteVo> pizzas = mapper.parseListObject(repo.findAll(), ClienteVo.class);
		return pizzas;
	}
	
	public ClienteVo save(ClienteVo pedidoVo){
		
		var entity = mapper.parseObject(pedidoVo, Cliente.class);
		var dto = mapper.parseObject(repo.save(entity), ClienteVo.class);
		return dto;
	}
	
	public ClienteVo update(ClienteVo pedidoVo) {
		var entity = repo.findById(pedidoVo.getId())
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		entity.setName(pedidoVo.getName());
		entity.setAdress(pedidoVo.getAdress());
		entity.setTel(pedidoVo.getTel());
		entity.setCep(pedidoVo.getCep());
		var dto = mapper.parseObject(repo.save(entity), ClienteVo.class);
		return dto;
	}

	public void delete(Long id) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		repo.delete(entity);
	}
	
	public List<PizzaPedidoVo> findAllPizzasByCliente(Long id){
		Optional<Cliente> clienteOptional = repo.findById(id);
		Cliente cliente = clienteOptional.get();
		var dto = mapper.parseListObject(repoPizzas.FindAllByCliente(cliente), PizzaPedidoVo.class);
		return dto;
	}
	public List<BebidasPedidoVo> findAllBebidasByCliente(Long id){
		Optional<Cliente> clienteOptional = repo.findById(id);
		Cliente cliente = clienteOptional.get();
		var dto = mapper.parseListObject(repoBebidas.FindAllByCliente(cliente),BebidasPedidoVo.class);
		return dto;
	}
}
