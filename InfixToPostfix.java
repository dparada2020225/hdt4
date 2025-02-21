import java.util.Stack;

public class InfixToPostfix {
    public static String convertir(String expresion) {
        StringBuilder resultado = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean numeroAnterior = false;

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isDigit(c) || c == '.') { // Permitir números decimales
                resultado.append(c);
                numeroAnterior = true;
            } else if (c == '(') {
                stack.push(c);
                numeroAnterior = false;
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    resultado.append(" ").append(stack.pop());
                }
                stack.pop(); // Eliminar '(' de la pila
                numeroAnterior = true;
            } else if (esOperador(c)) {
                if (numeroAnterior) {
                    resultado.append(" ");
                }
                while (!stack.isEmpty() && prioridad(c) <= prioridad(stack.peek())) {
                    resultado.append(stack.pop()).append(" ");
                }
                stack.push(c);
                numeroAnterior = false;
            }
        }

        while (!stack.isEmpty()) {
            resultado.append(" ").append(stack.pop());
        }

        return resultado.toString().trim();
    }

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int prioridad(char operador) {
        switch (operador) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    }
}
