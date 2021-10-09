package geneticClassSchedulingDomain;

import java.util.ArrayList;

public class Class {
    private int id;
    private Department dept;
    private Course course;
    private Professor professor;
    private MeetingTime meetingTime;
    private Room room;
    private ArrayList <Student> students;
    
    public Class(int id, Department dept, Course course) {
        this.id = id;
        this.dept = dept;
        this.course = course;
        this.students = course.getStudents();
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setMeetingTime(MeetingTime meetingTime) {
        this.meetingTime = meetingTime;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public Department getDept() {
        return dept;
    }

    public Course getCourse() {
        return course;
    }

    public Professor getProfessor() {
        return professor;
    }

    public MeetingTime getMeetingTime() {
        return meetingTime;
    }

    public Room getRoom() {
        return room;
    }
    
    public ArrayList<Student> getStudents(){
        return students;
    }
    
    public String toString(){
        return "["+dept.getName()+","+course.getNumber()+","+room.getNumber()+","+professor.getId()+","+meetingTime.getId()+"]";
    }
}
