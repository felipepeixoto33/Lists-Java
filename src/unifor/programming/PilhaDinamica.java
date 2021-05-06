//package unifor.programming;
//
//public class PilhaDinamica {
//    private No primeiro;
//    private No ultimo;
//    private int cont;
//
//    public PilhaDinamica() {
//        primeiro = null;
//        ultimo = null;
//        cont = 0;
//    }
//
//    public void push(Object valor) {
//        No novo  = new No(valor);
//
//        if (primeiro == null) {  // Lista vazia?
//            primeiro = novo;
//            ultimo = novo;
//        } else {
//            ultimo.proximo = novo;
//            ultimo = novo;
//        }
//
//        cont++;
//    }
//
//    public void pop() {
//        No aux = primeiro;
//
//        if(length()>1) {
//
//            while (aux.proximo.proximo != null) {
//                aux = aux.proximo;
//            }
//
//            aux.proximo = null;
//            ultimo = aux;
//
//        } else {
//
//            primeiro = null;
//            ultimo = null;
//
//        }
//        cont--;
//    }
//
//    public boolean search(Object valor) {
//        No aux = primeiro;
//        while(aux != null) {
//            if(aux.dado.equals(valor)) {
//                return true;
//            }
//            aux = aux.proximo;
//        }
//
//        return false;
//    }
//
//    public int length() {
//        return this.cont;
//    }
//
//    public Object peek() {
//        return ultimo.dado;
//    }
//
//    public boolean empty() {
//
//        if(length() == 0) {
//            return true;
//        }
//        return false;
//
//    }
//
//    public void show() {
//        No aux = primeiro;
//
//        while (aux != null) {
//            System.out.print(aux.dado + " ");
//            aux = aux.proximo;
//        }
//        System.out.println();
//    }
//}
//
