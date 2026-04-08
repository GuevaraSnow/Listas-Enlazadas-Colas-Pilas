public class PlaylistMusica {

    static class Nodo {
        String cancion;
        String artista;
        Nodo siguiente;

        Nodo(String cancion, String artista) {
            this.cancion = cancion;
            this.artista = artista;
            this.siguiente = null;
        }
    }

    static class ListaCircular {
        private Nodo ultimo;
        private Nodo actual;
        private int tamanio;

        void agregar(String cancion, String artista) {
            Nodo nuevo = new Nodo(cancion, artista);
            if (ultimo == null) {
                nuevo.siguiente = nuevo;
                ultimo = nuevo;
                actual = nuevo;
            } else {
                nuevo.siguiente = ultimo.siguiente;
                ultimo.siguiente = nuevo;
                ultimo = nuevo;
            }
            tamanio++;
        }

        void siguiente() {
            if (ultimo != null) {
                actual = actual.siguiente;
            }
        }

        void eliminar(String cancion) {
            if (ultimo == null) return;

            Nodo anterior = ultimo;
            Nodo cursor = ultimo.siguiente;

            for (int i = 0; i < tamanio; i++) {
                if (cursor.cancion.equalsIgnoreCase(cancion)) {
                    if (tamanio == 1) {
                        ultimo = null;
                        actual = null;
                    } else {
                        anterior.siguiente = cursor.siguiente;
                        if (cursor == ultimo) ultimo = anterior;
                        if (cursor == actual) actual = cursor.siguiente;
                    }
                    tamanio--;
                    return;
                }
                anterior = cursor;
                cursor = cursor.siguiente;
            }
        }

        boolean buscar(String cancion) {
            if (ultimo == null) return false;
            Nodo cursor = ultimo.siguiente;
            for (int i = 0; i < tamanio; i++) {
                if (cursor.cancion.equalsIgnoreCase(cancion)) return true;
                cursor = cursor.siguiente;
            }
            return false;
        }

        void mostrar() {
            if (ultimo == null) return;
            Nodo cursor = ultimo.siguiente;
            for (int i = 0; i < tamanio; i++) {
                System.out.println(cursor.cancion + " - " + cursor.artista + (cursor == actual ? " [ACTUAL]" : ""));
                cursor = cursor.siguiente;
            }
        }
    }