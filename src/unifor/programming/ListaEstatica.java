package unifor.programming;

public class ListaEstatica {

    private Object base[] = new Object[10];
    private int cont = 0;


    public void push(Object n){

        if(cont < base.length) {
            this.base[cont] = n;
            cont++;
        } else {
            Object[] aux = new Object[(int) (base.length * 1.5)];

            for(int i = 0; i < base.length; i++) {
                aux[i] = base[i];
            }

            base = aux;
        }
    }

    public void push(Object n, int pos) {
        if(pos < base.length) {
            for (int i = pos; i < cont; i++) {
                this.base[i + 1] = this.base[i];
            }

            this.base[pos] = n;
            cont++;
        } else {
            System.out.println("Posição Inexistente ao tentar inserir valor.");
            System.exit(1);
        }
    }

    public void pop() {
        cont--;
    }

    public void pop(int pos) {
        for(int i = pos; i < cont-1; i++) {
            this.base[i] = this.base[i+1];
        }
        cont--;
    }

    public int length() {
        return this.cont;
    }

    public boolean search(Object n) {
        boolean exists = false;

        for(int i = 0; i < cont; i++) {
            exists = false;

            if(this.base[i].equals(n)) {
                exists = true;
            }
        }
        return exists;
    }

    public int searchIndex(Object element) {
        for(int i = 0; i < cont; i++) {
            if(this.base[i].equals(element)) {
                return i;
            }
        }
        System.out.println("O elemento nao existe no array");
        return -1;
    }

    public Object searchElement(int index) {
        try {
            return this.base[index];
        } catch (Exception e) {
            System.out.println("Nao foi possivel pegar o elemento neste index. O index realmente existe? \n" +
                    "Exception = " + e);
            System.exit(1);
        }

        return -1;
    }

    public void show() {
        for(int i = 0; i < cont; i++) {
            System.out.print(this.base[i] + " ");
        }
    }
}
