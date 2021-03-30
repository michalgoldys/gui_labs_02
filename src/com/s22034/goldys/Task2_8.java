package com.s22034.goldys;

import java.util.Iterator;

public class Task2_8 {

    public static void main(String [] args)
    {
        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        for (char z: napis)
            System.out.print(z + " ");

        System.out.println();

        napis.ustawPoczatek(2);
        napis.ustawKrok(3);

        for (char z: napis)
            System.out.print(z + " ");

        System.out.println(
                "\n==forEach=="
        );

        napis.ustawPoczatek(2);
        napis.ustawKrok(3);

        napis.forEach( c -> {
                    System.out.print(
                            c.toString().toLowerCase()
                    );
                }
        );
    }
}

class IterNap implements Iterable<Character>{

    private String napis;
    private int pozycja, krok;

    public IterNap(String napis) {
        this.napis = napis;
        this.krok = 1;
        this.pozycja = 0;
    }


    public void ustawPoczatek(int pozycja) {
        this.pozycja = pozycja;
    }


    public void ustawKrok(int krok) {
        this.krok = krok;
    }

    public Iterator<Character> iterator(){
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                if(napis.length() >= (pozycja+krok)){
                    return true;
                }
                return false;
            }

            @Override
            public Character next() {
                int temp = pozycja;
                pozycja = temp+krok;
                return napis.charAt(temp);
            }
        };
    }
}