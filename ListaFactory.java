public class ListaFactory {

    /**
     * Crea una instancia de Lista<Double> según el tipo elegido.
     *
     * @param tipoLista 1=ListaSimple, 2=ListaDoble
     * @return una implementación de Lista<Double>
     */
    public static Lista<Double> createLista(int tipoLista) {
        switch (tipoLista) {
            case 1:
                return new ListaSimple<>();
            case 2:
                return new ListaDoble<>();
            default:
                // Opción inválida -> usar ListaSimple por defecto
                return new ListaSimple<>();
        }
    }
}
