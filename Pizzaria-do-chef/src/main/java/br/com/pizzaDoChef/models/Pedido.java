package br.com.pizzaDoChef.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import br.com.pizzaDoChef.models.pedido.BebidaPedido;
import br.com.pizzaDoChef.models.pedido.Cliente;
import br.com.pizzaDoChef.models.pedido.PizzaPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToMany
	private PizzaPedido pizzaPedido;
	
	@OneToMany
	private BebidaPedido bebidaPedido;
	
	@Column
	private double total;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	

	public String getName() {
		return personName;
	}

	public String getAdress() {
		return adress;
	}

	public Date getData() {
		return data;
	}

	public void setName(String name) {
		this.personName = name;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adress, bebidas, data, id, personName, pizzas, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(bebidas, other.bebidas)
				&& Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(personName, other.personName) && Objects.equals(pizzas, other.pizzas)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}
	
	
}
