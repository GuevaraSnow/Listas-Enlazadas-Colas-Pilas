public class HistorialNavegador {

    public static class Nodo {
        String url;
        Nodo anterior;
        Nodo siguiente;

        Nodo(String url) {
            this.url = url;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    public static class ListaDoble {
        private Nodo actual;   // Página donde está el usuario ahora
        private int tamanio;

        ListaDoble() {
            actual = null;
            tamanio = 0;
        }

        // Visitar una nueva página (agrega después del nodo actual
        // y elimina cualquier "futuro" existente)
        public void visitar(String url) {
            Nodo nuevo = new Nodo(url);
            if (actual == null) {
                actual = nuevo;
            } else {
                // Descartar páginas "futuras" al abrir una URL nueva
                actual.siguiente = nuevo;
                nuevo.anterior = actual;
                actual = nuevo;
            }
            tamanio++;
            System.out.println("✔ Visitando: " + url);
        }

        // Retroceder a la página anterior
        public void retroceder() {
            if (actual == null || actual.anterior == null) {
                System.out.println("✘ No hay página anterior.");
                return;
            }
            actual = actual.anterior;
            System.out.println("◀ Retrocediendo a: " + actual.url);
        }

        // Avanzar a la página siguiente (si existe)
        public void avanzar() {
            if (actual == null || actual.siguiente == null) {
                System.out.println("✘ No hay página siguiente.");
                return;
            }
            actual = actual.siguiente;
            System.out.println("▶ Avanzando a: " + actual.url);
        }

        // Eliminar la página actual del historial
        public void eliminarActual() {
            if (actual == null) {
                System.out.println("✘ El historial está vacío.");
                return;
            }
            System.out.println("✔ Eliminando página: " + actual.url);
            Nodo aBorrar = actual;

            if (actual.anterior != null) {
                actual.anterior.siguiente = actual.siguiente;
            }
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;
            }

            // Mover el puntero actual
            if (actual.anterior != null) {
                actual = actual.anterior;
            } else {
                actual = actual.siguiente;
            }
            tamanio--;
        }

        // Buscar una URL en el historial completo
        boolean buscar(String url) {
            Nodo cursor = actual;
            // Ir al inicio
            while (cursor != null && cursor.anterior != null) {
                cursor = cursor.anterior;
            }
            while (cursor != null) {
                if (cursor.url.equalsIgnoreCase(url)) {
                    System.out.println("✔ URL encontrada en historial: " + url);
                    return true;
                }
                cursor = cursor.siguiente;
            }
            System.out.println("✘ URL no encontrada: " + url);
            return false;
        }

        // Mostrar página actual
        public void mostrarActual() {
            if (actual == null) {
                System.out.println("✘ No hay página activa.");
                return;
            }
            System.out.println("📄 Página actual: " + actual.url);
            System.out.println("   ← Anterior : "
                    + (actual.anterior != null ? actual.anterior.url : "ninguna"));
            System.out.println("   → Siguiente: "
                    + (actual.siguiente != null ? actual.siguiente.url : "ninguna"));
        }

        // Mostrar todo el historial desde el inicio
        public void mostrar() {
            Nodo cursor = actual;
            while (cursor != null && cursor.anterior != null) {
                cursor = cursor.anterior;
            }
            if (cursor == null) {
                System.out.println("✘ El historial está vacío.");
                return;
            }
            System.out.println("\n--- Historial de navegación ---");
            while (cursor != null) {
                String marca = (cursor == actual) ? " ◄ [ACTUAL]" : "";
                System.out.println("  " + cursor.url + marca);
                cursor = cursor.siguiente;
            }
            System.out.println("-------------------------------\n");
        }
    }
}