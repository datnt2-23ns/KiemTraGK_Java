import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLThread implements Runnable {
    private static final List<Student> students = new ArrayList<>();

    public static List<Student> getStudents() {
        return students;
    }

    @Override
    public void run() {
        try {
            File file = new File("student.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Student");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element studentElement = (Element) nodeList.item(i);
                String id = studentElement.getElementsByTagName("id").item(0).getTextContent();
                String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                String address = studentElement.getElementsByTagName("address").item(0).getTextContent();
                String dateOfBirth = studentElement.getElementsByTagName("dateOfBirth").item(0).getTextContent();

                Student student = new Student(id, name, address, dateOfBirth);
                students.add(student);
            }

            System.out.println("Thread 1 đã đọc file student.xml.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}