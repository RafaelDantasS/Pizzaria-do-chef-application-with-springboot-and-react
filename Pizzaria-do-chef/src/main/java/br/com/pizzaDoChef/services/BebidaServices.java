package br.com.pizzaDoChef.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaDoChef.excepitions.ResourceNotFoundEXception;
import br.com.pizzaDoChef.mapper.Mapper;
import br.com.pizzaDoChef.models.Bebidas;
import br.com.pizzaDoChef.repositorys.BebidasRepository;
import br.com.pizzaDoChef.v1.dto.BebidasVo;

@Service
public class BebidaServices {
	@Autowired
	BebidasRepository repo;
	
	@Autowired
	Mapper maper;
	
	public List<BebidasVo> findAll(){
	List<BebidasVo> Bebidas= maper.parseListObject(repo.findAll(), BebidasVo.class);
	return Bebidas;
	}

	public BebidasVo save(BebidasVo bebida) {
		
		var entity = maper.parseObject(bebida, Bebidas.class);
		var dto = maper.parseObject(repo.save(entity), BebidasVo.class);
		return dto;
	}

	public BebidasVo findById(Long id) {
		var vo = maper.parseObject(repo.findById(id), BebidasVo.class);
		return vo;
	}

	public BebidasVo update(BebidasVo bebida) {
		var entity = repo.findById(bebida.getId())
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		entity.setName(bebida.getName());
		entity.setPrice(bebida.getPrice());
		entity.setImage(bebida.getImage());
		var vo = maper.parseObject(repo.save(entity), BebidasVo.class);
		
		return vo;
	}
	
	public void delete(Long id) {
		var entity = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundEXception("No records found for this name."));
		repo.delete(entity);
	}
}
