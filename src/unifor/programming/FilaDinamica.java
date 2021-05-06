package unifor.programming;

public class FilaDinamica {
    private No primeiro;
    private No ultimo;
    private int cont;

    public FilaDinamica() {
        primeiro = null;
        ultimo = null;
        cont = 0;
    }

    public void enqueue(Object valor) {
        No novo  = new No(valor);

        if (primeiro == null) {  // Lista vazia?
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }

        cont++;
    }

    public void dequeue() {
        No aux = primeiro;

        if(length()>1) {
            primeiro = aux.proximo;
        }

         else {
            primeiro = null;
            ultimo = null;
        }

        cont--;
    }

    public boolean search(Object valor) {
        No aux = primeiro;
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

    public Object front() {

        return primeiro.dado;

    }

    public void show() {
        No aux = primeiro;

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

