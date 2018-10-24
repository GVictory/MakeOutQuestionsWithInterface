package com.example.demo;

import java.util.*;

/**
 * Created by Administrator on 2018/9/29 0029.
 */
public class Arithmetic {

    private static int a;
    private static int b;
    private static int c;
    private static String symbolA;
    private static String symbolB;



    public HashMap<String,Integer> getArithmetic(int count){
        HashMap<String,Integer> arithmetics=new HashMap<>(0);
        int result = 0;
        for (int i = 0; i < count; i++) {
            a = (int) (Math.random() * 100);
            b = (int) (Math.random() * 100);
            c = (int) (Math.random() * 100);
            symbolA = randomSymbol();
            symbolB = randomSymbol();
            if (symbolA.equals("/")) {
                b = (int) (Math.random() * 100) + 1;
                a =  b * ((int)(Math.random() * 100));
                while (a > 100) {
                    a =  b * ((int)(Math.random() * 100));
                }
                if(symbolB.equals("/")){
                    c = (int) (Math.random() * 100) + 1;
                    while ((a/b)%c!=0){
                        c = (int) (Math.random() * 100) + 1;
                    }
                }
            }
            if(symbolA.equals("*")&&symbolB.equals("/")){
                c = (int) (Math.random() * 100) + 1;
                while ((a*b)%c!=0){
                    c = (int) (Math.random() * 100) + 1;
                }
            }
            if((symbolA.equals("+")||symbolA.equals("-"))&&symbolB.equals("/")){
                c = (int) (Math.random() * 100) + 1;
                b =  c * ((int)(Math.random() * 100));
                while (b > 100) {
                    b =  c * ((int)(Math.random() * 100));
                }
            }
            result = calculate(a, b, c, symbolA, symbolB);
            if (result < 0) {
                i--;
                continue;
            }
            String equaltion = a + symbolA + b + symbolB + c;
            arithmetics.put(equaltion,result);

        }
        return arithmetics;
    }

    public static int calculate(int a, int b, int c, String symbolA, String symbolB) {
        int result = 0;
        if ((symbolA.equals("+") || symbolA.equals("-")) && (symbolB.equals("*") || symbolB.equals("/"))) {
            if (symbolB.equals("*")) {
                result = (b * c);
            } else if (symbolB.equals("/")) {
                if(c==0) return -1;
                result = (b / c);
            }
            if (symbolA.equals("-")) {
                result = a - result;

            } else {
                result = a + result;
            }
        } else {
            if (symbolA.equals("+")) {
                result = (a + b);
            } else if (symbolA.equals("-")) {
                result = (a - b);
            } else if (symbolA.equals("*")) {
                result = (a * b);
            }else {
                if(b==0) return -1;
                result = (a / b);
            }
            if (symbolB.equals("+")) {
                result = result + c;
            } else if (symbolB.equals("-")) {
                result = result - c;
            } else if (symbolB.equals("*")) {
                result = result * c;
            } else {
                if(c==0) return -1;

                result = result / c;
            }
        }
        return result;
    }

    public static String randomSymbol() {
        String add = "+";
        String decrease = "-";
        String multiply = "*";
        String divide = "/";
        int ran = (int) (Math.random() * 4);
        if (ran == 0) {
            return add;
        } else if (ran == 1) {
            return decrease;
        } else if (ran == 2) {
            return multiply;
        } else {
            return divide;
        }
    }
}
