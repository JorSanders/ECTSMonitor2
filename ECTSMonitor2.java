package ects2monitor;

import java.util.*;

/**
 * improved version of ectsMonitor program to calculate how many ECTS you will
 * get
 *
 * @author jor sanders IG102
 */
public class ECTSMonitor2 {

    static ArrayList<Vak> courseId = new ArrayList<Vak>();

    //lay out of the program
    public static void main(String[] args) {
        System.out.println("welcome to the ECT monitor 2.0 \n");
        makeCourses();
        readGrades();
        System.out.println("");
        printResults();
        System.out.println("");
        sheduleCheck();
        System.out.println("");
        progressBar();

    }

    //add new courses here
    public static void makeCourses() {
        //give (name of course, max obtainable ects for that course)
        courseId.add(new Vak("Learning Skills", 1));
        courseId.add(new Vak("Project Skills", 2));
        courseId.add(new Vak("Research Skills", 2));
        courseId.add(new Vak("Com. Skills", 2));
        courseId.add(new Vak("Essential Skills", 4));
        courseId.add(new Vak("Programming", 3));
        courseId.add(new Vak("Business ", 3));
        courseId.add(new Vak("Infrastructure", 3));
        courseId.add(new Vak("Databases", 3));
        courseId.add(new Vak("UserInteraction", 3));
        courseId.add(new Vak("Game basics", 3));
        courseId.add(new Vak("Sim./Phicics", 3));
        courseId.add(new Vak("Project FYS", 12));
        courseId.add(new Vak("Project PAD", 12));
        courseId.add(new Vak("Project SIM", 1));

    }

    //asks the user to input grades
    public static void readGrades() {
        for (int i = 0; i < courseId.size(); i++) {
            courseId.get(i).setGrade();
        }
    }

    //prints the result per course
    public static void printResults() {
        for (int i = 0; i < courseId.size(); i++) {
            courseId.get(i).printResults();
        }
    }

    //checks if you are on shedule
    public static void sheduleCheck() {
        System.out.println("Total obtained ECTS: " //prints how much ECTS of the total you obtained
                + Vak.totalEctsAchieved + "/" + Vak.totalEcts);

        if (Vak.totalEctsAchieved < (double) Vak.totalEcts / 6 * 5) {//prints if you are on shedule or not
            System.out.println("careful you are behind on shedule");
        } else {
            System.out.println("you are on shedule");
        }
    }

    //makes a progressbar
    public static void progressBar() {
        int size = 20;
        int progress;
        double ratio;
        int i;

        System.out.println("progress bar");
        ratio = (double) size / (double) Vak.totalEcts;
        progress = (int) Math.round((double) Vak.totalEctsAchieved * ratio);
        for (i = 0; i < progress; i++) {
            System.out.print("[x]");
        }
        for (; i < size; i++) {
            System.out.print("[ ]");
        }
    }
}
//reached end of file have a cookie
