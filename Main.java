import java.util.Scanner;
import java.util.Random;


public class Main {
    int hero_Choice, move_Choice;
    static String green;
    static int my_Hp, my_Att, Rosh_tmp_health, initial_Rosh_Hp, initial_Health;

    public static void main(String[] args) {


        //                      Heroes

        Heroes Morph = new Heroes("Morhp", 310, ramdom_Attack_Number(59 - 10, 59  + 10));
        Heroes Lina = new Heroes("Lina", 190, ramdom_Attack_Number(129 - 60, 129 + 60 ));
        Heroes Centaur = new Heroes("Centaur", 600,31);
        Heroes Tiny = new Heroes("Tiny", 450,40);
        Heroes Rosh = new Heroes ("Rosh", 800, 60 );

        initial_Rosh_Hp = Rosh.getHp();
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
        while (my_Hp > 0 ){
            System.out.println("0 to attack, 1 to heal");
            System.out.println("Whats is your next action ?");
                Scanner move_Choice =  new Scanner(System.in);
                int value2 = move_Choice.nextInt();
                if (value2 == 0){
                    System.out.println("You have decided to attack, who currently has " + Rosh.getHp() + " Health Points");
                    Rosh_tmp_health = Rosh.getHp() - ramdom_Attack_Number(my_Att-20,my_Att+20);
                    Rosh.setHp(Rosh_tmp_health);
                    if (Rosh.getHp() <= 0) {
                        System.out.println(" You won!!!!!!!!!!!!");
                        break;
                    }
                 else if (value2 == 1 ){
                        System.out.println("You have chosen to heal 86 points");
                        //Work to be done to recalibrate potions, superpotions, megapotions
                        my_Hp += 86;
                    }
                    else {System.out.println("You didn't know what to do. GG.");}

                }
                // ROsh's turn
                System.out.println("Roshan is gonna attack you with " + Rosh.getAtt() + " Attack Points");
                my_Hp = my_Hp - ramdom_Attack_Number(Rosh.getAtt()-20,Rosh.getAtt()+20 );
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
