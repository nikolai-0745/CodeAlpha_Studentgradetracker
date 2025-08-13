import java.util.*;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Report");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush newline

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    displayReport();
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
        sc.close();
    }

    static void addStudent(Scanner sc) {
        sc.nextLine(); // flush input
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter score: ");
        int score = sc.nextInt();
        students.add(new Student(name, score));
        System.out.println("Student added.");
    }

    static void displayReport() {
        if (students.isEmpty()) {
            System.out.println("No students yet.");
            return;
        }

        int total = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (Student s : students) {
            total += s.score;
            if (s.score > max) max = s.score;
            if (s.score < min) min = s.score;
        }

        double avg = total / (double) students.size();

        System.out.println("\n--- Student Report ---");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.score);
        }
        System.out.printf("Average Score: %.2f\n", avg);
        System.out.println("Highest Score: " + max);
        System.out.println("Lowest Score: " + min);
    }
}

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}