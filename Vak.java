package ects2monitor;
//fuck de system eigen class

import java.util.*;

public class Vak {

    Scanner stdin = new Scanner(System.in);

    String name;
    int ectsForThisCourse;
    int obtainedEcts;
    double grade;
    static int totalEcts;
    static int totalEctsAchieved;
    boolean notCorrectInput;

    //set the name of the course and the max ects for that course
    Vak(String name, int EctsPerCourse) {
        this.name = name;
        this.ectsForThisCourse = EctsPerCourse;
        totalEcts += EctsPerCourse;

    }

    //gives out the name
    public String getName() {
        return name;
    }

    //ask the user to input a grade and checks if grade is between the 1 and 10
    //you get a cookie if you understand this
    public void setGrade() {
        do {
            try {
                System.out.print("What is your grade for " + name + "?: ");
                grade = stdin.nextDouble();

                if (grade < 1 || grade > 10) {
                    System.out.println('\t' + "Number must be between 1 and 10!");
                } else {
                    grade = (double) ((int) (grade * 100)) / 100;
                    notCorrectInput = false;
                }

            } catch (Exception e) {
                System.out.println('\t' + "That's not even a number!");
                stdin.next();
            }
        } while (grade < 1 || grade > 10);
    }

    //checks weather you earned your ECTS or not
    public int getObtainedEcts() {
        if (grade >= 5.5) {
            totalEctsAchieved += ectsForThisCourse;
            return ectsForThisCourse;
        } else {
            return 0;
        }
    }

    //prints out coursename, your grade, and the obtained ECTS
    public void printResults() {
        System.out.println("Course/project:" + name + '\t'
                + "Grade: " + grade + '\t'
                + "ECTS obtained: " + getObtainedEcts());
    }

}
