package unifor.programming;

public class FilaPrioridadeHeapMin {
    private NoPrioridade[] dados;
    private int contador;

    public FilaPrioridadeHeapMin(int n) {
        dados = new NoPrioridade[n];
        contador = 0;

    }

    public NoPrioridade front() {
        if (empty())
            System.out.println("Heap vazio");

        return dados[0];
    }

    public boolean empty() {
        return (contador == 0);
    }

    public void enqueue(Object valor, int prioridade) {
        if (contador == dados.length)
            System.out.println("Heap lotado");

        dados[contador] = new NoPrioridade(valor, prioridade);
        contador++;
        subir(contador - 1);
    }

    private void subir(int indice) {
        int indicePai;
        NoPrioridade temp;

        if (indice != 0) {
            indicePai = (indice - 1) / 2;

            if (dados[indicePai].prioridade > dados[indice].prioridade) {
                temp = dados[indicePai];
                dados[indicePai] = dados[indice];
                dados[indice] = temp;
                subir(indicePai);
            }
        }
    }

    public void dequeue() {
        if (empty())
            System.out.println("Heap vazio");

        dados[0] = dados[contador - 1];
        contador--;
        if (contador > 0)
            descer(0);
    }

    private void descer(int indice) {
        int indiceFilhoEsq, indiceFilhoDir, indiceMin;
        NoPrioridade temp;

        indiceFilhoEsq = 2 * indice + 1;
        indiceFilhoDir = 2 * indice + 2;

        if (indiceFilhoDir >= contador) {
            if (indiceFilhoEsq >= contador)
                return;
            else
                indiceMin = indiceFilhoEsq;
        } else {
            if (dados[indiceFilhoEsq].prioridade < dados[indiceFilhoDir].prioridade)
                indiceMin = indiceFilhoEsq;
            else
                indiceMin = indiceFilhoDir;
        }

        if (dados[indice].prioridade >= dados[indiceMin].prioridade) {
            temp = dados[indiceMin];
            dados[indiceMin] = dados[indice];
            dados[indice] = temp;
            descer(indiceMin);
        }
    }

    public void show() {
        for (int i = 0; i < contador; i++)
            System.out.print(dados[i].dado + "(" + dados[i].prioridade + ") ");

        System.out.println();
    }
}
