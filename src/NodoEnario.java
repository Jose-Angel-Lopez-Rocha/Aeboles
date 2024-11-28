public class NodoEnario {
        char valor;
        NodoEnario siguienteHermano;
        NodoEnario primerHijo;
        public NodoEnario(char valor) {
            this.valor = valor;
            this.primerHijo = null;
            this.siguienteHermano = null;
        }
    }
