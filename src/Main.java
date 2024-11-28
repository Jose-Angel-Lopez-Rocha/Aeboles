import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree binaryTree = new BinaryTree();
        AVLTree avlTree=new AVLTree();
        while (true){
            System.out.println("1. Menu Árbol Binario");
            System.out.println("2. Menu Árbol AVL");
            System.out.println("3. Salir");
            System.out.print("Elije una opción: ");

            int mainOption = scanner.nextInt();

            switch (mainOption) {
                case 1:
                    BinaryMenu binaryMenu=new BinaryMenu(binaryTree,scanner);
                    break;
                case 2:
                    AVLMenu  avlMenu=new AVLMenu(avlTree,scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}