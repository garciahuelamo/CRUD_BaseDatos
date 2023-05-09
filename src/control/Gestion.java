package control;

import datos.BD;
import usuario.SolicitudDatos;
import static control.Utilidades.*;

public class Gestion {

    public static void main(String[] args) {

        int respuesta;

        try {
            do{
                showMenu();
                respuesta = optionMenu();
                switch (respuesta){
                    case 1:
                        addVideojuego();
                        break;
                    case 2:
                        searchVideojuego();
                        break;
                    case 3:
                        updateVideojuego();
                        break;
                    case 4:
                        deleteVideojuego();
                        break;
                    case 5:
                        exitVideojuego();
                        break;
                }
            } while (respuesta!=5);
        } catch (Exception e){
            System.out.println("ERROR --- desconocido.");

        }
    }

    public static void addVideojuego(){

        //Method that inserts user data into a String to transform it into a SQL statement and save it in the database.

        String sql;

        Videojuegos videojuego = SolicitudDatos.addDatos();
        sql = Transformacion.transformarVideojuego(videojuego);
        BD.insertDataSQL(sql);
    }

    public static void searchVideojuego(){
        BD.selectDataSQL();
    }

    public static void updateVideojuego(){
        BD.updateDataSQL();
    }

    public static void deleteVideojuego(){
        BD.dropDataSQL();
    }

    public static void exitVideojuego(){
        outMenu();
    }

}
