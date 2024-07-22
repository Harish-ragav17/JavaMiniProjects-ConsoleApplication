package TrainTicketBookingApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class TicketCancellation extends TicketBooking {

       static private Map<Integer,Character> cancelledTickets = new HashMap<>();
       static private int seatNo;
       static private char seatPref;


        public static void cancelTicket(int id){
            if(confirmedListHas(id)){
                racToConfirm();
                waitingListToRac();
                System.out.println("Ticket Cancelled Sucessfully");
            }
            else if(racHas(id)){
                waitingListToRac();
                System.out.println("Ticket Cancelled Sucessfully");
            }
            else if(waitingListHas(id)){
                System.out.println("Ticket Cancelled Sucessfully");
            }else{
                System.out.println("Invalid Id");
            }
        }

    private static void racToConfirm() {
        Queue<Passanger> rac=getRacQueue();
        Passanger p=rac.poll();
        if(p!=null){
            p.setSeatNo(seatNo);
            p.setSeatPreference(seatPref);
            p.setTicketType("Berth");

            if(p.getSeatPreference() == 'M'){
                ArrayList<Passanger> ml=getMiddleList();
                ml.add(p);
                setMiddleList(ml);
            }
            else if(p.getSeatPreference() == 'U'){
                ArrayList<Passanger> ul=getUpperList();
                ul.add(p);
                setUpperList(ul);
            }else{
                ArrayList<Passanger> ll=getLowerList();
                ll.add(p);
                setLowerList(ll);
            }
            ArrayList<Passanger> confirmedList=getConfirmedList();
            confirmedList.add(p);
            setConfirmedList(confirmedList);

        }else{
             cancelledTickets.put(seatNo,seatPref);
        }
    }

    private static void waitingListToRac(){
            Queue<Passanger> wl=getWaitingListQueue();
            Passanger p=wl.poll();
            if(p!=null){
                Queue<Passanger> rac=getRacQueue();
                p.setTicketType("RAC");
                rac.add(p);
                setRacQueue(rac);
            }
    }

    public static boolean confirmedListHas(int id){
            ArrayList<Passanger> confirmedList = getConfirmedList();
            for(Passanger p:confirmedList){
                if(p.getPassengerId()==id){
                    seatNo=p.getSeatNo();
                    seatPref=p.getSeatPreference();
                    confirmedList.remove(p);
                    setConfirmedList(confirmedList);
                    removeFromAllList(p);
                    return true;
                }
            }
            return false;
        }

    public static boolean racHas(int id){
          Queue<Passanger> rac =getRacQueue();
          for(Passanger p:rac){
              if(p.getPassengerId() == id){
                  rac.remove(p);
                  return true;
              }
          }
          return false;
    }

    public static boolean waitingListHas(int id){
            Queue<Passanger> wl=getWaitingListQueue();

            for(Passanger p:wl){
                if(p.getPassengerId() == id){
                    wl.remove(p);
                    return true;
                }
            }
            return false;
    }

    public static void removeFromAllList(Passanger p){
            ArrayList<Passanger> upper=getUpperList();
            upper.remove(p);
            setUpperList(upper);

            ArrayList<Passanger> lower=getLowerList();
            lower.remove(p);
            setLowerList(lower);

            ArrayList<Passanger> middle=getMiddleList();
            middle.remove(p);
            setMiddleList(middle);
    }

    public static Map<Integer, Character> getCancelledTickets() {
        return cancelledTickets;
    }

    public static void setCancelledTickets(Map<Integer, Character> cancelledTickets) {
        TicketCancellation.cancelledTickets = cancelledTickets;
    }
}
