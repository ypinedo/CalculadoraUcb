/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraucb;

import java.util.Scanner;

/**
 *
 * @author Yurguen Pinedo
 */
public class CalculadoraUcb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;
        boolean continuar = false;
        do {
            String numero1;
            do {
                System.out.println("\n Dame el primer número de la operación. ");
                numero1 = sc.nextLine();
                if (numero1.matches("[+-]?[\\d]*[.]?[\\d]+")) {
                    continuar = true;
                } 
            } while (!continuar);
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);
            do {
                System.out.println("\n ¿Que operación desea hacer? (Solo coloque un signo)");
                System.out.println("Teniendo en cuenta que: \n + = sumar \n - = restar \n"
                        + " x = multiplicar \n / = dividir \n * = elevar primer número al segundo numero."
                        + "\n % = residuo");
                operacion = sc.nextLine();
                comprobar = ValidarOperacionExistente(operacion);
            } while (comprobar != true);
            String numero2;
            continuar = false;
            do {
                System.out.println("\n Por favor, dame el segundo número.");
                numero2 = sc.nextLine();
                if (numero2.matches("[+-]?[\\d]*[.]?[\\d]+")) {
                    continuar = true;
                } 
            } while (!continuar);
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);
            do {
                comprobar = true;
                switch (operacion) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        while (n2 == 0) {
                            continuar = false;
                            do {
                                System.err.println(" En el denominador se encuentra \n"
                                        + "un cero, para evitar errores coloca otro número.");
                                numero2 = sc.nextLine();
                                if (numero2.matches("[+-]?[\\d]*[.]?[\\d]+")) {
                                    continuar = true;
                                }
                            } while (!continuar);
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        while (n2 == 0) {
                            do {
                                System.err.println(" En el denominador se encuentra \n"
                                        + "un cero, para evitar errores coloca otro número.");
                                numero2 = sc.nextLine();
                                if (numero2.matches("[+-]?[\\d]*[.]?[\\d]+")) {
                                    continuar = true;
                                } else {
                                    continuar = false;
                                }
                            } while (continuar != true);
                            nume2 = Double.parseDouble(numero2);
                            n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                }
            } while (!comprobar);

            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
            System.out.println("\n ¿Desea hacer alguna otra operación? \n");
            System.out.println(" [s/n]");
            do {
                operacion = sc.nextLine();
                comprobar = ValidarRespuestaRealizarOtraOP(operacion);
            } while (!comprobar);
        } while (Es_S_la_res(operacion));
    }
    private boolean Es_S_la_res(String operacion) {
        return operacion.equals("s") || operacion.equals("S");   
    }
    private boolean ValidarOperacionExistente(String operacion) {
        boolean comprobar = false;
        if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                }
    }

    private boolean ValidarRespuestaRealizarOtraOP(String operacion) {
        boolean comprobar = true;
            switch (operacion) {
                case "s":
                case "S":
                case "n":
                case "N":
                    break;
                default:
                    System.err.println("\n Error, ponga un literal valido. \n");
                    comprobar = false;
            }
    }
}
