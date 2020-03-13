package empresa_almacen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

		Almacen almacen = new Almacen( new ArrayList<Clientes>(), new ArrayList<Producto>(), new ArrayList<Pedidos>());
		
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
				System.out.println("Introduzca un valor num�rico, por favor.");
				leido = in.readLine();
			}
			opcion = Integer.parseUnsignedInt(leido);	
			
			//Realizar un nuevo Pedido
			if(opcion == 1) {
				RealizarNuevoPedido(in, num_productos, fecha_estimada, almacen);
			}
			
			//Recuperar Pedido
			
			else if(opcion == 2) {
				RecuperarPedido();
			}
			
			
			else if(opcion == 3) {
				if(almacen.getClientes().size() + almacen.getPedidos().size() + almacen.getProducts().size() == 0) {
					System.out.println("No hay nada que guardar");
				}
				else{
					GuardarPedidos(almacen);
				}
			}

			else if(opcion == 4) {
				CrearProducto(in, almacen.getProducts());
			}
			
			else if(opcion == 5) {
				CrearCliente(in, almacen.getClientes());
			}
			
			else if(opcion == 0) {
				System.out.println("Hasta luego");
			}			
		}
	}
	
	public static void RealizarNuevoPedido(BufferedReader in, int num_productos, Calendar fecha_estimada, Almacen almacen) throws NumberFormatException, IOException
	{
		System.out.println("Generando nuevo pedido");
		almacen.getPedidos().add(new Pedidos());

		System.out.println("Cuantos productos va a pedir?");
		num_productos = Integer.parseUnsignedInt(in.readLine());			
		for(int i = 0; i < num_productos; i++) {					
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.add(new Producto());
			System.out.println("Introduzca el codigo del producto");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setCode(Integer.parseInt(in.readLine()));
			System.out.println("Introduzca el nombre del producto");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setName(in.readLine());
			System.out.println("Introduzca la descripcion del producto");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setDescription(in.readLine());
			System.out.println("Esta en stock?\n0:NO\t1:SI");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setStock(Integer.parseUnsignedInt(in.readLine()));
			
			//Control errores while
			if(almacen.getPedidos().get(almacen.getPedidos().size() -1 ).products.get(i).getStock() == 1) {
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).setLocalizacion(new Localizacion());
				System.out.println("Esta en el pasillo?\n0:NO\t1:SI");
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setHall(Integer.parseUnsignedInt(in.readLine()));
				System.out.println("Esta en una estanteria?\n0:NO\t1:SI");
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setShelf(Integer.parseUnsignedInt(in.readLine()));				
				System.out.println("Esta en un estante?\n0:NO\t1:SI");
				almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).getLocalizacion().setShelving(Integer.parseUnsignedInt(in.readLine()));
				
			}else {
				almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setLocalizacion(new Localizacion());
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setHall(0);
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setShelf(0);
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setShelving(0);
			}
			
			System.out.println("Esta Pendiente?\n0:NO\t1:SI");
			almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).setPending(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Cantidad?");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).quantity.add(Integer.parseUnsignedInt(in.readLine()));
			almacen.getProducts().add((almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i)));
		}

		System.out.println("Introduzca el nombre del cliente");
		almacen.getClientes().add(new Clientes());
		almacen.getClientes().get(almacen.getClientes().size()-1).setName(in.readLine());
		System.out.println("Introduzca los apellidos del cliente");
		almacen.getClientes().get(almacen.getClientes().size() -1).setSurname(in.readLine());
		System.out.println("Introduzca el email del cliente");
		almacen.getClientes().get(almacen.getClientes().size() -1).setEmail(in.readLine());
		System.out.println("Introduzca el telefono de contacto");
		almacen.getClientes().get(almacen.getClientes().size() -1).setPhone_number(in.readLine());
		System.out.println("Introduzca la direccion del cliente");
		almacen.getClientes().get(almacen.getClientes().size() -1).setDireccion(new Direccion());
		System.out.println("Introduzca la calle");
		almacen.getClientes().get(almacen.getClientes().size() -1).getDireccion().setStreet(in.readLine());
		System.out.println("Numero de la calle");
		almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion().setNumber(Integer.parseUnsignedInt(in.readLine()));
		System.out.println("Codigo postal");
		almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion().setPostal_code(Integer.parseUnsignedInt(in.readLine()));
		System.out.println("Poblacion");
		almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion().setPopulation(in.readLine());
		System.out.println("Pais");
		almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion().setPopulation(in.readLine());
						
		almacen.getPedidos().get(almacen.getPedidos().size() -1).setClient(almacen.getClientes().get(almacen.getClientes().size()-1));
		
		
		System.out.println("Es la misma direccion que la direccion de entrega?\n0:NO\t1:SI");
		int respuesta = Integer.parseUnsignedInt(in.readLine());
		if(respuesta == 0) {
			almacen.getPedidos().get(almacen.getPedidos().size()-1).setDelivery_address(new Direccion());
			System.out.println("Introduzca la calle");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setStreet(in.readLine());
			System.out.println("Numero de la calle");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setNumber(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Codigo postal");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setPostal_code(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Poblacion");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setPopulation(in.readLine());
			System.out.println("Pais");
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setCountry(in.readLine());
		}
		else if(respuesta == 1) {
			almacen.getPedidos().get(almacen.getPedidos().size()-1).setDelivery_address(almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion());
		}
		System.out.println("Destinatario");
		almacen.getPedidos().get(almacen.getPedidos().size()-1).setDestinatario(in.readLine());

		almacen.getPedidos().get(almacen.getPedidos().size()-1).setEstimated_date(fecha_estimada.getTime());
		System.out.println("Pedido generado bien");
								
	}
	
	public static void RecuperarPedido() {
		
	}

	
	
	public static void GuardarPedidos(Almacen almacen) throws FileNotFoundException {
		
		JAXBContext contextObj;
					
		try {
			contextObj = JAXBContext.newInstance(Almacen.class);
			Marshaller marshallerObj = contextObj.createMarshaller();  
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
			marshallerObj.marshal(almacen, new FileOutputStream("almacen.xml"));  		
			} 
		catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
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
