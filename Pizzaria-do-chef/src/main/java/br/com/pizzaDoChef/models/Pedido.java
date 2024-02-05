package br.com.pizzaDoChef.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "person_name",nullable = false)
	private String personName;
	@Column(name = "tel_number", nullable = false)
	private String telNumber;
	@Column(nullable = false)
	private String pizzas;
	@Column(nullable = true)
	private String bebidas;
	@Column(nullable = false)
	private String adress;
	@Column(nullable = false)
	private double total;
	@Column(nullable = false)
	private Date data;

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
