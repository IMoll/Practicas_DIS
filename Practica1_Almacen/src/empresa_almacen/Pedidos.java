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
	
	
	public ArrayList<Producto> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Producto> products) {
		this.products = products;
	}
	
	
	public ArrayList<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(ArrayList<Integer> quantity) {
		this.quantity = quantity;
	}
	

	public Direccion getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(Direccion delivery_address) {
		this.delivery_address = delivery_address;
	}

	
	public Clientes getClient() {
		return client;
	}

	public void setClient(Clientes client) {
		this.client = client;
	}


	public Date getEstimated_date() {
		return estimated_date;
	}

	public void setEstimated_date(Date estimated_date) {
		this.estimated_date = estimated_date;
	}

	
	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
}
