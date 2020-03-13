package empresa_almacen;

public class Direccion {
	
	private String street;
	private int number;
	private int postal_code;
	private String population;
	private String country;
	
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	public int getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}

	
	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public Direccion() {
		
	}
	
	public Direccion(String street, int number, int postal_code, String population, String country) {
		
		this.street = street;
		this.number = number;
		this.postal_code = postal_code;
		this.population = population;
		this.country = country;
		
	}

}
