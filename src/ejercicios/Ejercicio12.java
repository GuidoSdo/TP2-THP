package ejercicios;

import java.util.Scanner;

public class Ejercicio12 {

    private static float codigoCliente;
    private static int duracionLlamada;
    private static String tipoAbono;
    private static int contador = 0;
    private static final float MIN_NUM = 10001;
    private static final float MAX_NUM = 99999;
    private static Scanner scanner = new Scanner(System.in);
    private static String finalizarOperacion;
    private static final int TIPO_A_VALOR_MINUTOS = 2;
    private static float importeDeLaLlamada;
    private static float importeRecaudadoPorTipoAbonoA;
    private static float importeRecaudadoPorTipoAbonoB;
    private static float importeRecaudadoPorTipoAbonoC;


    private static float duracionLlamadaMasLarga = 0;
    private static double promedioPrecioPorLlamada;

    public static void main(String[] args) {

        System.out.println("Sistema de Consumo de clientes");
        System.out.println(" ");

        while (finalizarOperacion != "SI") {


            System.out.println("Ingrese el codigo de cliente: ");
            codigoCliente = validarCodigoCliente(scanner.nextFloat());
            System.out.println("Ingrese el tipo de abono: ");
            System.out.println("A, B o C");
            tipoAbono = scanner.next();

            switch (tipoAbono) {

                case "A":
                    System.out.println("Ingrese la duracion ");
                    duracionLlamada = validarDuracionLlamada(scanner.nextInt());
                    importeDeLaLlamada = calcularImporteLlamadaTipoA(duracionLlamada);
                    importeRecaudadoPorTipoAbonoA = importeRecaudadoPorTipoAbonoA + importeDeLaLlamada;
                    contador++;

                    break;

                case "B":
                    System.out.println("Ingrese la duracion ");
                    duracionLlamada = validarDuracionLlamada(scanner.nextInt());
                    importeDeLaLlamada = calcularImporteLlamadaTipoB(duracionLlamada);
                    importeRecaudadoPorTipoAbonoB = importeRecaudadoPorTipoAbonoB + importeDeLaLlamada;
                    contador++;
                    break;
                case "C":
                    System.out.println("Ingrese la duracion ");
                    duracionLlamada = validarDuracionLlamada(scanner.nextInt());
                    importeDeLaLlamada = calcularImporteLlamadaTipoC(duracionLlamada);
                    importeRecaudadoPorTipoAbonoC = importeRecaudadoPorTipoAbonoC + importeDeLaLlamada;
                    contador++;
                    break;
                default:
                    System.out.println("El tipo de abono no existe!");
                    System.out.println("No se pudo realizar ninguna operacion.");
                    System.out.println("Vuelva a ingresar el tipo de abono");
                    break;

            }

            if (duracionLlamada > duracionLlamadaMasLarga) {
                duracionLlamadaMasLarga = duracionLlamada;
            }
            mostrarResumen(codigoCliente, tipoAbono, duracionLlamada, importeDeLaLlamada);
            determinarOperacion();


        }

        System.out.println("1.A. Importe recaudado por tipo abono A: $" + importeRecaudadoPorTipoAbonoA);
        System.out.println("1.B. Importe recaudado por tipo abono B: $" + importeRecaudadoPorTipoAbonoB);
        System.out.println("1.C. Importe recaudado por tipo abono C: $" + importeRecaudadoPorTipoAbonoC);
        System.out.println("2. Cantidad minutos de la llamada mas larga: " + duracionLlamadaMasLarga + "min");
        System.out.println("3. ");
        System.out.println("4. El precio promedio por llamada es de: $" + ((importeRecaudadoPorTipoAbonoA + importeRecaudadoPorTipoAbonoB + importeRecaudadoPorTipoAbonoC) / contador));
    }


    private static int validarDuracionLlamada(int duracionLlamada) {
        while (duracionLlamada <= 0) {

            if (duracionLlamada <= 0) {
                System.out.println("Vuelva a ingresar la duracion de la llamada");
                duracionLlamada = scanner.nextInt();
            }
        }

        return duracionLlamada;
    }

    /**
     * Devuelve el codigoCliente segun la validacion de la empresa
     *
     * @param codigoCliente
     * @return
     */
    private static float validarCodigoCliente(float codigoCliente) {
        boolean operacionValidar = false;

        while (operacionValidar != true) {
            contador++;
            if (codigoCliente > MIN_NUM && codigoCliente < MAX_NUM) {
                operacionValidar = true;
            } else {
                System.out.println("Ingrese un codigo que cumpla con los requisitos: ");
                System.out.println("int de 5 num, entre 10001 y 99999, 0 = fin");
                codigoCliente = scanner.nextInt();
            }

            //TODO: ver
            if (codigoCliente == 0) {
                operacionValidar = true;
            }
        }

        return codigoCliente;
    }

    /**
     * Devuelve importe recaudado por operadora con un valor del min de $2
     *
     * @param duracionLlamada
     * @return
     */
    private static float calcularImporteLlamadaTipoA(int duracionLlamada) {

        return TIPO_A_VALOR_MINUTOS * duracionLlamada;
    }

    private static float calcularImporteLlamadaTipoB(int duracionLlamada) {
        float importe = 0;
        float COSTO_MENOR_A = 2;
        float COSTO_MAYOR_A = 1.5f;
        float TIEMPO = 5;
        if (duracionLlamada < TIEMPO) {
            importe = COSTO_MENOR_A * duracionLlamada;
        }
        if (duracionLlamada > TIEMPO) {
            importe = COSTO_MAYOR_A * duracionLlamada;
        }

        return importe;
    }

    private static float calcularImporteLlamadaTipoC(int duracionLlamada){
        float MAXIMO_COSTO = 10;
        float COSTO_INICIAL = 1;
        float importe;
        if(duracionLlamada >= MAXIMO_COSTO){
            importe = MAXIMO_COSTO;
        } else{
            importe = duracionLlamada *  COSTO_INICIAL;
        }
        return importe;
    }
    private static void mostrarResumen(float codigoCliente, String tipoAbono, float duracionLlamada, float importeDeLaLlamada) {
        System.out.println(" ");
        System.out.println("Resumen de operacion");
        System.out.println("Codigo Cliente: " + codigoCliente);
        System.out.println("Tipo de abono: " + tipoAbono);
        System.out.println("Duracion llamada: " + duracionLlamada +"min");
        System.out.println("Importe por llamada: $" + importeDeLaLlamada);
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
