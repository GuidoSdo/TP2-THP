package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio7 {
    private static int numeroIngresado;
    private final static int PROMEDIO_MAXIMO = 20;
    private static int contador = 0;
    private static float promedioTotal = 0;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        contador =  leerSerieNumeros(contador);
        System.out.println("Valores leidos: " + contador);
    }

    /**
     * Obtiene la cantidad de numeros leidos de una serie
     * @param contador
     * @return cantidad de numeros leidos
     */
    public static int leerSerieNumeros(int contador){
        System.out.println("El promedio maximo será: " + PROMEDIO_MAXIMO);
        while (promedioTotal < PROMEDIO_MAXIMO) {
            System.out.println("Ingrese un numero");
            numeroIngresado = scan.nextInt();
            contador++;

            // Se realizo esta condicion motivo de permitir ingresar el numero 20 como primer numero y realizar el ciclo mas de 1 ves
            if(contador != 1){
                promedioTotal = (promedioTotal + numeroIngresado) / contador;
                System.out.println("promedio actual: " + promedioTotal);
            }

        }
        return contador;
    }

}
