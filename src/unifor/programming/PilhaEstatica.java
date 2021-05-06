package unifor.programming;

public class PilhaEstatica {

    private Object base[] = new Object[10];
    private int cont = 0;

    public PilhaEstatica() {
        base = new Object[10];
        cont = 0;
    }


    private void moreSize() {
        Object[] aux = new Object[(int) (this.base.length * 1.5)];

        for (int i = 0; i < this.base.length; i++) {
            aux[i] = base[i];
        }

        this.base = aux;
    }

    public void push(Object n) {

        if (cont >= base.length) {
            moreSize();
        }

        this.base[cont] = n;
        cont++;
    }


    public void pop() {
        if(cont > 0) {
            cont--;
        }
    }


    public int length() {
        return this.cont;
    }

    public boolean search(Object n) {

        for (int i = 0; i < cont; i++) {

            if (this.base[i].equals(n)) {
                return true;
            }

        }
        return false;
    }

    public boolean empty() {

        if(cont == 0) {
            return true;
        }

        return false;

    }

    public Object peek() {

        return base[cont-1];
    }

    public void show() {
        for (int i = 0; i < cont; i++) {
            System.out.print(this.base[i]);
        }
        System.out.println();
    }
}
