/* TASK2- Grade Calculator
 * Author - Satya Narayan Gochhi
 * NumberGame
 */

import java.util.*;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWelcome to Satya's Grade Calculator.");
        System.out.println("Enter the number of subjects:");
        int noOfSubject = sc.nextInt();

        int[] marks = new int[noOfSubject];
        int totalMarks = 0;

        for (int i = 0; i < noOfSubject; i++) {
            System.out.println("Enter the marks obtained in subject " + (i + 1) + ":");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        double avgPercentage = (double) totalMarks / noOfSubject;
        String grade;

        if (avgPercentage >= 90) 
        {
            grade = "A";
        } 
        else if (avgPercentage >= 80) 
        {
            grade = "B";
        } 
        else if (avgPercentage >= 70) 
        {
            grade = "C";
        } 
        else if (avgPercentage >= 60) 
        {
            grade = "D";
        } 
        else 
        {
            grade = "F";
        }

        System.out.println("\nTotal marks: " + totalMarks);
        System.out.println("Average percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);
    }
}