package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio11 {

    private static final float facturacionTotal = 0;
    private static int cantidadEmpresas;

    private static float facturacionMensual;
    private static float resumenDeViaje;
    private static float promedioPagadoPorEmpresa;
    private static float valorFacturaMasCara;
    private static String nombreEmpresa;
    private static int cantidadViajes;
    private static Scanner scanner = new Scanner(System.in);


    private static final int CANTIDAD_VIAJES_DIARIOS_LIBRES = 2;
    private static final float COSTO_BASE_VIAJE_DIARIO_LIBRE = 8500;
    private static final float COSTO_VIAJE_ADICIONAL = 100;
    private static final int VIAJES_ADICIONALES_PARA_PROMOCIONAR = 30;
    private static final int VIAJES_MAXIMOS = 1000;
    private static final int DESCUENTO_PROMOCION = 10;
    private static boolean hayDescuento = false;
    private static String selector;

    public static void main(String[] args) {

        System.out.println("Elija entre las opciones dadas que desea hacer: ");
        System.out.println("A - Ingresar Facturacion de una empresa");
        System.out.println("B - Calcular Facturacion total de las empresas ingresadas");
        selector = scanner.next();

        // MENU
        while (!selector.equals("F")) {
            switch (selector) {

                case "A":
                    calcularFacturacionMensualEmpresa();
                    break;
                case "B":

                default:
                    System.out.println("No existe tal opcion");
                    break;
            }
            System.out.println("Elija la opcion que desea realizar");
            System.out.println("A - Ingresar Facturacion de una empresa");
            System.out.println("B - Calcular Facturacion total de las empresas ingresadas");
            selector = scanner.next();
        }


    }


    private static void calcularFacturacionMensualEmpresa() {

        //TODO: Falta terminar, no funciona
        float cantidadViajesAdicionales;
        float descuento;
        System.out.println("Ingrese el nombre de la Empresa");
        nombreEmpresa = "Guido";
        System.out.println("Ingrese la cantidad de viajes adicionales");
        cantidadViajes = 10;

        if (cantidadViajes >= 0 && cantidadViajes < VIAJES_MAXIMOS){

            if (cantidadViajes > CANTIDAD_VIAJES_DIARIOS_LIBRES){
                // + PRECIO BASE
                facturacionMensual = facturacionMensual + COSTO_BASE_VIAJE_DIARIO_LIBRE;
            }

            // Viajes adicionales neto sin contar los viajes diarios libres
            cantidadViajesAdicionales = cantidadViajes - CANTIDAD_VIAJES_DIARIOS_LIBRES;

            // + VIAJES ADICIONALES
            facturacionMensual = (cantidadViajesAdicionales * COSTO_VIAJE_ADICIONAL);

            // DESCUENTO
            if (cantidadViajesAdicionales > VIAJES_ADICIONALES_PARA_PROMOCIONAR){
                descuento = (facturacionMensual * DESCUENTO_PROMOCION)/100;
                facturacionMensual = facturacionMensual - descuento;
            }

        }

        System.out.println("La empresa: " + nombreEmpresa + " debe abonar " + facturacionMensual);
    }
}


