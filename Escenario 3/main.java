public static void main(String[] args) {
    ListaCircular playlist = new ListaCircular();
    playlist.agregar("Blinding Lights", "The Weeknd");
    playlist.agregar("Shape of You", "Ed Sheeran");
    playlist.agregar("Stay", "The Kid LAROI");

    playlist.mostrar();

    System.out.println("\nCambiando canción...");
    playlist.siguiente();
    playlist.mostrar();

    System.out.println("\nEliminando 'Shape of You'...");
    playlist.eliminar("Shape of You");
    playlist.mostrar();
}
}