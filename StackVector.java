/**
 * @param <E> El tipo de elementos que se almacenarán en el stack.
 */

 import java.util.Vector;

 public class StackVector<E> implements Stack<E> {
 
     /**
      * Vector que almacena los elementos del stack.
      */
     protected Vector<E> data;
 
     /**
      * Constructor que inicializa un stack vacío.
      * 
      * @post Se construye un stack vacío.
      */
     public StackVector() {
         data = new Vector<E>();
     }
 
     /**
      * Añade un elemento al stack.
      * 
      * @param item El elemento que se desea añadir al stack.
      * @post El elemento se añade al final del stack.
      */
     @Override
     public void push(E item) {
         data.add(item);
     }
 
     /**
      * Remueve y devuelve el elemento más recientemente añadido al stack.
      * 
      * @return El elemento que estaba en la cima del stack.
      * @pre El stack no debe estar vacío.
      * @post El elemento más reciente es removido y retornado.
      */
     @Override
     public E pop() {
         return data.remove(size() - 1);
     }
 
     /**
      * Devuelve el elemento en la cima del stack sin removerlo.
      * 
      * @return El elemento que está en la cima del stack.
      * @pre El stack no debe estar vacío.
      * @post Se devuelve el valor en la cima del stack sin modificarlo.
      */
     @Override
     public E peek() {
         return data.get(size() - 1);
     }
 
     /**
      * Devuelve el número de elementos en el stack.
      * 
      * @return El número de elementos almacenados en el stack.
      * @post Devuelve la cantidad de elementos en el stack.
      */
     @Override
     public int size() {
         return data.size();
     }
 
     /**
      * Verifica si el stack está vacío.
      * 
      * @return {@code true} si el stack está vacío, {@code false} en caso contrario.
      * @post Devuelve verdadero si el stack no contiene elementos.
      */
     @Override
     public boolean empty() {
         return size() == 0;
     }
 }
 