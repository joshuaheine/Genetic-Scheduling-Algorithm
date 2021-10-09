package geneticClassSchedulingDomain;

public class Professor {
    private String id;
    private String name;
    public Professor(String id, String name){
        this.id=id;
        this.name=name;
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

}
