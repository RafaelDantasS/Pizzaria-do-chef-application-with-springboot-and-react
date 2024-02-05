package br.com.pizzaDoChef.v1.dto;

import java.io.Serializable;
import java.util.Objects;

public class ClienteVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String tel;
	private String adress;
	private String cep;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(adress, cep, id, name, tel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteVo other = (ClienteVo) obj;
		return Objects.equals(adress, other.adress) && Objects.equals(cep, other.cep) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(tel, other.tel);
	}
	
	
}
