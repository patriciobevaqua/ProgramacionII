package programacion2;

import ejercicios.TrabajoPractico1;
import ejercicios.TrabajoPractico2;
import ejercicios.TrabajoPractico3;
import java.util.List;
import modelos.DetallePedido;
import modelos.Mercaderia;
import modelos.Pedido;

public class Programacion2 {

    public static void main(String[] args) throws Exception {
        
        TrabajoPractico1 practico1=new TrabajoPractico1();
        
        practico1.ejercicio3();
        practico1.ejercicio4();
        
        TrabajoPractico2 practico2 = new TrabajoPractico2();
        practico2.ejercicio1();
        practico2.ejercicio2();
        practico2.ejercicio3();
        practico2.ejercicio4();
        practico2.ejercicio5();
        //practico2.ejercicio6();
        practico2.dividir(2, 0);
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

}
