// Main File

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SubSystems system = new SubSystems();
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        do {
            System.out.println("=====================\n Student Portal \n=====================");
            System.out.println("Choose a system\n1: Registration System\n2: Grading System\n3: GPA Calculator\n4: Course Management\n5: Exit");
            System.out.print(": ");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        Student student = system.registerStudent();
                        student.displayStudentInfo();
                        system.enrollInBlock(student);
                        break;
                    case 2:
                        system.gradeSystem();
                        break;
                    case 3:
                        system.gpaCalculator();
                        break;
                    case 4:
                        system.courseManagement();
                        break;
                    case 5:
                        done = true;
                        break;
                    default:
                        System.out.println("Invalid Choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
            }
        } while (!done);

        sc.close();
    }
}
