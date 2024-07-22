package TrainTicketBookingApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TicketBooking {
    private static int berthLimit=1; //lower-2,middle-2,upper-2
    private static int racLimit=2;
    private static int waitingListLimit=2;

    private static int upperSearNumber=1;
    private static int middleSeatNumber=2;
    private static int lowerSeatNumber=3;

    private static ArrayList<Passanger> confirmedList=new ArrayList<>();

    private static ArrayList<Passanger> upperList=new ArrayList<>();
    private static ArrayList<Passanger> lowerList=new ArrayList<>();
    private static ArrayList<Passanger> middleList=new ArrayList<>();

    private static Queue<Passanger> racQueue=new LinkedList<>();
    private static Queue<Passanger> waitingListQueue=new LinkedList<>();

        public static void bookTicket(Passanger p) {
            if (isBerthFull()) {
                    if (racQueue.size() < racLimit) {
                        addPassengertoRacQueue(p);
                        System.out.println("Added to RAC: ");
                        System.out.println("Your ID: " + p.getPassengerId());
                    }
                    else if (waitingListQueue.size() < waitingListLimit) {
                        addPassengertoWaitingList(p);
                        System.out.println("Added to Waiting List: ");
                        System.out.println("Your ID: " + p.getPassengerId());
                    }
                    else {
                        System.out.println("Ticket Not Available..!");
                    }
            }
            else if(checkTicketAvailablity(p)){
                  p.setTicketType("Berth");
                  confirmedList.add(p);
                  System.out.println("Your Ticket has beed Confirmed \n Your Id "+ p.getPassengerId());
            }else{
                System.out.println("Seat Not Available \n Checkout Available Seats: ");
                p.setPassengerIdProvider(p.getPassengerId()-1);
                displayAvailableSeats();
            }
        }

        static void displayAvailableSeats(){
            System.out.println("Upper: "+(berthLimit-upperList.size()));
            System.out.println("Middle: "+(berthLimit-middleList.size()));
            System.out.println("Lower: "+(berthLimit-lowerList.size()));
        }


         private static boolean checkTicketAvailablity( Passanger p){
                if(p.getSeatPreference() == 'U'){
                    if(upperList.size() < berthLimit){
                         p.setSeatNo(upperSearNumber);
                         upperList.add(p);
                         upperSearNumber+=3;
                         return true;
                    }
                }
                else if(p.getSeatPreference() == 'M'){
                     if(middleList.size() < berthLimit){
                         p.setSeatNo(middleSeatNumber);
                         middleList.add(p);
                        middleSeatNumber+=3;
                        return true;
                     }
                }
                else {
                     if(lowerList.size() < berthLimit) {
                         p.setSeatNo(lowerSeatNumber);
                         lowerList.add(p);
                         lowerSeatNumber += 3;
                         return true;
                     }
                }
            return false;
        }

        private static void addPassengertoRacQueue(Passanger p){
            racQueue.add(p);
            p.setTicketType("RAC");
        }

        private static void addPassengertoWaitingList(Passanger p){
            waitingListQueue.add(p);
            p.setTicketType("Waiting List");
        }

        private static boolean isBerthFull () {
            if (upperList.size() == berthLimit && lowerList.size() == berthLimit && middleList.size() == berthLimit) {
                return true;
            }
            return false;
        }

        static void displayConfirmedList(){
            for(Passanger p:confirmedList){
                System.out.println("Passeneger ID: "+p.getPassengerId());
                System.out.println("Passenger Name: "+p.getPassengerName());
                System.out.println("Passenger Age: "+p.getPassengerAge());
                System.out.println("Passenger Seat No: "+p.getSeatNo());
                System.out.println("Passenger Seat Preference: "+p.getSeatPreference());
                System.out.println("Booked Category: "+p.getTicketType());
                System.out.println("------------------------------------------------------");
            }
        }
        static void displayRacList(){
            for(Passanger p:racQueue){
                System.out.println("Passeneger ID: "+p.getPassengerId());
                System.out.println("Passenger Name: "+p.getPassengerName());
                System.out.println("Passenger Age: "+p.getPassengerAge());
                System.out.println("Passenger Seat No: "+p.getSeatNo());
                System.out.println("Passenger Seat Preference: "+p.getSeatPreference());
                System.out.println("Booked Category: "+p.getTicketType());
                System.out.println("------------------------------------------------------");
            }
        }
        static void displayWaitingList(){
            for(Passanger p:waitingListQueue){
                System.out.println("Passeneger ID: "+p.getPassengerId());
                System.out.println("Passenger Name: "+p.getPassengerName());
                System.out.println("Passenger Age: "+p.getPassengerAge());
                System.out.println("Passenger Seat No: "+p.getSeatNo());
                System.out.println("Passenger Seat Preference: "+p.getSeatPreference());
                System.out.println("Booked Category: "+p.getTicketType());
                System.out.println("------------------------------------------------------");
            }
        }


}

