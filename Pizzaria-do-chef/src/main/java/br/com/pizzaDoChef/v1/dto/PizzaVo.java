package br.com.pizzaDoChef.v1.dto;

import java.io.Serializable;
import java.util.Objects;

public class PizzaVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String title;
	
	private String image;
	
	private double price;
	
	private String descripition;
	
	public String getDescripition() {
		return descripition;
	}
	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public double getPrice() {
		return price;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripition, id, image, price, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaVo other = (PizzaVo) obj;
		return Objects.equals(descripition, other.descripition) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title);
	}

	
	
}
