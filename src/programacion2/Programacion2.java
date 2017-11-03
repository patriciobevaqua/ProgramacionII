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

    }

}
