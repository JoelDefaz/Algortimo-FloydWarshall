/**
 * @author Joe Defaz
 */
public class Vertice {
    private String nombre;
    private int numeroDeVertice;
    
    public Vertice(String x) {
        nombre = x;
        numeroDeVertice = -1;
    }
        
    public String getNombreDelVertice(){ // devuelve el nombre del vértice
        return nombre;
    }
        
    public boolean equals(Vertice n) { // devuelve true si dos vértices son iguales
        return nombre.equals(n.nombre);
    }
        
    public void asignarVertice(int n) { // establece el número de vértices
        numeroDeVertice = n;
    }
        
    public String toString() { // caracteristicas del vértice
        return nombre + " (" + numeroDeVertice + ")";
    }
}
