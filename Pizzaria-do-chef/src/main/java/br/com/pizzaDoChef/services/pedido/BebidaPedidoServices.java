package br.com.pizzaDoChef.services.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaDoChef.excepitions.ResourceNotFoundEXception;
import br.com.pizzaDoChef.mapper.Mapper;
import br.com.pizzaDoChef.models.pedido.BebidaPedido;
import br.com.pizzaDoChef.repositorys.pedido.BebidaPedidoRepository;
import br.com.pizzaDoChef.v1.dto.BebidasPedidoVo;

@Service
public class BebidaPedidoServices {

	@Autowired
	BebidaPedidoRepository repo;

	@Autowired
	Mapper mapper;

	public BebidasPedidoVo findById(Long id) {
		var dto = mapper.parseObject(repo.findById(id), BebidasPedidoVo.class);
		return dto;
	}

	public List<BebidasPedidoVo> findAll() {
		List<BebidasPedidoVo> pizzas = mapper.parseListObject(repo.findAll(), BebidasPedidoVo.class);
		return pizzas;
	}

	public BebidasPedidoVo save(BebidasPedidoVo pedidoVo) {

		var entity = mapper.parseObject(pedidoVo, BebidaPedido.class);
		var dto = mapper.parseObject(repo.save(entity), BebidasPedidoVo.class);
		return dto;
	}

	public BebidasPedidoVo update(BebidasPedidoVo pedidoVo) {
		var entity = repo.findById(pedidoVo.getId())
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		entity.setName(pedidoVo.getName());
		entity.setQuant(pedidoVo.getQuant());
		entity.setPrice(pedidoVo.getPrice());

		var dto = mapper.parseObject(repo.save(entity), BebidasPedidoVo.class);
		return dto;
	}

	public void delete(Long id) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		repo.delete(entity);
	}

}
