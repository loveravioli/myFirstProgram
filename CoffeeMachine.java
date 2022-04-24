package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int waterInMachine = 400;
    static int milkInMachine = 540;
    static int coffeeInMachine = 120;
    static int disposableCups = 9;
    static int moneyInMachine = 550;

    public static void main(String[] args) {
        coffeeMachine();
    }

    public static void coffeeMachine () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write action (buy, fill, take, remaining, exit): ");
        String action = scanner.nextLine();

        switch (action) {
            case "buy":
                System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String moveCoffee = scanner.nextLine();
                switch (moveCoffee) {
                    case "1":
                        if (waterInMachine < 250) {
                            System.out.print("\nSorry, not enough water!\n");
                            break;
                        } else if (coffeeInMachine < 16) {
                            System.out.print("\nSorry, not enough coffee!\n");
                            break;
                        } else if (disposableCups < 1) {
                            System.out.println("\nSorry, not enough cups!\n");
                            break;
                        } else {
                            System.out.println("\nI have enough resources, making you a coffee!");
                        }
                        waterInMachine -= 250;
                        coffeeInMachine -= 16;
                        moneyInMachine += 4;
                        disposableCups--;
                        break;
                    case "2":
                        if (waterInMachine < 350) {
                            System.out.print("\nSorry, not enough water!\n");
                            break;
                        } else if (milkInMachine < 75) {
                            System.out.print("\nSorry, not enough milk!\n");
                            break;
                        } else if (coffeeInMachine < 20) {
                            System.out.print("\nSorry, not enough coffee!\n");
                            break;
                        } else if (disposableCups < 1) {
                            System.out.println("\nSorry, not enough cups!\n");
                            break;
                        } else {
                            System.out.println("\nI have enough resources, making you a coffee!");
                        }
                        waterInMachine -= 350;
                        milkInMachine -= 75;
                        coffeeInMachine -= 20;
                        moneyInMachine += 7;
                        disposableCups--;
                        break;
                    case "3":
                        if (waterInMachine < 200) {
                            System.out.print("\nSorry, not enough water!\n");
                            break;
                        } else if (milkInMachine < 100) {
                            System.out.print("\nSorry, not enough milk!\n");
                            break;
                        } else if (coffeeInMachine < 12) {
                            System.out.print("\nSorry, not enough coffee!\n");
                            break;
                        } else if (disposableCups < 1) {
                            System.out.println("\nSorry, not enough cups!\n");
                            break;
                        } else {
                            System.out.println("\nI have enough resources, making you a coffee!");
                        }
                        waterInMachine -= 200;
                        milkInMachine -= 100;
                        coffeeInMachine -= 12;
                        moneyInMachine += 6;
                        disposableCups--;
                        break;
                    case "back":
                        break;
                }
                coffeeMachine();
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add: ");
                int mlWater = scanner.nextInt();
                waterInMachine += mlWater;
                System.out.println("Write how many ml of milk you want to add: ");
                int mlMilk = scanner.nextInt();
                milkInMachine += mlMilk;
                System.out.println("Write how many grams of coffee beans you want to add: ");
                int grCoffee = scanner.nextInt();
                coffeeInMachine += grCoffee;
                System.out.println("Write how many disposable cups of coffee you want to add: ");
                int disposable = scanner.nextInt();
                disposableCups += disposable;
                coffeeMachine();
                break;
            case "take":
                System.out.println("I gave you $" + moneyInMachine);
                moneyInMachine -= moneyInMachine;
                coffeeMachine();
                break;
            case "remaining":
                menu(waterInMachine, milkInMachine, coffeeInMachine, disposableCups, moneyInMachine);
                coffeeMachine();
                break;
            case "exit":
                break;
        }
    }


    public static void menu(int waterInMachine,int milkInMachine,int coffeeInMachine,int disposableCups,int moneyInMachine) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterInMachine + " ml of water");
        System.out.println(milkInMachine + " ml of milk");
        System.out.println(coffeeInMachine + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + moneyInMachine + " of money\n");
    }
}