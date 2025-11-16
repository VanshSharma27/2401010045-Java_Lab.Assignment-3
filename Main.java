import java.util.Scanner;

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String m) {
        super(m);
    }
}

interface RecordActions {
    void addStudent() throws StudentNotFoundException;
}

class Loader implements Runnable {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.print("Loading");
                for (int j = 0; j < 3; j++) {
                    System.out.print(".");
                    Thread.sleep(300);
                }
                System.out.println();
            }
        } catch (Exception e) {}
    }
}

class Student {
    Integer roll;
    String name;
    String email;
    String course;
    Double marks;

    public Student(Integer r, String n, String e, String c, Double m) {
        roll = r;
        name = n;
        email = e;
        course = c;
        marks = m;
    }

    public String grade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else return "D";
    }
}

class StudentManager implements RecordActions {
    Scanner sc = new Scanner(System.in);

    public void addStudent() throws StudentNotFoundException {
        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer roll = Integer.valueOf(sc.nextLine());
            
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            if (name.isEmpty()) throw new StudentNotFoundException("Name cannot be empty");

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            if (email.isEmpty()) throw new StudentNotFoundException("Email cannot be empty");

            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            if (course.isEmpty()) throw new StudentNotFoundException("Course cannot be empty");

            System.out.print("Enter Marks: ");
            Double marks = Double.valueOf(sc.nextLine());
            if (marks < 0 || marks > 100)
                throw new StudentNotFoundException("Marks must be between 0 and 100");

            Loader loader = new Loader();
            Thread t = new Thread(loader);
            t.start();
            t.join();

            Student s = new Student(roll, name, email, course, marks);

            System.out.println("Roll No: " + s.roll);
            System.out.println("Name: " + s.name);
            System.out.println("Email: " + s.email);
            System.out.println("Course: " + s.course);
            System.out.println("Marks: " + s.marks);
            System.out.println("Grade: " + s.grade());

        } catch (NumberFormatException n) {
            throw new StudentNotFoundException("Invalid numeric input");
        } catch (StudentNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new StudentNotFoundException("Unexpected error");
        } finally {
            System.out.println("Program execution completed");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        try {
            sm.addStudent();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}