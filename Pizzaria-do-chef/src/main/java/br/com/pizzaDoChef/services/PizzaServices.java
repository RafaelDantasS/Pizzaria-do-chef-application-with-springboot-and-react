package br.com.pizzaDoChef.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaDoChef.excepitions.ResourceNotFoundEXception;
import br.com.pizzaDoChef.mapper.Mapper;
import br.com.pizzaDoChef.models.Pizzas;
import br.com.pizzaDoChef.repositorys.PizzaRepository;
import br.com.pizzaDoChef.v1.dto.PizzaVo;

@Service
public class PizzaServices {
	@Autowired
	PizzaRepository repo;
	
	@Autowired
	Mapper maper;
	
	public List<PizzaVo> findAll(){
	List<PizzaVo> pizzas= maper.parseListObject(repo.findAll(), PizzaVo.class);
	return pizzas;
	}

	public PizzaVo savePizza(PizzaVo pizza) {
		
		var entity = maper.parseObject(pizza, Pizzas.class);
		var dto = maper.parseObject(repo.save(entity), PizzaVo.class);
		return dto;
	}

	public PizzaVo findById(Long id) {
		var vo = maper.parseObject(repo.findById(id), PizzaVo.class);
		return vo;
	}

	public PizzaVo update(PizzaVo pizza) {
		var entity = repo.findById(pizza.getId())
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		entity.setTitle(pizza.getTitle());
		entity.setPrice(pizza.getPrice());
		entity.setImage(pizza.getImage());
		var vo = maper.parseObject(repo.save(entity), PizzaVo.class);
		
		return vo;
	}
	
	public void delete(Long id) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		repo.delete(entity);
	}
}
