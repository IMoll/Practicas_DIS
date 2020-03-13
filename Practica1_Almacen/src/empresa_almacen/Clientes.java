package empresa_almacen;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Clientes {
	
	
	private String name;
	private String surname;
	private String email;
	private String phone_number;
	private Direccion direccion;
	
	public Clientes() {
		
	}
	
	public Clientes(String name, String surname, String email, String phone_number, Direccion direccion) {
		
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone_number = phone_number;
		this.direccion = direccion;
		
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@XmlElement
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	@XmlElement
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}
