package br.com.pizzaDoChef.models.pedido;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String tel;
	@Column
	private String adress;
	@Column
	private String cep;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) 
	@JsonIgnore
	private List<PizzaPedido> pizzas;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BebidaPedido> bebidas;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAdress() {
		return adress;
	}
	public String getCep() {
		return cep;
	}
	public List<PizzaPedido> getPizzas() {
		return pizzas;
	}
	public List<BebidaPedido> getBebidas() {
		return bebidas;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setPizzas(List<PizzaPedido> pizzas) {
		this.pizzas = pizzas;
	}
	public void setBebidas(List<BebidaPedido> bebidas) {
		this.bebidas = bebidas;
	
	}
	@Override
	public int hashCode() {
		return Objects.hash(adress, bebidas, cep, id, name, pizzas, tel);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(bebidas, other.bebidas)
				&& Objects.equals(cep, other.cep) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(pizzas, other.pizzas) && Objects.equals(tel, other.tel);
	}
	
	
}
