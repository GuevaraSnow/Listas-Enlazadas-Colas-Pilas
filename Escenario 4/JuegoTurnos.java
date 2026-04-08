public class JuegoTurnos {

    static class Nodo {
        String nombre;
        int puntuacion;
        Nodo siguiente;
        Nodo anterior;

        Nodo(String nombre) {
            this.nombre = nombre;
            this.puntuacion = 0;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    static class ListaCircularDoble {
        private Nodo actual;
        private int tamanio;

        void agregar(String nombre) {
            Nodo nuevo = new Nodo(nombre);
            if (actual == null) {
                nuevo.siguiente = nuevo;
                nuevo.anterior = nuevo;
                actual = nuevo;
            } else {
                Nodo ultimo = actual.anterior;
                ultimo.siguiente = nuevo;
                nuevo.anterior = ultimo;
                nuevo.siguiente = actual;
                actual.anterior = nuevo;
            }
            tamanio++;
        }

        void expulsar(String nombre) {
            if (actual == null) return;
            Nodo cursor = actual;
            for (int i = 0; i < tamanio; i++) {
                if (cursor.nombre.equalsIgnoreCase(nombre)) {
                    if (tamanio == 1) {
                        actual = null;
                    } else {
                        cursor.anterior.siguiente = cursor.siguiente;
                        cursor.siguiente.anterior = cursor.anterior;
                        if (cursor == actual) actual = cursor.siguiente;
                    }
                    tamanio--;
                    return;
                }
                cursor = cursor.siguiente;
            }
        }

        void siguienteTurno() {
            if (actual != null) actual = actual.siguiente;
        }

        void anteriorTurno() {
            if (actual != null) actual = actual.anterior;
        }

        void sumarPuntos(int puntos) {
            if (actual != null) actual.puntuacion += puntos;
        }

        boolean buscar(String nombre) {
            if (actual == null) return false;
            Nodo cursor = actual;
            for (int i = 0; i < tamanio; i++) {
                if (cursor.nombre.equalsIgnoreCase(nombre)) return true;
                cursor = cursor.siguiente;
            }
            return false;
        }

        void mostrar() {
            if (actual == null) return;
            Nodo cursor = actual;
            for (int i = 0; i < tamanio; i++) {
                System.out.println(cursor.nombre + " (" + cursor.puntuacion + " pts)" + (cursor == actual ? " [TURNO]" : ""));
                cursor = cursor.siguiente;
            }
        }
    }