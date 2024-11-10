// Student System

import java.util.Random;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String degreeProgram;
    private int yearLevel;
    private int studentNumber;

    public Student(String firstName, String lastName, int age, String gender, String degreeProgram, int yearLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.degreeProgram = degreeProgram;
        this.yearLevel = yearLevel;
        this.studentNumber = generateStudentNumber();
    }

    private int generateStudentNumber() {
        Random rand = new Random();
        return rand.nextInt(10000) + 202500000 - (yearLevel * 100000);
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getDegreeProgram() {
        return degreeProgram;
    }
    public int getYearLevel() {
        return yearLevel;
    }
    public int getStudentNumber() {
        return studentNumber;
    }

    public void displayStudentInfo() {
        System.out.println("===== Student Information =====");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Degree Program: " + degreeProgram);
        System.out.println("Year Level: " + yearLevel);
        System.out.println("Student Number: " + studentNumber);
    }
}
