package newTheatre.com;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {
    //This 2D array stores all the seats in the system.
    private static int[][] seatsInTheater = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private static Person person;
    private static Ticket ticket;
    //This array list stores name, surname, email, row number, and price.
    private static ArrayList<Ticket> ticketDetails = new ArrayList<Ticket>();

    //this is main method. main method print program welcome message and calling menu method.
    public static void main(String[] args) {
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                  Welcome to the New Theatre                                    ");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println();

        menu();
        System.out.println();
    }

    //This is menu method print program menu. then get each manu item number from user.
    //switch case (Arrow syntax) used for user input validation part.
    //when user enter string value, then program handle that case using try catch.
    public static void menu() {
        Scanner Input = new Scanner(System.in);
        System.out.print("""
                -----------------------MENU----------------------
                Please select an option:
                1) Buy a ticket
                2) Print seating area
                3) Cancel ticket
                4) List available seats
                5) Save to file
                6) Load from file
                7) Print ticket information and total price
                8) Sort tickets by price
                        0) Quit
                -------------------------------------------------
                """
        );
//        System.out.print( );

        while (true) {
            System.out.print("Enter option: ");
            try {
                int menuInput = Input.nextInt();     //get menu option number from user

                switch (menuInput) {
                    case 1 -> buy_ticket();
                    case 2 -> print_seating_area();
                    case 3 -> cancel_ticket();
                    case 4 -> show_available();
                    case 5 -> save();
                    case 6 -> load();
                    case 7 -> show_tickets_info();
                    case 8 -> sort_tickets();
                    case 0 -> exit();
                    default -> {System.out.println("Enter Valid Input");
                                menu();
                    }
                }
            } catch (Exception e) {
                Input.next();
                System.out.println("Your input is not a integer. input valid integer");
            }
        }
    }


    //This is buy ticket method. In menu printing part, when user enter 1, then this method will run.
    //This method get user details, row number and seat number using scanner.
    //Then validate each row number and each row's seat number input is in 2D array range.
    //check each row's seat number = 1 ?. then print "Seat is already booked".
    //check each row's seat number = 0 ?. then set seat number = 1. print  "Seat booked successfully!".
    public static void buy_ticket() {
        Scanner Input = new Scanner(System.in);

        System.out.print("Enter name:  ");
        String name = Input.nextLine();

        System.out.print("Enter surname:  ");
        String surName = Input.nextLine();

        System.out.print("Enter email:  ");
        String email = Input.nextLine();

        System.out.print("Enter row number:  ");
        int row_number = Input.nextInt() ;

        System.out.print("Enter seat number:  ");
        int seat_number = Input.nextInt();

        System.out.print("Enter price:  ");
        double price = Input.nextDouble();

        //validation part
        if (row_number == 1 ) {
            if (seat_number >= 0 && seat_number <= 12) {
                if (seatsInTheater[0][seat_number-1] == 1) {
                    System.out.println("Seat is already booked.");
                    System.out.println();
                    buyTicket_continue();
                } else {
                    seatsInTheater[0][seat_number-1] = 1;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number, seat_number, price, person);
                    System.out.println();
                    System.out.println("Seat booked successfully!");
                    System.out.println();
                    ticketDetails.add(ticket);
                    menu();
                }
            } else {
                System.out.println("Invalid seat number.");
                buyTicket_continue();
            }

        } else if (row_number == 2) {
            if (seat_number >= 0 && seat_number <= 16) {
                if (seatsInTheater[1][seat_number-1] == 1) {
                    System.out.println("Seat is already booked.");
                    System.out.println();
                    buyTicket_continue();
                } else {
                    seatsInTheater[1][seat_number-1] = 1;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number, seat_number, price, person);
                    System.out.println();
                    System.out.println("Seat booked successfully!");
                    System.out.println();
                    ticketDetails.add(ticket);
                    menu();
                }
            } else {
                System.out.println("Invalid seat number.");
                buyTicket_continue();
            }

        } else if (row_number == 3) {
            if (seat_number >= 0 && seat_number <= 20) {
                if (seatsInTheater[2][seat_number-1] == 1) {
                    System.out.println("Seat is already booked.");
                    System.out.println();
                    buyTicket_continue();
                } else {
                    seatsInTheater[2][seat_number-1] = 1;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number, seat_number, price, person);
                    System.out.println();
                    System.out.println("Seat booked successfully!");
                    System.out.println();
                    ticketDetails.add(ticket);
                    menu();
                }
            } else {
                System.out.println("Invalid seat number.");
                buyTicket_continue();
            }
        } else {
            System.out.println("Invalid row or column number. Please check again! ");
            System.out.println();
            buy_ticket();
        }
    }

    // In buy ticket part, when user enter already entered row and seat number, then display  "Seat is already booked".
    //After that message buyTicket_continue() method running.
    //In buyTicket_continue method ask "Would you like to continue with buy ticket option?".
    // user answer is yes, then run again buy_ticket method. if no, run menu method.
    public static void buyTicket_continue() {
        Scanner Input = new Scanner(System.in);
        System.out.println();
        System.out.println(" Would you like to continue with buy ticket option? (y/n) ");
        String continue_buy = Input.next().toLowerCase();
        if (continue_buy.equals("y")) {
            buy_ticket();
        } else if (continue_buy.equals("n")) {
            menu();
        } else {
            System.out.println("Invalid input");
            buyTicket_continue();
        }
    }

    //This is seating area printing method. when user book a seat, then in 2D array 0 is changing to 1. when cancel a seat, then in 2D array 1 is changing to 0.
    //that updated changes print this method when user enter menu number 2
    private static void print_seating_area() {
        System.out.println("""
                 
                                           ***********
                                            * STAGE *
                                           ***********
                 
                """);

        for (int i = 0; i < seatsInTheater.length; i++) {
            for (int j = 0; j < (seatsInTheater[2].length - seatsInTheater[i].length) / 2; j += 1) {
                System.out.print("   ");
            }

            for (int z = 0; z < seatsInTheater[i].length; z++) {
                if (seatsInTheater[i][z] == 1) {
                    System.out.print(" X ");
                } else {
                    System.out.print(" 0 ");
                }
                if (seatsInTheater[i].length / 2 - 1 == z) {
                    System.out.print("   ");
                }
            }
            for (int j = 0; j < (seatsInTheater[2].length - seatsInTheater[i].length) / 2; j += 1) {
                System.out.print("   ");
            }
            System.out.println(" ");
        }
        System.out.println();
        menu();
    }


    //This is buy ticket method. In menu printing part, when user enter 3, then this method will run.
    //This method get user details, row number and seat number using scanner.
    //Then validate each row number and each row's seat number input is in 2D array range.
    //check each row's seat number = 0 ?. then print "It's Free seat. you can't cancel this seat".
    //check each row's seat number = 1 ?. then set seat number = 0. print  "Successfully canceled ".
    public static void cancel_ticket() {

        Scanner Input = new Scanner(System.in);

        System.out.print("Enter row number:  ");
        int row_number = Input.nextInt();

        System.out.print("Enter seat number:  ");
        int seat_number = Input.nextInt();

        if (row_number == 1) {
            if (seat_number >= 0 && seat_number <= 11) {
                if (seatsInTheater[0][seat_number-1] == 0) {
                    System.out.println(" It's Free seat. you can't cancel this seat ");
                    cancelTicket_continue();
                } else {
                    seatsInTheater[0][seat_number-1] = 0;
                    if (ticketDetails.get(0).getRow() == row_number && ticketDetails.get(0).getSeat() == seat_number){
                        ticketDetails.remove(0);
                    } else return;
                    System.out.println(" Successfully canceled ");
                    menu();
                }
            } else {
                System.out.println("Invalid seat number.");
            }
        } else if (row_number == 2) {
            if (seat_number >= 0 && seat_number <= 15) {
                if (seatsInTheater[1][seat_number-1] == 0) {
                    System.out.println(" It's Free seat. you can't cancel this seat ");
                    cancelTicket_continue();

                } else {
                    seatsInTheater[1][seat_number-1] = 0;
                    if (ticketDetails.get(1).getRow() == row_number && ticketDetails.get(1).getSeat() == seat_number){
                        ticketDetails.remove(0);
                    }
                    System.out.println(" Successfully canceled ");
                    menu();
                }
            } else {
                System.out.println("Invalid seat number.");
            }


        } else if (row_number == 3) {
            if (seat_number >= 0 && seat_number <= 19) {
                if (seatsInTheater[2][seat_number-1] == 0) {
                    System.out.println(" It's Free seat. you can't cancel this seat ");
                    cancelTicket_continue();
                } else {
                    seatsInTheater[2][seat_number-1] = 0;
                    if (ticketDetails.get(2).getRow() == row_number && ticketDetails.get(2).getSeat() == seat_number){
                        ticketDetails.remove(0);
                    }
                    System.out.println(" Successfully canceled ");
                    menu();
                }
            } else {
                System.out.println("Invalid seat number.");
            }
        } else {
            System.out.println("Invalid input. Try Again");
            System.out.println();
            cancel_ticket();
        }
    }


    //
    public static void cancelTicket_continue() {
        Scanner Input = new Scanner(System.in);
        System.out.println();
        System.out.println(" Would you like to continue with cancel ticket option? (y/n) ");
        String continue_cancel = Input.next().toLowerCase();
        if (continue_cancel.equals("y")) {
            cancel_ticket();
        } else if (continue_cancel.equals("n")) {
            menu();
        } else {
            System.out.println("Invalid input");
            cancelTicket_continue();
        }
    }

    public static void show_available() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Seats available in row " + (i + 1) + ": ");

            for (int a = 0; a < seatsInTheater[i].length; a++) {
                if (seatsInTheater[i][a] == 0)
                    System.out.print((a + 1) + " ");
            }
            System.out.println();

        }
        menu();
    }

    public static void save() {
        try {
            BufferedWriter arrayWrite = new BufferedWriter(new FileWriter("Theater Seat.txt"));
            for (int i = 0; i < seatsInTheater.length; i++) {
                for (int j = 0; j < seatsInTheater[i].length; j++) {
                    arrayWrite.write(seatsInTheater[i][j] + " ");
                }
                arrayWrite.newLine();
            }
            System.out.println("Data saved to file.");
            arrayWrite.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        menu();
    }


    public static void load() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Theater Seat.txt"));
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] seats = line.split(" ");
                for (int i = 0; i < seats.length; i++) {
                    seatsInTheater[row][i] = Integer.parseInt(seats[i]);
                }
                row += 1;
            }
            reader.close();
            System.out.println("Data loaded from file.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        menu();
    }


    public static void show_tickets_info() {
        ticketDetails.forEach((n) -> {
            Ticket currentTicket = n;
            currentTicket.print();
        });

        System.out.println();
        double totalPrice = 0.0;
        for (int i = 0; i < ticketDetails.size(); i++) {
            totalPrice = totalPrice + ticketDetails.get(i).getPrice();
        }
        System.out.println("Total ticket price " + totalPrice);

    }

    public static void sort_tickets() {
        int n = ticketDetails.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                Ticket ticket1 = ticketDetails.get(j);
                Ticket ticket2 = ticketDetails.get(j+1);
                if (ticket1.getPrice() > ticket2.getPrice()) {
                    ticketDetails.set(j, ticket2);
                    ticketDetails.set(j+1, ticket1);
                }
            }
        }
        menu();
    }


    public static void exit() {
        System.out.println("""
                ------------------------------------------------------------------------------------------------   
                                                          T H A N K   Y O U !
                ------------------------------------------------------------------------------------------------
                """);
    }


}





