import java.io.*;
import java.util.*;

class Address implements Serializable {
private
  static final long serialVersionUID = 1L;
private
  String city, state, country;
private
  int pinCode;

public
  Address(String city, String state, int pinCode, String country) {
    this.city = city;
    this.state = state;
    this.pinCode = pinCode;
    this.country = country;
  }

public
  String toString() {
    return city + ", " + state + " - " + pinCode + ", " + country;
  }

}

class Student implements Serializable {
private
  static final long serialVersionUID = 2L;
private
  String firstName;
private
  String dateOfBirth;
private
  Address address;

public
  Student(String firstName, String dateOfBirth, Address address) {
    this.firstName = firstName;
    this.dateOfBirth = dateOfBirth;
    this.address = address;
  }

public
  String toString() {
    return "Student{name='" + firstName + "', dateOfBirth='" + dateOfBirth +
           "', address=" + address + "}";
  }

}

public class assignment5 {
public
  static void assignment5(String[] args) throws IOException {
    List<Student> students = Arrays.asList(
        new Student("Aman", "2002-08-30",
                    new Address("New Delhi", "ND", 10001, "India")),
        new Student("Akash", "1999-05-15",
                    new Address("Mumbai", "MU", 90001, "India")));
    try(ObjectOutputStream oos =
            new ObjectOutputStream(new FileOutputStream("students.ser"))) {
      oos.writeObject(students);
    }
    System.out.println("Serialization complete.");
  }
}

class DeserializationTest {
public
  static void main(String[] args) {
    try(ObjectInputStream ois =
            new ObjectInputStream(new FileInputStream("students.ser"))) {
      List<Student> students = (List<Student>)ois.readObject();
      students.forEach(System.out::println);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}