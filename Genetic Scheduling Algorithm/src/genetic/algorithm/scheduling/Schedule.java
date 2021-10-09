package genetic.algorithm.scheduling;

import geneticClassSchedulingDomain.Course;
import geneticClassSchedulingDomain.Department;
import geneticClassSchedulingDomain.Class;
import geneticClassSchedulingDomain.Professor;
import java.util.ArrayList;

public class Schedule {
    private ArrayList<Class> classes;
    private Data data;//Uses data from the data class
    private int classNum = 0;
    private int numberOfConflicts = 0;
    private boolean isFitnessChanged = true;
    private double fitness = -1;
    
    public Data getData() {
        return data;
    }

    public Schedule(Data data) {
        this.data = data;
        classes = new ArrayList<Class>(data.getNumberOfClasses());
    }
    public Schedule initialize(){
        new ArrayList<Department>(data.getDepts()).forEach(dept ->{
        dept.getCourses().forEach((Course course) -> {
            Class newClass = new Class(classNum++,dept,course);
            newClass.setMeetingTime(data.getMeetingTimes().get((int)(data.getMeetingTimes().size()*Math.random())));
            newClass.setRoom(data.getRooms().get((int)(data.getRooms().size()* Math.random())));
            newClass.setProfessor(course.getProfessors().get((int)(course.getProfessors().size() * Math.random())));
            classes.add(newClass);
            });
        });
        return this;
    }    

    public int getNumberOfConflicts() {
        return numberOfConflicts;
    }
    
    public ArrayList<Class> getClasses(){
        isFitnessChanged = true;
        return classes;
    }
    
    public double getFitness(){
        if(isFitnessChanged==true){
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    private double calculateFitness(){
       numberOfConflicts = 0;  
       classes.forEach(x -> {
            if(x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberofStudents()) numberOfConflicts++;
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
                if(x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()){
                    if(x.getRoom() == y.getRoom()) numberOfConflicts++;
                    if(x.getProfessor() == y.getProfessor()) numberOfConflicts++;
                    if(x.getCourse().needComputers() != x.getRoom().hasComputers()) numberOfConflicts++;
                    int endTimeAtLecture1 = x.getMeetingTime().getEndTime();       
                    int startTimeAtLecture2 = y.getMeetingTime().getStartTime();     
                    if(x.getRoom().getLocationID()!= y.getRoom().getLocationID() &&
                       x.getMeetingTime().getDay()==y.getMeetingTime().getDay() &&
                       endTimeAtLecture1 >= startTimeAtLecture2+30) numberOfConflicts++;    //30 Minutes early for the lecture      
                }
            });
        });
        return 1/(double)(numberOfConflicts +1);
    }
                
    public String toString() {
        String returnValue = new String();
        for (int x = 0; x < classes.size()-1; x++) returnValue += classes.get(x) + ",";
        returnValue += classes.get(classes.size()-1);
        return returnValue;
    }
}
