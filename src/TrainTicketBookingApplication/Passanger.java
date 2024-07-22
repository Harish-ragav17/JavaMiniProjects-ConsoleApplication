package TrainTicketBookingApplication;

public class Passanger {
    static private int passengerIdProvider=0;
    private int passengerId;
    private String passengerName;
    private int passengerAge;
    private char seatPreference;
    private int seatNo;
    private String ticketType;

    public Passanger(String name,int age, char pref){
        this.passengerId=++passengerIdProvider;
        this.passengerName=name;
        this.passengerAge=age;
        this.seatPreference=pref;
    }

    public static void setPassengerIdProvider(int passengerIdProvider) {
        Passanger.passengerIdProvider = passengerIdProvider;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public int getPassengerId(){
        return passengerId;
    }
    public void setPassengerId(int pid){
        this.passengerId=pid;
    }

    public char getSeatPreference() {
        return seatPreference;
    }

    public void setSeatPreference(char seatPreference) {
        this.seatPreference = seatPreference;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }
}
