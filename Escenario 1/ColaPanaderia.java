public class ColaPanaderia {

    public static class Nodo {
        String nombreCliente;
        int numeroTurno;
        Nodo siguiente;

        Nodo(String nombreCliente, int numeroTurno) {
            this.nombreCliente = nombreCliente;
            this.numeroTurno = numeroTurno;
            this.siguiente = null;
        }
    }

    public static class Cola {
        private Nodo frente;   // Primer cliente en espera
        private Nodo final_;   // Último cliente registrado
        private int tamanio;
        private int contadorTurnos;

        Cola() {
            frente = null;
            final_ = null;
            tamanio = 0;
            contadorTurnos = 1;
        }

        // Agregar un nuevo cliente al final de la cola (enqueue)
        public void agregar(String nombreCliente) {
            Nodo nuevo = new Nodo(nombreCliente, contadorTurnos++);
            if (estaVacia()) {
                frente = nuevo;
                final_ = nuevo;
            } else {
                final_.siguiente = nuevo;
                final_ = nuevo;
            }
            tamanio++;
            System.out.println("✔ Cliente registrado: " + nombreCliente
                    + " | Turno #" + nuevo.numeroTurno);
        }

        // Atender (eliminar) al primer cliente de la cola (dequeue)
        Nodo atender() {
            if (estaVacia()) {
                System.out.println("✘ No hay clientes en espera.");
                return null;
            }
            Nodo atendido = frente;
            frente = frente.siguiente;
            if (frente == null) final_ = null;
            tamanio--;
            System.out.println("✔ Atendiendo a: " + atendido.nombreCliente
                    + " | Turno #" + atendido.numeroTurno);
            return atendido;
        }

        // Consultar quién es el siguiente sin eliminarlo (peek)
        public void verSiguiente() {
            if (estaVacia()) {
                System.out.println("✘ La cola está vacía.");
                return;
            }
            System.out.println("▶ Siguiente en ser atendido: "
                    + frente.nombreCliente
                    + " | Turno #" + frente.numeroTurno);
        }

        // Buscar un cliente por nombre
        public boolean buscar(String nombre) {
            Nodo actual = frente;
            while (actual != null) {
                if (actual.nombreCliente.equalsIgnoreCase(nombre)) {
                    System.out.println("✔ Cliente encontrado: " + actual.nombreCliente
                            + " | Turno #" + actual.numeroTurno);
                    return true;
                }
                actual = actual.siguiente;
            }
            System.out.println("✘ Cliente '" + nombre + "' no está en la cola.");
            return false;
        }

        // Mostrar todos los clientes en espera
        public void mostrar() {
            if (estaVacia()) {
                System.out.println("✘ La cola está vacía.");
                return;
            }
            System.out.println("\n--- Lista de turnos actuales (" + tamanio + " clientes) ---");
            Nodo actual = frente;
            int posicion = 1;
            while (actual != null) {
                System.out.println("  " + posicion + ". "
                        + actual.nombreCliente + " (Turno #" + actual.numeroTurno + ")");
                actual = actual.siguiente;
                posicion++;
            }
            System.out.println("--------------------------------------------------\n");
        }

        boolean estaVacia() {
            return frente == null;
        }

        int getTamanio() {
            return tamanio;
        }
    }

}
