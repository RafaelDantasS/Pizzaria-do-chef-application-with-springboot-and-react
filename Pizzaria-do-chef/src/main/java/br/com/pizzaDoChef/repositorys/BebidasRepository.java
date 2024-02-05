package br.com.pizzaDoChef.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pizzaDoChef.models.Bebidas;

@Repository
public interface BebidasRepository extends JpaRepository<Bebidas, Long>{}
