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
