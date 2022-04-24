package cinema;

import java.util.Scanner;

class Cinema {

    static int currentIncome = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = scanner.nextInt();
        System.out.print("Enter the number of seats in each row: ");
        int seat = scanner.nextInt();
        String[][] hall = new String[row + 1][seat + 1];

        fillTheArray(hall, row, seat);
        Menu(hall, row, seat);
    }

    public static void Menu(String[][] hall, int row, int seat) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                lookAtTheHall(hall);
                Menu(hall, row, seat);
                break;
            case 2:
                buyTicket(hall, row, seat);
                Menu(hall, row, seat);
                break;
            case 3:
                statistic(hall, row, seat);
                Menu(hall, row, seat);
                break;
            case 0:
                break;
        }
    }

    public static void lookAtTheHall(String[][] hall) {
        System.out.println("Cinema:");
        for (int i = 0; i < hall.length; i++) {
            for (int j = 0; j < hall[i].length; j++) {
                System.out.print(hall[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void fillTheArray(String[][] hall, int row, int seat) {
        hall[0][0] = " ";
        for (int i = 1; i <= row; i++) { // lines
            hall[i][0] = String.valueOf(i);
        }
        for (int i = 1; i <= seat; i++) { // columns
            hall[0][i] = String.valueOf(i);
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= seat; j++) {
                hall[i][j] = "S";
            }
        }
    }

    public static void buyTicket(String[][] hall, int row, int seat) {
            int ticketPrice;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a row number: ");
            int row2 = scanner.nextInt();
            System.out.print("Enter a seat number in that row: ");
            int seat2 = scanner.nextInt();
            System.out.println();

             if ((row2 > row) || (seat2 > seat)) {
                 System.out.println("Wrong input\n");
                 buyTicket(hall, row, seat);
             } else if (hall[row2][seat2].equals("B")) {
                System.out.println("That ticket has already been purchased!\n");
                buyTicket(hall, row, seat);
             } else {
                hall[row2][seat2] = "B";
                if ((row * seat) <= 60) {
                    ticketPrice = 10;
                    currentIncome += 10;
                } else if (row2 <= 4) {
                    ticketPrice = 10;
                    currentIncome += 10;
                } else {
                    ticketPrice = 8;
                    currentIncome += 8;
                }
                System.out.println("Ticket price: $" + ticketPrice);
                System.out.println();
             }
    }

    public static void statistic (String[][] hall, int row, int seat) {
        int purchasedTickets = 0;
        for (String[] strings : hall) {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals("B")) {
                    purchasedTickets++;
                }
            }
        }

        float percentage = purchasedTickets / ((float)row * (float)seat) * 100;

        int totalIncome;
        if (row * seat <= 60) {
            totalIncome = row * seat * 10;
        } else {
            if (row % 2 == 0) {
                totalIncome = (row / 2 * seat * 10) + (row / 2 * seat * 8);
            } else {
                totalIncome = (row / 2 * seat * 10) + (((row / 2) + 1) * seat * 8);
            }
        }

        String result = String.format("%.2f",percentage);

        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.println("Percentage: " + result + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
        System.out.println();
    }
}