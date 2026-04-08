public static void main(String[] args) {
    ListaCircularDoble mesa = new ListaCircularDoble();
    mesa.agregar("Alejandro");
    mesa.agregar("Beatriz");
    mesa.agregar("Carlos");

    mesa.mostrar();

    mesa.sumarPuntos(10);
    mesa.siguienteTurno();
    mesa.sumarPuntos(20);

    System.out.println("\nEstado actual:");
    mesa.mostrar();

    mesa.expulsar("Beatriz");
    System.out.println("\nTras expulsar a Beatriz:");
    mesa.mostrar();
}
}