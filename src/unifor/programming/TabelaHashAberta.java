package unifor.programming;

public class TabelaHashAberta {

    private Integer[] table;

    public TabelaHashAberta(int n) {
        table = new Integer[n];
    }

    public int hash(int valor) {
        int h = valor % table.length;
        int index = h;
        int i = 0;

        //Tentativa Linear
//        while(table[index] != null) {
//            i++;
//            index = (h + i) % table.length;
//        }

        //Tentativa Quadrática
        while(table[index] != null) {
            i++;
            index = (index + i) % table.length;
        }

        return index;
    }

    public void push(int valor) {
        int index = hash(valor);
        table[index] = valor;
    }

    public boolean search(int valor) {
        int index = hash(valor);
        if(table[index] == valor) {
            return true;
        }
        return false;
    }

    public void show() {
        for(int i = 0; i < table.length; i++) {
            System.out.print(table[i] + " ");
        }
    }

}
