package control;

import java.util.Scanner;

public class Utilidades {

    /**
     * Method to show-menu.
     * @author Angela_Garcia
     */

    public static void showMenu(){
        System.out.println("1. Insertar");
        System.out.println("2. Buscar");
        System.out.println("3. Modificar");
        System.out.println("4. Eliminar");
        System.out.println("5. Salir del programa");
    }

    /**
     * Method to choose the option.
     * @author Angela_Garcia
     */
    public static int optionMenu(){

        int respuesta;

        do{
            respuesta = Utilidades.pedirInt("Elija el numero de la opción a llevar a cabo:");
        } while (respuesta<1 || respuesta>5);

        return respuesta;
    }

    /**
     * Method that shows a menu with the options to add and exit the program.
     * @author Angela_Garcia
     * @return respuestaMenu It is a variable that returns the value of the option that the user wants to carry out.
     */

    public static int mostrarMenu() {

        int respuestaMenu;

        System.out.println("MENÚ:" +
                "\nOPCIÓN 1. AÑADIR" +
                "\nOPCIÓN 5. SALIR");

        System.out.println();
        respuestaMenu = Utilidades.pedirInt("Introduzca (1) para AÑADIR datos o (5) para SALIR del programa.");

        do {
            if(respuestaMenu!=1 && respuestaMenu!=5){
                System.out.println("ERROR");
                respuestaMenu = Utilidades.pedirInt("Introduzca (1) para AÑADIR datos o (5) para SALIR del programa.");
            }
        }while (respuestaMenu!=1 && respuestaMenu!=5);

        return respuestaMenu;
    }

    /**
     * Method that shows a submenu with the options to search, delete, modify and exit of the program.
     * @author Angela_Garcia
     * @param texto It is a variable for the user interaction by console.
     * @return respuestaSubmenu It is a variable that returns the value of the option that the user wants to carry out.
     */

    public static int mostrarSubmenu(String texto){

        int respuestaSubmenu;

        System.out.println("SUBMENÚ:" +
                "\nOPCIÓN 2.BUSCAR" +
                "\nOPCIÓN 3.BORRAR" +
                "\nOPCIÓN 4.MODIFICAR" +
                "\nOPCIÓN 5.SALIR");

        System.out.println(texto);
        respuestaSubmenu = Utilidades.pedirInt("Introduzca (2) para BUSCAR, (3) para BORRAR, (4) para MODIFICAR" +
                " O (5) para SALIR.");

        do {
            if(respuestaSubmenu<=1 || respuestaSubmenu>=6){
                System.out.println("ERROR");
                respuestaSubmenu = Utilidades.pedirInt("Introduzca (2) para BUSCAR, (3) para BORRAR, (4) para MODIFICAR" +
                        " O (5) para SALIR.");
            }
        }while (respuestaSubmenu<1 || respuestaSubmenu>6);

        return respuestaSubmenu;
    }

    /**
     * Method that requests a String data to the user by console.
     * @author Angela_Garcia
     * @param texto It is a variable for the user interaction by console.
     * @return respuesta It is a variable that returns the value given by the user.
     */

    public static String pedirString(String texto) {

        String respuesta;

        Scanner reader = new Scanner(System.in);
        System.out.println(texto);
        respuesta = reader.next();
        reader.nextLine();

        return respuesta;
    }

    /**
     * Method that requests a int data to the user by console.
     * @author Angela_Garcia
     * @param texto It is a variable for the user interaction by console.
     * @return respuesta It is a variable that returns the value given by the user.
     */

    public static int pedirInt(String texto) {

        int respuesta;

        Scanner reader = new Scanner(System.in);
        System.out.println(texto);
        respuesta = reader.nextInt();
        reader.nextLine();

        return respuesta;
    }

    /**
     * Method that requests a double data to the user by console.
     * @author Angela_Garcia
     * @param texto It is a variable for the user interaction by console.
     * @return respuesta It is a variable that returns the value given by the user.
     */

    public static double pedirDouble(String texto) {

        double respuesta;

        Scanner reader = new Scanner(System.in);
        System.out.println(texto);
        respuesta = reader.nextDouble();
        reader.nextLine();

        return respuesta;
    }

    /**
     * Method to exit of the program.
     * @author Angela_Garcia
     */
    public static void outMenu(){

        System.out.println("PROGRAMA FINALIZADO.");

    }
}
