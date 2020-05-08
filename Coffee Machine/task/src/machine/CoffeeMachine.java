package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner scanner = new Scanner(System.in);

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    static Boolean exit = false;

    public static void main(String[] args) {

        do{
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        switch (action){
            case "buy":{
                buy();
                break;
            }
            case "fill":{
                fill();
                break;
            }
            case "take":{
                take();
                break;
            }
            case "remaining":{
                remaining();
                break;
            }
            case "exit":{
                exit();
                break;
            }
        }
        }
        while (exit == false);
    }

    static void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffee = scanner.next();
        switch (coffee) {
            case "1": {
                if (canMakeCoffee(250, 0, 16)) {
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                    break;
                }
            }
            case "2": {
                if (canMakeCoffee(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    money += 7;
                    break;
                }
            }
            case "3": {
                if (canMakeCoffee(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
                    money += 6;
                    break;
                }
            }
            case "back": {
                break;
            }
            default: {
                break;
            }
        }
    }

    static void fill(){
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scanner.nextInt();
        water += addWater;
        milk += addMilk;
        beans += addBeans;
        cups += addCups;
    }

    static void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    static void remaining(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$"+ money + " of money");
        System.out.println();
    }

    static void exit() {
        exit = true;
    }

    static boolean canMakeCoffee(int needWater, int needMilk, int needBeans){
        if(water > needWater){
            if (milk > needMilk){
                if (beans > needBeans){
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }
                else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }
            }
            else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        }
        else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }
}
