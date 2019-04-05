package ejercicios;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {


        int numeroDeVentasAIntroducir;

        float importe;
        float todasLasVentas = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese numero de ventas");
        numeroDeVentasAIntroducir = scan.nextInt();

        for (int i = 0; i < numeroDeVentasAIntroducir; i++) {
            System.out.println("Ingrese importe de la venta numero: " + i);
            importe = scan.nextFloat();

            todasLasVentas += importe;

        }

        System.out.println("la suma de todas las ventas es:  $" + todasLasVentas);
    }
}
