package br.com.pizzaDoChef.repositorys.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.pizzaDoChef.models.pedido.BebidaPedido;
import br.com.pizzaDoChef.models.pedido.Cliente;

public interface BebidaPedidoRepository extends JpaRepository<BebidaPedido, Long>{
	@Query("SELECT b FROM BebidaPedido b WHERE b.cliente = :cliente")
	List<BebidaPedido> FindAllByCliente(@Param("cliente") Cliente cliente); 
}
