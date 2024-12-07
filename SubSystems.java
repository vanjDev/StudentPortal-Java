// All System's

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class SubSystems {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    class Schedule {
        String courseName;
        String timeSlot;
        String day;

        public Schedule(String courseName, String timeSlot, String day) {
            this.courseName = courseName;
            this.timeSlot = timeSlot;
            this.day = day;
        }

        public void display() {
            System.out.println("Course: " + courseName + ", Time: " + timeSlot + ", Day: " + day);
        }
    }

    public void scheduleManagement() {
        ArrayList<Schedule> schedules = new ArrayList<>();

        while (true) {
            System.out.print("Enter course name (or type 'done' to finish): ");
            String courseName = sc.nextLine();
            if (courseName.equalsIgnoreCase("done")) break;

            System.out.print("Enter preferred day (e.g., Monday): ");
            String day = sc.nextLine();

            System.out.print("Enter preferred time slot (e.g., 10:00 AM - 12:00 PM): ");
            String timeSlot = sc.nextLine();

            // Check for conflicts
            boolean conflict = false;
            for (Schedule s : schedules) {
                if (s.day.equalsIgnoreCase(day) && s.timeSlot.equalsIgnoreCase(timeSlot)) {
                    System.out.println("Conflict detected with course: " + s.courseName);
                    conflict = true;
                    break;
                }
            }

            if (!conflict) {
                schedules.add(new Schedule(courseName, timeSlot, day));
                System.out.println("Course successfully added to your schedule.");
            } else {
                System.out.println("Please choose a different time slot.");
            }
        }

        System.out.println("\nYour Final Schedule:");
        for (Schedule s : schedules) {
            s.display();
        }
    }


    public Student registerStudent() {
        System.out.println("=======================================");
        System.out.println("        🚀 REGISTRATION SYSTEM        ");
        System.out.println("=======================================");
        System.out.println("Please fill in the following details:");
        System.out.print(">> Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.print(">> Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.print(">> Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print(">> Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print(">> Enter Degree Program: ");
        String degreeProgram = sc.nextLine();
        System.out.print(">> (Input Number) Enter Year Level: ");
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
        Scanner sc = new Scanner(System.in);
        System.out.println("\n****************************************");
        System.out.println("          📚 GRADING SYSTEM             ");
        System.out.println("****************************************");
        System.out.println("Grade Calculation Breakdown:");
        System.out.println("🔸 Class Standing: 60%");
        System.out.println("🔸 Midterm Exam: 15%");
        System.out.println("🔸 Final Exam: 25%");
        System.out.println("****************************************");

        // LongQuiz
        ArrayList<Integer> longQuizScores = new ArrayList<>();
        ArrayList<Integer> longQuizTotals = new ArrayList<>();
        System.out.println("\nEnter Long Quiz Scores:");
        while (true) {
            System.out.print(">> Enter [Total Score] for Long Quiz: ");
            longQuizTotals.add(sc.nextInt());
            System.out.print(">> Enter Score for Long Quiz: ");
            longQuizScores.add(sc.nextInt());

            System.out.print("Do you want to add another Long Quiz? (yes/no): ");
            sc.nextLine();
            if (!sc.nextLine().equalsIgnoreCase("yes")) break;
        }

        // Seatworks
        ArrayList<Integer> seatWorkScores = new ArrayList<>();
        ArrayList<Integer> seatWorkTotals = new ArrayList<>();
        System.out.println("\nEnter Seat Work Scores:");
        while (true) {
            System.out.print(">> Enter [Total Score] for Seat Work: ");
            seatWorkTotals.add(sc.nextInt());
            System.out.print(">> Enter Score for Seat Work: ");
            seatWorkScores.add(sc.nextInt());

            System.out.print("Do you want to add another Seat Work? (yes/no): ");
            sc.nextLine();
            if (!sc.nextLine().equalsIgnoreCase("yes")) break;
        }

        System.out.print(">> Enter [Total Score] for Midterm Exam: ");
        int midtermTotal = sc.nextInt();
        System.out.print("\n>> Enter Score for Midterm Exam: ");
        int midtermScore = sc.nextInt();

        System.out.print(">> Enter [Total Score] for Final Exam: ");
        int finalTotal = sc.nextInt();
        System.out.print(">> Enter Score for Final Exam: ");
        int finalScore = sc.nextInt();

        // Calculations
        double longQuizPercentage = calculatePercentage(longQuizScores, longQuizTotals);
        double seatWorkPercentage = calculatePercentage(seatWorkScores, seatWorkTotals);
        double classStanding = (longQuizPercentage * 0.6 + seatWorkPercentage * 0.4) * 0.6;

        double midtermPercentage = (midtermScore / (double) midtermTotal) * 100;
        double finalPercentage = (finalScore / (double) finalTotal) * 100;
        double totalExam = (midtermPercentage * 0.15 + finalPercentage * 0.25);

        double rawScore = classStanding + totalExam;

        int grade = (int) rawScore / 4;
        double gpa;
        if (rawScore >= 97) {
            gpa = 4.0;
        } else if (rawScore >= 93) {
            gpa = 3.5;
        } else if (rawScore >= 89) {
            gpa = 3.0;
        } else if (rawScore >= 85) {
            gpa = 2.5;
        } else if (rawScore >= 80) {
            gpa = 2.0;
        } else if (rawScore >= 75) {
            gpa = 1.5;
        } else if (rawScore >= 70) {
            gpa = 1.0;
        } else {
            gpa = 0.5;
        }


        Random random = new Random();

        List<String> motivationalMessages = List.of(
                "Don't give up! There’s always a chance to improve!",
                "Keep pushing forward. Great things take time!",
                "Every failure is a step closer to success.",
                "Your journey is just beginning. Never stop trying!",
                "Remember, success is built on perseverance."
        );

        List<String> congratulatoryMessages = List.of(
                "🎉 Congratulations! You did an amazing job!",
                "Great work! Your efforts have paid off! 🎓",
                "You’ve earned it! Keep reaching for the stars! 🌟",
                "Well done! Success looks great on you!",
                "Fantastic performance! Celebrate your achievement! 🎉"
        );

        String message = (gpa >= 1.0)
                ? congratulatoryMessages.get(random.nextInt(congratulatoryMessages.size()))
                : motivationalMessages.get(random.nextInt(motivationalMessages.size()));

        // Enhanced Output
        System.out.println("\n****************************************");
        System.out.println("              📊 FINAL RESULTS           ");
        System.out.println("****************************************");
        System.out.printf("📘 Class Standing Score: %.2f%%\n", classStanding);
        System.out.printf("📝 Midterm Exam Score: %.2f%%\n", midtermPercentage);
        System.out.printf("📕 Final Exam Score: %.2f%%\n", finalPercentage);
        System.out.println("----------------------------------------");
        System.out.printf("🏆 Total Exam Score: %.2f%%\n", totalExam);
        System.out.printf("🎯 Total Raw Score: %.2f%%\n", rawScore);
        System.out.println("----------------------------------------");
        System.out.printf("🎓 Final Grade (GPA): %.2f\n", gpa);
        System.out.println("📢 Status: " + (gpa >= 1.0 ? "✅ Passed" : "❌ Failed"));
        System.out.println("----------------------------------------");
        System.out.println(message);
        System.out.println("****************************************");
    }

    // Calculate Percentage
    private double calculatePercentage(ArrayList<Integer> scores, ArrayList<Integer> totals) {
        double totalScore = 0;
        double totalMaxScore = 0;

        for (int i = 0; i < scores.size(); i++) {
            totalScore += scores.get(i);
            totalMaxScore += totals.get(i);
        }
        return totalMaxScore > 0 ? (totalScore / totalMaxScore) * 100 : 0;
    }


    public void gpaCalculator() {
        double totalGradePoints = 0;
        int totalUnits = 0;

        System.out.println("\n===============================");
        System.out.println("📊 GPA Calculator");
        System.out.println("===============================\n");

        while (true) {
            System.out.print("📘 Enter course name (or type 'done' to finish): ");
            String courseName = sc.nextLine();
            if (courseName.equalsIgnoreCase("done")) {
                System.out.println("\n✅ Finished entering courses.");
                break;
            }

            System.out.print(">> Enter number of units for " + courseName + ": ");
            int units;
            while (true) {
                if (sc.hasNextInt()) {
                    units = sc.nextInt();
                    if (units > 0) break;
                    System.out.print("❌ Units must be a positive integer. Please re-enter: ");
                } else {
                    System.out.print("❌ Invalid input. Please enter a number for units: ");
                    sc.next();
                }
            }

            double gpa;
            while (true) {
                System.out.print("🎓 Enter GPA (valid values: 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0): ");
                if (sc.hasNextDouble()) {
                    gpa = sc.nextDouble();
                    if (gpa == 0.5 || gpa == 1.0 || gpa == 1.5 || gpa == 2.0 || gpa == 2.5 || gpa == 3.0 || gpa == 3.5 || gpa == 4.0) {
                        break;
                    } else {
                        System.out.println("❌ Invalid GPA value. Please enter a valid GPA.");
                    }
                } else {
                    System.out.println("❌ Invalid input. Please enter a numeric GPA value.");
                    sc.next();
                }
            }

            totalGradePoints += gpa * units;
            totalUnits += units;
            sc.nextLine();

            System.out.println("📌 Successfully added course: " + courseName + " | Units: " + units + " | GPA: " + gpa + "\n");
        }

        System.out.println("\n===============================");
        if (totalUnits > 0) {
            double cgpa = totalGradePoints / totalUnits;
            System.out.println("🎉 Your cumulative GPA (CGPA) is: " + String.format("%.2f", cgpa));
            System.out.println("===============================");
            System.out.println(cgpa >= 2.0 ? "👏 Great job! Keep up the good work!" : "💡 Keep striving for improvement. You got this!");
        } else {
            System.out.println("❌ No courses were entered. GPA calculation aborted.");
        }
        System.out.println("===============================\n");
    }

    public void courseManagement() {
        System.out.println("\n===============================");
        System.out.println("       🎓 COURSE SELECTION       ");
        System.out.println("===============================");
        System.out.println("Available Specializations in Computer Science:");
        System.out.println("1️⃣: Software Engineering");
        System.out.println("2️⃣: Artificial Intelligence");
        System.out.println("3️⃣: Data Science");

        System.out.print("\n>> Choose a specialization (1-3): ");
        int choice = sc.nextInt();

        String selectedCourse = switch (choice) {
            case 1 -> "Software Engineering";
            case 2 -> "Artificial Intelligence";
            case 3 -> "Data Science";
            default -> {
                System.out.println("❌ Invalid specialization selection. Please restart.");
                yield null;
            }
        };

        System.out.println("\n===============================");
        System.out.println("      📚 COURSE CATEGORIES      ");
        System.out.println("===============================");
        System.out.println("1️⃣: GED - General Education Subjects");
        System.out.println("2️⃣: CS - Computer Science Subjects");
        System.out.println("3️⃣: CCS - College of Computer Studies Subjects");
        System.out.print(">> Choose a course (1-3): ");
        int choice2 = sc.nextInt();

        String selectedCategory = switch (choice2) {
            case 1 -> "GED - Subjects";
            case 2 -> "CS - Subjects";
            case 3 -> "CCS - Subjects";
            default -> {
                System.out.println("❌ Invalid category selection. Please restart.");
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
            System.out.println("14: SPECIALIZED ENGLISH PROGRAM 2");
            System.out.println("15: LINEAR ALGEBRA");
            System.out.println("16: COLLEGE PHYSICS 1 LECTURE");
            System.out.println("17: COLLEGE PHYSICS 2 LECTURE");
            System.out.println("18: PURPOSIVE COMMUNICATION");

            System.out.print(">> Choose a subject (1-13): ");
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
                case 14 -> "SPECIALIZED ENGLISH PROGRAM 2";
                case 15 -> "LINEAR ALGEBRA";
                case 16 -> "COLLEGE PHYSICS 1 LECTURE";
                case 17 -> "COLLEGE PHYSICS 2 LECTURE";
                case 18 -> "PURPOSIVE COMMUNICATION";
                default -> {
                    System.out.println("❌ Invalid subject selection. Please restart.");
                    yield null;
                }
            };

            System.out.println("Choosen Subject: "+ selectedSubjects);
            GED mySubject = new GED(selectedSubjects, 3);
            mySubject.department_program = selectedCourse;
            mySubject.show();
        } else if (selectedCategory == "CS - Subjects") {
            System.out.println("Available Subjects:");
            System.out.println("1: DISCRETE STRUCTURES 1");
            System.out.println("2: COMPUTER SYSTEMS & ARCHITECTURE");
            System.out.println("3: OBJECT ORIENTED PROGRAMMING");
            System.out.println("4: ALGORITHM");
            System.out.println("5: FUNDAMENTALS OF ANALYTICS");
            System.out.println("6: OPERATING SYSTEM");
            System.out.println("7: DISCRETE STRUCTURES 2");
            System.out.println("8: DATABASE SYSTEMS");
            System.out.println("9: NETWORKS AND COMMUNICATIONS 1");
            System.out.println("10: AUTOMATA THEORY AND FORMAL LANGUAGES");
            System.out.println("11: CS SPECIALIZATION 1 (STRUCTURED PROGRAMMING LANGUAGE)");
            System.out.println("12: MOBILE PROGRAMMING");
            System.out.println("13: NETWORK AND COMMUNICATIONS 2A");
            System.out.println("14: MODELING AND SIMULATION");
            System.out.println("15: SOFTWARE ENGINEERING 1");
            System.out.println("16: CS ELECTIVE - COMPUTER GRAPHICS AND VISUAL COMPUTING");
            System.out.println("17: CS SPECIALIZATION 2 - PROGRAMMING TOOLS AND TECHNIQUES");
            System.out.println("18: CS PROJECT MANAGEMENT");
            System.out.println("19: SOFTWARE ENGINEERING 2");
            System.out.println("20: PROGRAMMING LANGUAGES");
            System.out.println("21: CS SPECIALIZATION 3 - IMAGE PROCESSING");
            System.out.println("22: INFORMATION ASSURANCE AND SECURITY");
            System.out.println("23: CS PROJECT 1");
            System.out.println("24: CS SPECIALIZATION 4 - BUSINESS PROCESS FOR COMPUTING");

            System.out.print(">> Choose a subject (1-24): ");
            int choice3 = sc.nextInt();

            String selectedSubjects = switch (choice3) {
                case 1 -> "DISCRETE STRUCTURES 1";
                case 2 -> "COMPUTER SYSTEMS & ARCHITECTURE";
                case 3 -> "OBJECT ORIENTED PROGRAMMING";
                case 4 -> "ALGORITHM";
                case 5 -> "FUNDAMENTALS OF ANALYTICS";
                case 6 -> "OPERATING SYSTEM";
                case 7 -> "DISCRETE STRUCTURES 2";
                case 8 -> "DATABASE SYSTEMS";
                case 9 -> "NETWORKS AND COMMUNICATIONS 1";
                case 10 -> "AUTOMATA THEORY AND FORMAL LANGUAGES";
                case 11 -> "CS SPECIALIZATION 1 (STRUCTURED PROGRAMMING LANGUAGE)";
                case 12 -> "MOBILE PROGRAMMING";
                case 13 -> "NETWORK AND COMMUNICATIONS 2A";
                case 14 -> "MODELING AND SIMULATION";
                case 15 -> "SOFTWARE ENGINEERING 1";
                case 16 -> "CS ELECTIVE - COMPUTER GRAPHICS AND VISUAL COMPUTING";
                case 17 -> "CS SPECIALIZATION 2 - PROGRAMMING TOOLS AND TECHNIQUES";
                case 18 -> "CS PROJECT MANAGEMENT";
                case 19 -> "SOFTWARE ENGINEERING 2";
                case 20 -> "PROGRAMMING LANGUAGES";
                case 21 -> "CS SPECIALIZATION 3 - IMAGE PROCESSING";
                case 22 -> "INFORMATION ASSURANCE AND SECURITY";
                case 23 -> "CS PROJECT 1";
                case 24 -> "CS SPECIALIZATION 4 - BUSINESS PROCESS FOR COMPUTING";
                default -> {
                    System.out.println("❌ Invalid subject selection. Please restart.");
                    yield null;
                }
            };

            System.out.println("Choosen Subject: "+ selectedSubjects);
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
            System.out.println("7: INFORMATION MANAGEMENT (LEC)");
            System.out.println("8: DESIGN THINKING (CCS)");
            System.out.println("9: APPLICATIONS DEVELOPMENT AND EMERGING TECHNOLOGIES (LEC)");
            System.out.println("10: TECHNOPRENEURSHIP (CCS)");

            System.out.print(">> Choose a subject (1-6): ");
            int choice3 = sc.nextInt();

            String selectedSubjects = switch (choice3) {
                case 1 -> "Introduction Computing";
                case 2 -> "Computer Programming 1";
                case 3 -> "Introduction to Human Computer Interaction";
                case 4 -> "Computer Programming 2";
                case 5 -> "Data Structures and Algorithms";
                case 6 -> "Professional Development (Computing Profession)";
                case 7 -> "INFORMATION MANAGEMENT (LEC)";
                case 8 -> "DESIGN THINKING (CCS)";
                case 9 -> "APPLICATIONS DEVELOPMENT AND EMERGING TECHNOLOGIES (LEC)";
                case 10 -> "TECHNOPRENEURSHIP (CCS)";
                default -> {
                    System.out.println("❌ Invalid subject selection. Please restart.");
                    yield null;
                }
            };

            System.out.println("\n===============================");
            System.out.println("        ✅ SELECTION SUMMARY        ");
            System.out.println("===============================");
            System.out.printf("🛠 Specialization: %s\n", selectedCourse);
            System.out.printf("📂 Category: %s\n", selectedCategory);
            System.out.printf("📘 Subject: %s\n", selectedSubjects);
            System.out.println("===============================");
            System.out.println("🚀 Ready to start your journey! Good luck!");
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
