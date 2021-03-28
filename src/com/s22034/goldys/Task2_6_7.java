package com.s22034.goldys;

import java.util.ArrayList;
import java.util.List;

public class Task2_6_7 {

    public static void main(String[] args)
    {
        Spiewak s1 = new Spiewak("Dietrich"){
            @Override
            String spiewaj() {
                return "abcd!4";
            }
        };

        Spiewak s2 = new Spiewak("Piaf"){
            @Override
            String spiewaj() {
                return "a4iBBiii";
            }
        };

        Spiewak s3 = new Spiewak("Adele"){
            @Override
            String spiewaj() {
                return "aAa";
            }
        };


        Spiewak sp[] = {s1, s2, s3};

        for (Spiewak s : sp){
            System.out.println(s);
        }

        System.out.println(
                "==Najglosniej spiewa=="
        );

        System.out.println("\n" + Spiewak.najglosniej(sp));


        Spiewak a1 = new Spiewak("Darrey") {
            @Override
            String spiewaj() {
                return "eeae";
            }
        };

        Spiewak a2 = new Spiewak("Darrey") {
            @Override
            String spiewaj() {
                return "bebe";
            }
        };

        Spiewak a3 = new Spiewak("Houston") {
            @Override
            String spiewaj() {
                return "a4iBBiii";
            }
        };

        Spiewak a4 = new Spiewak("Carrey") {
            @Override
            String spiewaj() {
                return "oaooooooooooo";
            }
        };

        Spiewak a5 = new Spiewak("Madonna") {
            @Override
            String spiewaj() {
                return "aAa";
            }
        };

        List<Spiewak> listaSpiewakow = new ArrayList<Spiewak>();

        listaSpiewakow.add(a1);
        listaSpiewakow.add(a2);
        listaSpiewakow.add(a3);
        listaSpiewakow.add(a4);
        listaSpiewakow.add(a5);

        System.out.println(
                "==Przed sortowaniem=="
        );

        for (Spiewak s : listaSpiewakow){
            System.out.println(s);
        }

        listaSpiewakow.sort(Spiewak::compareTo);

        System.out.println(
                "==Po sortowaniu=="
        );

        for (Spiewak s : listaSpiewakow){
            System.out.println(s);
        }
    }
}

abstract class Spiewak implements Comparable<Spiewak>{

    String nazwisko;

    static int count = 0;
    int number;

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        count++;
        number = count;
    }

    abstract String spiewaj();

    @Override
    public String toString() {
        return nazwisko + ": " + spiewaj();
    }

    static Spiewak najglosniej(Spiewak[] spiewak){

        int highestUniqueIndex = 0;
        int tempCountOfUniqueChars = 0;

        for (int i = 0; i < spiewak.length; i++){

            char[] characters = spiewak[i].spiewaj().toCharArray();
            int countOfUniqueChars = spiewak[i].spiewaj().length();

            for (int j = 0; j < characters.length; j++) {
                if (j != spiewak[i].spiewaj().toLowerCase().replaceAll("\\W+", "").indexOf(characters[j])) {
                    countOfUniqueChars--;
                }
            }
            if(countOfUniqueChars > tempCountOfUniqueChars){
                highestUniqueIndex = i;
                tempCountOfUniqueChars = countOfUniqueChars;
            }
        }
        return spiewak[highestUniqueIndex];
    }

    public int glosnosc(){
        char[] characters = this.spiewaj().toCharArray();
        int countOfUniqueChars = this.spiewaj().length();

        for (int j = 0; j < characters.length; j++) {
            if (j != this.spiewaj().toLowerCase().replaceAll("\\W+", "").indexOf(characters[j])) {
                countOfUniqueChars--;
            }
        }
        return countOfUniqueChars;
    }

    @Override
    public int compareTo(Spiewak o) {
        if(this.glosnosc() - o.glosnosc() < 0){
            return 1;
        } else if (this.glosnosc() - o.glosnosc() > 0) {
            return -1;
        } else {
            if(this.nazwisko.compareTo(o.nazwisko) < 0){
                return 1;
            } else if(this.nazwisko.compareTo(o.nazwisko) > 0){
                return -1;
            } else {
                if(this.number - o.number > 0){
                    return 1;
                } else if(this.number - o.number <0){
                    return -1;
                }
            }
        }
        return -1;
    }
}