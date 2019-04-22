package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio9 {

    private static String nombreIngresado;
    private static int contrasenaIngresada;
    private final static String NOMBRE_CORRECTO = "Guido";
    private final static int CONTRASENA_CORRECTA = 1234;
    private static boolean usuarioAceptado = false;
    private static int contador = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loginUsuarioYContrasena();

    }

    /**
     * Login de usuario y contrasena, devuelve un print como respuesta
     */
    private static void loginUsuarioYContrasena() {
        while (contador < 3 && usuarioAceptado == false) {
            System.out.println("Ingrese nombre del usuario");
            nombreIngresado = scanner.next();
            System.out.println("Ingrese contrasena del usuario");
            contrasenaIngresada = scanner.nextInt();

            if (nombreIngresado.equals(NOMBRE_CORRECTO) && (contrasenaIngresada == CONTRASENA_CORRECTA)) {
                usuarioAceptado = true;
                contador = 4;
                System.out.println("Ha ingresado correctamente");
            } else {
                contador++;
                System.out.println("Usuario o contrasena erroneo.");
            }

            if (usuarioAceptado == false && contador == 3) {
                System.out.println("Se ha bloqueado su cuenta");
            }
        }
    }
}
