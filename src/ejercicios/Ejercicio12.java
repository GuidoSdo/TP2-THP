package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio12 {

    private static final float MIN_NUM = 10001;
    private static final float MAX_NUM = 99999;
    private static final int TIPO_A_VALOR_MINUTOS = 2; // Abono de 2$ por minuto en Abono Tipo A
    private static final int DURACION_MENOR_A_6 = 6;
    private static int duracionLlamada;
    private static int contador = 0;
    private static int cantDuracionMenorA6Minutos = 0;
    private static float importeDeLaLlamada;
    private static float importeRecaudadoPorTipoAbonoA = 0;
    private static float importeRecaudadoPorTipoAbonoB = 0;
    private static float importeRecaudadoPorTipoAbonoC = 0;
    private static float codigoCliente = 1;
    private static float duracionLlamadaMasLarga = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static String tipoAbono;

    public static void main(String[] args) {

        System.out.println("Sistema de Consumo de clientes");

        while (ingresoCodigoCliente() != 0) {
            duracionLlamada = ingresoDuracionLlamada();
            tipoAbono = ingresoTipoAbono();
            switch (tipoAbono) {

                case "A":
                    importeDeLaLlamada = calcularImporteLlamadaTipoA(duracionLlamada);
                    importeRecaudadoPorTipoAbonoA = importeRecaudadoPorTipoAbonoA + importeDeLaLlamada;
                    contador++;
                    break;

                case "B":
                    importeDeLaLlamada = calcularImporteLlamadaTipoB(duracionLlamada);
                    importeRecaudadoPorTipoAbonoB = importeRecaudadoPorTipoAbonoB + importeDeLaLlamada;
                    contador++;
                    break;
                case "C":
                    importeDeLaLlamada = calcularImporteLlamadaTipoC(duracionLlamada);
                    importeRecaudadoPorTipoAbonoC = importeRecaudadoPorTipoAbonoC + importeDeLaLlamada;
                    contador++;
                    break;
            }

            if (duracionLlamada > duracionLlamadaMasLarga) {
                duracionLlamadaMasLarga = duracionLlamada;
            }
            if (duracionLlamada < DURACION_MENOR_A_6) {
                cantDuracionMenorA6Minutos++;
            }
            mostrarResumen(codigoCliente, tipoAbono, duracionLlamada, importeDeLaLlamada);
        }

        if (contador != 0) {
            System.out.println("1.A. Importe recaudado por tipo abono A: $" + importeRecaudadoPorTipoAbonoA);
            System.out.println("1.B. Importe recaudado por tipo abono B: $" + importeRecaudadoPorTipoAbonoB);
            System.out.println("1.C. Importe recaudado por tipo abono C: $" + importeRecaudadoPorTipoAbonoC);
            System.out.println("2. Cantidad minutos de la llamada mas larga: " + duracionLlamadaMasLarga + "min");
            System.out.println("3. Cantidad de llamadas de menos de 6 minutos: " + cantDuracionMenorA6Minutos);
            System.out.println("4. El precio promedio por llamada es de: $" + ((importeRecaudadoPorTipoAbonoA + importeRecaudadoPorTipoAbonoB + importeRecaudadoPorTipoAbonoC) / contador));

        } else {
            System.out.println("No hubo llamadas ingresadas");

        }
    }


    private static int ingresoDuracionLlamada() {
        do {
            System.out.println("Ingrese la duracion de la llamada");
            duracionLlamada = scanner.nextInt();
        }
        while (duracionLlamada <= 0);

        return duracionLlamada;
    }

    /**
     * Devuelve el tipoAbono segun la validacion de la empresa
     *
     * @return
     */
    private static String ingresoTipoAbono() {
        do {
            System.out.println("Ingrese el tipo de abono: ");
            System.out.println("A, B o C");
            tipoAbono = scanner.next();
        } while (!(tipoAbono.equals("A") || tipoAbono.equals("B") || tipoAbono.equals("C")));

        return tipoAbono;
    }

    /**
     * Devuelve el codigoCliente segun la validacion de la empresa
     * <p>
     * * @return
     */
    private static float ingresoCodigoCliente() {
        do {
            System.out.println(" ");
            System.out.println("Ingrese el codigo de cliente: ");
            System.out.println("Mayor a 10001 y menor a 9999, en caso de querer finalizar el programa: 0");
            codigoCliente = scanner.nextInt();
        }
        while (!(codigoCliente > MIN_NUM && codigoCliente < MAX_NUM || codigoCliente == 0));

        return codigoCliente;
    }

    /**
     * Devuelve importe recaudado por operadora con un tipo de abono A
     *
     * @param duracionLlamada
     * @return
     */
    private static float calcularImporteLlamadaTipoA(int duracionLlamada) {

        return TIPO_A_VALOR_MINUTOS * duracionLlamada;
    }

    /**
     * Devuelve importe recaudado por operadora con un tipo de abono tipo B
     *
     * @param duracionLlamada
     * @return
     */
    private static float calcularImporteLlamadaTipoB(int duracionLlamada) {
        float importe = 0;
        float COSTO_MENOR_A = 2; // Valor de costo por minuto menor a 5min
        float COSTO_MAYOR_A = 1.5f; // Valor del costo por minuto  mayor a 5min
        float TIEMPO = 5; // Limite de 5min
        if (duracionLlamada < TIEMPO) {
            importe = COSTO_MENOR_A * duracionLlamada;
        }
        if (duracionLlamada > TIEMPO) {
            importe = COSTO_MAYOR_A * duracionLlamada;
        }

        return importe;
    }

    /**
     * Devuelve importe recaudado por operador con un tipo de abono tipo C
     *
     * @param duracionLlamada
     * @return
     */
    private static float calcularImporteLlamadaTipoC(int duracionLlamada) {
        float MAXIMO_COSTO = 10; // Valor maximo que puede costar el minuto
        float COSTO_INICIAL = 1; // Valor del costo por minuto
        float importe;
        if (duracionLlamada >= MAXIMO_COSTO) {
            importe = MAXIMO_COSTO;
        } else {
            importe = duracionLlamada * COSTO_INICIAL;
        }
        return importe;
    }

    /**
     * Formato de salida final ciclo
     *
     * @param codigoCliente
     * @param tipoAbono
     * @param duracionLlamada
     * @param importeDeLaLlamada
     */
    private static void mostrarResumen(float codigoCliente, String tipoAbono, float duracionLlamada, float importeDeLaLlamada) {
        System.out.println(" ");
        System.out.println("Resumen de operacion");
        System.out.println("Codigo Cliente: " + codigoCliente);
        System.out.println("Tipo de abono: " + tipoAbono);
        System.out.println("Duracion llamada: " + duracionLlamada + "min");
        System.out.println("Importe por llamada: $" + importeDeLaLlamada);
        System.out.println("-----------------------------------------------------");
    }


}
