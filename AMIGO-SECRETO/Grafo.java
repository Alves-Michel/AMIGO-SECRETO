import java.util.ArrayList;
import java.util.List;

public class Grafo<Tipo> {
    private List<Vertice<Tipo>> vertices;
    private List<Aresta<Tipo>> arestas;
    private List<AmigoSecreto<Tipo>> amigosSecretos;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<Tipo>>();
        this.arestas = new ArrayList<Aresta<Tipo>>();
        this.amigosSecretos = new ArrayList<AmigoSecreto<Tipo>>();
    }

    public void adicionarVertice(Tipo nome) {
        Vertice<Tipo> novoVertice = new Vertice<Tipo>(nome);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Aresta<Tipo> aresta) {
        arestas.add(aresta);
    }

    public List<Vertice<Tipo>> getVertices() {
        return vertices;
    }

    public List<Aresta<Tipo>> getArestas() {
        return this.arestas;
    }

}
