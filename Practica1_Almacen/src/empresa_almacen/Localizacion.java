package empresa_almacen;

import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Localizacion {

	private int hall;
	private int shelving;
	private int shelf;
	
	public Localizacion() {
		
	}
	public Localizacion(int hall, int shelving, int shelf) {
		this.hall = hall;
		this.shelving = shelving;
		this.shelf = shelf;
	}
	
	
	@XmlElement
	public int getHall() {
		return hall;
	}
	
	public void setHall(int hall) {
		this.hall = hall;
	}
	
	@XmlElement
	public int getShelving() {
		return shelving;
	}
	
	public void setShelving(int shelving) {
		this.shelving = shelving;
	}
	
	@XmlElement
	public int getShelf() {
		return shelf;
	}
	
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
	
	/*----------------------------------------*/
	
	@Override
	public String toString() {
		return "\n[\t" + "Hall = " + hall + "\n\t" + "Shelving = " + shelving + "\n\t"+ "Shelf = " + shelf + "\n" +"]";
	}
	
	
}
