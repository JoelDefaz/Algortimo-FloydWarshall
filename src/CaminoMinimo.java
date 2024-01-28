/**
 * @author Joel Defaz
 */
public class CaminoMinimo {
    private static int INFINITO = 0xFFFF;
    private GrafoPonderado grafo;                   //Grafo en el ue trabajamos
    private int[][] matrizDeDistancias;             //Matriz que contendrá las rutas minimas desde un vertice i a un vertice j
    private int vertice_origen, numero_vertices;    // vértice origen y número de vértices
    private int[][] matrizDeRecorridos;             // Matriz que contendrá la ruta por la que pasa el minimo recorrido

    //Constructor que inicializa las variables necesarias
    public CaminoMinimo(GrafoPonderado grafo, int origen) {
        this.grafo = grafo;
        numero_vertices = grafo.getNumeroDeVertices();
        vertice_origen = origen;
        matrizDeDistancias = grafo.matrizDePesos;
        matrizDeRecorridos = new int[numero_vertices][numero_vertices];
        int m = 0;
        //Llena la matriz de recorridos, colocando la posición de la columna en toda la columna
        for (int i = 0; i < numero_vertices; i++) {
            for (int j = 0; j < numero_vertices; j++) {
                if (i == j) {
                    matrizDeRecorridos[j][i] = INFINITO;
                } else {
                    matrizDeRecorridos[j][i] = m;
                }
            }
            m++;
        }
    }

    // Implementación del Algoritmo de Floyd Warshall
    public void caminoMinimos() {
        // Recorre la los valores en toda la columna y fila i de la matriz de recorridos
        for (int i = 0; i < numero_vertices; i++) {
            // Recorre los valores en toda la columna j de la matriz de recorridos
            for (int j = 0; j < numero_vertices; j++) {
                // Recorre los valores en toda la fila k de la matriz de recorridos
                for (int k = 0; k < numero_vertices; k++) {
                    //Si la suma de los valores i y k con la de j e i es menor que el valor en la interssion j y k
                    if (matrizDeDistancias[i][k] + matrizDeDistancias[j][i] < matrizDeDistancias[j][k]) {
                        //Entonces actualiza el valor de la distancia (Siendo esta la más corta)
                        matrizDeDistancias[j][k] = matrizDeDistancias[i][k] + matrizDeDistancias[j][i];
                        //A la vez coloca en la matriz de recorridos el valor i en la misma posicion
                        //Representando asi la ruta por donde pasa
                        matrizDeRecorridos[j][k] = i;
                    }
                }
            }
        }
    }

    public void imprimirSolucion() {
        System.out.printf("Distancia desde el vertice "+ grafo.vertices[vertice_origen].getNombreDelVertice() +" a los vertices\n");
        for(int i = 0; i < numero_vertices; i++){
            System.out.printf(grafo.vertices[i].getNombreDelVertice() + " : "+ matrizDeDistancias[vertice_origen][i] + "\t\tRuta" + getRuta(i) + "\n");
        }
    }

    private String getRuta(int vertice_final) {
        String ruta = "";
        int vertice = vertice_origen;
        while(vertice != INFINITO){
            ruta += " -> " + grafo.vertices[vertice].getNombreDelVertice();
            vertice = matrizDeRecorridos[vertice][vertice_final];
        }
        return ruta;
    }
}