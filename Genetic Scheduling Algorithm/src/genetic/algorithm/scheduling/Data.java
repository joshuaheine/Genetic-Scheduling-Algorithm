package genetic.algorithm.scheduling;

import geneticClassSchedulingDomain.Course;
import geneticClassSchedulingDomain.Department;
import geneticClassSchedulingDomain.Location;
import geneticClassSchedulingDomain.MeetingTime;
import geneticClassSchedulingDomain.Professor;
import geneticClassSchedulingDomain.Room;
import geneticClassSchedulingDomain.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    private ArrayList<Room> rooms;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;
    private ArrayList<Department> depts;
    private ArrayList<MeetingTime> meetingTimes;
    private int numberOfClasses = 0;
    private ArrayList<Student> students;

    public Data() {// initialize all the variables    
        initialize();
    }

    private ArrayList<Location> setLocations() {
        ArrayList<Location> locations = new ArrayList<Location>();
        Location l1 = new Location("Wheatley", 1);
        Location l2 = new Location("Headington", 2);
        Location l3 = new Location("Gipsy Lane", 3);
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        return locations;
    }

    private void setUpRooms() {
        ArrayList<Location> locate = setLocations();
        Room room1 = new Room("R1", 105, true, locate.get(0));
        Room room2 = new Room("R2", 45, true, locate.get(0));
        Room room3 = new Room("R3", 35, true, locate.get(0));
        Room room4 = new Room("R4", 55, false, locate.get(0));
        Room room5 = new Room("R5", 35, true, locate.get(1));
        Room room6 = new Room("R6", 35, true, locate.get(1));
        Room room7 = new Room("R7", 75, true, locate.get(1));
        Room room8 = new Room("R8", 100, true, locate.get(1));
        Room room9 = new Room("R9", 35, false, locate.get(2));
        Room room10 = new Room("R10", 45, true, locate.get(2));
        Room room11 = new Room("R11", 55, true, locate.get(2));
        Room room12 = new Room("R12", 105, false, locate.get(2));
        Room room13 = new Room("R12", 35, true, locate.get(0));
        Room room14 = new Room("R14", 25, true, locate.get(0));
        Room room15 = new Room("R15", 55, true, locate.get(2));
        Room room16 = new Room("R16", 45, false, locate.get(2));
        Room room17 = new Room("R17", 45, true, locate.get(1));
        Room room18 = new Room("R18", 65, true, locate.get(1));
        Room room19 = new Room("R19", 35, true, locate.get(1));
        Room room20 = new Room("R20", 70, true, locate.get(1));
        rooms = new ArrayList<Room>(Arrays.asList(room1, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11, room12, room13, room14, room15, room16, room17, room18, room19, room20));
    }

    private void setUpMeetingTimes() {
        MeetingTime meetingTime1 = new MeetingTime("MT1", "Monday", "11:00 - 12:00");
        MeetingTime meetingTime2 = new MeetingTime("MT2", "Monday", "14:00 - 15:30");
        MeetingTime meetingTime3 = new MeetingTime("MT3", "Monday", "16:00 - 18:00");
        MeetingTime meetingTime4 = new MeetingTime("MT4", "Monday", "08:00 - 10:30");
        
        MeetingTime meetingTime5 = new MeetingTime("MT5", "Tuesday", "10:00 - 12:00");
        MeetingTime meetingTime6 = new MeetingTime("MT6", "Tuesday", "17:00 - 19:00");
        MeetingTime meetingTime7 = new MeetingTime("MT7", "Tuesday", "14:00 - 16:00");
        MeetingTime meetingTime8 = new MeetingTime("MT8", "Tuesday", "08:00 - 09:30");
        
        MeetingTime meetingTime9 = new MeetingTime("MT9","Wednesday", "11:00 - 14:30");
        MeetingTime meetingTime10 = new MeetingTime("MT10", "Wednesday", "13:00 - 14:30");
        MeetingTime meetingTime11 = new MeetingTime("MT11","Wednesday", "15:00 - 17:30");
        MeetingTime meetingTime12 = new MeetingTime("MT12", "Wednesday", "08:00 - 10:30");
        
        MeetingTime meetingTime13 = new MeetingTime("MT13", "Thursday", "10:30 - 12:00");
        MeetingTime meetingTime14 = new MeetingTime("MT14", "Thursday", "12:30 - 14:00");   
        MeetingTime meetingTime15 = new MeetingTime("MT15", "Thursday", "08:30 - 10:00");
        MeetingTime meetingTime16 = new MeetingTime("MT16", "Thursday", "14:30 - 16:00"); 
        
        MeetingTime meetingTime17 = new MeetingTime("MT17", "Friday", "09:00 - 11:00");
        MeetingTime meetingTime18 = new MeetingTime("MT18", "Friday", "13:00 - 15:00");
        MeetingTime meetingTime19 = new MeetingTime("MT19", "Friday", "15:30 - 17:00");        
        MeetingTime meetingTime20 = new MeetingTime("MT20", "Friday", "12:30 - 15:00");  
        /*
        MeetingTime meetingTime21 = new MeetingTime("MT21", "Monday", "15:00 - 18:00");
        MeetingTime meetingTime22 = new MeetingTime("MT22", "Monday", "10:00 - 12:30");
        MeetingTime meetingTime23 = new MeetingTime("MT23", "Monday", "15:00 - 16:50");
        MeetingTime meetingTime24 = new MeetingTime("MT24", "Monday", "13:00 - 15:30");
        
        MeetingTime meetingTime25 = new MeetingTime("MT25", "Tuesday", "06:00 - 08:00");
        MeetingTime meetingTime26 = new MeetingTime("MT26", "Tuesday", "07:00 - 09:00");
        MeetingTime meetingTime27 = new MeetingTime("MT27", "Tuesday", "16:00 - 18:00");
        MeetingTime meetingTime28 = new MeetingTime("MT28", "Tuesday", "14:00 - 16:30");
        */
        meetingTimes = new ArrayList<MeetingTime>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4, meetingTime5, meetingTime6, meetingTime7, meetingTime8,meetingTime9,meetingTime10,meetingTime11,meetingTime12, meetingTime13, meetingTime14, meetingTime15, meetingTime16, meetingTime17, meetingTime18, meetingTime19,meetingTime20/*,meetingTime21,meetingTime22, meetingTime23, meetingTime24, meetingTime25, meetingTime26, meetingTime27, meetingTime28*/));
    }

    private void setUpProfessors() {
        Professor professor1 = new Professor("P1", "Dr 1");
        Professor professor2 = new Professor("P2", "Dr 2");
        Professor professor3 = new Professor("P3", "Dr 3");
        Professor professor4 = new Professor("P4", "Dr 4");
        Professor professor5 = new Professor("P5", "Dr 5");
        Professor professor6 = new Professor("P6", "Dr 6");
        Professor professor7 = new Professor("P7", "Dr 7");
        Professor professor8 = new Professor("P8", "Dr 8");
        Professor professor9 = new Professor("P9", "Dr 9");
        Professor professor10 = new Professor("P10", "Dr 10");
        professors = new ArrayList<Professor>(Arrays.asList(professor1, professor2, professor3, professor4, professor5, professor6, professor7, professor8, professor9, professor10));
    }

    private void setUpCourses() {
        ArrayList<Student> studentDeptCS = new ArrayList<>();
        ArrayList<Student> studentDeptEng = new ArrayList<>();
        ArrayList<Student> studentDeptM = new ArrayList<>();
        for (Student s : students) {
            if (s.getDepartment().equals("Computer Science")) {
                studentDeptCS.add(s);
            } else if (s.getDepartment().equals("Engineering")) {
                studentDeptEng.add(s);
            } else if (s.getDepartment().equals("Mathematics")) {
                studentDeptM.add(s);
            }
        }
        courses = new ArrayList<Course>();

        Course course;
        //Computer Science 
        addStudentToCourse(courses, studentDeptCS, 25, "C1", "U1", new ArrayList<Professor>(Arrays.asList(professors.get(0))), true);
        addStudentToCourse(courses, studentDeptCS, 30, "C2", "U2", new ArrayList<Professor>(Arrays.asList(professors.get(0), professors.get(1), professors.get(2))), true);
        addStudentToCourse(courses, studentDeptCS, 40, "C3", "U3", new ArrayList<Professor>(Arrays.asList(professors.get(0), professors.get(1))), true);
        addStudentToCourse(courses, studentDeptCS, 50, "C4", "U4", new ArrayList<Professor>(Arrays.asList(professors.get(1), professors.get(2))), true);
        addStudentToCourse(courses, studentDeptCS, 50, "C5", "U5", new ArrayList<Professor>(Arrays.asList(professors.get(2))), true);
        addStudentToCourse(courses, studentDeptCS, 45, "C6", "U6", new ArrayList<Professor>(Arrays.asList(professors.get(2))), true);
        addStudentToCourse(courses, studentDeptCS, 45, "C7", "U7", new ArrayList<Professor>(Arrays.asList(professors.get(1), professors.get(2))), true);

        /*
        addStudentToCourse(courses,studentDeptCS,65,"C23","U23",new ArrayList<Professor>(Arrays.asList(professors.get(2))), false);
        addStudentToCourse(courses,studentDeptCS,40,"C24","U24",new ArrayList<Professor>(Arrays.asList(professors.get(0), professors.get(2), professors.get(2))), false);
        addStudentToCourse(courses,studentDeptCS,25,"C25","U25",new ArrayList<Professor>(Arrays.asList(professors.get(0), professors.get(1))), false);
        addStudentToCourse(courses,studentDeptCS,70,"C26","U26",new ArrayList<Professor>(Arrays.asList(professors.get(1), professors.get(2))), false);
        addStudentToCourse(courses,studentDeptCS,40,"C27","U27",new ArrayList<Professor>(Arrays.asList(professors.get(2))), true);
        addStudentToCourse(courses,studentDeptCS,35,"C28","U28",new ArrayList<Professor>(Arrays.asList(professors.get(2))), true);
        addStudentToCourse(courses,studentDeptCS,35,"C29","U29",new ArrayList<Professor>(Arrays.asList(professors.get(1), professors.get(0))), true);
        */
        //Mathematics
        addStudentToCourse(courses, studentDeptM, 25, "C8", "U8", new ArrayList<Professor>(Arrays.asList(professors.get(5), professors.get(6))), false);
        addStudentToCourse(courses, studentDeptM, 35, "C9", "U9", new ArrayList<Professor>(Arrays.asList(professors.get(6))), false);
        addStudentToCourse(courses, studentDeptM, 55, "C10", "U10", new ArrayList<Professor>(Arrays.asList(professors.get(5))), false);
        addStudentToCourse(courses, studentDeptM, 50, "C11", "U11", new ArrayList<Professor>(Arrays.asList(professors.get(4), professors.get(5))), false);
        addStudentToCourse(courses, studentDeptM, 45, "C12", "U12", new ArrayList<Professor>(Arrays.asList(professors.get(4), professors.get(6))), false);
        addStudentToCourse(courses, studentDeptM, 45, "C13", "U13", new ArrayList<Professor>(Arrays.asList(professors.get(4), professors.get(5), professors.get(6))), false);
        addStudentToCourse(courses, studentDeptM, 25, "C14", "U14", new ArrayList<Professor>(Arrays.asList(professors.get(4))), true);

        /*
        addStudentToCourse(courses,studentDeptM,50,"C30","U30",new ArrayList<Professor>(Arrays.asList(professors.get(5), professors.get(6))), true);
        addStudentToCourse(courses,studentDeptM,45,"C31","U31",new ArrayList<Professor>(Arrays.asList(professors.get(6))), false);
        addStudentToCourse(courses,studentDeptM,75,"C32","U32",new ArrayList<Professor>(Arrays.asList(professors.get(5))), false);
        addStudentToCourse(courses,studentDeptM,25,"C33","U33", new ArrayList<Professor>(Arrays.asList(professors.get(4), professors.get(5))), true);
        addStudentToCourse(courses,studentDeptM,35,"C34","U34", new ArrayList<Professor>(Arrays.asList(professors.get(4), professors.get(6))), true);
        addStudentToCourse(courses,studentDeptM,35,"C35","U35", new ArrayList<Professor>(Arrays.asList(professors.get(4), professors.get(5), professors.get(6))), false);
        addStudentToCourse(courses,studentDeptM,45,"C36","U36", new ArrayList<Professor>(Arrays.asList(professors.get(4))), true);
        */
        //Engineering
        addStudentToCourse(courses, studentDeptEng, 50, "C15", "U15", new ArrayList<Professor>(Arrays.asList(professors.get(7))), false);
        addStudentToCourse(courses, studentDeptEng, 25, "C16", "U16", new ArrayList<Professor>(Arrays.asList(professors.get(7), professors.get(8), professors.get(9))), true);
        addStudentToCourse(courses, studentDeptEng, 35, "C17", "U17", new ArrayList<Professor>(Arrays.asList(professors.get(8))), false);
        addStudentToCourse(courses, studentDeptEng, 30, "C18", "U18", new ArrayList<Professor>(Arrays.asList(professors.get(8), professors.get(9))), true);
        addStudentToCourse(courses, studentDeptEng, 50, "C19", "U19", new ArrayList<Professor>(Arrays.asList(professors.get(9))), false);
        addStudentToCourse(courses, studentDeptEng, 25, "C20", "U20", new ArrayList<Professor>(Arrays.asList(professors.get(7), professors.get(9))), true);
        addStudentToCourse(courses, studentDeptEng, 45, "C21", "U21", new ArrayList<Professor>(Arrays.asList(professors.get(8))), false);
        addStudentToCourse(courses, studentDeptEng, 40, "C22", "U22", new ArrayList<Professor>(Arrays.asList(professors.get(7), professors.get(9))), false);
        /*
        addStudentToCourse(courses,studentDeptEng,55,"C37","U37", new ArrayList<Professor>(Arrays.asList(professors.get(7))), true);
        addStudentToCourse(courses,studentDeptEng,65,"C38","U38", new ArrayList<Professor>(Arrays.asList(professors.get(7), professors.get(8), professors.get(9))), true);
        addStudentToCourse(courses,studentDeptEng,75,"C39","U39", new ArrayList<Professor>(Arrays.asList(professors.get(8))), false);
        addStudentToCourse(courses,studentDeptEng,35,"C40","U40", new ArrayList<Professor>(Arrays.asList(professors.get(8), professors.get(9))), true);        
        addStudentToCourse(courses,studentDeptEng,50,"C41","U41", new ArrayList<Professor>(Arrays.asList(professors.get(9))), false);
        addStudentToCourse(courses,studentDeptEng,25,"C42","U42", new ArrayList<Professor>(Arrays.asList(professors.get(7))), false);
        addStudentToCourse(courses,studentDeptEng,45,"C43","U43", new ArrayList<Professor>(Arrays.asList(professors.get(8))), false);
        addStudentToCourse(courses,studentDeptEng,50,"C44","U44", new ArrayList<Professor>(Arrays.asList(professors.get(7), professors.get(9))), false);
        */
}

    private void addStudentToCourse(ArrayList<Course> courses, ArrayList<Student> students, int courseSize, String courseID,
        String courseName, ArrayList<Professor> professors, boolean needComputers) {
        Course course;
        int studentSize = students.size();
        int studentLeft = studentSize;
        int numberOfCourse = (int) Math.ceil(studentSize / (double) courseSize);
        int position = 0;
        for (int i = 0; i < numberOfCourse; i++) {
            ArrayList<Student> newStudentSet = new ArrayList<>();
            int thisCourseSize;
            if (studentLeft > courseSize) {
                thisCourseSize = courseSize;
            } else {
                thisCourseSize = studentLeft;
            }
            int studentNum = 0;
            while (studentNum < thisCourseSize) {
                newStudentSet.add(students.get(position));
                position++;
                studentNum++;
                studentLeft--;
            }
            course = new Course(courseID, courseName, professors, thisCourseSize, newStudentSet, needComputers);
            courses.add(course);
        }
    }

    private void setUpStudents() {
        students = new ArrayList<>();
        int[] classes = {0, 1};
        for (int i = 0; i < 50; i++) {
            String number = String.valueOf(i);
            System.out.println(number);
            students.add(new Student(number, number, "Computer Science"));
        }
        for (int i = 50; i < 100; i++) {
            String number = String.valueOf(i);
            students.add(new Student(number, number, "Engineering"));
        }
        for (int i = 100; i <150 ; i++) {
            String number = String.valueOf(i);
            students.add(new Student(number, number, "Mathematics"));
        }
    }

    private void setUpDepartment() {
        Department dept1 = new Department("Computer Science");
        Department dept2 = new Department("Engineering");
        Department dept3 = new Department("Mathematics");

        for (Course c : courses) {
            if (c.getName().equals("U1") || c.getName().equals("U2") || c.getName().equals("U3") || c.getName().equals("U4") || c.getName().equals("U5") || c.getName().equals("U6") || c.getName().equals("U7") /*|| c.getName().equals("U23") || c.getName().equals("U24") || c.getName().equals("U25") || c.getName().equals("U26") || c.getName().equals("U27")|| c.getName().equals("U28") || c.getName().equals("U29")*/){
                dept1.addCourse(c);
            } else if (c.getName().equals("U8") || c.getName().equals("U9") || c.getName().equals("U10") || c.getName().equals("U11") || c.getName().equals("U12") || c.getName().equals("U13") || c.getName().equals("U14") /* || c.getName().equals("U30") || c.getName().equals("U31") || c.getName().equals("U32") || c.getName().equals("U33") || c.getName().equals("U34") || c.getName().equals("U35")|| c.getName().equals("U36")*/) {
                dept2.addCourse(c);
            } else if ((c.getName().equals("U15") || c.getName().equals("U16") || c.getName().equals("U17") || c.getName().equals("U18") || c.getName().equals("U19") || c.getName().equals("U20") || c.getName().equals("U21")) || c.getName().equals("U22") /*|| c.getName().equals("U37") || c.getName().equals("U38") || c.getName().equals("U39") || c.getName().equals("U40") || c.getName().equals("U41") || c.getName().equals("U42") || c.getName().equals("U43")|| c.getName().equals("U44")*/) {
                dept3.addCourse(c);
            }
        }
        for (Student s : students) {
            if (s.getDepartment().equals("Computer Science")) {
                dept1.addStudent(s);
            } else if (s.getDepartment().equals("Engineering")) {
                dept2.addStudent(s);
            } else if (s.getDepartment().equals("Mathematics")) {
                dept3.addStudent(s);
            }
        }
        depts = new ArrayList<Department>(Arrays.asList(dept1, dept2, dept3));
    }

    private Data initialize() {//returns this data instance
        setUpRooms();
        setUpMeetingTimes();
        setUpProfessors();
        setUpStudents();
        setUpCourses();
        setUpDepartment();
        depts.forEach(x -> numberOfClasses += x.getCourses().size());
        return this;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Department> getDepts() {
        return depts;
    }

    public ArrayList<MeetingTime> getMeetingTimes() {
        return meetingTimes;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
