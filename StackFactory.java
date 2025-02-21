public class StackFactory {

    /**
     * Crea una instancia de Stack<Double> según la opción de implementación elegida.
     *
     * @param opcion    1=ArrayList, 2=Vector, 3=Lista encadenada
     * @param tipoLista 1=ListaSimple, 2=ListaDoble (solo se usa si opcion=3)
     * @return Stack<Double> con la implementación seleccionada
     */
    public static Stack<Double> createStack(int opcion, int tipoLista) {
        switch (opcion) {
            case 1:
                return new StackArrayList<>();
            case 2:
                return new StackVector<>();
            case 3:
                // Se delega la creación de la lista a ListaFactory (Commit #2),
                // pero aquí asumimos que ya existe:
                return new StackLista<>(ListaFactory.createLista(tipoLista));
            default:
                // Opción inválida -> usar Vector por defecto
                return new StackVector<>();
        }
    }
}
