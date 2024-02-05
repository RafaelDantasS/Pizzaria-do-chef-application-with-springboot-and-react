package br.com.pizzaDoChef.v1.dto;

import java.io.Serializable;
import java.util.Objects;

import br.com.pizzaDoChef.models.pedido.Cliente;

public class BebidasPedidoVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Cliente cliente;
	private String name;
	private int quant;
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
		BebidasPedidoVo other = (BebidasPedidoVo) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quant == other.quant;
	}
	
}
