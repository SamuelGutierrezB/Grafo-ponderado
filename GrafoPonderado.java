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
        vertices = v; // 10
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adj[i] = new LinkedList<>();
    }

    // 0 2 5
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
        int vertices = 8;
        GrafoPonderado grafo = new GrafoPonderado(vertices);

        // A
        grafo.agregarArista(0, 1, 2);
        grafo.agregarArista(0, 5, 1);
        // B
        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(1, 3, 2);
        grafo.agregarArista(1, 4, 4);
        // C
        grafo.agregarArista(2, 1, 2);
        grafo.agregarArista(2, 4, 3);
        grafo.agregarArista(2, 6, 1);
        // D
        grafo.agregarArista(3, 1, 2);
        grafo.agregarArista(3, 4, 4);
        grafo.agregarArista(3, 5, 3);
        // E
        grafo.agregarArista(4, 2, 3);
        grafo.agregarArista(4, 1, 4);
        grafo.agregarArista(4, 3, 4);
        // F
        grafo.agregarArista(5, 0, 1);
        grafo.agregarArista(5, 3, 3);
        grafo.agregarArista(5, 6, 5);

        // G
        grafo.agregarArista(6, 5, 5);
        grafo.agregarArista(6, 4, 7);
        grafo.agregarArista(6, 7, 3);

        // H
        grafo.agregarArista(7, 2, 1);
        grafo.agregarArista(7, 6, 3);

        grafo.imprimirGrafo();
    }
}
