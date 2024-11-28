import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        AVLTree avlTree = new AVLTree();
        ArbolEnario arbolEnario = new ArbolEnario();  // Instancia para el árbol n-ario

        // Menú principal
        while (true) {
            System.out.println("1. Menú Árbol Binario");
            System.out.println("2. Menú Árbol AVL");
            System.out.println("3. Menú Árbol B");
            System.out.println("4. Menú Árbol N-ario");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int mainOption = scanner.nextInt();

            switch (mainOption) {
                case 1:
                    BinaryMenu binaryMenu = new BinaryMenu(binaryTree, scanner);
                    break;
                case 2:
                    AVLMenu avlMenu = new AVLMenu(avlTree, scanner);
                    break;
                case 3:
                    // Solicitar el grado t del árbol B
                    System.out.print("Introduce el grado (t) del Árbol B: ");
                    int t = scanner.nextInt();

                    // Crear e interactuar con el menú del Árbol B
                    BMenu menuArbolB = new BMenu(t, scanner);
                    menuArbolB.mostrarMenu();
                    break;
                case 4:
                    // Aquí se muestra el menú para el árbol n-ario
                    EnarioMenu arbolEnarioMenu = new EnarioMenu();  // Instanciamos el menú del árbol n-ario
                    arbolEnarioMenu.mostrarMenu();  // Mostramos el menú del árbol n-ario
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
