package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio6 {
    private static int primerNumero;
    private static int segundoNumero;
    private static int producto = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor de A");
        primerNumero = scanner.nextInt();
        System.out.println("Ingrese el valor de segundoNumero");
        segundoNumero = scanner.nextInt();

        calcularProducto(primerNumero, segundoNumero);
        System.out.print("El resultado es: " + producto);

    }

    /**
     * Calcula el producto entre dos numeros
     * @param primerNumero
     * @param segundoNumero
     * @return producto
     */
    private  static int calcularProducto (int primerNumero, int segundoNumero){
       int contador =1;
        while (contador<= segundoNumero) {
            producto = producto + primerNumero;
            contador++;
        }
        return producto;
    }

}
