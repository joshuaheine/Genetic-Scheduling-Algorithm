package geneticClassSchedulingDomain;

public class MeetingTime {
    private String id;
    private String time;
    private String day;
    private int endTime;       
    private int startTime;     

    public MeetingTime(String id, String day, String time) {
        this.id = id;
        this.time = time;
        this.day = day;
        endTime = Integer.parseInt(time.substring(8,9))*60+ Integer.parseInt(time.substring(11,12));      
        startTime = Integer.parseInt(time.substring(0,1))*60+ Integer.parseInt(time.substring(3,4));     

    }
    
    public int getStartTime(){
        return startTime;
        
    }
    
    public int getEndTime(){
        return endTime;
        
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }
    
    public String getDay() {
        return day;
    }
    
}
