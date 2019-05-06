package ejercicios;

import java.util.Scanner;

/**
 * @author guido
 */
public class Ejercicio10 {

    private static int num1;
    private static int num2;
    private static String operacion;
    private static double resultado;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Ingrese el valor de num1");
        num1 = scan.nextInt();
        System.out.println("Ingrese el valor de num2");
        num2 = scan.nextInt();
        calculadora(num1, num2);


    }

    private static void calculadora(int num1, int num2) {
        do {
            System.out.println("Ingrese una operacion");
            System.out.println("Operadores validos: + _ - _ / _ * _ %");
            operacion = scan.next();

        }
        while (operacion.equals('F') && !operacion.equals("+") && !operacion.equals("-") && !operacion.equals("/") && !operacion.equals("*") && !operacion.equals("%"));

        while (!operacion.equals("F")) {
            switch (operacion) {

                case "+":
                    resultado = operacionSuma(num1, num2);
                    break;

                case "-":
                    resultado = operacionResta(num1, num2);
                    break;
                case "/":
                    resultado = operacionDivision(num1, num2);
                    break;
                case "*":
                    resultado = operacionMultiplicacion(num1, num2);
                    break;
                case "%":
                    resultado = operacionResto(num1, num2);
                    break;
                default:
                    System.out.println("No existe el operador");
                    break;
            }
            System.out.println(" ");
            System.out.println("Ingrese una operacion");
            System.out.println("Operadores validos: + _ - _ / _ * _ %");
            operacion = scan.next();
        }

        System.out.println("La calculadora finalizo");
    }

    // Operadores
    private static double operacionSuma(int num1, int num2) {
        System.out.println("Suma: " + num1 + " + " + num2 + " = " + (num1 + num2));
        return (num1 + num2);
    }

    private static double operacionResta(int num1, int num2) {
        System.out.println("Resta: " + num1 + " - " + num2 + " = " + (num1 - num2));
        return (num1 - num2);
    }

    private static double operacionDivision(int num1, int num2) {
        if (num2 != 0) {
            System.out.println("Division de : " + num1 + " / " + num2 + " = " + (num1 * 1.0 / num2));
            return (num1 * 1.0 / num2);

        } else {
            System.out.println("No se puede dividir por cero. Resultado: " + 0);
            return 0;
        }
    }

    private static double operacionMultiplicacion(int num1, int num2) {
        System.out.println("Multiplicacion: " + num1 + " * " + num2 + " = " + (num1 * num2));
        return (num1 * num2);
    }

    private static double operacionResto(int num1, int num2) {
        if (num2 != 0) {
            System.out.println("Resto: " + num1 + " % " + num2 + " = " + (num1 % num2));
            return (num1 % num2);
        } else {

            System.out.println("No se puede dividir por cero. Resultado: " + 0);
            return 0;
        }
    }
}