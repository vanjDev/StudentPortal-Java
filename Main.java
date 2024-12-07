// Main File

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SubSystems system = new SubSystems();
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        do {
            System.out.println("\n=========================================");
            System.out.println("         🎓 STUDENT PORTAL MENU        ");
            System.out.println("=========================================");
            System.out.println("Choose a system:");
            System.out.println("1️⃣ : Registration System");
            System.out.println("2️⃣ : Grading System");
            System.out.println("3️⃣ : GPA Calculator");
            System.out.println("4️⃣ : Course Management");
            System.out.println("5️⃣ : Schedule Management");
            System.out.println("6️⃣ : Exit");
            System.out.print(">> Your Choice: ");

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
                        system.scheduleManagement();
                        break;
                    case 6:
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
