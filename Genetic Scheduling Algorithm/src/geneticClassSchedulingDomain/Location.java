package geneticClassSchedulingDomain;


public class Location {
    private String locationName;
    private int locationID;
    
    public Location(String locationName, int locationID){
        this.locationName=locationName;
        this.locationID=locationID;
    }
    
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
   
}
