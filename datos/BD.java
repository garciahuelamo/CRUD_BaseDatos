package datos;

import control.Utilidades;
import java.sql.*;

public class BD {

    public static void insertDataSQL(String sql) {

        Statement sentenciaSQL = null;
        int resultado = 0;
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/videojuegos",
                    "root", "");
            sentenciaSQL = conexion.createStatement();
            resultado = sentenciaSQL.executeUpdate(sql);

            if (resultado >= 1) {
                System.out.println("Se ha insertado correctamente.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
                sentenciaSQL.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void selectDataSQL(){

        Connection conexion = null;
        Statement sentenciaSQL = null;
        ResultSet rs;
        String sql = "";
        int respuesta;
        int respuestaCodigo;
        double respuestaPrecio;
        String respuestaNombre;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/videojuegos", "root", "");

            respuesta = Utilidades.pedirInt("Elije el método por el cual buscar el videojuego: (1) NOMBRE - (2) CODIGO - (3) PRECIO:");

            switch (respuesta){

                case 1:
                    System.out.println("Has seleccionado buscar el juego por su nombre.");
                    respuestaNombre = Utilidades.pedirString("Introduzca el nombre a buscar:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "SELECT * FROM listasvideojuegos WHERE nombre = '" + respuestaNombre + "';";
                    rs = sentenciaSQL.executeQuery(sql);
                    if (rs.next()){
                        System.out.println("Nombre: " + rs.getString("nombre") + " - codigo: " + rs.getInt("codigo") +
                                " - precio: " + rs.getDouble("precio"));
                    }
                    break;
                case 2:
                    System.out.println("Has seleccionado buscar el juego por su codigo.");
                    respuestaCodigo = Utilidades.pedirInt("Introduzca el codigo a buscar:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "SELECT * FROM listasvideojuegos WHERE codigo = " + respuestaCodigo + ";";
                    rs = sentenciaSQL.executeQuery(sql);
                    if (rs.next()){
                        System.out.println("Nombre: " + rs.getString("nombre") + " - codigo: " + rs.getInt("codigo") +
                                " - precio: " + rs.getDouble("precio"));
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado buscar el juego por su precio.");
                    respuestaPrecio = Utilidades.pedirDouble("Introduzca el precio a buscar:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "SELECT * FROM listasvideojuegos WHERE precio = " + respuestaPrecio + ";";
                    rs = sentenciaSQL.executeQuery(sql);
                    if (rs.next()){
                        System.out.println("Nombre: " + rs.getString("nombre") + " - codigo: " + rs.getInt("codigo") +
                                " - precio: " + rs.getDouble("precio"));
                    }

                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                sentenciaSQL.close();
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateDataSQL(){

       
    }

    public static void dropDataSQL(){

       
    }

}
