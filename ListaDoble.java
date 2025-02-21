public class ListaDoble<E> implements Lista<E> {
    private Nodo<E> cabeza, cola;
    private int tamano = 0;

    public void agregar(E item) {
        Nodo<E> nuevo = new Nodo<>(item, null, cola);
        if (cola != null) cola.siguiente = nuevo;
        cola = nuevo;
        if (cabeza == null) cabeza = nuevo;
        tamano++;
    }

    public E removerUltimo() {
        if (cola == null) return null;
        E item = cola.valor;
        cola = cola.anterior;
        if (cola != null) cola.siguiente = null;
        else cabeza = null;
        tamano--;
        return item;
    }

    public E obtenerUltimo() {
        return cola != null ? cola.valor : null;
    }

    public int tamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente, anterior;

        Nodo(T valor, Nodo<T> siguiente, Nodo<T> anterior) {
            this.valor = valor;
            this.siguiente = siguiente;
            this.anterior = anterior;
        }
    }
}
