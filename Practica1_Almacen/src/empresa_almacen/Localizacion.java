package empresa_almacen;

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
	
	public int getHall() {
		return hall;
	}
	
	public void setHall(int hall) {
		this.hall = hall;
	}
	
	public int getShelving() {
		return shelving;
	}
	
	public void setShelving(int shelving) {
		this.shelving = shelving;
	}
	
	public int getShelf() {
		return shelf;
	}
	
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
}
