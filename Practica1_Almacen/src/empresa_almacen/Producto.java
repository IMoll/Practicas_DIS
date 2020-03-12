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


}
