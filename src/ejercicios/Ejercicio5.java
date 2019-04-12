package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio5 {
    private static int numeroDeCorredorIngresado;
    private static int corredorMasRapido;
    private static int tiempoMasRapido = 999999999;
    private static int horasRecorridasIngresadas;
    private static int minutosRecorridosIngresados;
    private static int segundosRecorridosIngresados;
    private static int totalSegundosCorredor;
    private static int totalSegundos;
    private static int contCorredor = 0;
    private static int contCorredorMenosHora = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("Ingrese el numero del corredor");
        numeroDeCorredorIngresado = scan.nextInt();
        while (numeroDeCorredorIngresado != 0) {
            contCorredor++;
            System.out.println("Ingrese horas recorridas");
            horasRecorridasIngresadas = scan.nextInt();
            System.out.println("Ingrese minutos recorridos");
            minutosRecorridosIngresados = scan.nextInt();
            System.out.println("Ingrese segundos recorridos");
            segundosRecorridosIngresados = scan.nextInt();

            totalSegundosCorredor = devolverSegundos(horasRecorridasIngresadas, minutosRecorridosIngresados, segundosRecorridosIngresados);

            // Corredores que hicieron la carrera en menos de 1h
            if (totalSegundosCorredor < 3600) {
                contCorredorMenosHora++;
            }
            totalSegundos = totalSegundos + totalSegundosCorredor;

            // Si fue mas rapido es el nuevo tiempo mas rapido
            if (totalSegundosCorredor < tiempoMasRapido) {
                corredorMasRapido = numeroDeCorredorIngresado;
                tiempoMasRapido = totalSegundosCorredor;
            }
            System.out.println("Ingrese el numero del corredor");
            numeroDeCorredorIngresado = scan.nextInt();
        }

        System.out.println("*********************************************************");
        System.out.println("El ganador es el corredor numero: " + corredorMasRapido);
        System.out.println("El promedio en segundos de los corredores es: " + (totalSegundos / contCorredor) + "s");
        System.out.println("Porcentaje de corredores que realizaron la carrera en menos de 1 hora: " + ((contCorredorMenosHora * 100) / contCorredor) + "%");
        System.out.println("*********************************************************");


    }

    /**
     * Devuelve la cantidad total en segundos
     * @param horas
     * @param minutos
     * @param segundos
     * @return segundos totales
     */
    private static int devolverSegundos(int horas, int minutos, int segundos) {

        int horasASegundoTotal = horas * 3600;
        int minutosASegundosTotal = minutos * 60;

        int segundosTotales = horasASegundoTotal + minutosASegundosTotal + segundos;
        return segundosTotales;
    }

}
