package empresa_almacen;

import java.util.ArrayList;

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
	
	
	/* No necesita getters y setters por que solo lo usaremos los constructores, 
	 * esta es la clase que sera la raiz del xml */
	

}
