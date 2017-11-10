 package ejercicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelos.Cliente;
import modelos.DetallePedido;
import modelos.Mercaderia;
import modelos.Pedido;

/**
 * Modelos
 * @author arielp
 */
public class TrabajoPractico3 {
    public static void main(String[] args) {  //creo el psvm para validar los metodos de la clase
        TrabajoPractico3 practico = new TrabajoPractico3();

        Pedido pedido;

        pedido = practico.ejercicio2();
        practico.ejercicio3();

        System.out.println("Nombre Cliente");
        System.out.println(pedido.getCliente().getNombre());

        System.out.println("Mercaderia 2");
        System.out.println(pedido.getDetalles().get(1).getMercaderia().getNombre());

        List<DetallePedido> listaDetalles = pedido.getDetalles();
        DetallePedido detallePedido2 = listaDetalles.get(1);
        Mercaderia mercaderia = detallePedido2.getMercaderia();

        System.out.println("Mercaderia 2 - Ordenada");
        System.out.println(mercaderia.getNombre());

        System.out.println("Cantidad de Botellas");
        System.out.println(pedido.getDetalles().get(1).getCantidad());

        //practico.ejercicio2();
    }
    public void ejercicio1() {
        //se crea un cliente, cliente1, se le cargan datos
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Leonel Messi");
        cliente1.setCuit("20-30059658-5");
        cliente1.setEmail("leonel@gmail.com");
        cliente1.setTipo("Delantero");
        
        // Mostrar el Nombre y el Email
        System.out.println("Nombre: " + cliente1.getNombre());
        System.out.println("Email: " + cliente1.getEmail());
    }
    
    /**
     * 1 Pedido
     * 1 Cliente
     * 2 Detalles de Pedidos y cada uno:
     * * 1 Mercaderia
     * * Cantidad
     * @return Pedido
     */
    public Pedido ejercicio2() {  
        Cliente cliente = new Cliente(); //Creo cliente
        cliente.setNombre("Jorge Gomez");
        cliente.setEmail("jorge@gmail.com");
        cliente.setCuit("20-30059658-5");
        
        Mercaderia mercaderia1 = new Mercaderia(); //Creo una mercadería
        mercaderia1.setCodigo("COD001");
        mercaderia1.setNombre("Yerba");
        mercaderia1.setValor(30);
        mercaderia1.setPeso(0.5f);
        
        Mercaderia mercaderia2 = new Mercaderia();  //Creo otra mercaderia
        mercaderia2.setCodigo("COD002");
        mercaderia2.setNombre("Fernet");
        mercaderia2.setValor(150);
        mercaderia2.setPeso(1);
        
        DetallePedido detalle1 = new DetallePedido(); // creo un detalle de peio
        detalle1.setMercaderia(mercaderia1);  //guardo la mercderia 
        detalle1.setCantidad(4);  // indico cantidad de esa mercadria
        
        DetallePedido detalle2 = new DetallePedido(); //Creo otro detalle e pedido
        detalle2.setMercaderia(mercaderia2);
        detalle2.setCantidad(6);
        
        List<DetallePedido> listaDetalles = new ArrayList();  //creo una lista de detalle de pedido que va a incorporarse al pedido
        listaDetalles.add(detalle1);  //agrego a la lista el detalle de pedido
        listaDetalles.add(detalle2); //agrego a la lista el detalle de pedido
        
        DetallePedido detalle = listaDetalles.get(1);  //creo un detalle y le asigno los datos de un elemento de la lista de detalles (en la posicion 1)
        
        // Ejemplo de lista sin tipo  (sin tipo de dato)
        List listaDetalles2 = new ArrayList();
        listaDetalles2.add(detalle1);
        listaDetalles2.add("Cualquier cosa"); //se puede adicionar cualquier cosa porque no tiene tipo de dato la lista
        DetallePedido detalleEnLista = (DetallePedido) listaDetalles2.get(0);
        
        
        Pedido pedido1 = new Pedido();
        pedido1.setCliente(cliente);
        pedido1.setFecha(new Date());
        pedido1.setDetalles(listaDetalles);
        
        
        return pedido1;
        
    }
    
     /**
     * LLamar al metodo del ejercicio 2 para crear un pedido completo
     * y agregar un nuevo detalle que incluya una mercaderia nueva
     */
    public void ejercicio3() {
        Pedido pedidoEjercicio2= this.ejercicio2(); //este es el metodo ejercicio2() que devuelve un pedido
        Mercaderia mercaderiaNueva= new Mercaderia();
        mercaderiaNueva.setCodigo("C004");
        mercaderiaNueva.setNombre("Azucar");
        
        //Crear un detalle con la mercaderia anterior
        DetallePedido pedido3= new DetallePedido();
        pedido3.setMercaderia(mercaderiaNueva);
        pedido3.setCantidad(3);
        
        pedidoEjercicio2.getDetalles().add(pedido3);
             
        System.out.println(""+ pedidoEjercicio2.getDetalles().get(2).getCantidad());
        System.out.println(""+ pedidoEjercicio2.getDetalles().get(2).getMercaderia().getNombre());
        
        //cambiar la cantidad del pedido uno
        pedidoEjercicio2.getDetalles().get(0).setCantidad(17);
                
        System.out.println("Nueva Cantidad: "+ pedidoEjercicio2.getDetalles().get(0).getCantidad());
        
        
    }

    
    
}
