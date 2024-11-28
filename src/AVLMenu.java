import java.util.Scanner;

public class AVLMenu {
    AVLTree avlArb =new AVLTree();
    AVLMenu(AVLTree arb, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=== Menú Árbol AVL ===");
            System.out.println("1. Insertar un nodo");
            System.out.println("2. Buscar un nodo");
            System.out.println("3. Eliminar un nodo");
            System.out.println("4. Recorrido Preorden");
            System.out.println("5. Recorrido Inorden");
            System.out.println("6. Recorrido Postorden");
            System.out.println("7. Volver al menú principal");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el valor a insertar: ");
                    int insertNum = scanner.nextInt();
                    arb.raiz = arb.insertar(arb.raiz,insertNum);
                    System.out.println("Valor insertado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingresa el valor a buscar: ");
                    int buscNum = scanner.nextInt();
                    NodoAVL result = arb.busqueda(arb.raiz, buscNum);
                    if (result != null)
                        System.out.println("Valor encontrado " + result.num);
                    else
                        System.out.println("Valor no encontrado.");
                    break;
                case 3:
                    System.out.print("Ingresa el valor a eliminar: ");
                    int borrarNum = scanner.nextInt();
                    arb.raiz = arb.borrar(arb.raiz, borrarNum);
                    System.out.println("Nodo eliminado");
                    break;
                case 4:
                    System.out.println("Recorrido Preorden:");
                    arb.preOrder(arb.raiz);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Recorrido Inorden:");
                    arb.inOrder(arb.raiz);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Recorrido Postorden:");
                    arb.postOrder(arb.raiz);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }
}
