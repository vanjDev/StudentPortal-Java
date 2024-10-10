import java.util.Random;
import java.util.Scanner;

public class Main {
    static boolean BlockSection(int yearLvl) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int[] availran = new int[9];
        for (int i = 0; i < 9; i++) { // Changed into ( for Loop )
            availran[i] = rand.nextInt(40);
        }

        String section = switch (yearLvl) { // From (If-else) to (switch)
            case 1 -> "TN0";
            case 2 -> "TN2";
            case 3 -> "TN3";
            case 4 -> "TN4";
            default -> "TN1";
        };


        System.out.println("=====================\n Enrollment System \n=====================");
        System.out.println("<< Block Sections >>");

        for (int i = 1; i <= 9; i++) { // Changed into a (for loop)
            System.out.println(i + ": " + section + i + " (Available: " + availran[i-1] + ")");
        }

        System.out.println("Choose a block section: ");
        int blocknum = sc.nextInt();

        boolean result = blocknum >= 1 && blocknum <= 9 && availran[blocknum - 1] > 0;
        String blocksection = section + blocknum;

        if (result) {
            System.out.println("[[ Block " + blocksection + " is enrolled ]]");
        } else {
            System.out.println("[[ Block " + blocksection + " is not enrolled (because it was full) ]]");
        }

        return result;
    }

    static void Registration(){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("=====================\n Registration System \n=====================");

        System.out.println("Enter First Name: ");
        String fname = sc.nextLine();  // Read user input
        System.out.println("Enter Last Name: ");
        String lname = sc.nextLine();
        System.out.println("Enter Age: ");
        String age = sc.nextLine();
        System.out.println("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.println("Enter Degree Program: ");
        String dprog = sc.nextLine();
        System.out.println("(Input Number) Enter Year Level: ");
        int yearLevel = sc.nextInt();

        int studentNum = rand.nextInt(10000) + 202500000 - (yearLevel* 100000);

        boolean donewithoses;
        do { // changed from (while) to (do-while)
            donewithoses = BlockSection(yearLevel);
            if (!donewithoses) {
                System.out.println("Try Again, since this block section is already full");
            }
        } while (!donewithoses);

        System.out.println("===== Student Information =====");
        System.out.println("First Name: " + fname);
        System.out.println("Last Name: " + lname);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Degree Program: " + dprog);
        System.out.println("Year Level: " + yearLevel);
        System.out.println("Student Number: " + studentNum);
    }
    static void Grading(){
        Scanner sc = new Scanner(System.in);
        int lq1, lq2, sw1, sw2, me, fe;

        System.out.println("Grading System");
        System.out.println("60% Class Standing\n15% Midterm Exam\n25% Final Exam");

        System.out.println("===== Input Grades =====");
        System.out.println("[Class Standing] Input Scores");
        System.out.println("(/40) Long Quiz 1: ");
        lq1 = sc.nextInt();
        System.out.println("(/50) Long Quiz 2: ");
        lq2 = sc.nextInt();
        System.out.println("(/100) Seat Work 1: ");
        sw1 = sc.nextInt();
        System.out.println("(/100) Seat Work 2: ");
        sw2 = sc.nextInt();
        System.out.println("[Examinations]");
        System.out.println("(/100) Midterm Exam: ");
        me = sc.nextInt();
        System.out.println("(/100) Final Exam: ");
        fe = sc.nextInt();

        // Class Standing Calculations
        double total_lq = lq1 + lq2;
        double total_sw = sw1 + sw2;

        total_lq /= 90;
        total_sw /= 200;

        double cs = (((total_lq * 0.60) + (total_sw * 0.40)) * 100) * 0.60;
        System.out.println("Total CS: " + cs);

        // Examination Calculations
        double calculated_me = ((double) me /100) * 0.15;
        double calculated_fe = ((double) fe /100) * 0.25;
        double total_exam = (calculated_me + calculated_fe) * 100;
        System.out.println("Total Exam: " + total_exam);

        double rawscore = cs + total_exam;
        System.out.println("Total Raw Score: " + rawscore);

        System.out.println("===== Course Card =====\nTerm: 1, School Year: 2024-2025");

        int grade = (int) rawscore;
        double gpa;

        // (if-else) to (switch) statements.
        switch (grade / 4) {
            case 25, 24 -> gpa = 4.0;
            case 23 -> gpa = 3.5;
            case 22 -> gpa = 3.0;
            case 21 -> gpa = 2.5;
            case 20 -> gpa = 2.0;
            case 19 -> gpa = 1.5;
            case 18 -> gpa = 1.0;
            default -> gpa = 0.5;
        }

        System.out.println("Your Grade: " + gpa);
        String result = (gpa >= 1.0) ? "Passed" : "Failed";
        System.out.println("You " + result + " This course!");
    }

    static void GPA_Calculator() {
        Scanner sc = new Scanner(System.in);
        double totalGradePoints = 0;
        int totalUnits = 0;

        while (true) {
            System.out.println("Enter course name (or type 'done' to finish): ");
            String courseName = sc.nextLine();
            if (courseName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter number of units for " + courseName + ": ");
            int units = sc.nextInt();

            double gpa = 0;
            boolean validGPA = false;
            while (!validGPA) {
                System.out.println("Enter GPA (valid values: 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0): ");
                gpa = sc.nextDouble();
                if (gpa == 0.5 || gpa == 1.0 || gpa == 1.5 || gpa == 2.0 || gpa == 2.5 || gpa == 3.0 || gpa == 3.5 || gpa == 4.0) {
                    validGPA = true;
                } else {
                    System.out.println("Invalid GPA entered. Please enter a valid GPA.");
                }
            }

            totalGradePoints += gpa * units;
            totalUnits += units;

            sc.nextLine();
        }

        if (totalUnits > 0) {
            double cgpa = totalGradePoints / totalUnits;
            System.out.println("Your cumulative GPA (CGPA) is: " + String.format("%.3f", cgpa));
        } else {
            System.out.println("No courses were entered.");
        }
    }

public static void CourseManagement() {

    System.out.println("=====================\n Course Selection \n=====================");
    System.out.println("Available Courses:");
    System.out.println("1: Computer Science");
    System.out.println("2: Information Technology");
    System.out.println("3: Business Analytics");
    System.out.println("4: Computer Engineering");
 
    System.out.print("Choose a course (1-4): ");
    Scanner choice = new Scanner(System.in);
    int Choice = choice.nextInt();
     
    String selectedCourse;

    switch (Choice) {
        case 1 -> selectedCourse = "Computer Science";
        case 2 -> selectedCourse = "Information Technology";
        case 3 -> selectedCourse = "Business Analytics";
        case 4 -> selectedCourse = "Computer Engineering";
        default -> {
            System.out.println("Invalid course selection.");
            return; 
        }
    }
    System.out.println("Your course is: " + selectedCourse);
}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = true;

        // changed from (while) to (do-while)
        do {
            System.out.println("=====================\n Student Portal \n=====================");
            System.out.println("Choose a system\n1: Registration System\n2: Grading System\n3: GPA Calculator\n:");

            int selected = sc.nextInt();

            switch (selected) {
                case 1 -> Registration();
                case 2 -> Grading();
                case 3 -> GPA_Calculator();
                case 4 -> CourseManagement();
                default -> {
                    System.out.println("Invalid Choice, please try again.");
                    done = false;  // Loop again if invalid choice
                }
            }
        } while (!done);
        sc.close();
    }
}
