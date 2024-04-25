import java.util.*;

class GrafoPonderado {
    private int vertices;
    private LinkedList<Nodo>[] adj;

    class Nodo {
        int destino;
        int peso;

        Nodo(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    GrafoPonderado(int v) {
        vertices = v;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adj[i] = new LinkedList<>();
    }

    void agregarArista(int origen, int destino, int peso) {
        Nodo nodo = new Nodo(destino, peso);
        adj[origen].add(nodo);
    }

    void imprimirGrafo() {
        for (int i = 0; i < vertices; ++i) {
            System.out.println("Lista de adyacencia del vértice " + i);
            for (Nodo nodo : adj[i])
                System.out.println(" -> " + nodo.destino + " (peso: " + nodo.peso + ")");
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int vertices = 10;
        GrafoPonderado grafo = new GrafoPonderado(vertices);

        grafo.agregarArista(0, 1, 3);
        grafo.agregarArista(0, 2, 5);

        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(1, 3, 7);

        grafo.agregarArista(2, 4, 4);

        grafo.agregarArista(3, 4, 1);
        grafo.agregarArista(3, 5, 8);

        grafo.agregarArista(4, 6, 6);

        grafo.agregarArista(5, 6, 9);

        grafo.agregarArista(6, 7, 10);
        grafo.agregarArista(6, 8, 3);

        grafo.agregarArista(7, 9, 5);

        grafo.agregarArista(8, 9, 4);

        grafo.imprimirGrafo();
    }
}
