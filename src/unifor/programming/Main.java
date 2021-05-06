package unifor.programming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TabelaHashFechada table = new TabelaHashFechada(8);

        table.push(17);
        table.push(20);
        table.push(36);
        table.push(4);
        table.push(14);
        table.push(22);

        table.show();

    }

}