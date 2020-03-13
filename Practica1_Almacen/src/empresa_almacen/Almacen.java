package empresa_almacen;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAttribute;  
import javax.xml.bind.annotation.XmlElement;  
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Almacen {
	
	private ArrayList<Clientes> clientes = new ArrayList<Clientes>();
	private ArrayList<Producto> products = new ArrayList<Producto>();
	private ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
	
	@XmlElement
	public ArrayList<Clientes> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Clientes> clientes) {
		this.clientes = clientes;
	}

	@XmlElement
	public ArrayList<Producto> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Producto> products) {
		this.products = products;
	}

	@XmlElement
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
