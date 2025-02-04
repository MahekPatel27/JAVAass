import java.util.Scanner;

class Student {
    private int studentID;
    private String name;
    private int age;
    private String department;

    public Student(int studentID, String name, int age, String department) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return "Student{ " +
                "studentID = " + studentID +
                ", name= '" + name + '\'' +
                ", age= " + age +
                ", department=' " + department + '\'' +
                '}';
    }
}

class StudentRecordSystem {
    private Student[] students;
    private int count;

    public StudentRecordSystem(int size) {
        students = new Student[size];
        count = 0;
    }

    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Cannot add more students, array is full.");
        }
    }

    public Student getStudent(int studentID) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID() == studentID) {
                return students[i];
            }
        }
        return null; 
    }

    public void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
    }
}
public class StudentRecordMGMT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordSystem system = new StudentRecordSystem(10);

        System.out.println("Enter the number of students to add:");
        int numStudents = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");

            System.out.print("Student ID: ");
            int studentID = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.print("Department: ");
            String department = sc.nextLine();

            Student student = new Student(studentID, name, age, department);
            system.addStudent(student);
        }

        System.out.println("\nAll Students:");
        system.displayAllStudents();

        char ch = 'y'; 
        while(ch == 'y')
        {
            System.out.print("\nEnter student ID to search: ");
            int searchID = sc.nextInt();
            Student foundStudent = system.getStudent(searchID);

            if (foundStudent != null) {
                System.out.println(foundStudent);
            } else {
                System.out.println("Student not found.");
            }

            System.out.println("Enter y to continue : ");
            ch = sc.next().charAt(1);
        }

        sc.close();
    }
}
