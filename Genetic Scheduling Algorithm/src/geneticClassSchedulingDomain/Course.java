package geneticClassSchedulingDomain;
import java.util.ArrayList;
public class Course {
    private String number = null;
    private String name = null;
    private int maxNumberofStudents;
    private ArrayList<Professor> professors;
    private ArrayList<Student> students;
    private ArrayList<Class> classes;
    private boolean needComputers;
    private int setNumber;
    private int roomNumber;
    
    public Course(String number, String name, ArrayList<Professor> professors,int maxNumberofStudents, ArrayList<Student> students, boolean needComputers){
        this.number = number;
        this.name = name;      
        this.maxNumberofStudents = maxNumberofStudents;
        this.professors = professors;
        this.students = students;
        this.needComputers= needComputers;
        roomNumber=0;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumberofStudents() {
        return maxNumberofStudents;
    }
    
    public int getSetNumber() {
        return setNumber;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    public ArrayList<Class> getClasses() {
        return classes;
    }
    
    public String toString(){
        return name;
    }
    
    public boolean needComputers(){
        return needComputers;
    }
    
    public int getRoomNumber(){
        return roomNumber;
    }
    
    public void setRoomNumber(int number){
        roomNumber=number;
    }
    
    
}
