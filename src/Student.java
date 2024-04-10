import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private String address;
    private String dateOfBirth;
    private int age;
    private int sum;
    private boolean isPrime;

    public Student(String id, String name, String address, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public int getSum() {
        return sum;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setPrime(boolean isPrime) {
        this.isPrime = isPrime;
    }
}