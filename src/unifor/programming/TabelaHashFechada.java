package unifor.programming;

public class TabelaHashFechada {

    private ListaDinamica table[];

    public TabelaHashFechada(int n) {
        table = new ListaDinamica[n];

        for(int i = 0; i < n; i++) {
            table[i] = new ListaDinamica();
        }
    }

    public int hash(int valor) {
        return valor % table.length;
    }

    public void push(int valor) {
        int index = hash(valor);
        table[index].push(0, valor);
    }

    public int search(int valor) {
        int index = hash(valor);
        return (int) table[index].searchIndex(valor);
    }

    public void show() {
        for (int i = 0; i < table.length; i++) {
            if(!table[i].empty()) {
                table[i].show();
            } else {
                System.out.println("Empty");
            }
        }
    }

}
