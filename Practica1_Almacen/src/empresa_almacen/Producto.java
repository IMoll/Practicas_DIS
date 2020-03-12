package empresa_almacen;

public class Producto {
	
	private int code;
	private String name;
	private String description;
	private int stock;
	private Localizacion localizacion;
	private int pending;
	
	
	public Producto() {
		
	}
	
	public Producto(int code, String name, String description, int stock, Localizacion localizacion, int pending) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.localizacion = localizacion;
		this.pending = pending;
	}
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	
	public Localizacion getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}

	
	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}



}
