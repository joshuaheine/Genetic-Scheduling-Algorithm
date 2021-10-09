package geneticClassSchedulingDomain;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private String department;
    
    public Student(String id, String name,String department){
        this.id=id;
        this.name=name;
        this.department=department;
    }

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString(){
        return name;
    }
    
    public String getDepartment(){
        return department;
    }

}
