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

    void dijkstra(int inicio, int fin) {
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(vertices, Comparator.comparingInt(n -> n.peso));
        int[] distancias = new int[vertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicio] = 0;
        colaPrioridad.add(new Nodo(inicio, 0));

        while (!colaPrioridad.isEmpty()) {
            int u = colaPrioridad.remove().destino;

            for (Nodo nodo : adj[u]) {
                int v = nodo.destino;
                int peso = nodo.peso;
                if (distancias[u] != Integer.MAX_VALUE && distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    colaPrioridad.add(new Nodo(v, distancias[v]));
                }
            }
        }

        System.out.println(
                "La distancia más corta desde el nodo " + inicio + " al nodo " + fin + " es: " + distancias[fin]);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int vertices = 8;
        GrafoPonderado grafo = new GrafoPonderado(vertices);

        grafo.agregarArista(0, 1, 2);
        grafo.agregarArista(0, 5, 1);
        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(1, 3, 2);
        grafo.agregarArista(1, 4, 4);
        grafo.agregarArista(2, 1, 2);
        grafo.agregarArista(2, 4, 3);
        grafo.agregarArista(2, 6, 1);
        grafo.agregarArista(3, 1, 2);
        grafo.agregarArista(3, 4, 4);
        grafo.agregarArista(3, 5, 3);
        grafo.agregarArista(4, 2, 3);
        grafo.agregarArista(4, 1, 4);
        grafo.agregarArista(4, 3, 4);
        grafo.agregarArista(5, 0, 1);
        grafo.agregarArista(5, 3, 3);
        grafo.agregarArista(5, 6, 5);
        grafo.agregarArista(6, 5, 5);
        grafo.agregarArista(6, 4, 7);
        grafo.agregarArista(6, 7, 3);
        grafo.agregarArista(7, 2, 1);
        grafo.agregarArista(7, 6, 3);

        grafo.imprimirGrafo();

        System.out.print("Ingrese el nodo de inicio: ");
        int inicio = scanner.nextInt();
        System.out.print("Ingrese el nodo de fin: ");
        int fin = scanner.nextInt();

        grafo.dijkstra(inicio, fin);
    }
}
