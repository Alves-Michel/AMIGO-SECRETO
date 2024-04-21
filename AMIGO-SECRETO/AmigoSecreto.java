import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AmigoSecreto<Tipo> {
    private Grafo<Tipo> grafoParticipantes;

    public AmigoSecreto() {
        this.grafoParticipantes = new Grafo<>();
    }

    public void adicionarParticipante(Tipo nome) {
        grafoParticipantes.adicionarVertice(nome);
    }

    public void realizarSorteio() {
        List<Vertice<Tipo>> participantes = grafoParticipantes.getVertices();
        List<Vertice<Tipo>> candidatos = new ArrayList<>(participantes);
        Collections.shuffle(candidatos);

        while (true) {
            // Verifique se alguém se tiraria a si mesmo e se haveria repetição
            boolean algumaRepeticao = false;
            for (int i = 0; i < participantes.size(); i++) {
                Vertice<Tipo> participante = participantes.get(i);
                Vertice<Tipo> candidato = candidatos.get(i);
                if (participante.equals(candidato)) {
                    algumaRepeticao = true;
                    Collections.shuffle(candidatos); // Embaralhe novamente se houver repetição
                    break;
                }
            }

            if (!algumaRepeticao) {
                break; // Saia do loop se não houver repetição
            }
        }

        for (int i = 0; i < participantes.size(); i++) {
            Vertice<Tipo> participante = participantes.get(i);
            Vertice<Tipo> candidato = candidatos.get(i);

            Aresta<Tipo> aresta = new Aresta<>(participante, candidato);
            grafoParticipantes.adicionarAresta(aresta);
        }
    }

    public List<Aresta<Tipo>> getResultadoSorteio() {
        return grafoParticipantes.getArestas();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sorteio de Amigo Secreto!");
        System.out.print("Quantas pessoas participarão? ");
        int numParticipantes = scanner.nextInt();
        if (numParticipantes < 2) {
            System.out.println("Pelo menos dois participantes são necessários.");
            return;
        }
        System.out.println("-----------------------------------");
        scanner.nextLine(); // Consumir a quebra de linha

        AmigoSecreto<String> amigoSecreto = new AmigoSecreto<>();

        for (int i = 0; i < numParticipantes; i++) {
            System.out.print("Nome da pessoa " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            amigoSecreto.adicionarParticipante(nome);
        }

        amigoSecreto.realizarSorteio();
        System.out.println("-----------------------------------");
        System.out.println("Sorteando.......");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------------------------------");
        List<Aresta<String>> amigosSecretos = amigoSecreto.getResultadoSorteio();
        System.out.println("Resultado do sorteio de Amigo Secreto:");
        for (Aresta<String> aresta : amigosSecretos) {
            Vertice<String> origem = aresta.getOrigem();
            Vertice<String> destino = aresta.getDestino();
            System.out.println(origem.getNome() + ", PRESENTEARÁ -> " + destino.getNome());
        }
        System.out.println("-----------------------------------");
        scanner.close();
    }
}
