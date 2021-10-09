package geneticClassSchedulingDomain;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Course> courses;
    private ArrayList<Student> students = new ArrayList<>();

    public Department(String name){
        this.name = name;
        courses = new ArrayList<>();
    }
    
    public Department(String name, ArrayList<Course> courses) {
        this.name = name;
        this.courses = courses;
    }
    
    public String getName() {
        return name;
    }
    
    public void addCourse(Course c){
        courses.add(c);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }
    
    public void addStudent(Student student){
        students.add(student);
        
    }
}
