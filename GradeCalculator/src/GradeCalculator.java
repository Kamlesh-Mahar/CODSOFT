import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int numberOfSubjects = scanner.nextInt();

        int[] marksArray = new int[numberOfSubjects];
        int maxMarksPerSubject = 100;

        // Input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            int marks = scanner.nextInt();

            // Validate marks to be in the range [0, 100]
            if (marks < 0 || marks > maxMarksPerSubject) {
                System.out.println("Invalid marks. Marks should be between 0 and 100. Please try again.");
                i--;  // Decrement i to re-enter marks for the current subject
            } else {
                marksArray[i] = marks;
            }
        }

        // Calculate total marks
        int totalMarks = calculateTotalMarks(marksArray);

        // Calculate average percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects, maxMarksPerSubject);

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + calculateGrade(averagePercentage));

        scanner.close();
    }

    private static int calculateTotalMarks(int[] marksArray) {
        int totalMarks = 0;
        for (int marks : marksArray) {
            totalMarks += marks;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int numberOfSubjects, int maxMarksPerSubject) {
        return (double) totalMarks / (numberOfSubjects * maxMarksPerSubject) * 100;
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
