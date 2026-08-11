package br.com.selvafit.util;

import java.util.Scanner;

public class InputUtil {
    
    public static String lerString(String mensagem, Scanner sc) {
        System.out.print(mensagem);
        String val = sc.nextLine();
        return val;
    }

    public static int lerInt(String mensagem, Scanner sc) {
        int val;
        System.out.print(mensagem);
        while (!sc.hasNextInt()) {
            System.out.println("Entrada invalida!");
            sc.next();
            System.out.print(mensagem);
        }
        val = sc.nextInt();
        return val;
    }
    
}
