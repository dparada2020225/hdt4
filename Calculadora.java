import java.util.Scanner;

public class Calculadora {
    Stack<Double> stack;

    public Calculadora(Stack<Double> stack) {
        this.stack = stack;
    }

    public double evaluar(String operacion) {
        Scanner scanner = new Scanner(operacion);

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                stack.push(scanner.nextDouble());
            } else {
                String operador = scanner.next();
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expresión inválida: no hay suficientes operandos.");
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
