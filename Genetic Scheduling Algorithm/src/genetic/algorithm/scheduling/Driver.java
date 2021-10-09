package genetic.algorithm.scheduling;

import java.util.ArrayList;
import geneticClassSchedulingDomain.Class;
import geneticClassSchedulingDomain.Course;
import geneticClassSchedulingDomain.Department;
import geneticClassSchedulingDomain.MeetingTime;
import geneticClassSchedulingDomain.Professor;
import geneticClassSchedulingDomain.Room;
import geneticClassSchedulingDomain.Student;

public class Driver {
    public static final int POPULATION_SIZE = 9;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUM_OF_ELITE_SCHEDULES = 1;
    private int scheduleNum=0;
    private int classNumb = 1;
    private Data data;
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.data = new Data();
        int generationNumber = 0;
        driver.printAvailableData();
        System.out.println("> Generation # "+generationNumber);
        System.out.println(" Schedule # |                                           ");
        System.out.println(" Classes [dept,class,room,professor,meeting-time]           ");
        System.out.println("                                                                                                                                                                                 | Fitness | Conflicts");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(driver.data); 
        Population population = new Population(Driver.POPULATION_SIZE,driver.data).sortByFitness();
        population.getSchedules().forEach(schedule -> System.out.println(driver.scheduleNum++ + "     | "+ schedule + " | " + String.format("%.5f", schedule.getFitness()) + " | " +schedule.getNumberOfConflicts()));
        driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
        driver.classNumb=1;
        while (population.getSchedules().get(0).getFitness() != 1.0){
        System.out.println("> Generation # "+ ++generationNumber);
        System.out.println(" Schedule # |                                           ");
        System.out.println(" Classes [dept,class,room,professor,meeting-time]           ");
        System.out.println("                                                                                                                                                                                     | Fitness | Conflicts");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
        //This evolves the population then sorts them out by fitness
        population = geneticAlgorithm.evolve(population).sortByFitness();
        driver.scheduleNum = 0;
        population.getSchedules().forEach(schedule -> System.out.println(driver.scheduleNum++ + " | "+ schedule + " | " + String.format("%.5f", schedule.getFitness()) + " | " + schedule.getNumberOfConflicts()));
        driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
        driver.classNumb = 1;
        }
    }   
    
    private void printScheduleAsTable(Schedule schedule, int generation){
        ArrayList<Class> classes = schedule.getClasses();
        System.out.println("\n                      ");
        System.out.println("Class # | Dept | Course (number, max # of students| Room(Capacity) | Professor (ID) | Meeting Time (ID)");
        System.out.println("                    ");
        System.out.println("------------------------------------------");
        System.out.println("-------------------------------------------------------------");
        int count = 0;
        classes.forEach(x ->{
            int majorIndex = data.getDepts().indexOf(x.getDept());
            int coursesIndex = data.getCourses().indexOf(x.getCourse());
            int roomsIndex = data.getRooms().indexOf(x.getRoom());
            int professorIndex = data.getProfessors().indexOf(x.getProfessor());
            int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
            int studentIndex = data.getStudents().indexOf(x.getStudents());
            System.out.println("                     ");
            System.out.println(String.format(" %1$02d ", classNumb));
            System.out.println(String.format(" %1$4s ", "|   " + data.getDepts().get(majorIndex).getName()));
            System.out.println(String.format(" %1$10s ","|   " + data.getCourses().get(coursesIndex).getName() + " ("+data.getCourses().get(coursesIndex).getNumber()+", "+ x.getCourse().getMaxNumberofStudents())+ ")");
            System.out.println(String.format(" %1$10s ","|   " + data.getRooms().get(roomsIndex).getNumber() + " ("+ x.getRoom().getSeatingCapacity()) + ")");
            System.out.println(String.format(" %1$15s ","|   " + data.getProfessors().get(professorIndex).getName()+ " ("+data.getProfessors().get(professorIndex).getId()+")"));
            System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getTime() + "("+data.getMeetingTimes().get(meetingTimeIndex).getId()+")"+ "("+data.getMeetingTimes().get(meetingTimeIndex).getDay()+")");
            int number = 0;
            for(Student s : data.getCourses().get(coursesIndex).getStudents()){
                if (number ==0){
                    System.out.print("Student Name:\t");
                }
                System.out.print(s.getName()+"\t");
                number ++;
                if (number >9){
                    System.out.println();
                    number = 0;
                }
            }
            System.out.println();
            classNumb++;
        });
        WriteXMLFile newXML = new WriteXMLFile();
        newXML.xmlCreator(classes);
        if (schedule.getFitness() == 1) System.out.println("> Solution Found in "+ (generation + 1) +" generations");
        System.out.println("----------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------------------");
    }
    
    private void printAvailableData(){
        System.out.println("Available Departments -->");
        data.getDepts().forEach(x->System.out.println("name: "+x.getName()+", courses: "+x.getCourses()));
        
        System.out.println("\nAvailable Courses ==>");
        data.getCourses().forEach(x->System.out.println("course #: "+x.getNumber()+", name :"+x.getName()+", max # of students: "+ x.getMaxNumberofStudents()+", professors: "+ x.getProfessors()));
    
        System.out.println("\nAvailable Rooms -->");
        data.getRooms().forEach(x->System.out.println("room #: "+ x.getNumber()+", max seating capacity: "+ x.getSeatingCapacity()));
    
        System.out.println("\nAvailable Professors -->");
        data.getProfessors().forEach(x->System.out.println("id : "+ x.getId()+", name: "+ x.getName()));
    
        System.out.println("\nAvailable Meeting Times -->");
        data.getMeetingTimes().forEach(x->System.out.println("id : "+ x.getId()+", Meeting Time:" + x.getTime()));
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------");
    }
    
}
