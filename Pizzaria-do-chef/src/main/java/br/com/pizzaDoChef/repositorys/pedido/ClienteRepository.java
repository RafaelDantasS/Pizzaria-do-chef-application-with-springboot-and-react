package br.com.pizzaDoChef.repositorys.pedido;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pizzaDoChef.models.pedido.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
