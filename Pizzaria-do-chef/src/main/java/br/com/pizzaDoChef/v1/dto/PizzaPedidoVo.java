package br.com.pizzaDoChef.v1.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.pizzaDoChef.models.pedido.Cliente;

public class PizzaPedidoVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private Long id;
	private String name;
	private double price;
	private boolean metade;
	private boolean recheio;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public boolean isMetade() {
		return metade;
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
	public void setMetade(boolean metade) {
		this.metade = metade;
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
		PizzaPedidoVo other = (PizzaPedidoVo) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id) && metade == other.metade
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && recheio == other.recheio;
	}
	
	
}
