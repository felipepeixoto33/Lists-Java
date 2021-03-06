package unifor.programming;

public class ListaDinamicaOrdenada {
    private No primeiro;
    private No ultimo;
    private int cont;

    public ListaDinamicaOrdenada() {
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

            No aux = primeiro;

            if( valor < (int) primeiro.dado) {

                novo.proximo = aux;
                primeiro = novo;

            } else if(valor > (int) ultimo.dado) {

                ultimo.proximo = novo;
                ultimo = novo;

            } else {

                while( (int) aux.proximo.dado < valor) {
                    aux = aux.proximo;
                }

                novo.proximo = aux.proximo;
                aux.proximo = novo;

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

    public boolean search(int valor) {
        No aux = primeiro;
        while(aux != null) {
            if( (int) aux.dado == valor) {
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

            return (int) aux.dado;
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

        return (int) aux.dado;
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

    public void clear() {

        while(length() > 0) {

            pop(0);

        }

    }
}

