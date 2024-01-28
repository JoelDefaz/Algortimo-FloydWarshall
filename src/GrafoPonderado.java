/**
 * @author Joel Defaz
 */
public class GrafoPonderado {
    static int INFINITO = 0xFFFF;
    int[][] matrizDePesos;
    int numeroDeVertices;
    static final int maxVerts = 20;
    Vertice[] vertices;

    public GrafoPonderado(int maximoDeVertices) {
        matrizDePesos = new int[maximoDeVertices][maximoDeVertices];
        vertices = new Vertice[maximoDeVertices];
        for (int i = 0; i < maximoDeVertices; i++) {
            for (int j = 0; j < maximoDeVertices; j++) {
                if (i == j){
                    matrizDePesos[i][j] = 0;
                }else {
                    matrizDePesos[i][j] = INFINITO;
                }
            }
        }
        numeroDeVertices = 0;
    }

    public int getNumeroDeVertices() {
        return numeroDeVertices;
    }

    public void crearNuevoVertice(String nombre) {
        boolean esta = getNumeroDelVertice(nombre) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nombre);
            v.asignarVertice(numeroDeVertices);
            vertices[numeroDeVertices++] = v;
        }
    }

    public void crearNuevoArco(String vertice_origen, String vertice_destino, int peso)
            throws Exception {
        int va, vb;
        va  = getNumeroDelVertice(vertice_origen);
        vb = getNumeroDelVertice(vertice_destino);
        if (va  < 0 || vb < 0) {
            throw new Exception("Vértice no existe");
        }
        matrizDePesos[va][vb] = peso;
    }

    public int getNumeroDelVertice(String vs) {
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numeroDeVertices) && !encontrado;) {
            encontrado = vertices[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }
        return (i < numeroDeVertices) ? i : -1;
    }

    public void imprimirGrafo() {
        System.out.println("Representation of Graph in the form of Adjacency Matrix: ");
        for (int i = 0; i < numeroDeVertices; i++) {
            for (int j = 0; j < numeroDeVertices; j++) {
                System.out.print(matrizDePesos[i][j] + "   ");
            }
            System.out.println();
        }

        for (int i = 0; i < numeroDeVertices; i++) {
            System.out.print("Vertex " + (i+1) + " is connected to: ");
            for (int j = 0; j < numeroDeVertices; j++) {
                if (matrizDePesos[i][j] != 65535) {
                    System.out.print((j+1) + " ");
                }
            }
            System.out.println();
        }
    }
}
