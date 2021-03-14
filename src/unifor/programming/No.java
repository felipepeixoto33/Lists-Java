package unifor.programming;

class No {
    public No proximo;
    public No anterior;
    public int dado;

    public No(int dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }
}
