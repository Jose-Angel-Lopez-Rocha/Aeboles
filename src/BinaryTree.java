public class BinaryTree {
    nodoBinario raiz;

    private nodoBinario anadirRec(nodoBinario act, int valor) {
        if (act == null) {
            return new nodoBinario(valor);
        }

        if (valor < act.valor) {
            act.izq = anadirRec(act.izq, valor);
        } else if (valor > act.valor) {
            act.der = anadirRec(act.der, valor);
        } else {
            // Si el valor ya existe
            return act;
        }
        return act;
    }

    public void Anadir(int valor) {
        raiz = anadirRec(raiz, valor);
    }

    boolean contieneNodoRec(nodoBinario act, int valor) {
        if (act == null) {
            return false;
        }
        if (valor == act.valor) {
            return true;
        }
        return valor < act.valor
                ? contieneNodoRec(act.izq, valor)
                : contieneNodoRec(act.der, valor);
    }

    private nodoBinario borrarRec(nodoBinario act, int valor) {
        if (act == null) {
            return null;
        }
        if (valor == act.valor) {
            // Nodo a borrar encontrado

            // Caso 1: Nodo hoja
            if (act.izq == null && act.der == null) {
                return null;
            }

            // Caso 2: Nodo con unico hijo
            if (act.izq == null) {
                return act.der;
            }
            if (act.der == null) {
                return act.izq;
            }

            // Caso 3: Node con dos hijos
            int minVal = valorMin(act.der);
            act.valor = minVal;
            act.der = borrarRec(act.der, minVal);
            return act;
        }

        if (valor < act.valor) {
            act.izq = borrarRec(act.izq, valor);
            return act;
        }

        act.der = borrarRec(act.der, valor);
        return act;
    }

    private int valorMin(nodoBinario raiz) {
        return raiz.izq== null ? raiz.valor : valorMin(raiz.izq);
    }
    public boolean borrar(int valor) {
        if (!contieneNodoRec(raiz, valor)) {
            System.out.println("El nodo con valor " + valor + " no existe en el árbol.");
            return false; // No hacer nada si el nodo no existe.
        }

        raiz = borrarRec(raiz, valor); // Elimina el nodo solo si existe.
        System.out.println("Valor eliminado.");
        return true;
    }

    public void InOrder(nodoBinario node) {
        if (node != null) {
            InOrder(node.izq);
            System.out.print(" " + node.valor);
            InOrder(node.der);
        }
    }

    public void PreOrder(nodoBinario node) {
        if (node != null) {
            System.out.print(" " + node.valor);
            PreOrder(node.izq);
            PreOrder(node.der);
        }
    }

    public void PostOrder(nodoBinario node) {
        if (node != null) {
            PostOrder(node.izq);
            PostOrder(node.der);
            System.out.print(" " + node.valor);
        }
    }
}
