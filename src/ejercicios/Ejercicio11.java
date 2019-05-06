package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio11 {

    private static float facturacionTotal;
    private static float facturacionMensual;
    private static float facturacionMayor = 0;
    private static String nombreEmpresa;
    private static String nombreEmpresaConFacturacionMasAlta;
    private static int cantidadViajes;
    private static Scanner scanner = new Scanner(System.in);
    private static final int CANTIDAD_VIAJES_DIARIOS_LIBRES = 2;
    private static final float COSTO_BASE_VIAJE_DIARIO_LIBRE = 8500;
    private static final float COSTO_VIAJE_ADICIONAL = 100;
    private static final int VIAJES_ADICIONALES_PARA_PROMOCIONAR = 30;
    private static final int VIAJES_MAXIMOS = 1000;
    private static final int DESCUENTO_PROMOCION = 10;
    private static String finalizarOperacion;
    private static int contador = 0;

    public static void main(String[] args) {

        System.out.println("Sistema de facturacion mensual");
        System.out.println(" ");

        while (finalizarOperacion != "SI") {
            contador++;

            System.out.println("Ingreso de los datos del resumen n°" + contador);
            System.out.println("Ingrese nombre de empresa: ");
            nombreEmpresa = scanner.next();
            cantidadViajes = validarCantidadDeViaje();

            //facturacion
            facturacionMensual = calcularFacturacionPorViaje(cantidadViajes);
            if (facturacionMensual > facturacionMayor) {
                facturacionMayor = facturacionMensual;
                nombreEmpresaConFacturacionMasAlta = nombreEmpresa;
            }
            facturacionTotal = facturacionTotal + facturacionMensual;

            System.out.println("Nombre empresa: " + nombreEmpresa);
            System.out.println("La empresa debe abonar de facturacion mensual: $" + facturacionMensual);

            finalizarOperacion = determinarOperacion();
        }

        System.out.println("El promedio de facturacion Total acumulada: $" + facturacionTotal / contador);
        System.out.println("La mayor facturacion del mes es: $" + facturacionMayor +
                ", de la empresa: " + nombreEmpresaConFacturacionMasAlta);

    }

    /**
     * Devuelve la cantidad de viajes
     * segun la validacion del facturador
     *
     * @return
     */
    private static int validarCantidadDeViaje() {
        boolean operacionValidada = false;

        System.out.println("Ingrese cantidad de viajes realizados: ");
        cantidadViajes = scanner.nextInt();

        while (operacionValidada != true) {

            if (cantidadViajes >= 0 && cantidadViajes < VIAJES_MAXIMOS) {
                operacionValidada = true;
            } else {
                System.out.println("Vuelva a ingresar una cantidad de viajes mayor/igual a 0 y menor a " + VIAJES_MAXIMOS);
                cantidadViajes = scanner.nextInt();
            }
        }
        return cantidadViajes;

    }

    /**
     * Devuelve importe facturado por una empresa
     *
     * @param cantidadViajes
     * @return
     */
    private static float calcularFacturacionPorViaje(int cantidadViajes) {
        float importe;
        float descuento;

        if (cantidadViajes > CANTIDAD_VIAJES_DIARIOS_LIBRES) {
            importe = COSTO_BASE_VIAJE_DIARIO_LIBRE + (cantidadViajes * COSTO_VIAJE_ADICIONAL);
            if (cantidadViajes > VIAJES_ADICIONALES_PARA_PROMOCIONAR) {
                descuento = (importe * DESCUENTO_PROMOCION) / 100;
                importe = importe - descuento;
            }
        } else {
            importe = COSTO_BASE_VIAJE_DIARIO_LIBRE;

        }
        return importe;
    }

    /**
     * Determinar si la operacion finalizo
     *
     * @return respuesta afirmativa o negativa del usuario
     */
    private static String determinarOperacion() {
        System.out.println(" ");
        System.out.println("Finalizar ingresos de facturacion?");
        System.out.println("Afirmativo: SI | Negativo: NO");
        System.out.println(" ");

        switch (finalizarOperacion = scanner.next()) {
            case "SI":
                finalizarOperacion = "SI";
                break;
            case "NO":
                finalizarOperacion = "NO";
                break;
        }
        return finalizarOperacion;
    }

}


