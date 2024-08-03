import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Sub;
        System.out.print("Enter the number of subjects: ");
        Sub = sc.nextInt();
        int[] marks = new int[Sub];
        for (int i = 0; i <Sub; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
        }
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        double averagePercentage = (double) totalMarks / Sub;
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        sc.close();
    }
}