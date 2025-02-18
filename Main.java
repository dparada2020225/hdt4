import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 
 public class Main {
 
     /**
      * Punto de entrada del programa. Lee expresiones matemáticas desde un archivo
      * de texto y utiliza una instancia de la clase Calculadora para evaluarlas.
      * 
      * @param args Argumentos de línea de comandos (no utilizados en este programa).
      */
     public static void main(String[] args) {
         // Instancia de la calculadora que se utilizará para evaluar las expresiones.
         Calculadora calculadora = new Calculadora();
 
         // Intenta abrir y leer el archivo "datos.txt" que contiene las expresiones.
         try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
             String linea;
 
             // Lee cada línea del archivo.
             while ((linea = br.readLine()) != null) {
                 try {
                     // Evalúa la expresión en la línea actual utilizando la calculadora.
                     int resultado = calculadora.evaluar(linea);
 
                     // Muestra la expresión y su resultado.
                     System.out.println("Expresión: " + linea + " = " + resultado);
                 } catch (Exception e) {
                     // Captura y muestra errores al evaluar la expresión.
                     System.err.println("Error evaluando expresión: " + linea);
                     System.err.println("Motivo: " + e.getMessage());
                 }
             }
         } catch (IOException e) {
             // Captura y muestra errores al leer el archivo.
             System.err.println("Error al leer el archivo: " + e.getMessage());
         }
     }
 }
 