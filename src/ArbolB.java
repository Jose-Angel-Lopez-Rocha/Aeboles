public class ArbolB {
    /**
     * Clase para representar el Árbol B
     */
        NodoArbolB root;
        int t;

        // Constructor
        public ArbolB(int t) {
            this.t = t;
            root = new NodoArbolB(t);
        }

        public int buscarClaveMayor() {
            int claveMaxima = getClaveMayor(this.root);
            return claveMaxima;
        }

        private int getClaveMayor(NodoArbolB current) {
            if (current == null) {
                return 0; // Si es cero no existe
            }

            // Mientras no sea una hoja
            while (!current.leaf) {
                // Se accede al hijo más a la derecha
                current = current.child[current.n];
            }

            return claveMayorPorNodo(current);
        }

        private int claveMayorPorNodo(NodoArbolB current) {
            // Devuelve el valor mayor, el que está más a la derecha
            return current.key[current.n - 1];
        }

        public void mostrarClavesNodoMinimo() {
            NodoArbolB temp = buscarNodoMinimo(root);

            if (temp == null) {
                System.out.println("Sin mínimo");
            } else {
                temp.imprimir();
            }
        }

        public NodoArbolB buscarNodoMinimo(NodoArbolB nodoActual) {
            if (root == null) {
                return null;
            }

            NodoArbolB aux = root;

            // Mientras no sea una hoja
            while (!aux.leaf) {
                // Se accede al primer hijo
                aux = aux.child[0];
            }

            // Devuelve el nodo menor, el que está más a la izquierda
            return aux;
        }

        // Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
        public void buscarNodoPorClave(int num) {
            NodoArbolB temp = search(root, num);

            if (temp == null) {
                System.out.println("No se ha encontrado un nodo con el valor ingresado");
            } else {
                print(temp);
            }
        }

        // Search
        private NodoArbolB search(NodoArbolB actual, int key) {
            int i = 0; // Se empieza a buscar siempre en la primera posición

            // Incrementa el índice mientras el valor de la clave del nodo sea menor
            while (i < actual.n && key > actual.key[i]) {
                i++;
            }

            // Si la clave es igual, entonces retornamos el nodo
            if (i < actual.n && key == actual.key[i]) {
                return actual;
            }

            // Si llegamos hasta aquí, entonces hay que buscar los hijos
            // Se revisa primero si tiene hijos
            if (actual.leaf) {
                return null;
            } else {
                // Si tiene hijos, hace una llamada recursiva
                return search(actual.child[i], key);
            }
        }

        public void insertar(int key) {
            NodoArbolB r = root;

            // Si el nodo está lleno lo debe separar antes de insertar
            if (r.n == ((2 * t) - 1)) {
                NodoArbolB s = new NodoArbolB(t);
                root = s;
                s.leaf = false;
                s.n = 0;
                s.child[0] = r;
                split(s, 0, r);
                nonFullInsert(s, key);
            } else {
                nonFullInsert(r, key);
            }
        }

        // Caso cuando la raíz se divide
        private void split(NodoArbolB x, int i, NodoArbolB y) {
            // Nodo temporal que será el hijo i + 1 de x
            NodoArbolB z = new NodoArbolB(t);
            z.leaf = y.leaf;
            z.n = (t - 1);

            // Copia las últimas (t - 1) claves del nodo y al inicio del nodo z
            for (int j = 0; j < (t - 1); j++) {
                z.key[j] = y.key[(j + t)];
            }

            // Si no es hoja hay que reasignar los nodos hijos
            if (!y.leaf) {
                for (int k = 0; k < t; k++) {
                    z.child[k] = y.child[(k + t)];
                }
            }

            // Nuevo tamaño de y
            y.n = (t - 1);

            // Mueve los hijos de x para darle espacio a z
            for (int j = x.n; j > i; j--) {
                x.child[(j + 1)] = x.child[j];
            }

            // Reasigna el hijo (i+1) de x
            x.child[(i + 1)] = z;

            // Mueve las claves de x
            for (int j = x.n; j > i; j--) {
                x.key[(j + 1)] = x.key[j];
            }

            // Agrega la clave situada en la mediana
            x.key[i] = y.key[(t - 1)];
            x.n++;
        }

        private void nonFullInsert(NodoArbolB x, int key) {
            // Si es una hoja
            if (x.leaf) {
                int i = x.n; // cantidad de valores del nodo
                // Busca la posición i donde asignar el valor
                while (i >= 1 && key < x.key[i - 1]) {
                    x.key[i] = x.key[i - 1]; // Desplaza los valores mayores a key
                    i--;
                }

                x.key[i] = key; // Asigna el valor al nodo
                x.n++; // Aumenta la cantidad de elementos del nodo
            } else {
                int j = 0;
                // Busca la posición del hijo
                while (j < x.n && key > x.key[j]) {
                    j++;
                }

                // Si el nodo hijo está lleno lo separa
                if (x.child[j].n == (2 * t - 1)) {
                    split(x, j, x.child[j]);

                    if (key > x.key[j]) {
                        j++;
                    }
                }

                nonFullInsert(x.child[j], key);
            }
        }

        public void showBTree() {
            print(root);
        }

        // Print en preorder
        private void print(NodoArbolB n) {
            n.imprimir();

            // Si no es hoja
            if (!n.leaf) {
                // Recorre los nodos para saber si tiene hijos
                for (int j = 0; j <= n.n; j++) {
                    if (n.child[j] != null) {
                        System.out.println();
                        print(n.child[j]);
                    }
                }
            }
        }
    }

    /**
     * Clase Nodo del Árbol B
     */
    class NodoArbolB {

        int n; // Número de claves almacenadas en el nodo
        boolean leaf; // Si el nodo es hoja (nodo hoja=true; nodo interno=false)
        int key[];  // Almacena las claves en el nodo
        NodoArbolB child[]; // Arreglo con referencias a los hijos

        // Constructor
        public NodoArbolB(int t) {
            n = 0;
            leaf = true;
            key = new int[((2 * t) - 1)];
            child = new NodoArbolB[(2 * t)];
        }

        public void imprimir() {
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                if (i < n - 1) {
                    System.out.print(key[i] + " | ");
                } else {
                    System.out.print(key[i]);
                }
            }
            System.out.print("]");
        }

        public int find(int k) {
            for (int i = 0; i < n; i++) {
                if (key[i] == k) {
                    return i;
                }
            }
            return -1;
        }
    }
