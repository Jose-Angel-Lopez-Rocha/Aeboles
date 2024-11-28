import java.util.Scanner;

public class BinaryMenu {
    BinaryTree binaryArb =new BinaryTree();
    BinaryMenu(BinaryTree binaryTree, Scanner scanner){
        int option;
        do {
            System.out.println("\n=== Menú Árbol Binario ===");
            System.out.println("1. Agregar un valor");
            System.out.println("2. Eliminar un valor");
            System.out.println("3. Buscar un valor");
            System.out.println("4. Recorrido en orden");
            System.out.println("5. Recorrido preorden");
            System.out.println("6. Recorrido postorden");
            System.out.println("7. Volver al menú principal");
            System.out.print("Elija una opción: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el valor a agregar: ");
                    int addValue = scanner.nextInt();
                    binaryTree.Anadir(addValue);
                    System.out.println("Valor agregado.");
                    break;
                case 2:
                    System.out.print("Ingrese el valor a eliminar: ");
                    int deleteValue = scanner.nextInt();
                    binaryTree.borrar(deleteValue);
                    break;
                case 3:
                    System.out.print("Ingrese el valor a buscar: ");
                    int searchValue = scanner.nextInt();
                    if (binaryTree.contieneNodoRec(binaryTree.raiz, searchValue)) {
                        System.out.println("El valor está en el árbol.");
                    } else {
                        System.out.println("El valor no está en el árbol.");
                    }
                    break;
                case 4:
                    System.out.println("Recorrido en orden:");
                    binaryTree.InOrder(binaryTree.raiz);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Recorrido preorden:");
                    binaryTree.PreOrder(binaryTree.raiz);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Recorrido postorden:");
                    binaryTree.PostOrder(binaryTree.raiz);
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 7);
    }
}
