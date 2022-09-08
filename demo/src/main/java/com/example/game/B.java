package com.example.game;

import java.util.Scanner;

/**
 * @author nyj
 * @date 2022/8/2
 * @ApiNote
 */
public class B {
    public static void main(String[] args) {
        /**
         *  取素 数（质数）
         */
        for (int i = 1; i < 100; i++) {
            boolean mark = true;
            for (int k = 2; 2 * k - 1 < i; k++) {
                if (i % k == 0) {
                    mark = false;
                }
            }
            if (mark == true) {
                System.out.println(i);
            }
        }
    }
}
class C {
    public static void main(String[] args) {
        /**
         *  画菱形
         */
        int n = 10;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i ; k++) {
                System.out.print("* ");
            }
            System.out.println("");

        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n-i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }


    }
}
class D{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            //default:
            //    System.out.println("error");
            //    break;
        }
    }
}
