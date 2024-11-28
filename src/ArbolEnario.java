import java.util.Scanner;
public class ArbolEnario {
    // Función para insertar una palabra en el árbol n-ario
    public void insertarPalabra(NodoEnario raiz, String palabra) {
        NodoEnario actual = raiz;
        for (int i = 0; i < palabra.length(); i++) {
            NodoEnario hijoExistente = null;

            NodoEnario temp = actual.primerHijo;
            while (temp != null) {
                if (temp.valor == palabra.charAt(i)) {
                    hijoExistente = temp;
                    break;
                }
                temp = temp.siguienteHermano;
            }

            if (hijoExistente == null) {
                NodoEnario nuevoNodo = new NodoEnario(palabra.charAt(i));

                if (actual.primerHijo == null) {
                    actual.primerHijo = nuevoNodo;
                } else {
                    NodoEnario ultimoHermano = actual.primerHijo;
                    while (ultimoHermano.siguienteHermano != null) {
                        ultimoHermano = ultimoHermano.siguienteHermano;
                    }
                    ultimoHermano.siguienteHermano = nuevoNodo;
                }
                actual = nuevoNodo;
            } else {
                actual = hijoExistente;
            }
        }
    }

    // Función para mostrar el árbol n-ario de manera recursiva
    public void mostrarArbol(NodoEnario nodo, int nivel) {
        if (nodo == null) return;

        NodoEnario hijo = nodo.primerHijo;
        while (hijo != null) {
            // Imprimir con indentación
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            System.out.println("|-- " + hijo.valor);
            mostrarArbol(hijo, nivel + 1);  // Recursión sin el parámetro adicional
            hijo = hijo.siguienteHermano;  // Pasar al siguiente hermano
        }
    }


    // Función para liberar la memoria del árbol
    public void destruirArbol(NodoEnario nodo) {
        if (nodo == null) return;

        NodoEnario hijo = nodo.primerHijo;
        while (hijo != null) {
            NodoEnario siguienteHijo = hijo.siguienteHermano;
            destruirArbol(hijo);
            hijo = siguienteHijo;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolEnario arbolEnario = new ArbolEnario(); // Instanciar la clase
        NodoEnario raiz = null;
        String palabra;

        while (true) {
            System.out.print("Ingrese una palabra para insertar en el árbol (0 para salir): ");
            palabra = scanner.nextLine();

            if (palabra.equals("0")) {
                break;
            }

            if (raiz == null) {
                raiz = new NodoEnario(palabra.charAt(0));
            }

            arbolEnario.insertarPalabra(raiz, palabra);  // Llamar a método no estático

            System.out.println("Árbol actualizado:");
            arbolEnario.mostrarArbol(raiz, 0);  // Llamar a método no estático
        }

        arbolEnario.destruirArbol(raiz);  // Llamar a método no estático
        scanner.close();
    }
}
