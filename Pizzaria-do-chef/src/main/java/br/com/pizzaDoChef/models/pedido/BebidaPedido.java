package br.com.pizzaDoChef.models.pedido;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bebida_pedido")
public class BebidaPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne @JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Column
	private String name;
	@Column
	private int quant;
	@Column
	private double price;
	
	public Long getId() {
		return id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public String getName() {
		return name;
	}
	public int getQuant() {
		return quant;
	}
	public double getPrice() {
		return price;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, id, name, price, quant);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BebidaPedido other = (BebidaPedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quant == other.quant;
	}
	

	
}
