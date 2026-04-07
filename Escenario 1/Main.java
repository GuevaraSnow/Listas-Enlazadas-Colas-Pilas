public class Main {
    public static void main(String[] args) {

        // Crear la cola de la panadería
        ColaPanaderia.Cola cola = new ColaPanaderia.Cola();

        // Agregar clientes
        cola.agregar("Juan");
        cola.agregar("María");
        cola.agregar("Carlos");
        cola.agregar("Ana");

        // Mostrar la cola
        cola.mostrar();

        // Ver quién sigue
        cola.verSiguiente();

        // Buscar clientes
        cola.buscar("Carlos");
        cola.buscar("Pedro");

        // Atender clientes
        cola.atender();
        cola.atender();

        // Mostrar estado después de atender
        cola.mostrar();

        // Ver siguiente nuevamente
        cola.verSiguiente();

        // Atender todos
        cola.atender();
        cola.atender();

        // Intentar atender cuando está vacía
        cola.atender();

        // Mostrar estado final
        cola.mostrar();
    }
}