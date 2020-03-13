package empresa_almacen;

import java.util.ArrayList;

public class Almacen {
	


	private ArrayList<Clientes> clientes = new ArrayList<Clientes>();
	private ArrayList<Producto> products = new ArrayList<Producto>();
	private ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
		
	
	public ArrayList<Clientes> getClientes() {
		return clientes;
	}


	public void setClientes(ArrayList<Clientes> clientes) {
		this.clientes = clientes;
	}


	public ArrayList<Producto> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<Producto> products) {
		this.products = products;
	}


	public ArrayList<Pedidos> getPedidos() {
		return pedidos;
	}


	public void setPedidos(ArrayList<Pedidos> pedidos) {
		
		this.pedidos = pedidos;
	}


		
	public Almacen() {
		super();
	}


	public Almacen(ArrayList<Clientes> clientes, ArrayList<Producto> products, ArrayList<Pedidos> pedidos) {
		super();
		this.clientes = clientes;
		this.products = products;
		this.pedidos = pedidos;
	}
	
	
	
	

}
