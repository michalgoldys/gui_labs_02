package com.s22034.goldys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2_5 {

    public static void main(String[] args)
    {

        List<Figura> listaFig = new ArrayList<Figura>();

        Prostokat prostokat = new Prostokat(1,1,4,9);
        Kolo kolo = new Kolo(1,1,5);
        Prostokat prostokat1 = new Prostokat(2,2,6,6);

        listaFig.add(prostokat);
        listaFig.add(kolo);
        listaFig.add(prostokat1);

        System.out.println("Figury przed sortowaniem:");

        for (Figura f: listaFig){
            System.out.println(
                    f.toString()
            );
        }

        Collections.sort(listaFig);

        System.out.println("Figury po sortowaniu:");

        for (Figura f: listaFig){
            System.out.println(
                    f.toString()
            );
        }

    }
}

abstract class Figura implements Obliczanie, Comparable<Figura>{

    static int count = 0;
    int number;

    private int x, y;

    public Figura(int x, int y){
        this.x = x;
        this.y = y;
        count++;
        number = count;
    }

    public abstract String fig();
    public abstract void pozycja(int x, int y);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        return "x: " + x + "y: " + y;
    }

    @Override
    public int compareTo(Figura o) {
        if(this.pole() - o.pole() < 0){
            return 1;
        } else if (this.pole() - o.pole() > 0) {
            return -1;
        } else {
            if(this.obwod() - o.obwod() < 0){
                return 1;
            } else if(this.obwod() - o.obwod() > 0){
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


class Kolo extends Figura implements Obliczanie {

    private int promien;

    public Kolo(int x, int y, int r)
    {
        super(x ,y);
        this.promien = r;
    }

    @Override
    public String fig() {
        return "Koło";
    }

    @Override
    public void pozycja(int x, int y)
    {
        if(Math.pow(((getX() - x)+(getY() - y)),2) <= Math.pow(promien,2)){
            System.out.println(
                    "Punkt " + "(" + x + "," + y + ") znajduje się wewnątrz koła"
            );
        }
        else{
            System.out.println(
                    "Punkt " + "(" + x + "," + y + ") znajduje się zewnątrz koła"
            );
        }
    }

    public int getPromien() {
        return promien;
    }

    @Override
    public String toString(){
        return "Koło\n" +
                "Środek - " + "(" + getX() + "," + getY() + ")\n" +
                "Promień - " + getPromien();
    }

    @Override
    public int pole() {
        return (int) (Math.PI*Math.pow(getPromien(),2));
    }

    @Override
    public int obwod() {
        return (int) (2*Math.PI*getPromien());
    }
}

class Prostokat extends Figura implements Obliczanie{

    protected int szer, wys;

    public Prostokat(int x, int y, int s, int w) {
        super(x,y);
        this.szer = s;
        this.wys = w;
    }

    public int getSzer() {
        return szer;
    }

    public int getWys() {
        return wys;
    }

    @Override
    public String fig() {
        return "Prostokat";
    }

    @Override
    public void pozycja(int x, int y)
    {
        if(x <= (getX()-getSzer()) && x >= getX() && y >= (getY()-getWys()) && y <= getY()){
            System.out.println(
                    "Punkt " + "(" + x + "," + y + ") znajduje się wewnątrz prostokąta"
            );
        } else{
            System.out.println(
                    "Punkt " + "(" + x + "," + y + ") znajduje się zewnątrz prostokąta"
            );
        }
    }

    @Override
    public String toString()
    {
        return "Prostokąt\n" +
                "Lewy górny - " + "(" + getX() + "," + getY() + ")\n" +
                "Szerokość: " + getSzer() + ", Wysokość: " + getWys();
    }

    @Override
    public int pole() {
        return (getWys()*getSzer());
    }

    @Override
    public int obwod() {
        return ((2*getWys())+(2*getSzer()));
    }

}

class Prostokat2 extends Prostokat implements Rysowanie{

    char znak;

    public Prostokat2(int x, int y, int s, int w, char znak) {
        super(x, y, s, w);
        this.znak = znak;
    }

    public char getZnak() {
        return znak;
    }

    @Override
    public void rysuj() {

        for(int i = 0; i < getWys() ; i++){
            for(int j = 0; j < getSzer(); j++){
                System.out.print(
                        getZnak()
                );
            }
            System.out.println(

            );
        }

    }
}

class Kolo2 extends Kolo implements Transformacja{

    int oldX, oldY;

    public Kolo2(int x, int y, int r) {
        super(x, y, r);
    }

    //Brak pomyslu jaka implementacje wykonac :(((
    @Override
    public void przesunDo(int x, int y) {
        oldX = getX();
        oldY = getY();
    }

    @Override
    public void powrot() {
    }

}

interface Obliczanie{
    int pole();
    int obwod();
}

interface Rysowanie{
    void rysuj();
}

interface Transformacja{
    void przesunDo(int x, int y);
    void powrot();
}