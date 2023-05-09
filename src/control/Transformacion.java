package control;

public class Transformacion {

    public static String transformarVideojuego(Videojuegos videojuego){

        //Method to transform user data into a SQL statement to interact with the database

        return "INSERT INTO listasvideojuegos (nombre, codigo, precio) VALUES ('" + videojuego.getNombre() + "' , ' " + videojuego.getCodigo() +
                "' , " + videojuego.getPrecio() + ");";
    }

}
