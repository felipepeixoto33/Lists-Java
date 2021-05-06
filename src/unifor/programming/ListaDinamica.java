package unifor.programming;

public class ListaDinamica {
    private No primeiro;
    private No ultimo;
    private int cont;

    public ListaDinamica() {
        primeiro = null;
        ultimo = null;
        cont = 0;
    }

    public void push(Object valor) {
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

    public void push(int posicao, Object valor) {
        No novo  = new No(valor);

        if (primeiro == null) {  // Lista vazia?
            primeiro = novo;
            ultimo = novo;

        } else {

            if (posicao >= 0 && posicao <= length()) {

                if (posicao == 0) { //Pos inicial
                    novo.proximo = primeiro;
                    primeiro = novo;

                } else if (posicao == length()) { //N devia ser 'length() - 1' n?
                    ultimo.proximo = novo;
                    ultimo = novo;
                } else {
                    No aux = primeiro;

                    for (int i = 0; i < posicao - 1; i++) {
                        aux = aux.proximo;
                    }

                    novo.proximo = aux.proximo;
                    aux.proximo = novo;

                }


            }

        }
        cont++;
    }

    public void pop(int posicao) {
        No aux = primeiro;

        if(length()>1) {

            if (posicao == 0) {

                primeiro = aux.proximo;


            } else {

                for (int i = 0; i < posicao - 1; i++) {
                    aux = aux.proximo;
                }

                if (posicao == length() - 1) {

                    ultimo = aux;
                    aux.proximo = null;

                } else {

                    aux.proximo = aux.proximo.proximo;

                }
            }
        } else {

            if(posicao == 0) {
                primeiro = null;
                ultimo = null;
            }

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

    public Object searchIndex(int valor) {

        if(valor < length()) {
            No aux = primeiro;

            for (int i = 0; i < valor; i++) {
                aux = aux.proximo;
            }

            return aux.dado;
        } else {
            System.out.println("It's not possible to get a Object from a position that is not on the list.\n" +
                    "Search Error. Invalid Position.");
            System.exit(1);
            return -1;
        }


    }

    public Object searchElement(int posicao) {
        if(posicao < cont) {
            No aux = primeiro;

            for (int i = 0; i < posicao; i++) {
                aux = aux.proximo;
            }

            return aux.dado;
        } else {
            System.out.println("Invalid position. This position is not on the list.");
            System.exit(1);
            return -1;
        }
    }

    public int length() {
        return this.cont;
    }

    public void clear() {

        while(length() > 0) {
            pop(0);
        }

    }

    public boolean empty() {
        if(primeiro == null) {
            return true;
        }
        return false;
    }

    public void show() {
        No aux = primeiro;

        while (aux != null) {
            System.out.print(aux.dado + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }
}

