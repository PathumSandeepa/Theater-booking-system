package newTheatre.com;

import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Theatre {
    private static final int[][] seatsInTheater = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private static Person person;
    private static Ticket ticket;
    private static ArrayList<Ticket> ticketDetails = new ArrayList<Ticket>();

    public static void main(String[] args) {
        System.out.print("\u001B[1m");
        System.out.print("\u001B[36m");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("                                  Welcome to the New Theatre                                    ");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.print("\u001B[0m");

        menu();
    }

    public static void menu() {
        Scanner Input = new Scanner(System.in);
        System.out.print("\u001B[1m");
        System.out.print("\u001B[38;2;138;201;38m");
        System.out.print("""
                -----------------------\u001B[0m\u001B[1mMENU\u001B[0m\u001B[38;2;138;201;38m--------------------------
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
        System.out.print("\u001B[0m");


        while (true) {
            System.out.print("Enter option: ");
            try {
                int menuInput = Input.nextInt();     //get menu option number from user

                switch (menuInput) {
                    case 1:
                        buy_ticket();
                        break;
                    case 2:
                        print_seating_area();
                        break;
                    case 3:
                        cancel_ticket();
                        break;
                    case 4:
                        show_available();
                        break;
                    case 5:
                        save();
                        break;
                    case 6:
                        load();
                        break;
                    case 7:
                        show_tickets_info();
                        break;
                    //                    case 8:
                    //                        //Sort tickets by price
                    //                        System.out.println("Enter option: ");
                    //                        break;
                    case 0:
                        exit();
                        break;
                    default:
                        System.out.println("Enter Valid Input");
                        menu();
                        break;
                }
            } catch (Exception e) {
                Input.next();
                System.out.println( "Your input is not a integer. input valid integer");}
        }
    }


    //buy ticket method
    public static void buy_ticket() {
        Scanner Input = new Scanner(System.in);

        System.out.print("Enter name:  ");
        String name = Input.nextLine();

        System.out.print("Enter surname:  ");
        String surName = Input.nextLine();

        System.out.print("Enter email:  ");
        String email = Input.nextLine();

        System.out.print("Enter row number:  ");
        int row_number = Input.nextInt() - 1;

        System.out.print("Enter seat number:  ");
        int seat_number = Input.nextInt() - 1;

        System.out.print("Enter price:  ");
        double price = Input.nextDouble();

        //validation part
        if (row_number == 0) {
            if (seat_number >= 0 && seat_number <= 11) {
                if (seatsInTheater[0][seat_number] == 1) {
                    System.out.println("Seat is already booked.");
                    System.out.println();
                    buyTicket_continue();
                } else {
                    seatsInTheater[0][seat_number] = 1;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number + 1, seat_number + 1, price, person);
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


        } else if (row_number == 1) {
            if (seat_number >= 0 && seat_number <= 15) {
                if (seatsInTheater[1][seat_number] == 1) {
                    System.out.println("Seat is already booked.");
                    System.out.println();
                    buyTicket_continue();
                } else {
                    seatsInTheater[1][seat_number] = 1;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number + 1, seat_number + 1, 100.0, person);
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
            if (seat_number >= 0 && seat_number <= 19) {
                if (seatsInTheater[2][seat_number] == 1) {
                    System.out.println("Seat is already booked.");
                    System.out.println();
                    buyTicket_continue();
                } else {
                    seatsInTheater[2][seat_number] = 1;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number + 1, seat_number + 1, 100.0, person);
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


    public static void cancel_ticket() {

        Scanner Input = new Scanner(System.in);

        System.out.print("Enter row name:  ");
        String name = Input.nextLine();

        System.out.print("Enter row surname:  ");
        String surName = Input.nextLine();

        System.out.print("Enter row email:  ");
        String email = Input.nextLine();

        System.out.print("Enter row number:  ");
        int row_number = Input.nextInt() - 1;

        System.out.print("Enter seat number:  ");
        int seat_number = Input.nextInt() - 1;

        if (row_number == 0) {
            if (seat_number >= 0 && seat_number <= 11) {
                if (seatsInTheater[0][seat_number] == 0) {
                    System.out.println(" It's Free seat. you can't cancel this seat ");
                    cancelTicket_continue();
                } else {
                    seatsInTheater[0][seat_number] = 0;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number + 1, seat_number + 1, 100.0, person);
                    ticketDetails.remove(ticket);
                    System.out.println(" Successfully canceled ");
                    menu();
                }
            } else {
                System.out.println("Invalid seat number.");
            }


        } else if (row_number == 1) {
            if (seat_number >= 0 && seat_number <= 15) {
                if (seatsInTheater[1][seat_number] == 0) {
                    System.out.println(" It's Free seat. you can't cancel this seat ");
                    cancelTicket_continue();

                } else {
                    seatsInTheater[1][seat_number] = 0;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number + 1, seat_number + 1, 100.0, person);
                    ticketDetails.remove(ticket);
                    System.out.println(" Successfully canceled ");
                    menu();
                }
            } else {
                System.out.println("Invalid seat number.");
            }


        } else if (row_number == 2) {
            if (seat_number >= 0 && seat_number <= 19) {
                if (seatsInTheater[2][seat_number] == 0) {
                    System.out.println(" It's Free seat. you can't cancel this seat ");
                    cancelTicket_continue();
                } else {
                    seatsInTheater[2][seat_number] = 0;
                    person = new Person(name, surName, email);
                    ticket = new Ticket(row_number + 1, seat_number + 1, 100.0, person);
                    ticketDetails.remove(ticket);
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
            for( int i = 0 ; i < seatsInTheater.length; i++){
                for( int j = 0 ; j < seatsInTheater[i].length; j++ ){
                    arrayWrite.write(seatsInTheater[i][j]+" ");
                }arrayWrite.newLine();
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

    }


    public static void exit() {
        System.out.println("""
                ------------------------------------------------------------------------------------------------      
                                                          T H A N K   Y O U !
                ------------------------------------------------------------------------------------------------
                """);
    }


}





