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

	public static void GuardarPedidos() {
		
	}

}
