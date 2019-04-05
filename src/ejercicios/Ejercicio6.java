package ejercicios;

import java.util.Scanner;

public class Ejercicio6 {
    private static int A;
    private static int B;
    private static int producto = 0;
    private static int contador = 1;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor de A");
        A = scanner.nextInt();
        System.out.println("Ingrese el valor de B");
        B = scanner.nextInt();

        while (contador<=B ){

            producto = producto + A;
            contador++;
            System.out.println("Producto: " + producto);

        }

    }
}
