package ejercicios;

import java.util.Scanner;

/**
 * Clase 3
 * @author guido
 */
public class Ejercicio10 {

    public static void main(String[] args) {

        int num1;
        int num2;
        String operacion;
        double resultado;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el valor de num1");
        num1 = scan.nextInt();
        System.out.println("Ingrese el valor de num2");
        num2 = scan.nextInt();

        do {
            System.out.println("Ingrese una operacion");
            System.out.println("Operadores validos: + _ - _ / _ * _ %");
            operacion = scan.next();

        } while (operacion.equals('F') && !operacion.equals("+") && !operacion.equals("-") && !operacion.equals("/") && !operacion.equals("*") && !operacion.equals("%"));

        while (!operacion.equals("F")) {
            switch (operacion) {

                case "+":
                    resultado = num1 + num2;
                    System.out.println("Suma: " + num1 + " + " + num2 + " = " + resultado);
                    break;

                case "-":
                    resultado = num1 - num2;
                    System.out.println("Resta: " + num1 + " - " + num2 + " = " + resultado);
                    break;
                case "/":if (num2 != 0) {
                        resultado = num1 * 1.0 / num2;
                        System.out.println("Division de : " + num1 + " / " + num2 + " = " + resultado);
                    } else {
                        resultado = 0;
                        System.out.println("No se puede dividir por cero. Resultado: " + resultado);

                    }
                    break;
                case "%":if (num2 != 0) {
                        resultado = num1 % num2;
                        System.out.println("Resto: " + num1 + " % " + num2 + " = " + resultado);
                    } else {
                        resultado = 0;
                        System.out.println("No se puede dividir por cero. Resultado: " + resultado);
                    }
                    break;
                default:

                    System.out.printf("no existe el operador");
                    break;
            }
            System.out.println("Ingrese una operacion");
            System.out.println("Operadores validos: + _ - _ / _ * _ %");
            operacion = scan.next();
        }

        System.out.println("La calculadora finalizo");
    }
}