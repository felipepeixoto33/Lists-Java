package unifor.programming;

public class FilaEstatica {

    private Object base[] = new Object[10];
    private int first = 0;
    private int end = -1;


    private void moreSize() {
        Object[] aux = new Object[(int) (this.base.length * 1.5)];

        for (int i = 0; i < this.base.length; i++) {
            aux[i] = base[i];
        }

        this.base = aux;
    }

    public void enqueue(Object n) {

        if (length() < base.length) {

            if(end == length()) {
                end = 0;
            }

            end++;
            this.base[end] = n;

        } else {

            moreSize();
            end++;
            this.base[end] = n;

        }


    }

    public void dequeue() {
        if(length() > 0) {
            first++;
            System.out.println("first = " + first);
        }
    }

    public int length() {
        if(end >= first) {
            return end - first + 1;
        } else {
            if(end != -1)
                //When I fill the list and then try to clean it, when the program removes the last element in it, an error occours.
                //First, you should know that when we have our list full of elements, the 'end' attribute equals 9 (Cuz it starts at -1)
                //And the 'first' attribute equals 10, causing the algorithm to enter in this case and to generate an error.
                //It says that the length of the list is 10, when it should be 0. This error happens because of the expression below.
                return base.length + (end - first + 1);
            else
                return 0;
        }
    }

    public boolean search(Object n) {

        for (int i = first; i < end; i++) {

            if (this.base[i].equals(n)) {
                return true;
            }

        }
        return false;
    }

    public boolean empty() {

        if(length() == 0) {
            return true;
        }
        return false;

    }

    public Object front() {

        return base[first];

    }

    public void show() {
        //The error described at the 'length()' method

        if(end >= first) {

            for (int i = first; i <= end; i++) {
                System.out.print(this.base[i] + " ");
            }
            System.out.println();

        } else {

            for (int i = first; i < base.length; i++) {
                System.out.print(this.base[i] + " ");
            }

            for (int i = end; i < first; i++) {
                System.out.print(this.base[i] + " ");
            }

        }
    }

    public void clear() {

        while(length() > 0) {
            dequeue();
        }

    }
}
