package br.com.pizzaDoChef.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaDoChef.models.Pizzas;

@Repository
public interface PizzaRepository extends JpaRepository<Pizzas, Long>{}
