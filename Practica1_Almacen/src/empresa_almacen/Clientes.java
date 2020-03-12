package empresa_almacen;

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
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}


}
