package com.s22034.goldys;

import java.util.Iterator;

public class Task2_8 {

    public static void main(String [] args)
    {
        IterNap napis = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        // iteracja po znakach napisu,
        // domyślnie zaczynając od pierwszego znaku (o indeksie 0)
        // i z krokiem iteracji = 1
        for (char z: napis)
            System.out.print(z + " ");

        System.out.println();

        napis.ustawPoczatek(2);     // ustawienie początku iteracji (tu: 2-gi znak, o indeksie 2)
        napis.ustawKrok(3);         // ustawienie kroku iteracji (tu: co 3-ci znak)

        // iteracja po znakach napisu,
        // od ustalonego znaku, z określonym krokiem
        for (char z: napis)
            System.out.print(z + " ");


	/*<-  co tu trzeba napisać w wywołaniu metody forEach z argumentem będącym lambda-wyrażeniem
	      w celu wyświetlenia znaków napisu (w postaci małych liter) zgodnie z iteracją

	napis.forEach(...)
	*/
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


    public void ustawPoczatek(int poczatek) {
        this.pozycja = poczatek;
    }


    public void ustawKrok(int krok) {
        this.krok = krok;
    }

    public Iterator<Character> iterator(){
        return new Iterator<Character>() {
            @Override
            public boolean hasNext() {
                if(napis.length() > (pozycja+krok)){
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

    @Override
    public String toString() {
        return napis;
    }
}
