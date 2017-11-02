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

    }
    public void ejercicio1() {
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
     * Pedido
     * 1 Cliente
     * 2 Detalles de PEdidos
     * * 1 Mercaderia
     * * Cantidad
     * @return Pedido
     */
    public Pedido ejercicio2() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Jorge Gomez");
        cliente.setEmail("jorge@gmail.com");
        cliente.setCuit("20-30059658-5");
        
        Mercaderia mercaderia1 = new Mercaderia();
        mercaderia1.setCodigo("COD001");
        mercaderia1.setNombre("Yerba");
        mercaderia1.setValor(30);
        mercaderia1.setPeso(0.5f);
        
        Mercaderia mercaderia2 = new Mercaderia();
        mercaderia2.setCodigo("COD002");
        mercaderia2.setNombre("Fernet");
        mercaderia2.setValor(150);
        mercaderia2.setPeso(1);
        
        DetallePedido detalle1 = new DetallePedido();
        detalle1.setMercaderia(mercaderia1);
        detalle1.setCantidad(4);
        
        DetallePedido detalle2 = new DetallePedido();
        detalle2.setMercaderia(mercaderia2);
        detalle2.setCantidad(6);
        
        List<DetallePedido> listaDetalles = new ArrayList();
        listaDetalles.add(detalle1);
        listaDetalles.add(detalle2);
        
        DetallePedido detalle = listaDetalles.get(1);
        
        // Ejemplo de lista sin tipo
        List listaDetalles2 = new ArrayList();
        listaDetalles2.add(detalle1);
        listaDetalles2.add("Cualquier cosa");        
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
        
    }

    
    
}
