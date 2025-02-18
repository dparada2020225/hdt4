import java.util.Scanner;

 public class Calculadora {
     
     /**
      * Pila que almacena los operandos durante la evaluación de la expresión.
      */
     Stack<Integer> stack = new StackVector<Integer>();
 
     /**
      * Obtiene el stack utilizado por la calculadora.
      * 
      * @return El stack actual de la calculadora.
      */
     public Stack<Integer> getStack() {
         return stack;
     }
 
     /**
      * Asigna un nuevo stack a la calculadora.
      * 
      * @param stack El nuevo stack que se va a asignar.
      */
     public void setStack(Stack<Integer> stack) {
         this.stack = stack;
     }
 
     /**
      * Constructor de la clase Calculadora. 
      * Inicializa la pila utilizando la implementación basada en Vector.
      */
     public Calculadora() {
         stack = new StackVector<>(); // Se usa la implementación con Vector
     }
 
     /**
      * Evalúa una expresión en notación postfija.
      * Los operandos se almacenan en un stack y las operaciones se realizan 
      * según los operadores encontrados.
      * 
      * @param operacion La expresión matemática en notación postfija.
      * @return El resultado de la evaluación de la expresión.
      * @throws IllegalArgumentException Si la expresión es inválida o incompleta.
      */
     public int evaluar(String operacion) {
         @SuppressWarnings("resource") // Se suprime el warning relacionado con Scanner no cerrado
         Scanner scanner = new Scanner(operacion);
 
         while (scanner.hasNext()) {
             if (scanner.hasNextInt()) {
                 stack.push(scanner.nextInt()); // Push del operando
             } else {
                 // Operador encontrado, hacer pop de dos operandos
                 String operador = scanner.next();
                 if (stack.size() < 2) {
                     throw new IllegalArgumentException("Expresión inválida: no hay suficientes operandos.");
                 }
                 int operandoB = stack.pop();
                 int operandoA = stack.pop();
                 stack.push(operar(operandoA, operandoB, operador));
             }
         }
 
         // Después del cálculo, el resultado debe ser el único elemento en la pila
         if (stack.size() != 1) {
             throw new IllegalArgumentException("Expresión inválida o incompleta.");
         }
         return stack.pop();
     }
 
     /**
      * Realiza la operación matemática especificada entre dos operandos.
      * 
      * @param operandoA El primer operando.
      * @param operandoB El segundo operando.
      * @param operador El operador que define la operación a realizar.
      *                 Puede ser "+", "-", "*", "/", o "%".
      * @return El resultado de la operación.
      * @throws ArithmeticException Si se intenta realizar una división por cero.
      * @throws IllegalArgumentException Si el operador es desconocido.
      */
     private int operar(int operandoA, int operandoB, String operador) {
         switch (operador) {
             case "+": return operandoA + operandoB;
             case "-": return operandoA - operandoB;
             case "*": return operandoA * operandoB;
             case "/":
                 if (operandoB == 0) throw new ArithmeticException("División por cero.");
                 return operandoA / operandoB;
             case "%": return operandoA % operandoB;
             default:
                 throw new IllegalArgumentException("Operador desconocido: " + operador);
         }
     }
 }
 