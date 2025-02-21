import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Double> stack = null;

        System.out.println("Seleccione la implementación del Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista encadenada");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                stack = new StackArrayList<>();
                break;
            case 2:
                stack = new StackVector<>();
                break;
            case 3:
                System.out.println("Seleccione el tipo de lista:");
                System.out.println("1. Lista simplemente encadenada");
                System.out.println("2. Lista doblemente encadenada");
                int tipoLista = scanner.nextInt();
                if (tipoLista == 1) {
                    stack = new StackLista<>(new ListaSimple<>());
                } else {
                    stack = new StackLista<>(new ListaDoble<>());
                }
                break;
            default:
                System.out.println("Opción inválida. Usando Vector por defecto.");
                stack = new StackVector<>();
        }

        Calculadora calculadora = new Calculadora(stack);

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    String postfix = InfixToPostfix.convertir(linea);
                    double resultado = calculadora.evaluar(postfix);
                    System.out.println("Expresión: " + linea + " -> Postfix: " + postfix + " = " + resultado);
                } catch (Exception e) {
                    System.err.println("Error evaluando expresión: " + linea);
                    System.err.println("Motivo: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
