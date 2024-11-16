// All System's

import java.util.Random;
import java.util.Scanner;

public class SubSystems {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public Student registerStudent() {
        System.out.println("=====================\n Registration System \n=====================");
        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Degree Program: ");
        String degreeProgram = sc.nextLine();
        System.out.print("(Input Number) Enter Year Level: ");
        int yearLevel = sc.nextInt();

        return new Student(firstName, lastName, age, gender, degreeProgram, yearLevel);
    }

    public void enrollInBlock(Student student) {
        int yearLevel = student.getYearLevel();
        int[] availSlots = new int[9];

        // Random Slot
        for (int i = 0; i < 9; i++) {
            availSlots[i] = rand.nextInt(40);
        }

        String section = switch (yearLevel) {
            case 1 -> "TN0";
            case 2 -> "TN2";
            case 3 -> "TN3";
            case 4 -> "TN4";
            default -> "TN1";
        };

        System.out.println("<< Block Sections >>");
        for (int i = 1; i <= 9; i++) {
            System.out.println(i + ": " + section + i + " (Available: " + availSlots[i - 1] + ")");
        }

        boolean enrolled = false;
        while (!enrolled) {
            System.out.print("Choose a block section (1-9): ");
            int blocknum = sc.nextInt();

            if (blocknum >= 1 && blocknum <= 9 && availSlots[blocknum - 1] > 0) {
                System.out.println("Enrolled in Block: " + section + blocknum);
                enrolled = true;
            } else {
                System.out.println("Block " + section + blocknum + " is full or invalid. Try again.");
            }
        }
    }

    public void gradeSystem() {
        System.out.println("Grading System - Calculate Course Grade");
        System.out.println("60% Class Standing\n15% Midterm Exam\n25% Final Exam");

        // Input scores
        System.out.print("Enter Long Quiz 1 (out of 40): ");
        int lq1 = sc.nextInt();
        System.out.print("Enter Long Quiz 2 (out of 50): ");
        int lq2 = sc.nextInt();
        System.out.print("Enter Seat Work 1 (out of 100): ");
        int sw1 = sc.nextInt();
        System.out.print("Enter Seat Work 2 (out of 100): ");
        int sw2 = sc.nextInt();
        System.out.print("Enter Midterm Exam (out of 100): ");
        int me = sc.nextInt();
        System.out.print("Enter Final Exam (out of 100): ");
        int fe = sc.nextInt();

        // Calculations
        double cs = ((lq1 + lq2) / 90.0 * 0.6 + (sw1 + sw2) / 200.0 * 0.4) * 100 * 0.6;
        double totalExam = ((me / 100.0) * 0.15 + (fe / 100.0) * 0.25) * 100;

        double rawScore = cs + totalExam;
        int grade = (int) rawScore / 4;
        double gpa = switch (grade) {
            case 25, 24 -> 4.0;
            case 23 -> 3.5;
            case 22 -> 3.0;
            case 21 -> 2.5;
            case 20 -> 2.0;
            case 19 -> 1.5;
            case 18 -> 1.0;
            default -> 0.5;
        };

        System.out.println("Total Raw Score: " + rawScore);
        System.out.println("Final Grade (GPA): " + gpa);
        System.out.println("You " + (gpa >= 1.0 ? "Passed" : "Failed") + " the course.");
    }

    public void gpaCalculator() {
        double totalGradePoints = 0;
        int totalUnits = 0;

        while (true) {
            System.out.print("Enter course name (or type 'done' to finish): ");
            String courseName = sc.nextLine();
            if (courseName.equalsIgnoreCase("done")) break;

            System.out.print("Enter number of units for " + courseName + ": ");
            int units = sc.nextInt();

            double gpa;
            boolean validGPA = false;
            do {
                System.out.print("Enter GPA (valid values: 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0): ");
                gpa = sc.nextDouble();
                if (gpa == 0.5 || gpa == 1.0 || gpa == 1.5 || gpa == 2.0 || gpa == 2.5 || gpa == 3.0 || gpa == 3.5 || gpa == 4.0) {
                    validGPA = true;
                } else {
                    System.out.println("Invalid GPA entered. Please try again.");
                }
            } while (!validGPA);

            totalGradePoints += gpa * units;
            totalUnits += units;
            sc.nextLine();
        }

        if (totalUnits > 0) {
            double cgpa = totalGradePoints / totalUnits;
            System.out.println("Your cumulative GPA (CGPA) is: " + String.format("%.2f", cgpa));
        } else {
            System.out.println("No courses were entered.");
        }
    }

    public void courseManagement() {
        System.out.println("=====================\n Course Selection \n=====================");
        System.out.println("Computer Science: ");
        System.out.println("Available Specialization:");
        System.out.println("1: Software Engineering");
        System.out.println("2: Artificial Intelligence");
        System.out.println("3: Data Science");

        System.out.print("Choose a course (1-3): ");
        int choice = sc.nextInt();

        String selectedCourse = switch (choice) {
            case 1 -> "Software Engineering";
            case 2 -> "Artificial Intelligence";
            case 3 -> "Data Science";
            default -> {
                System.out.println("Invalid course selection.");
                yield null;
            }
        };

        System.out.println("1: GED - Subjects");
        System.out.println("2: CS - Subjects");
        System.out.println("3: CCS - Subjects");

        System.out.print("Choose a course (1-3): ");
        int choice2 = sc.nextInt();

        String selectedCategory = switch (choice2) {
            case 1 -> "GED - Subjects";
            case 2 -> "CS - Subjects";
            case 3 -> "CCS - Subjects";
            default -> {
                System.out.println("Invalid Course Category selection.");
                yield null;
            }
        };
        if (selectedCategory == "GED - Subjects"){
            System.out.println("Available Subjects:");
            System.out.println("1: Specialized English 1");
            System.out.println("2: Physical Education 1");
            System.out.println("3: Personal and Professional Effectiveness");
            System.out.println("4: Readings in Philippines History");
            System.out.println("5: Science, Technology and Society");
            System.out.println("6: Physical Education 2");
            System.out.println("7: Mathematics in the Modern World");
            System.out.println("8: Analytical Geometry with Calculus");
            System.out.println("9: Art Appreciation");
            System.out.println("10: Physical Education 3");
            System.out.println("11: The Contemporary World");
            System.out.println("12: Applied Statistics for CS");
            System.out.println("13: Mathematical Analysis");

            System.out.print("Choose a subject (1-13): ");
            int choice3 = sc.nextInt();

            String selectedSubjects = switch (choice3) {
                case 1 -> "Specialized English";
                case 2 -> "Physical Education 1";
                case 3 -> "Personal and Professional Effectiveness";
                case 4 -> "Readings in Philippines History";
                case 5 -> "Science, Technology and Society";
                case 6 -> "Physical Education 2";
                case 7 -> "Mathematics in the Modern World";
                case 8 -> "Analytical Geometry with Calculus";
                case 9 -> "Art Appreciation";
                case 10 -> "Physical Education 3";
                case 11 -> "The Contemporary World";
                case 12 -> "Applied Statistics for CS";
                case 13 -> "Mathematical Analysis";
                default -> {
                    System.out.println("Invalid subject selection.");
                    yield null;
                }
            };

            GED mySubject = new GED(selectedSubjects, 3);
            mySubject.department_program = selectedCourse;
            mySubject.show();
        } else if (selectedCategory == "CS - Subjects") {
            System.out.println("Available Subjects:");
            System.out.println("1: ---");
            System.out.println("2: ---");
            System.out.println("3: ---");

            System.out.print("Choose a subject (1-3): ");
            int choice3 = sc.nextInt();

            String selectedSubjects = switch (choice3) {
                case 1 -> "";
                case 2 -> "";
                case 3 -> "";
                default -> {
                    System.out.println("Invalid subject selection.");
                    yield null;
                }
            };

            CS mySubject = new CS(selectedSubjects, 3);
            mySubject.specialization = choice;
            mySubject.show();
        } else if (selectedCategory == "CCS - Subjects") {
            System.out.println("Available Subjects:");
            System.out.println("1: Introduction Computing");
            System.out.println("2: Computer Programming 1");
            System.out.println("3: Introduction to Human Computer Interaction");
            System.out.println("4: Computer Programming 2");
            System.out.println("5: Data Structures and Algorithms");
            System.out.println("6: Professional Development (Computing Profession)");

            System.out.print("Choose a subject (1-6): ");
            int choice3 = sc.nextInt();

            String selectedSubjects = switch (choice3) {
                case 1 -> "Introduction Computing";
                case 2 -> "Computer Programming 1";
                case 3 -> "Introduction to Human Computer Interaction";
                case 4 -> "Computer Programming 2";
                case 5 -> "Data Structures and Algorithms";
                case 6 -> "Professional Development (Computing Profession)";
                default -> {
                    System.out.println("Invalid subject selection.");
                    yield null;
                }
            };
            CCS mySubject = new CCS(selectedSubjects, 3);
            mySubject.isCS = true;
            mySubject.show();
        }else{
            System.out.println("Invalid course selection.");
        }
        if (selectedCourse != null) {
            System.out.println("You have selected the course: " + selectedCourse);
        }
    }
}
