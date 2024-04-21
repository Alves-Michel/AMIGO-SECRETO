public class Aresta <Tipo> {
    private Vertice <Tipo>origem;
    private Vertice <Tipo>destino;

    public Aresta(Vertice <Tipo> origem, Vertice <Tipo> destino) {
        this.origem = origem;
        this.destino = destino;
    }
    public Vertice <Tipo> getOrigem() {
        return origem;
    }

    public Vertice <Tipo> getDestino() {
        return destino;
    }


}
