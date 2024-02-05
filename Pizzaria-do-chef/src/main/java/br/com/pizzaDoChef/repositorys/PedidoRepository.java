package br.com.pizzaDoChef.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaDoChef.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{}
