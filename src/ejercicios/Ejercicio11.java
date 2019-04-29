package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio11 {

    private static  float facturacionTotal = 0;
    private static int cantidadEmpresas;

    private static float facturacionMensual;
    private static float resumenDeViaje;
    private static float promedioPagadoPorEmpresa;
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
    private static boolean finalizarOperacion = false;
    private static int contador = 0;
    public static void main(String[] args) {

        System.out.println("Sistema de facturacion mensual");

        while(finalizarOperacion != true){
            contador++;

            System.out.println("Ingrese los datos del resumen n°" + contador);

            System.out.println("Nombre de empresa: ");
            nombreEmpresa = scanner.next();
            cantidadViajes = ingresarResumenDeViaje();

            if(cantidadViajes != 0) {
                facturacionMensual = calcularFacturacionPorViaje(cantidadViajes);
            }

            if(facturacionMensual > facturacionMayor){
                // nueva facturacion mas alta
                facturacionMayor = facturacionMensual;
                nombreEmpresaConFacturacionMasAlta = nombreEmpresa;
            }

            if(facturacionMensual != 0){

            }
            facturacionTotal =  facturacionTotal + facturacionMensual;

        }

    }

    /**
     * Devuelve la cantidad de viajes
     * segun la validacion del facturador
     * @return
     */
    private static int ingresarResumenDeViaje() {

        System.out.println("Cantidad de viajes realizados: ");
        cantidadViajes = scanner.nextInt();

        if (cantidadViajes >= 0 && cantidadViajes < VIAJES_MAXIMOS) {
            return cantidadViajes;
        } else {
            return 0;
        }
    }

    /**
     * Devuelve importe facturado por una empresa
     * @param cantidadViajes
     * @return
     */
    private static float calcularFacturacionPorViaje(int cantidadViajes) {
        float importe;
        // viajes adicionales sin contar los libres
        int viajesAdicionales = cantidadViajes - CANTIDAD_VIAJES_DIARIOS_LIBRES;


        if (viajesAdicionales > 0) {
            importe = COSTO_BASE_VIAJE_DIARIO_LIBRE + (viajesAdicionales * COSTO_VIAJE_ADICIONAL);
            if (viajesAdicionales > VIAJES_ADICIONALES_PARA_PROMOCIONAR) {
                importe = (importe * DESCUENTO_PROMOCION) / 100;
            }
        } else {
            importe = COSTO_BASE_VIAJE_DIARIO_LIBRE;

        }
        return importe;
    }
}


