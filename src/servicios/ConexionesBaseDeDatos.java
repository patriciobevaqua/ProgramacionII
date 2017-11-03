/* para crear una conexion a una base de datos siempre debemos agregar el driver correspondiente 
que se hace desde libraries -> add libraries
Luego, debemos instanciar la conexión
creamos un metodo que devuelve un Connection
usamos las clases 
            MysqlDataSource
            Connection conexion = null;
Nota pab: puedo comparar  con el proyecto programación 2.1
ruta:
C:\Users\Estudio\Documents\NetBeansProjects\TecnicaturaAParra\Programacion2.1
 */
package servicios;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Cliente;
import modelos.Mercaderia;
import modelos.Pedido;

/* Clase 01-09-17 */
public class ConexionesBaseDeDatos {

    public Connection getConexionMysql() {
        MysqlDataSource fuenteDatos = new MysqlDataSource();
        fuenteDatos.setUser("root"); // usuario anterior:programacion2
        fuenteDatos.setPassword(""); //pass anterior: password
        fuenteDatos.setServerName("localhost"); //setear el nombre del servidor
        fuenteDatos.setPort(3306);
        fuenteDatos.setDatabaseName("bd_programacion2");

        Connection conexion = null;
        try {
            conexion = fuenteDatos.getConnection();  //getConnection (es un string) devuelve la conexion viva a la base de datos. si se rompe capturamos la excepcion
            System.out.println("La conexión a Mysql se realizo sin problemas! =) ");
        } catch (SQLException e) {
            System.out.println("Ocurrio un error : " + e.getMessage());
        }

        return conexion;
    }

    /* Clase 01-09-17 */
    /**
     * Imprime los clientes que existen en la base de datos
     *
     * @throws Exception
     */
    public void leerClientes() throws Exception {
        Connection conexion = this.getConexionMysql();
        Statement statement = conexion.createStatement();

        ResultSet rs = statement.executeQuery("select * from clientes"); //executeQuery: LEER (EJECUTAR CONSULTA)
        while (rs.next()) {
            System.out.println("id: " + rs.getObject("id"));
            System.out.println("nombre: " + rs.getObject("nombre"));
            System.out.println("cuit: " + rs.getObject("cuit"));
        }
        rs.close();

    }

    //14-09-17      busca en la base de datos y devuelve una lista de clientes
    /**
     * Crea una lista de clientes con los clientes obtenidos de la base de datos
     *
     * @return devuelve una lista de clientes
     * @throws Exception
     */
    public List<Cliente> buscarTodosLosClientes() throws Exception {
        List<Cliente> clientes = new ArrayList();
        Connection conexion = this.getConexionMysql();
        Statement statement = conexion.createStatement();

        ResultSet rs = statement.executeQuery("select * from clientes"); //executeQuery: LEER (EJECUTAR CONSULTA)

        while (rs.next()) {   //ResultSet rs guarda los datos de la selección
            Cliente cliente = new Cliente();
            cliente.setId((int) rs.getLong("id")); //hay dos maneras de buscarlo casteando o utilizando el getTipodeDato
            cliente.setNombre(rs.getString("nombre"));
            cliente.setCuit(rs.getString("cuit"));
            cliente.setEmail(rs.getString("email"));

            clientes.add(cliente);
        }
        rs.close();

        return clientes;
    }

    /* Clase 01-09-17 */
    public void insertarCliente(Cliente cliente) {
        Connection conexion = this.getConexionMysql();

        String query = "INSERT INTO clientes VALUES("
                + "\"" + cliente.getId() + "\", "
                + "\"" + cliente.getNombre() + "\", "
                + "\"" + cliente.getEmail() + "\", "
                + "\"" + cliente.getCuit() + "\", "
                + "\"" + cliente.getTipo() + "\")";

        Statement st;
        try {
            st = conexion.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Hubo un error al escribir datos" + ex.getMessage());
        }
    }

    /* Clase 01-09-17 */
    public void insertarPedido(Pedido pedido) {
        Connection conexion = this.getConexionMysql();

        String insert = "INSERT INTO pedidos VALUES (" + pedido.getNumeroPedido() + ", " + pedido.getNumeroPedido() + ")";

        try {
            Statement st = conexion.createStatement();
            st.executeUpdate(insert);
        } catch (SQLException ex) {
            System.out.println("Hubo un error al escribir datos" + ex.getMessage());
        }

    }

    /* Clase 06-09-17 */
    public Cliente buscarClientePorId(int id) {
        Cliente cliente = new Cliente();
        Connection conexion = this.getConexionMysql();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE id = " + id);

            if (rs.next()) {
                cliente.setCuit(rs.getString("cuit"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setId((int) rs.getLong("id"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTipo(rs.getString("tipo"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un error al escribir datos" + ex.getMessage());
        }

        return cliente;
    }

    /* Clase 07-09-17 */
    public Cliente buscarClientePorCuit(String cuit) {
        Cliente cliente = new Cliente();
        Connection conexion = this.getConexionMysql();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE cuit = '" + cuit + "'"); //executeQuery: LEER (EJECUTAR CONSULTA)

            if (rs.next()) {     //ResultSet rs guarda los datos de la selección
                cliente.setCuit(rs.getString("cuit"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setId((int) rs.getLong("id")); //hay dos maneras de buscarlo casteando o utilizando el getTipodeDato
                cliente.setEmail(rs.getString("email"));
                cliente.setTipo(rs.getString("tipo"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un error al leer datos" + ex.getMessage());
        }

        return cliente;
    }

    public Mercaderia buscarMercaderiaPorCodigo(String codigo) {
        Mercaderia mercaderia = new Mercaderia();
        Connection conexion = this.getConexionMysql();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mercaderias WHERE codigo = '" + codigo + "'");  //executeQuery: LEER (EJECUTAR CONSULTA)

            if (rs.next()) {  //ResultSet rs guarda los datos de la selección
                mercaderia.setCodigo(rs.getString("codigo"));  //hay dos maneras de buscarlo casteando o utilizando el getTipodeDato
                mercaderia.setNombre(rs.getString("nombre"));
                mercaderia.setPeso((float) rs.getLong("peso"));
                mercaderia.setValor((float) rs.getLong("valor"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Hubo un error al leer datos" + ex.getMessage());
        }

        return mercaderia;
    }

    /* Clase 01-09-17 */
    public void insertarMercaderia(Mercaderia mercaderia) {
        Connection conexion = this.getConexionMysql(); //crear la conexion

        String insert = "INSERT INTO mercaderias VALUES (" //armamos el string que será la sentencia de sql
                + "\"" + mercaderia.getCodigo() + "\","
                + "\"" + mercaderia.getNombre() + "\","
                + mercaderia.getValor() + ","
                + mercaderia.getPeso() + ")";

        Statement st;
        try {
            st = conexion.createStatement();
            st.executeUpdate(insert);//executeUpdate

        } catch (SQLException ex) {
            System.out.println("Hubo un error al escribir los datos");
        }
    }

    //07-09-17      busca en la base de datos y devuelve un lista de mercaderia
    public List<Mercaderia> buscarTodasLasMercaderias() {
        List<Mercaderia> mercaderias = new ArrayList();
        Connection conexion = this.getConexionMysql();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mercaderias");

            while (rs.next()) {
                Mercaderia mercaderia = new Mercaderia();
                mercaderia.setCodigo(rs.getString("codigo"));
                mercaderia.setNombre(rs.getString("nombre"));
                mercaderia.setPeso(rs.getFloat("peso"));
                mercaderia.setValor(rs.getFloat("valor"));

                mercaderias.add(mercaderia);
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un error al leer datos de mercaderia" + ex.getMessage());
        }

        return mercaderias;
    }

}
