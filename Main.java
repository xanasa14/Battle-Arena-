package com.company;

import java.util.Scanner;
import java.util.Random;


public class Main {
    //Choices
    int hero_Choice, move_Choice, item_Choice;
    //Name of Hero
    static String green;
    // HP, attack, Rosh HP, Initial ROsh HP, Initial Heal of the protagonist hero
    static int my_Hp, my_Att, Rosh_tmp_health, initial_Rosh_Hp, initial_Health, turns_Of_Blinding;
    // Blinder
    static boolean blinder_Activated = false;
    public static void main(String[] args) {


        //                      Heroes

        Heroes Morph = new Heroes("Morhp", 310, ramdom_Attack_Number(59 - 10, 59  + 10));
        Heroes Lina = new Heroes("Lina", 190, ramdom_Attack_Number(129 - 60, 129 + 60 ));
        Heroes Centaur = new Heroes("Centaur", 600,31);
        Heroes Tiny = new Heroes("Tiny", 450,40);
        Heroes Rosh = new Heroes ("Rosh", 800, 60 );
        //                          Rosh
        initial_Rosh_Hp = Rosh.getHp();

        //items
        Items Tango = new Items("Tango",3, 120 );
        Items blinding_Light =  new Items ("blindingLigth",2, 0 );
        turns_Of_Blinding = 2;


        System.out.println("Please choose your hero");
        Scanner heroChoice =  new Scanner(System.in);
        int value = heroChoice.nextInt();
            if (value == 1) {
                Morph.intro();
                green = Morph.getName();
                my_Hp = Morph.getHp();
                my_Att = Morph.getAtt();
                initial_Health = Morph.getHp();
            }
            else if (value == 2) {
                Lina.intro();
                green= Lina.getName();
                my_Hp = Lina.getHp();
                initial_Health = Lina.getHp();
                my_Att = Lina.getAtt();
            }
            else if (value == 3) {
                Centaur.intro();
                green  = Centaur.getName();
                my_Hp = Centaur.getHp();
                my_Att = Centaur.getAtt();
                initial_Health = Centaur.getHp();
            }
            else if (value == 4) {
                Tiny.intro();
                green = Tiny.getName();
                my_Hp = Tiny.getHp();
                initial_Health = Tiny.getHp();
                my_Att = Tiny.getAtt();

            }

            else {
                System.out.println("Game Over");
        }
        System.out.println("0 to attack ");
        System.out.println("1 to go to items ");
        System.out.println("2 to heal with Tangoes. You only have 3.  ");
        System.out.println("3 to use blinder dust on enemy, which last 2 turns. You only have one. ");



        while (my_Hp > 0 ){
            System.out.println("0 to attack, 1 to use one of the Items. You only have " +  Tango.getQuantity() + " Tangoes, and " + blinding_Light.getQuantity() + " Blinding Dust");
            System.out.println("Whats is your next action ?");
                Scanner move_Choice =  new Scanner(System.in);
                int value2 = move_Choice.nextInt();
                if (value2 == 0){
                    System.out.println("You have decided to attack, who currently has " + Rosh.getHp() + " Health Points");
                    Rosh_tmp_health = Rosh.getHp() - ramdom_Attack_Number(my_Att-20,my_Att+20);
                    Rosh.setHp(Rosh_tmp_health);
                    if (Rosh.getHp() <= 0) {
                        System.out.println(" You won!!!!!!!!!!!!");
                        System.out.println(green + " has overcome the powers of Roshan");

                        System.out.println();
                        break;
                    }
                    }

                 else if (value2 == 1 ) {

                    System.out.println("Whats is your item choice. 2 for Tangoes and 3 for Blinding Light, which blinds Roshan to attack for 2 turns?");
                    Scanner item_Choice = new Scanner(System.in);
                    int value3 = move_Choice.nextInt();
                    if (value3 == 2)
                    {
                        if (Tango.quantity > 0) {
                            System.out.println("You have chosen to heal 120 points");
                            //Work to be done to recalibrate potions, superpotions, megapotions
                            my_Hp += Tango.getHealingPoints();
                            System.out.println("You have healed 120 points ");
                            Tango.setQuantity(Tango.getQuantity() - 1);
                        } else {
                            System.out.println("You have no Tangoes, so you have no healed yourself ");
                        }

                    }
                     else if (value3==3){
                        if (blinding_Light.quantity>0)
                        {blinder_Activated = true;}
                        blinding_Light.setQuantity(blinding_Light.getQuantity()-1);

                    }
                    }


                // ROsh's turn
                if (blinder_Activated){System.out.println("Roshan cannot attack you. He is currently blind");
                turns_Of_Blinding -= 1;
                if (turns_Of_Blinding == 0) {
                    blinder_Activated = false;
                    }
                }
                else{
                System.out.println("Roshan is gonna attack you with " + Rosh.getAtt() + " Attack Points");
                my_Hp = my_Hp - ramdom_Attack_Number(Rosh.getAtt()-20,Rosh.getAtt()+20 );}
                System.out.println("My current HP is " + my_Hp);
                int tmp_Percentage = (my_Hp*100)/initial_Health;
                System.out.println("HP: " + tmp_Percentage + " %" );
                while (tmp_Percentage >= 0) {
                    System.out.print("*");
                    tmp_Percentage -= 10;

               }
               System.out.println("");


               System.out.println("Enemy's HP "  + Rosh.getHp());
            int tmp_Percentage_Rosh = (Rosh_tmp_health*100)/initial_Rosh_Hp;
            System.out.println("Rosh's HP: " + tmp_Percentage_Rosh + " %");
            while (tmp_Percentage_Rosh >= 0) {
                System.out.print("+");
                tmp_Percentage_Rosh -= 10;

            }
            System.out.println("    ");


        }
            if (my_Hp < 0){
                        System.out.println("You lost. GG. Thanks for playing");
            }




    }
    private static int ramdom_Attack_Number(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
