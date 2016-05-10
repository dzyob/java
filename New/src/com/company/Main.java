package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ведите имя первого бойца: ");
        String name1 = r.readLine();
        System.out.print("Ведите вес первого бойца(1-300): ");
        int weight1 = Integer.parseInt(r.readLine());;
        setWeight(weight1);
        System.out.print("Ведите силу первого бойца(1-100): ");
        int strength1 = Integer.parseInt(r.readLine());
        setStrength(strength1);
        System.out.print("Ведите уровень первого бойца(1-10): ");
        int lvl1 = Integer.parseInt(r.readLine());
        setLvl(lvl1);
        System.out.print("Ведите имя второго бойца: ");
        String name2 = r.readLine();
        System.out.print("Ведите вес второго бойца(1-300): ");
        int weight2 = Integer.parseInt(r.readLine());
        setWeight(weight2);
        System.out.print("Ведите силу второго бойца(1-100): ");
        int strength2 = Integer.parseInt(r.readLine());
        setStrength(strength2);
        System.out.print("Ведите уровень второго бойца(1-10): ");
        int lvl2 = Integer.parseInt(r.readLine());
        setLvl(lvl2);
        Fighter fighter1 = new Fighter(name1, setWeight(weight1), setStrength(strength1), setLvl(lvl1));
        Fighter fighter2 = new Fighter(name2, setWeight(weight2), setStrength(strength2), setLvl(lvl2));
        String result = fighter1.fight(fighter2) ? ("Победил боец: " + fighter1.name) : ("Победил боец: " + fighter2.name);
        System.out.println(result);
    }

    public static int setWeight(int value) throws Exception{
        do{
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            if(value<1 || value>300){
                System.out.println("Неверное значение!!!");
                System.out.print("Ведите вес бойца(1-300): ");
                value = Integer.parseInt(r.readLine());
            }
        } while(value<1 || value>300);
        return value;
    }
    public static int setStrength(int value) throws Exception{
        do{
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            if(value<1 || value>100){
                System.out.println("Неверное значение!!!");
                System.out.print("Ведите силу бойца(1-100): ");
                value = Integer.parseInt(r.readLine());
            }
        } while(value<1 || value>100);
        return value;
    }
    public static int setLvl(int value) throws Exception{
        do{
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            if(value<1 || value>10){
                System.out.println("Неверное значение!!!");
                System.out.print("Ведите уровень бойца(1-10): ");
                value = Integer.parseInt(r.readLine());
            }
        } while(value<1 || value>10);
        return value;
    }

    public static class Fighter {
        String name;
        int weight;
        int strength;
        int lvl;

        public Fighter(String name, int weight, int strength, int lvl){
            this.name = name;
            this.weight = weight;
            this.strength = strength;
            this.lvl = lvl;
        }

        public boolean fight(Fighter anotherFighter){
            int weightScore1 = this.weight > anotherFighter.weight ? this.weight*2:0;
            int strengthScore1 = this.strength > anotherFighter.strength ? this.strength*7:0;
            int lvlScore1 = this.lvl > anotherFighter.lvl ? this.lvl*10:0;
            int weightScore2 = this.weight < anotherFighter.weight ? anotherFighter.weight*2:0;
            int strengthScore2 = this.strength < anotherFighter.strength ? anotherFighter.strength*7:0;
            int lvlScore2 = this.lvl < anotherFighter.lvl ? anotherFighter.lvl*10:0;

            int score1 = weightScore1 + strengthScore1 +lvlScore1;
            System.out.println(this.name + "=" + score1);
            int score2 = weightScore2 + strengthScore2 +lvlScore2;
            System.out.println(anotherFighter.name + "=" +score2);
            return score1 > score2;
        }
    }


}
