public class AVLTree {
    NodoAVL raiz;

    // Tener altura de nodos
    int altura(NodoAVL Alt) {
        if (Alt == null)
            return 0;
        return Alt.altura;
    }

    // Tener el numero maximo de dos
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Rotacion en Y
    NodoAVL rotacionDer(NodoAVL y) {
        NodoAVL x = y.izq;
        NodoAVL T2 = x.der;

        x.der = y;
        y.izq = T2;

        //Actualizar alturas
        y.altura = max(altura(y.izq), altura(y.der)) + 1;
        x.altura = max(altura(x.izq), altura(x.der)) + 1;

        // Retornar en x
        return x;
    }

    // Rotacion en X
    NodoAVL rotacionIzq(NodoAVL x) {
        NodoAVL y = x.der;
        NodoAVL T2 = y.izq;


        y.izq = x;
        x.der = T2;

        // Update heights
        x.altura = max(altura(x.izq), altura(x.der)) + 1;
        y.altura = max(altura(y.izq), altura(y.der)) + 1;

        // Retornar en y
        return y;
    }

    // Calculo balance
    int balance(NodoAVL Alt) {
        if (Alt == null)
            return 0;
        return altura(Alt.izq) - altura(Alt.der);
    }


    NodoAVL insertar(NodoAVL nodo, int val) {
        if (nodo == null)
            return (new NodoAVL(val));

        if (val < nodo.num)
            nodo.izq = insertar(nodo.izq, val);
        else if (val > nodo.num)
            nodo.der = insertar(nodo.der, val);
        else
            return nodo;

        // Actualizar la altra de su ancestro
        nodo.altura = 1 + max(altura(nodo.izq), altura(nodo.der));

        int balance = balance(nodo);

        // izq, izq
        if (balance > 1 && val < nodo.izq.num)
            return rotacionDer(nodo);

        // der,der
        if (balance < -1 && val > nodo.der.num)
            return rotacionIzq(nodo);

        // izq,der
        if (balance > 1 && val > nodo.izq.num) {
            nodo.izq = rotacionIzq(nodo.izq);
            return rotacionDer(nodo);
        }

        // der,izq
        if (balance < -1 && val < nodo.der.num) {
            nodo.der = rotacionDer(nodo.der);
            return rotacionIzq(nodo);
        }

        return nodo;
    }

    // Utility function to print preorder traversal of the tree
    void preOrder(NodoAVL node) {
        if (node != null) {
            System.out.print(node.num + " ");
            preOrder(node.izq);
            preOrder(node.der);
        }
    }

    // Utility function to print inorder traversal of the tree
    void inOrder(NodoAVL node) {
        if (node != null) {
            inOrder(node.izq);
            System.out.print(node.num + " ");
            inOrder(node.der);
        }
    }

    // Utility function to print postorder traversal of the tree
    void postOrder(NodoAVL node) {
        if (node != null) {
            postOrder(node.izq);
            postOrder(node.der);
            System.out.print(node.num + " ");
        }
    }
    // Buscar un nodo en el árbol
    NodoAVL busqueda(NodoAVL node, int cve) {
        // Caso base: el nodo es nulo o se encuentra el valor
        if (node == null || node.num == cve)
            return node;

        // Si la clave es menor, busca en el subárbol izquierdo
        if (cve < node.num)
            return busqueda(node.izq, cve);

        // Si la clave es mayor, busca en el subárbol derecho
        return busqueda(node.der, cve);
    }
    // Eliminar un nodo del árbol AVL
    NodoAVL borrar(NodoAVL raiz, int cve) {
        // Caso base: el árbol está vacío
        if (raiz == null)
            return raiz;

        // Realizar la eliminación estándar de un BST
        if (cve < raiz.num)
            raiz.izq = borrar(raiz.izq, cve);
        else if (cve > raiz.num)
            raiz.der = borrar(raiz.der, cve);
        else {
            // Nodo con solo un hijo o sin hijos
            if ((raiz.izq == null) || (raiz.der == null)) {
                NodoAVL temp = (raiz.izq != null) ? raiz.izq : raiz.der;

                // No hay hijos
                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else // Un hijo
                    raiz = temp;

                temp = null;
            } else {
                // Nodo con dos hijos: obtener el sucesor en el inorden
                NodoAVL temp = valorMin(raiz.der);

                // Copiar el valor del sucesor en el nodo actual
                raiz.num = temp.num;

                // Eliminar el sucesor en el subárbol derecho
                raiz.der = borrar(raiz.der, temp.num);
            }
        }

        // Si el árbol tenía solo un nodo
        if (raiz == null)
            return raiz;

        // Actualizar la altura del nodo actual
        raiz.altura = max(altura(raiz.izq), altura(raiz.der)) + 1;

        // Obtener el factor de balance de este nodo
        int balance = balance(raiz);

        // Si el nodo está desbalanceado, hay 4 casos:

        // Caso Izquierda Izquierda
        if (balance > 1 && balance(raiz.izq) >= 0)
            return rotacionDer(raiz);

        // Caso Izquierda Derecha
        if (balance > 1 && balance(raiz.izq) < 0) {
            raiz.izq = rotacionIzq(raiz.izq);
            return rotacionDer(raiz);
        }

        // Caso Derecha Derecha
        if (balance < -1 && balance(raiz.der) <= 0)
            return rotacionIzq(raiz);

        // Caso Derecha Izquierda
        if (balance < -1 && balance(raiz.der) > 0) {
            raiz.der = rotacionDer(raiz.der);
            return rotacionIzq(raiz);
        }

        return raiz;
    }

    // Obtener el nodo con el valor más pequeño
    NodoAVL valorMin(NodoAVL node) {
        NodoAVL act = node;

        // Encuentra la hoja más a la izquierda
        while (act.izq != null)
            act = act.izq;

        return act;
    }
}
