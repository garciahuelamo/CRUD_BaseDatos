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

        Connection conexion = null;
        Statement sentenciaSQL = null;
        int resultado = 0;
        String sql = "";
        String respuestaNombre;
        String nombreActualizado;
        int respuestaCodigo;
        double respuestaPrecio;
        double precioActualizado;
        int respuestaUsuario;
        int codigoActualizado;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/videojuegos", "root", "");

            respuestaUsuario = Utilidades.pedirInt("Elije el método por el cual actualizar el videojuego: (1) NOMBRE - (2) CODIGO - (3) PRECIO:");

            switch (respuestaUsuario){

                case 1:
                    respuestaNombre = Utilidades.pedirString("Introduzca el nombre que desea actualizar:");
                    nombreActualizado = Utilidades.pedirString("Introduzca el nuevo nombre:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "UPDATE listasvideojuegos SET nombre = '" + nombreActualizado + "' WHERE nombre = '" + respuestaNombre + "';";
                    resultado = sentenciaSQL.executeUpdate(sql);
                    if(resultado>=1){
                        System.out.println("El videojuego se ha actualizado correctamente.");
                    }
                    break;
                case 2:
                    respuestaCodigo = Utilidades.pedirInt("Introduzca el codigo que desea actualizar:");
                    codigoActualizado = Utilidades.pedirInt("Introduzca el nuevo codigo:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "UPDATE listasvideojuegos SET codigo = " + codigoActualizado + " WHERE codigo = " + respuestaCodigo + ";";
                    resultado = sentenciaSQL.executeUpdate(sql);
                    if(resultado>=1){
                        System.out.println("El videojuego se ha actualizado correctamente.");
                    }
                    break;
                case 3:
                    respuestaPrecio = Utilidades.pedirDouble("Introduzca el precio que desea actualizar:");
                    precioActualizado = Utilidades.pedirDouble("Introduzca el nuevo precio:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "UPDATE listasvideojuegos SET precio = " + precioActualizado + " WHERE precio = " + respuestaPrecio + ";";
                    resultado = sentenciaSQL.executeUpdate(sql);
                    if(resultado>=1){
                        System.out.println("El videojuego se ha actualizado correctamente.");
                    }
                    break;
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dropDataSQL(){

        Connection conexion = null;
        Statement sentenciaSQL = null;
        int resultado = 0;
        String sql = "";
        String respuestaNombre;
        int respuestaCodigo;
        double respuestaPrecio;
        int respuestaUsuario;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/videojuegos", "root", "");

            respuestaUsuario = Utilidades.pedirInt("Elije el método por el cual eliminar el videojuego: (1) NOMBRE - (2) CODIGO - (3) PRECIO:");

            switch (respuestaUsuario){

                case 1:
                    respuestaNombre = Utilidades.pedirString("Introduzca el nombre por el que desea eliminar el videojuego:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "DELETE FROM listasvideojuegos WHERE nombre = '" + respuestaNombre + "';";
                    resultado = sentenciaSQL.executeUpdate(sql);
                    if(resultado>=1){
                        System.out.println("El videojuego se ha eliminado correctamente.");
                    }
                    break;
                case 2:
                    respuestaCodigo = Utilidades.pedirInt("Introduzca el codigo por el que desea eliminar el videojuego:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "DELETE FROM listasvideojuegos WHERE codigo = '" + respuestaCodigo + "';";
                    resultado = sentenciaSQL.executeUpdate(sql);
                    if(resultado>=1){
                        System.out.println("El videojuego se ha eliminado correctamente.");
                    }
                    break;
                case 3:
                    respuestaPrecio = Utilidades.pedirDouble("Introduzca el precio por el que desea eliminar el videojuego:");
                    sentenciaSQL = conexion.createStatement();
                    sql = "DELETE FROM listasvideojuegos WHERE precio = '" + respuestaPrecio + "';";
                    resultado = sentenciaSQL.executeUpdate(sql);
                    if(resultado>=1){
                        System.out.println("El videojuego se ha eliminado correctamente.");
                    }
                    break;
            }
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
