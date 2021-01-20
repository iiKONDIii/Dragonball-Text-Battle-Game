import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System Requirements
        Scanner in = new Scanner(System.in);
        Random random = new Random();


        //Enemies

        String[] Enemies = {"Vegeta", "Frieza", "Cell", "Buu", "Androids 17 & 18"};
        int enemiesMaxHealth = 100;
        int enemiesAttack = 95;

        //Player
        int health = 100;
        int kamehamehaDMG = 75;
        int punchDMG = 30;
        int kickDMG = 50;
        int senzuBeans = 3;
        int senzuHealthHeal = 45;
        int chanceOfSenzu = 50;


        boolean running = true;

        // Story
        System.out.println("Welcome to the world of Dragonball. Can you defeat all the warriors to keep peace on planet earth.....find out NOW! ");

        GAME:
        while (running) {

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");

            int enemyHealth = random.nextInt(enemiesMaxHealth);
            String enemies = Enemies[random.nextInt(Enemies.length)];
            System.out.println(enemies + " appeared.......what will you do ?");

            while (enemyHealth > 0) {

                System.out.println("\tYour HP: " + health);
                System.out.println("\t" + enemies + "'s HP: " + enemyHealth);
                System.out.println("\t\nWhat move will you do?\n 1) Punch\n 2) Kick\n " +
                        "3) Kamehameha\n 4) Eat Senzu Bean\n 5) Run");
                int moveSelection = in.nextInt();

                // Punch Mechanic
                if (moveSelection == 1) {
                    enemyHealth = enemyHealth - random.nextInt(punchDMG)+1;
                    System.out.println(enemies+"'s health is now " + enemyHealth);
                    if (enemyHealth > 0) {
                        health = health - random.nextInt(enemiesAttack);
                        System.out.println("Your health is now " + health);
                        if (health < 1) {
                            System.out.println("Earth has been destroyed by " + enemies);
                            break;
                        }
                    }
                }

                // Kick Mechanic
                else if (moveSelection == 2) {
                    enemyHealth = enemyHealth - random.nextInt(kickDMG)+1;
                    System.out.println(enemies+"'s health is now " + enemyHealth);
                    if (enemyHealth > 0) {
                        health = health - random.nextInt(enemiesAttack);
                        System.out.println("Your health is now " + health);
                        if (health < 1) {
                            System.out.println("Earth has been destroyed by " + enemies);
                            break;
                        }
                    }
                }
                // Kamehameha Mechanic
                else if (moveSelection == 3) {
                    enemyHealth = enemyHealth - random.nextInt(kamehamehaDMG)+1;
                    System.out.println(enemies+"'s health is now " + enemyHealth);
                    if (enemyHealth > 0) {
                        health = health - random.nextInt(enemiesAttack);
                        System.out.println("Your health is now " + health);
                        if (health < 1) {
                            System.out.println("Earth has been destroyed by " + enemies);
                            break;
                        }
                    }
                }
                // heal mechanic
                else if (moveSelection == 4) {
                    health = health + senzuHealthHeal;
                    senzuBeans = senzuBeans-1 ;
                    System.out.println("You have "+senzuBeans+" senzu bean(s) left");
                    if(senzuBeans < 1){
                        System.out.println("You are out of senzu beans!");

                    }
                }
                // instant transmission
                else if (moveSelection == 5){
                    System.out.println("You used instant transmission to run");
                        continue GAME;
                }

                else {
                    System.out.println("That option is not viable");
                }
            }
            if (health<1){
                System.out.println("GAME OVER");
                break;
            }
            System.out.println(enemies+" was defeated");
            System.out.println("your health is "+health);
            if (random.nextInt(100) < chanceOfSenzu){
                senzuBeans++;
                System.out.println(enemies+" dropped a senzu, you now have "+senzuBeans+" senzu bean(s)");
            }
            String input;
            System.out.println("You have won the battle, do you wish to stay in the Hyperbolic Time Chamber?");
            input=in.next();
            while (!input.equals("yes") && !input.equals("no")){
                System.out.println("INVALID OPTION");
                input =in.next();
            }

            if (input.equals("yes")){
                System.out.println("You step back into the chamber");

            }
            else if (input.equals("no")){
                System.out.println("You exit the chamber stronger than ever");
                break;
            }
        }

    }
}

