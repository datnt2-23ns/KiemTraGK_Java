import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
    public static void main(String[] args) {
        // Tạo danh sách sinh viên để làm ví dụ
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập thông tin sinh viên 1:");
        System.out.print("ID: ");
        String id1 = scanner.nextLine();
        System.out.print("Name: ");
        String name1 = scanner.nextLine();
        System.out.print("Address: ");
        String address1 = scanner.nextLine();
        System.out.print("Date of Birth: ");
        String dob1 = scanner.nextLine();

        System.out.println("Nhập thông tin sinh viên 2:");
        System.out.print("ID: ");
        String id2 = scanner.nextLine();
        System.out.print("Name: ");
        String name2 = scanner.nextLine();
        System.out.print("Address: ");
        String address2 = scanner.nextLine();
        System.out.print("Date of Birth: ");
        String dob2 = scanner.nextLine();

        scanner.close();

        // Tạo một DocumentBuilderFactory
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

        try {
            // Tạo DocumentBuilder từ DocumentBuilderFactory
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Tạo một Document mới
            Document doc = docBuilder.newDocument();

            // Tạo một phần tử gốc (root element)
            Element rootElement = doc.createElement("students");
            doc.appendChild(rootElement);

            // Thêm sinh viên 1 vào root element
            Element studentElement1 = doc.createElement("student");
            rootElement.appendChild(studentElement1);

            Element idElement1 = doc.createElement("id");
            idElement1.appendChild(doc.createTextNode(id1));
            studentElement1.appendChild(idElement1);

            Element nameElement1 = doc.createElement("name");
            nameElement1.appendChild(doc.createTextNode(name1));
            studentElement1.appendChild(nameElement1);

            Element addressElement1 = doc.createElement("address");
            addressElement1.appendChild(doc.createTextNode(address1));
            studentElement1.appendChild(addressElement1);

            Element dobElement1 = doc.createElement("dateOfBirth");
            dobElement1.appendChild(doc.createTextNode(dob1));
            studentElement1.appendChild(dobElement1);

            // Thêm sinh viên 2 vào root element
            Element studentElement2 = doc.createElement("student");
            rootElement.appendChild(studentElement2);

            Element idElement2 = doc.createElement("id");
            idElement2.appendChild(doc.createTextNode(id2));
            studentElement2.appendChild(idElement2);

            Element nameElement2 = doc.createElement("name");
            nameElement2.appendChild(doc.createTextNode(name2));
            studentElement2.appendChild(nameElement2);

            Element addressElement2 = doc.createElement("address");
            addressElement2.appendChild(doc.createTextNode(address2));
            studentElement2.appendChild(addressElement2);

            Element dobElement2 = doc.createElement("dateOfBirth");
            dobElement2.appendChild(doc.createTextNode(dob2));
            studentElement2.appendChild(dobElement2);

            // Ghi dữ liệu vào file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("student.xml"));

            transformer.transform(source, result);

            System.out.println("File student.xml đã được tạo thành công!");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}