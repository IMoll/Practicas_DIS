package empresa_almacen;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Pedidos {

	ArrayList<Producto> products = new ArrayList<Producto>();
	ArrayList<Integer> quantity = new ArrayList<Integer>();
	private Direccion delivery_address;
	private Clientes client;
	private String destinatario;
	private Date estimated_date = new Date();
	
	
	public Pedidos() {
		
	}
	
	public Pedidos(ArrayList<Producto> products, ArrayList<Integer> quantity, Direccion delivery_address, Clientes client, Date estimated_date) {
		
		this.products = products;
		this.quantity = quantity;
		this.delivery_address = delivery_address;
		this.client = client;
		this.estimated_date = estimated_date;
	}
	
}
