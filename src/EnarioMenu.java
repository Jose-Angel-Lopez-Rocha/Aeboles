import java.util.Scanner;

public class EnarioMenu {
    private ArbolEnario arbolEnario;
    private Scanner scanner;
    private NodoEnario raiz; // Mover la raíz fuera del método

    // Constructor
    public EnarioMenu() {
        arbolEnario = new ArbolEnario();
        scanner = new Scanner(System.in);
        raiz = null; // Inicializar la raíz
    }

    // Método para mostrar el menú y gestionar las opciones
    public void mostrarMenu() {
        String palabra;

        while (true) {
            System.out.println("\n--- Menú Árbol N-ario ---");
            System.out.println("1. Insertar una palabra");
            System.out.println("2. Mostrar el árbol");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese una palabra para insertar: ");
                    palabra = scanner.nextLine();

                    if (raiz == null) {
                        raiz = new NodoEnario(palabra.charAt(0));  // La primera letra de la palabra es la raíz
                    }

                    arbolEnario.insertarPalabra(raiz, palabra);
                    System.out.println("Palabra insertada correctamente.");
                    break;

                case 2:
                    if (raiz == null) {
                        System.out.println("El árbol está vacío.");
                    } else {
                        System.out.println("Mostrando el árbol:");
                        arbolEnario.mostrarArbol(raiz, 0);
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;  // Sale del programa

                default:
                    System.out.println("Opción no válida, por favor elija una opción válida.");
            }
        }
    }
}

