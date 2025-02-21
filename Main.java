import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Se obtienen opciones del usuario
        System.out.println("Seleccione la implementación del Stack:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista encadenada");
        int opcionStack = scanner.nextInt();

        int tipoLista = 0;
        if (opcionStack == 3) {
            // Si el usuario eligió 'Lista encadenada', preguntamos qué tipo
            System.out.println("Seleccione el tipo de lista:");
            System.out.println("1. Lista simplemente encadenada");
            System.out.println("2. Lista doblemente encadenada");
            tipoLista = scanner.nextInt();
        }

        // Se delega la creación del Stack a la fábrica
        Stack<Double> stack = StackFactory.createStack(opcionStack, tipoLista);

        // (Resto del código para usar la Calculadora y leer el archivo)
        Calculadora calculadora = new Calculadora(stack);

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    String postfix = InfixToPostfix.convertir(linea);
                    double resultado = calculadora.evaluar(postfix);
                    System.out.println("Expresión: " + linea
                                       + " -> Postfix: " + postfix
                                       + " = " + resultado);
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
