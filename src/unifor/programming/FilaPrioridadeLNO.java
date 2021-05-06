package unifor.programming;

public class FilaPrioridadeLNO {
    private NoPrioridade primeiro;
    private NoPrioridade ultimo;
    private NoPrioridade anterior;
    private int cont;

    public FilaPrioridadeLNO() {
        primeiro = null;
        ultimo = null;
        anterior = null;
        cont = 0;
    }

    public void enqueue(Object valor, int prioridade) {
        NoPrioridade novo  = new NoPrioridade(valor, prioridade);

        if (primeiro == null) {  // Lista vazia?
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        }

        cont++;
    }

    public void dequeue() {
        NoPrioridade aux = front();

        if(length()>1) {


            if(aux.anterior != null) {
                aux.anterior.proximo = aux.proximo;
            } else {
                primeiro = aux.proximo;
                aux.proximo.anterior = null;
            }

            if(aux.proximo != null) {
                aux.proximo.anterior = aux.anterior;
            } else {
                ultimo = aux.anterior;
            }

        }

        else {
            primeiro = null;
            ultimo = null;
        }

        cont--;
    }

    public boolean search(Object valor) {
        NoPrioridade aux = primeiro;
        while(aux != null) {
            if(aux.dado.equals(valor)) {
                return true;
            }
            aux = aux.proximo;
        }

        return false;
    }

    public int length() {
        return this.cont;
    }

    public boolean empty() {

        if(cont == 0) {
            return true;
        }

        return false;

    }

    public NoPrioridade front() {

        if(primeiro != null) {
            for (int i = 0; i < 3; i++) {
                NoPrioridade aux = primeiro;
                while (aux != null) {
                    if (aux.prioridade == i) {
                        return aux;
                    }
                    aux = aux.proximo;
                }
            }
        }

        return null;

    }

    public void show() {
        NoPrioridade aux = primeiro;

        int l = length();
        int i = 0;

        while (aux != null) {


            if(i == length() - 1) {
                System.out.print(aux.dado);
            } else {
                System.out.print(aux.dado + " ");
            }
            aux = aux.proximo;

            i++;
        }
        System.out.println();
    }

    public void clear() {
        while(!empty()) {
            dequeue();
        }
    }



}