package empresa_almacen;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
	
	@XmlElement
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@XmlElement
	public Localizacion getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}

	@XmlElement
	public int getPending() {
		return pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	/*------------------------------*/
	@Override
	public String toString() {
		return "\n" + "Code = " + code + "\n" + "Name = " + name +"\n" + "Description = " + description + "\n"+"Stock = " + stock
				+"\n"+"Localizacion = " + localizacion + "\n"+"Pending = " + pending + "\n------------------------------"+"\n";
	}									/*localizacion.toString()*/
	
	
	
}
