package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio8 {

    private static String nombreAlumnoIngresado;
    private static float promedioAlumnoIngresado;
    private static int contador = 0;
    private static float promedioMejorAlumno = 1;
    private static String nombreMejorAlumno;
    private final static int ALUM_MAX = 10;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        calcularPromedioMaximoDeAlumno();
    }

    /**
     * Calcular mejor promedio de un grupo de alumnos
     */
    private static void calcularPromedioMaximoDeAlumno() {
        while (contador < ALUM_MAX) {
            System.out.println("Ingrese el nombre del alumno");
            nombreAlumnoIngresado = scanner.next();
            System.out.println("Ingrese el promedio del alumno");
            promedioAlumnoIngresado = scanner.nextFloat();

            if (promedioAlumnoIngresado > promedioMejorAlumno) {
                promedioMejorAlumno = promedioAlumnoIngresado;
                nombreMejorAlumno = nombreAlumnoIngresado;
            }

            contador++;
        }
        System.out.println("El alumno con el mejor promedio es " + nombreMejorAlumno + " y su promedio fue de: " + promedioMejorAlumno);

    }


}
