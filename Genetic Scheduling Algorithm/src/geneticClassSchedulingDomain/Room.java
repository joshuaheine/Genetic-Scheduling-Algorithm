package geneticClassSchedulingDomain;

public class Room {
    private String number;
    private int seatingCapacity;
    private boolean hasComputers;
    private Location location;

    public Room(String number, int seatingCapacity, boolean hasComputers, Location location) {
        this.number = number;
        this.seatingCapacity = seatingCapacity;
        this.hasComputers = hasComputers;
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    
    public boolean hasComputers(){
        return hasComputers;
    }
    
    public int getLocationID(){
        return location.getLocationID();
    }
    
}
