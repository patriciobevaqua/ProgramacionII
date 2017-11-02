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

public class ConexionesBaseDeDatos {

    public Connection getConexionMysql() {
        MysqlDataSource fuenteDatos = new MysqlDataSource();
        fuenteDatos.setServerName("localhost");
        fuenteDatos.setPort(3306);
        fuenteDatos.setDatabaseName("bd_programacion2");
        fuenteDatos.setUser("root");
        fuenteDatos.setPassword("");

        Connection conexion = null;
        try {
            conexion = fuenteDatos.getConnection();
            System.out.println("La conexión a Mysql se realizo sin problemas! =) ");
        } catch (SQLException e) {
            System.out.println("Ocurrio un error : " + e.getMessage());
        }

        return conexion;
    }

    public List<Cliente> buscarTodosLosClientes() throws Exception {
        List<Cliente> clientes = new ArrayList();
        Connection conexion = this.getConexionMysql();
        Statement statement = conexion.createStatement();

        ResultSet rs = statement.executeQuery("select * from clientes");

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId((int) rs.getLong("id"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setCuit(rs.getString("cuit"));
            cliente.setEmail(rs.getString("email"));

            clientes.add(cliente);
        }
        rs.close();

        return clientes;
    }

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

    public Cliente buscarClientePorCuit(String cuit) {
        Cliente cliente = new Cliente();
        Connection conexion = this.getConexionMysql();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clientes WHERE cuit = '" + cuit + "'");

            if (rs.next()) {
                cliente.setCuit(rs.getString("cuit"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setId((int) rs.getLong("id"));
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
            ResultSet rs = st.executeQuery("SELECT * FROM mercaderias WHERE codigo = '" + codigo + "'");

            if (rs.next()) {
                mercaderia.setCodigo(rs.getString("codigo"));
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

    public void insertarMercaderia(Mercaderia mercaderia) {

    }

    public List<Mercaderia> buscarTodasLasMercaderias() {
        List<Mercaderia> mercaderias = new ArrayList();
        Connection conexion = this.getConexionMysql();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mercaderias");

            while(rs.next()) {
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
