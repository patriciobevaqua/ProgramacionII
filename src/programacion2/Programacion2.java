package programacion2;

import ejercicios.TrabajoPractico1;
import ejercicios.TrabajoPractico2;
import ejercicios.TrabajoPractico3;
import excepciones.ExcepcionBevaqua;
import java.sql.Connection;
import java.util.List;
import modelos.DetallePedido;
import modelos.Mercaderia;
import modelos.Pedido;
import servicios.ConexionesBaseDeDatos;

public class Programacion2 {

    public static void main(String[] args) throws Exception {
        //clase 02-11-2017 Ejemplo de cómo usar el método insertarMercadería()
        ConexionesBaseDeDatos conexiones = new ConexionesBaseDeDatos();
        Mercaderia mercaderia = new Mercaderia();
        mercaderia.setCodigo("AA05");
        mercaderia.setNombre("azucar negra");
        mercaderia.setPeso(1);
        mercaderia.setValor(24);

        conexiones.insertarMercaderia(mercaderia);

        // cómo verificar la conexión a la base de datos:
        ConexionesBaseDeDatos c = new ConexionesBaseDeDatos();
        c.getConexionMysql();
        
        //03-11-2017 crear un pedido, utilizar el metodo ejercicio2() que trae un pedido
        TrabajoPractico3 practico3= new TrabajoPractico3();
        
        DetallePedido detalle8=new DetallePedido();
        detalle8.setMercaderia(mercaderia);
        detalle8.setCantidad(10);
        Pedido pedido1=practico3.ejercicio2(); //ver qué hace acá
        pedido1.getDetalles().add(detalle8);
        //obtener el nombre de la mercaderia del detalle 2
        System.out.println("nombre de la mercaderia del detalle 2: "
                +pedido1.getDetalles().get(2).getMercaderia().getNombre());
        
        
        
    //        TrabajoPractico1 ejercicio1= new TrabajoPractico1();
        //ejercicio1.ejercicio3();
        TrabajoPractico3 ejercicio4=new TrabajoPractico3();
        ejercicio4.ejercicio4(2);

    
    }

}
