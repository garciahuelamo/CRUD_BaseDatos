package usuario;

import control.Videojuegos;

import java.util.Scanner;

public class SolicitudDatos {

    public static Videojuegos addDatos(){

        Scanner sc = new Scanner(System.in);
        String nombre;
        int codigo;
        double precio;

        System.out.println("Introduzca el nombre del videojuego:");
        nombre = sc.nextLine();
        System.out.println("Introduzca el codigo del videojuego:");
        codigo = sc.nextInt();
        System.out.println("Introduzca el precio del videojuego:");
        precio = sc.nextDouble();

        sc.nextLine();

        return new Videojuegos(nombre, codigo, precio);
    }
}
