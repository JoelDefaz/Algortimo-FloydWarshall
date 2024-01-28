/**
 * @author Joel Defaz
 */
public class Main {
    public static void main(String[] args) {
        GrafoPonderado matriz = new GrafoPonderado(6);
        matriz.crearNuevoVertice("A");
        matriz.crearNuevoVertice("B");
        matriz.crearNuevoVertice("C");
        matriz.crearNuevoVertice("D");
        matriz.crearNuevoVertice("E");

        try {
            matriz.crearNuevoArco("A", "B",4);
            matriz.crearNuevoArco("B", "A",4);
            matriz.crearNuevoArco("A", "C",8);
            matriz.crearNuevoArco("C", "A",8);
            matriz.crearNuevoArco("B", "C",1);
            matriz.crearNuevoArco("C", "E",2);
            matriz.crearNuevoArco("E", "C",2);
            matriz.crearNuevoArco("C", "D",4);
            matriz.crearNuevoArco("D", "C",4);
            matriz.crearNuevoArco("B", "D",2);
            matriz.crearNuevoArco("D", "B",2);
            matriz.crearNuevoArco("D", "E",7);
            matriz.crearNuevoArco("E", "D",7);
            matriz.imprimirGrafo();
        } catch (Exception e) {
            System.out.println(e);
        }

        CaminoMinimo FloydWarshall = new CaminoMinimo(matriz,0);
        FloydWarshall.caminoMinimos();
        FloydWarshall.imprimirSolucion();
    }
}