package TrainTicketBookingApplication;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            String pName;
            int age;
            char seatPref;

            Scanner sc=new Scanner(System.in);

            while(true){
                System.out.println("-------------------------------------");
                System.out.println("Select The Above Choices: ");
                System.out.println("1 : Book Ticket");
                System.out.println("2 : Cancel Ticket");
                System.out.println("3 : Display Confirmed List");
                System.out.println("4 : Display RAC List");
                System.out.println("5 : Display Waiting List");
                System.out.println("-------------------------------------");

                int choice=sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Enter Your Name: ");
                        pName=sc.next();
                        System.out.println("Enter Your Age: ");
                        age=sc.nextInt();
                        System.out.println("Enter Your Seat Preference: M , U , L");
                        seatPref=sc.next().charAt(0);

                        if(pName=="" || age <= 0){
                            if(seatPref!='M' || seatPref != 'U' || seatPref != 'L'){
                                System.out.println("Invalid Seat Preference , Please Try Again..!");
                            }else{
                                System.out.println("Invalid Details , Please Try Again..!");
                            }
                        }else{
                          TicketBooking.bookTicket(new Passanger(pName,age,seatPref));
                        }
                        break;

                    case 2:
                        System.out.println("Enter Your Id: ");
                        int id=sc.nextInt();
                        TicketCancellation.cancelTicket(id);
                        break;
                    case 3:
                        System.out.println("----------------------------------------");
                        TicketBooking.displayConfirmedList();
                        break;
                    case 4:
                        System.out.println("----------------------------------------");
                        TicketBooking.displayRacList();
                        break;
                    case 5:
                        System.out.println("----------------------------------------");
                        TicketBooking.displayWaitingList();
                        break;
                    case 6:
                        System.out.println("Thank You..!");
                        return;
                }
            }
    }
}