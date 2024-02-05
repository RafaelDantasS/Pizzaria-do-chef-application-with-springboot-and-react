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
@Table(name = "pizza_pedido")
public class PizzaPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private boolean metade;
	@Column
	private double price;
	@Column
	private boolean recheio;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isMetade() {
		return metade;
	}
	public void setMetade(boolean metade) {
		this.metade = metade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public boolean isRecheio() {
		return recheio;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRecheio(boolean recheio) {
		this.recheio = recheio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cliente, id, metade, name, price, recheio);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaPedido other = (PizzaPedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id) && metade == other.metade
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && recheio == other.recheio;
	}
}
