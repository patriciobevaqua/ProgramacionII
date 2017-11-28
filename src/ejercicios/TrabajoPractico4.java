package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelos.DetallePedido;
import modelos.Cliente;

/**
 * Listas con Entidades
 *
 * @author arielp
 */
public class TrabajoPractico4 {

    public static void main(String[] args) {
        TrabajoPractico4 ejercicio3 = new TrabajoPractico4();
        ejercicio3.ejercicio3();

    }

    /** LISTAS
     * Ejemplos de listas y objetos.
     */
    public void ejercicio1() {
        DetallePedido detalle1 = new DetallePedido(); //crea un detalle de peido
        detalle1.setCantidad(7); // indica cantidad de ese detalle de pedido
        DetallePedido detalle2 = new DetallePedido(); //crea un detalle de peido
        detalle2.setCantidad(8); // indica cantidad de ese detalle de pedido
        DetallePedido detalle3 = new DetallePedido(); //crea un detalle de peido
        detalle3.setCantidad(9); // indica cantidad de ese detalle de pedido

        List<DetallePedido> detalles = new ArrayList(); //creo la lista de detalles de pedido
        detalles.add(detalle1); // guarda en la lista
        detalles.add(detalle2);
        detalles.add(detalle3);

        for (int i = 0; i < detalles.size(); i++) { // recorre la lista con un for i para imprimir la cantidad
            DetallePedido detalle = detalles.get(i);
            System.out.println(detalle.getCantidad());
        }

        for (DetallePedido detalle : detalles) {  // recorre la list con un for e para imprimir la cantidad
            System.out.println(detalle.getCantidad());
        }

        Iterator<DetallePedido> iterador = detalles.listIterator();
        while (iterador.hasNext()) {
            DetallePedido detalle = iterador.next();
            System.out.println(detalle.getCantidad());   // o   System.out.println(iterador.next());
            
        }
    }

    /**
     * 1. Crear n clientes y agregarlos a una lista. 
     * 2. Recorrer la lista y
     * mostrar un mensaje para cada cliente de la forma: 
     * Cliente Numero: {id} Nombre: Nombre_{id} Email: email_{id}@gmail.com
     *
     * @param cantidadClientes
     * @return Lista de clientes
     */
    public List<Cliente> ejercicio2(int cantidadClientes) {
        List<Cliente> clientes = new ArrayList();

        for (int i = 1; i <= cantidadClientes; i++) {
            Cliente cliente = new Cliente();
            cliente.setId(i);
            cliente.setNombre("nombre_" + i);
            cliente.setEmail("email_" + i + "gmail.com");

            clientes.add(cliente);
        }

        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("");
        }

        return clientes;
    }

    /**
     * Crear una lista de 20 clientes y mostrar solo los clientes con id impar
     * El ID empieza en 1
     *
     * @param clientes
     */
    public void ejercicio3() {
        List<Cliente> clientes = new ArrayList();
        int cantidadClientes = 20;
        for (int i = 1; i <= cantidadClientes; i++) {
            Cliente cliente = new Cliente();
            cliente.setId(i);
            cliente.setNombre("nombre_" + i);
            cliente.setEmail("email_" + i + "@gmail.com");

            clientes.add(cliente);

        }

        for (int i = 0; i < clientes.size(); i++) {

            Cliente c = clientes.get(i);
            if (c.getId() % 2 != 0) {
                System.out.println(c.getId());
                System.out.println(c.getNombre());
                System.out.println(c.getEmail());
            }
        }
    }
}
