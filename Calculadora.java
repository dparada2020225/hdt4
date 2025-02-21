import java.util.Scanner;

public class Calculadora {
    private static Calculadora instancia;    // Única instancia (Singleton)
    private Stack<Double> stack;             // Asociación con cualquier implementación de Stack

    /**
     * Constructor privado para forzar uso de getInstance()
     */
    private Calculadora(Stack<Double> stack) {
        this.stack = stack;
    }

    /**
     * Método estático para obtener la única instancia de Calculadora.
     * Si ya existe, se retorna la misma.
     * 
     * @param stack el Stack<Double> que se usará (solo se considera en la 1ra llamada)
     * @return la única instancia de Calculadora
     */
    public static Calculadora getInstance(Stack<Double> stack) {
        if (instancia == null) {
            instancia = new Calculadora(stack);
        }
        return instancia;
    }

    /**
     * Evalúa una expresión en notación postfix.
     *
     * @param operacion la cadena en postfix
     * @return el resultado de la evaluación
     */
    public double evaluar(String operacion) {
        // Se limpia el stack antes de cada evaluación
        while (!stack.empty()) {
            stack.pop();
        }

        Scanner scanner = new Scanner(operacion);

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                stack.push(scanner.nextDouble());
            } else {
                String operador = scanner.next();
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida: faltan operandos.");
                }
                double operandoB = stack.pop();
                double operandoA = stack.pop();
                stack.push(operar(operandoA, operandoB, operador));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expresión inválida o incompleta.");
        }
        return stack.pop();
    }

    /**
     * Realiza la operación aritmética correspondiente.
     */
    private double operar(double operandoA, double operandoB, String operador) {
        switch (operador) {
            case "+": return operandoA + operandoB;
            case "-": return operandoA - operandoB;
            case "*": return operandoA * operandoB;
            case "/":
                if (operandoB == 0) throw new ArithmeticException("División por cero.");
                return operandoA / operandoB;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operador);
        }
    }
}
