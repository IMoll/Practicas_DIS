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
		
		ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
		
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		Almacen almacen = new Almacen( clientes, productos, pedidos);
		
		int num_productos = 0;
		java.io.BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		Calendar fecha_estimada = Calendar.getInstance();
		
		while(opcion != 0) {
			System.out.println("1:Realizar un nuevo Pedido");
			System.out.println("2:Recuperar Pedido");
			System.out.println("3:Guardar Pedidos");
			System.out.println("0:Salir");
			opcion = Integer.parseUnsignedInt(in.readLine());	
			//Realizar un nuevo Pedido
			if(opcion == 1) {
				RealizarNuevoPedido(in, num_productos, fecha_estimada, almacen);
			}
			
			//Recuperar Pedido
			else if(opcion == 2) {
				RecuperarPedido();
			}
			
			//Guardar Pedido
			else if(opcion == 3) {
	//			Almacen almacen = new Almacen(clientes,productos, pedidos);
	//			GuardarPedidos();
				JAXBContext contextObj;
				
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
			
			else if(opcion == 0) {
				System.out.println("Hasta luego");
			}			
		}
	}
	
	public static void RealizarNuevoPedido(BufferedReader in, int num_productos, Calendar fecha_estimada, Almacen almacen) throws NumberFormatException, IOException
	{
		System.out.println("Generando nuevo pedido");
		almacen.getPedidos().add(new Pedidos());
//		Pedidos pedido_aux = new Pedidos();
		System.out.println("Cuantos productos va a pedir?");
		num_productos = Integer.parseUnsignedInt(in.readLine());	
		
		for(int i = 0; i < num_productos; i++) {					
		//	pedido_aux.products.add(new Producto());
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.add(new Producto());
			System.out.println("Introduzca el codigo del producto");
//			pedido_aux.products.get(i).setCode(Integer.parseInt(in.readLine()));
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setCode(Integer.parseInt(in.readLine()));
			System.out.println("Introduzca el nombre del producto");
//			pedido_aux.products.get(i).setName(in.readLine());
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setName(in.readLine());
			System.out.println("Introduzca la descripcion del producto");
//			pedido_aux.products.get(i).setDescription(in.readLine());
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setDescription(in.readLine());
			System.out.println("Esta en stock?\n0:NO\t1:SI");
//			pedido_aux.products.get(i).setStock(Integer.parseUnsignedInt(in.readLine()));
			almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setStock(Integer.parseUnsignedInt(in.readLine()));
			
			//Control errores while
			//pedido_aux.products.get(i).getStock()
			if(almacen.getPedidos().get(almacen.getPedidos().size() -1 ).products.get(i).getStock() == 1) {
//				pedido_aux.products.get(i).setLocalizacion(new Localizacion());
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).setLocalizacion(new Localizacion());
				System.out.println("Esta en el pasillo?\n0:NO\t1:SI");
//				pedido_aux.products.get(i).getLocalizacion().setHall(Integer.parseUnsignedInt(in.readLine()));
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setHall(Integer.parseUnsignedInt(in.readLine()));
				System.out.println("Esta en una estanteria?\n0:NO\t1:SI");
//				pedido_aux.products.get(i).getLocalizacion().setShelf(Integer.parseUnsignedInt(in.readLine()));
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setShelf(Integer.parseUnsignedInt(in.readLine()));				
				System.out.println("Esta en un estante?\n0:NO\t1:SI");
//				pedido_aux.products.get(i).getLocalizacion().setShelving(Integer.parseUnsignedInt(in.readLine()));
				almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).getLocalizacion().setShelving(Integer.parseUnsignedInt(in.readLine()));
				
			}else {
//				pedido_aux.products.get(i).setLocalizacion(new Localizacion());
				almacen.getPedidos().get(almacen.getPedidos().size()-1).products.get(i).setLocalizacion(new Localizacion());
//				pedido_aux.products.get(i).getLocalizacion().setHall(0);
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setHall(0);
//				pedido_aux.products.get(i).getLocalizacion().setShelf(0);
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setShelf(0);
//				pedido_aux.products.get(i).getLocalizacion().setShelving(0);
				almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).getLocalizacion().setShelving(0);
			}
			
			System.out.println("Esta Pendiente?\n0:NO\t1:SI");
//			pedido_aux.products.get(i).setPending(Integer.parseUnsignedInt(in.readLine()));
			almacen.getPedidos().get(almacen.getPedidos().size() -1).products.get(i).setPending(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Cantidad?");
//			pedido_aux.quantity.add(Integer.parseUnsignedInt(in.readLine()));
			almacen.getPedidos().get(almacen.getPedidos().size()-1).quantity.add(Integer.parseUnsignedInt(in.readLine()));
			//Anyadir Producto					
//			productos.add(pedido_aux.getProducts().get(i));
		}

		System.out.println("Introduzca el nombre del cliente");
//		pedido_aux.setClient(new Clientes());	
		almacen.getClientes().add(new Clientes());
//		pedido_aux.getClient().setName(in.readLine());
		almacen.getClientes().get(almacen.getClientes().size()-1).setName(in.readLine());
		System.out.println("Introduzca los apellidos del cliente");
//		pedido_aux.getClient().setSurname(in.readLine());
		almacen.getClientes().get(almacen.getClientes().size() -1).setSurname(in.readLine());
		System.out.println("Introduzca el email del cliente");
//		pedido_aux.getClient().setEmail(in.readLine());
		almacen.getClientes().get(almacen.getClientes().size() -1).setEmail(in.readLine());
		System.out.println("Introduzca el telefono de contacto");
//		pedido_aux.getClient().setPhone_number(in.readLine());
		almacen.getClientes().get(almacen.getClientes().size() -1).setPhone_number(in.readLine());
		System.out.println("Introduzca la direccion del cliente");
//		pedido_aux.getClient().setDireccion(new Direccion());
		almacen.getClientes().get(almacen.getClientes().size() -1).setDireccion(new Direccion());
		System.out.println("Introduzca la calle");
//		pedido_aux.getClient().getDireccion().setStreet(in.readLine());
		almacen.getClientes().get(almacen.getClientes().size() -1).getDireccion().setStreet(in.readLine());
		System.out.println("Numero de la calle");
//		pedido_aux.getClient().getDireccion().setNumber(Integer.parseUnsignedInt(in.readLine()));
		almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion().setNumber(Integer.parseUnsignedInt(in.readLine()));
		System.out.println("Codigo postal");
//		pedido_aux.getClient().getDireccion().setPostal_code(Integer.parseUnsignedInt(in.readLine()));
		almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion().setPostal_code(Integer.parseUnsignedInt(in.readLine()));
		System.out.println("Poblacion");
//		pedido_aux.getClient().getDireccion().setPopulation(in.readLine());
		almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion().setPopulation(in.readLine());
		System.out.println("Pais");
//		pedido_aux.getClient().getDireccion().setCountry(in.readLine());
		almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion().setPopulation(in.readLine());
						
		//AnyadirCliente
//clientes.add(pedido_aux.getClient());
		almacen.getPedidos().get(almacen.getPedidos().size() -1).setClient(almacen.getClientes().get(almacen.getClientes().size()-1));
		
		
		System.out.println("Es la misma direccion que la direccion de entrega?\n0:NO\t1:SI");
		int respuesta = Integer.parseUnsignedInt(in.readLine());
		if(respuesta == 0) {
//			pedido_aux.setDelivery_address(new Direccion());
			almacen.getPedidos().get(almacen.getPedidos().size()-1).setDelivery_address(new Direccion());
			System.out.println("Introduzca la calle");
//			pedido_aux.getDelivery_address().setStreet(in.readLine());
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setStreet(in.readLine());
			System.out.println("Numero de la calle");
//			pedido_aux.getDelivery_address().setNumber(Integer.parseUnsignedInt(in.readLine()));
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setNumber(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Codigo postal");
//			pedido_aux.getDelivery_address().setPostal_code(Integer.parseUnsignedInt(in.readLine()));
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setPostal_code(Integer.parseUnsignedInt(in.readLine()));
			System.out.println("Poblacion");
//			pedido_aux.getDelivery_address().setPopulation(in.readLine());
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setPopulation(in.readLine());
			System.out.println("Pais");
//			pedido_aux.getDelivery_address().setCountry(in.readLine());
			almacen.getPedidos().get(almacen.getPedidos().size()-1).getDelivery_address().setCountry(in.readLine());
		}
		else if(respuesta == 1) {
//			pedido_aux.setDelivery_address(pedido_aux.getClient().getDireccion());
			almacen.getPedidos().get(almacen.getPedidos().size()-1).setDelivery_address(almacen.getClientes().get(almacen.getClientes().size()-1).getDireccion());
		}
		System.out.println("Destinatario");
//		pedido_aux.setDestinatario(in.readLine());
//		pedido_aux.setEstimated_date(fecha_estimada.getTime());
		System.out.println("Pedido generado bien");
								
//		pedidos.add(pedido_aux);
	}
	
	public static void RecuperarPedido() {
		
	}

	public static void GuardarPedidos() {
		
	}

}
