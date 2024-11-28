import java.util.Scanner;

public class BMenu {

    private ArbolB arbol;
    private Scanner scanner;

    // Constructor que recibe el grado del árbol
    public BMenu(int t, Scanner scanner) {
        this.arbol = new ArbolB(t);
        this.scanner = scanner;
    }

    // Método para mostrar el menú y permitir la interacción
    public void mostrarMenu() {
        while (true) {
            // Mostrar el menú de opciones
            System.out.println("\n--- Menú Árbol B ---");
            System.out.println("1. Insertar clave");
            System.out.println("2. Buscar clave mayor");
            System.out.println("3. Mostrar árbol");
            System.out.println("4. Buscar nodo por clave");
            System.out.println("5. Mostrar claves del nodo mínimo");
            System.out.println("6. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    insertarClave();
                    break;

                case 2:
                    buscarClaveMayor();
                    break;

                case 3:
                    mostrarArbol();
                    break;

                case 4:
                    buscarNodoPorClave();
                    break;

                case 5:
                    mostrarClavesNodoMinimo();
                    break;

                case 6:
                    return; // Volver al menú principal

                default:
                    System.out.println("Opción no válida. Inténtalo nuevamente.");
                    break;
            }
        }
    }

    private void insertarClave() {
        System.out.print("Introduce la clave a insertar: ");
        int clave = scanner.nextInt();
        arbol.insertar(clave);
        System.out.println("Clave insertada.");
    }

    private void buscarClaveMayor() {
        int claveMayor = arbol.buscarClaveMayor();
        System.out.println("La clave mayor es: " + claveMayor);
    }

    private void mostrarArbol() {
        arbol.showBTree();
    }

    private void buscarNodoPorClave() {
        System.out.print("Introduce la clave a buscar: ");
        int claveBuscar = scanner.nextInt();
        arbol.buscarNodoPorClave(claveBuscar);
    }

    private void mostrarClavesNodoMinimo() {
        arbol.mostrarClavesNodoMinimo();
    }
}