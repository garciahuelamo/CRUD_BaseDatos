package control;

public class Transformacion {

    public static String transformarVideojuego(Videojuegos videojuego){

        return "INSERT INTO listasvideojuegos (nombre, codigo, precio) VALUES ('" + videojuego.getNombre() + "' , ' " + videojuego.getCodigo() +
                "' , " + videojuego.getPrecio() + ");";
    }

}
