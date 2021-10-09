package genetic.algorithm.scheduling;

import geneticClassSchedulingDomain.Course;
import geneticClassSchedulingDomain.Department;
import geneticClassSchedulingDomain.MeetingTime;
import geneticClassSchedulingDomain.Professor;
import geneticClassSchedulingDomain.Room;
import geneticClassSchedulingDomain.Student;
import geneticClassSchedulingDomain.Class;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WriteXMLFile {

   
    private static ArrayList<Professor>professors;
    private static ArrayList<MeetingTime>meetingTimes;
    private static ArrayList<ArrayList<Student>>students;
    private static ArrayList<Course>courses;
    private static ArrayList<Department>departments;

	public void xmlCreator(ArrayList<Class>classes){
	  try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("timetable");
		doc.appendChild(rootElement);

                String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday"};
                for(String s: days){
                    Element day = doc.createElement(s);
                    rootElement.appendChild(day);
                    for(Class c: classes)
                        if(c.getMeetingTime().getDay().equals(s)){
                            Element time = doc.createElement("time");
                            time.appendChild(doc.createTextNode(c.getMeetingTime().getTime()));
                            day.appendChild(time);
                            
                            Element prof = doc.createElement("professor");
                            prof.appendChild(doc.createTextNode(c.getProfessor().getName()));
                            day.appendChild(prof);
                            
                            Element course = doc.createElement("course");
                            course.appendChild(doc.createTextNode(c.getCourse().getName()));
                            day.appendChild(course);
                            
                            Element room = doc.createElement("room");
                            room.appendChild(doc.createTextNode(c.getRoom().getNumber()));
                            day.appendChild(room);
                            
                            for(Student stu : c.getStudents()){
                                Element student = doc.createElement("Student");
                                student.appendChild(doc.createTextNode(stu.getName()));
                                day.appendChild(student);
                            }
                        }
                            
                }

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("xmlTest"));

		transformer.transform(source, result);

		System.out.println("File saved!");

	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}
