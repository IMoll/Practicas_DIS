package empresa_almacen;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class main {

	public static void main(String[] args) throws IOException {
		int opcion = 1;
		String leido = "";
		ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
		
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		int num_productos = 0;
		java.io.BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		Calendar fecha_estimada = Calendar.getInstance();
		
		while(opcion != 0) {
			System.out.println("1:Realizar un nuevo Pedido");
			System.out.println("2:Recuperar Pedido");
			System.out.println("3:Guardar Pedidos");
			System.out.println("4:Insertar Producto");
			System.out.println("5:Insertar Cliente");
			System.out.println("0:Salir");
			//Leemos por pantalla
			leido = in.readLine();
			while(!tryParseInt(leido)) {
				System.out.println("Introduzca un valor numérico, por favor.");
				leido = in.readLine();
			}
			opcion = Integer.parseUnsignedInt(leido);	
			//Realizar un nuevo Pedido
			if(opcion == 1) {
				RealizarNuevoPedido(in, num_productos, fecha_estimada, pedidos, clientes, productos);
			}
			
			//Recuperar Pedido
			else if(opcion == 2) {
				RecuperarPedido();
			}
			
			//Guardar Pedido
			else if(opcion == 3) {
				
				JAXBContext contextObj;
				Almacen almacen = new Almacen(clientes,productos, pedidos);
				try {
					contextObj = JAXBContext.newInstance(Almacen.class);
				    Marshaller marshallerObj = contextObj.createMarshaller();  
				    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
				    marshallerObj.marshal(almacen, new FileOutputStream("almacen.xml"));  
					
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  

			}

			else if(opcion == 4) {
				CrearProducto(in, productos);
			}
			
			else if(opcion == 5) {
				CrearCliente(in, clientes);
			}
			
			else if(opcion == 0) {
				System.out.println("Hasta luego");
			}			
		}
	}
	
	public static void RealizarNuevoPedido(BufferedReader in, int num_productos, Calendar fecha_estimada, ArrayList<Pedidos> pedidos, ArrayList<Clientes> clientes, ArrayList<Producto> productos) throws NumberFormatException, IOException
	{
		System.out.println("Generando nuevo pedido");
		Pedidos pedido_aux = new Pedidos();
		System.out.println("Cuantos productos va a pedir?");
		num_productos = Integer.parseUnsignedInt(in.readLine());	
		
		for(int i = 0; i < num_productos; i++) {					
			pedido_aux.products.add(new Producto());
			System.out.println("Introduzca el codigo del producto");
			pedido_aux.products.get(i).setCode(Integer.parseInt(in.readLine()));
			System.out.println("Introduzca el nombre del producto");
			pedido_aux.products.get(i).setName(in.readLine());
			System.out.println("Introduzca la descripcion del producto");
			pedido_aux.products.get(i).setDescription(in.readLine());
			System.out.println("Esta en stock?\n0:NO\t1:SI");
			pedido_aux.products.get(i).setStock(Integer.parseUnsignedInt(in.readLine()));
			
			//Control errores while
			if(pedido_aux.products.get(i).getStock() == 1) {
				pedido_aux.products.get(i).setLocalizacion(new Localizacion());
				System.out.println("Esta en el pasillo?\n0:NO\t1:SI");
				pedido_aux.products.get(i).getLocalizacion().setHall(Integer.parseUnsignedInt(in.readLine()));
				System.out.println("Esta en una estanteria?\n0:NO\t1:SI");
				pedido_aux.products.get(i).getLocalizacion().setShelf(Integer.parseUnsignedInt(in.readLine()));
				System.out.println("Esta en un estante?\n0:NO\t1:SI");
				pedido_aux.products.get(i).getLocalizacion().setShelving(Integer.parseUnsignedInt(in.readLine()));						
			}else {
				pedido_aux.products.get(i).setLocalizacion(new Localizacion());
				pedido_aux.products.get(i).getLocalizacion().setHall(0);
				pedido_aux.products.get(i).getLocalizacion().setShelf(0);
				pedido_aux.products.get(i).getLocalizacion().setShelving(0);
			}
			
			System.out.println("Esta Pendiente?\n0:NO\t1:SI");
			pedido_aux.products.get(i).setPending(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Cantidad?");
			pedido_aux.quantity.add(Integer.parseUnsignedInt(in.readLine()));
			//Anyadir Producto					
			productos.add(pedido_aux.getProducts().get(i));
		}

		System.out.println("Introduzca el nombre del cliente");
		pedido_aux.setClient(new Clientes());		
		pedido_aux.getClient().setName(in.readLine());
		System.out.println("Introduzca los apellidos del cliente");
		pedido_aux.getClient().setSurname(in.readLine());
		System.out.println("Introduzca el email del cliente");
		pedido_aux.getClient().setEmail(in.readLine());
		System.out.println("Introduzca el telefono de contacto");
		pedido_aux.getClient().setPhone_number(in.readLine());
		System.out.println("Introduzca la direccion del cliente");
		pedido_aux.getClient().setDireccion(new Direccion());
		System.out.println("Introduzca la calle");
		pedido_aux.getClient().getDireccion().setStreet(in.readLine());
		System.out.println("Numero de la calle");
		pedido_aux.getClient().getDireccion().setNumber(Integer.parseUnsignedInt(in.readLine()));
		System.out.println("Codigo postal");
		pedido_aux.getClient().getDireccion().setPostal_code(Integer.parseUnsignedInt(in.readLine()));
		System.out.println("Poblacion");
		pedido_aux.getClient().getDireccion().setPopulation(in.readLine());
		System.out.println("Pais");
		pedido_aux.getClient().getDireccion().setCountry(in.readLine());
						
		//AnyadirCliente
		clientes.add(pedido_aux.getClient());
		
		
		System.out.println("Es la misma direccion que la direccion de entrega?\n0:NO\t1:SI");
		int respuesta = Integer.parseUnsignedInt(in.readLine());
		if(respuesta == 0) {
			pedido_aux.setDelivery_address(new Direccion());
			System.out.println("Introduzca la calle");
			pedido_aux.getDelivery_address().setStreet(in.readLine());
			System.out.println("Numero de la calle");
			pedido_aux.getDelivery_address().setNumber(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Codigo postal");
			pedido_aux.getDelivery_address().setPostal_code(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Poblacion");
			pedido_aux.getDelivery_address().setPopulation(in.readLine());
			System.out.println("Pais");
			pedido_aux.getDelivery_address().setCountry(in.readLine());
		}
		else if(respuesta == 1) {
			pedido_aux.setDelivery_address(pedido_aux.getClient().getDireccion());
		}
		System.out.println("Destinatario");
		pedido_aux.setDestinatario(in.readLine());
		pedido_aux.setEstimated_date(fecha_estimada.getTime());
		System.out.println("Pedido generado bien");
								
		pedidos.add(pedido_aux);
	}
	
	public static void RecuperarPedido() {
		
	}

	public static void GuardarPedidos() {
		
	}
	
	public static void CrearProducto(BufferedReader in, ArrayList<Producto> productos) throws NumberFormatException, IOException {
		Producto producto_aux = new Producto();	
		String leido = "";
		
		System.out.println("Introduzca el codigo del producto");
		leido = in.readLine();
		while(!tryParseInt(leido)) {
			System.out.println("Introduzca el codigo del producto");
			leido = in.readLine();
		}
		producto_aux.setCode(Integer.parseInt(leido));
		
		System.out.println("Introduzca el nombre del producto");
		producto_aux.setName(in.readLine());
		
		System.out.println("Introduzca la descripcion del producto");
		producto_aux.setDescription(in.readLine());
		
		System.out.println("Esta en stock?\n0:NO\t1:SI");
		leido = in.readLine();
		while(!tryParseInt(leido)) {
			System.out.println("Esta en stock?\n0:NO\t1:SI");
			leido = in.readLine();
		}
		producto_aux.setStock(Integer.parseUnsignedInt(leido));
		
		//Control errores while
		if(producto_aux.getStock() == 1) {
			producto_aux.setLocalizacion(new Localizacion());
			
			System.out.println("Esta en el pasillo?\n0:NO\t1:SI");
			leido = in.readLine();
			while(!tryParseInt(leido)) {
				System.out.println("Esta en el pasillo?\n0:NO\t1:SI");
				leido = in.readLine();
			}
			producto_aux.getLocalizacion().setHall(Integer.parseUnsignedInt(leido));
			
			System.out.println("Esta en una estanteria?\n0:NO\t1:SI");
			leido = in.readLine();
			while(!tryParseInt(leido)) {
				System.out.println("Esta en una estanteria?\n0:NO\t1:SI");
				leido = in.readLine();
			}
			producto_aux.getLocalizacion().setShelf(Integer.parseUnsignedInt(leido));
			
			System.out.println("Esta en un estante?\n0:NO\t1:SI");
			leido = in.readLine();
			while(!tryParseInt(leido)) {
				System.out.println("Esta en un estante?\n0:NO\t1:SI");
				leido = in.readLine();
			}
			producto_aux.getLocalizacion().setShelving(Integer.parseUnsignedInt(leido));
			
		}
		else {
			producto_aux.setLocalizacion(new Localizacion());
			producto_aux.getLocalizacion().setHall(0);
			producto_aux.getLocalizacion().setShelf(0);
			producto_aux.getLocalizacion().setShelving(0);
		}
		
		System.out.println("Esta Pendiente?\n0:NO\t1:SI");
		leido = in.readLine();
		while(!tryParseInt(leido)) {
			System.out.println("Esta Pendiente?\n0:NO\t1:SI");
			leido = in.readLine();
		}
		producto_aux.setPending(Integer.parseUnsignedInt(leido));
		
		//Anyadir Producto					
		productos.add(producto_aux);
	}
	
	public static void CrearCliente(BufferedReader in,ArrayList<Clientes> clientes) throws IOException {

		Clientes cliente_aux = new Clientes();	
		String leido = "";
		
		System.out.println("Introduzca el nombre del cliente");
		cliente_aux.setName(in.readLine());
		
		System.out.println("Introduzca los apellidos del cliente");
		cliente_aux.setSurname(in.readLine());
		
		System.out.println("Introduzca el email del cliente");
		cliente_aux.setEmail(in.readLine());
		
		System.out.println("Introduzca el telefono de contacto");
		cliente_aux.setPhone_number(in.readLine());
		
		System.out.println("Introduzca la direccion del cliente");
		cliente_aux.setDireccion(new Direccion());
		
		System.out.println("Introduzca la calle");
		cliente_aux.getDireccion().setStreet(in.readLine());
		
		System.out.println("Numero de la calle");
		leido = in.readLine();
		while(!tryParseInt(leido)) {
			System.out.println("Numero de la calle");
			leido = in.readLine();
		}
		cliente_aux.getDireccion().setNumber(Integer.parseUnsignedInt(leido));
		
		System.out.println("Codigo postal");
		leido = in.readLine();
		while(!tryParseInt(leido)) {
			if(!tryParseInt(leido)) {
				System.out.println("Codigo postal");
				leido = in.readLine();
			}
		}
		cliente_aux.getDireccion().setPostal_code(Integer.parseUnsignedInt(leido));
		
		System.out.println("Poblacion");
		cliente_aux.getDireccion().setPopulation(in.readLine());
		
		System.out.println("Pais");
		cliente_aux.getDireccion().setCountry(in.readLine());
		
		//Insertamos al cliente.
		clientes.add(cliente_aux);
	}
	
	//Control de errores. Es un entero unsigned?
	public static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseUnsignedInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
}
