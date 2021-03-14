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

    public void push(int valor) {
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

    public void push(int posicao, int valor) {
        No novo  = new No(valor);

        if (primeiro == null) {  // Lista vazia?
            primeiro = novo;
            ultimo = novo;

        } if(posicao == 0) { //Pos inicial
            novo.proximo = primeiro;
            primeiro = novo;

        } else if(posicao == length()) { //N devia ser 'length() - 1' n?
            ultimo.proximo = novo;
            ultimo = novo;
        }

        else {
            No aux = primeiro;

            for(int i = 0; i < posicao-1; i++) {
                aux = aux.proximo;
            }

            novo.proximo = aux.proximo;
            aux.proximo = novo;

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

    public boolean search(int valor) {
        No aux = primeiro;
        while(aux != null) {
            if(aux.dado == valor) {
                return true;
            }
            aux = aux.proximo;
        }

        return false;
    }

    public int searchIndex(int valor) {

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

    public int searchElement(int posicao) {
        No aux = primeiro;

        for (int i = 0; i < posicao; i++) {
            aux = aux.proximo;
        }

        return aux.dado;
    }

    public int length() {
        return this.cont;
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

