public class Main {
    public static void main(String[] args) {

        // Crear el historial
        HistorialNavegador.ListaDoble historial = new HistorialNavegador.ListaDoble();

        // Visitar páginas
        historial.visitar("google.com");
        historial.visitar("youtube.com");
        historial.visitar("github.com");
        historial.visitar("stackoverflow.com");

        // Mostrar historial completo
        historial.mostrar();

        // Mostrar página actual
        historial.mostrarActual();

        // Retroceder
        historial.retroceder();
        historial.mostrarActual();

        historial.retroceder();
        historial.mostrarActual();

        // Avanzar
        historial.avanzar();
        historial.mostrarActual();

        // Buscar URLs
        historial.buscar("youtube.com");
        historial.buscar("facebook.com");

        // Visitar nueva página (esto elimina el "futuro")
        historial.visitar("wikipedia.org");
        historial.mostrar();

        // Intentar avanzar (ya no debería poder)
        historial.avanzar();

        // Eliminar página actual
        historial.eliminarActual();
        historial.mostrar();

        // Eliminar varias páginas
        historial.eliminarActual();
        historial.eliminarActual();
        historial.mostrar();

        // Mostrar estado final
        historial.mostrarActual();
    }
}