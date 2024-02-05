package br.com.pizzaDoChef.repositorys.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pizzaDoChef.models.pedido.Cliente;
import br.com.pizzaDoChef.models.pedido.PizzaPedido;

public interface PizzaPedidoRepository extends JpaRepository<PizzaPedido, Long>{
	@Query("SELECT p FROM PizzaPedido p WHERE p.cliente = :cliente")
	List<PizzaPedido> FindAllByCliente(@Param("cliente") Cliente cliente); 
}
