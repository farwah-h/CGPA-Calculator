import java.util.InputMismatchException;
import java.util.Scanner;
public class Final {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("...GPA CALCULATOR...");
            System.out.println("Instructions: ");
            System.out.println("1. Enter the number of students of class.");
            System.out.println("2. Enter the names of the students, the subjects and credit hours, and their marks in the subjects. ");
            System.out.println("3. The result will display: ");
            System.out.println("    a. The name of the student");
            System.out.println("    b. The total points of the student");
            System.out.println("    c. The GPA of the student");
            System.out.println("    d. The CGPA of the student");
            System.out.println("    d. The Grade of the Student");
            System.out.println();

            // Getting the number of students to determine the rows of array
            // 4 is set for the columns as they will present the name,total points,gpa, and grade of student

            System.out.print("Enter the number of students: ");
            int students = input.nextInt();
            String [][] record = new String[students][5];

            System.out.print("Enter the total credit hours: "); // getting all the credit hours
            double totalHours = input.nextDouble();
            input.nextLine(); // using input.nextLine() cz without it, the string value on the second iteration wasn't taking input


            // The StudentRecord is called here
            String [][] record1 = StoreRecord(record,totalHours);


            // We iterate it over the rows only, as if it is iterated over the columns, then it will result in more iterations than expected
            // suppose I iterate it over the columns as well, then it will complete the 2 iterations of column with the 1st row, and then 2 more iterations
            for (int i = 0; i < record1.length; i++) {
                System.out.println();
                System.out.println("The name of the student " + (i + 1) + " is: " + record[i][0]);
                System.out.println("The total points of the student " + (i + 1) + " are: " + record[i][1]);
                System.out.println("The GPA of the student " + (i + 1) + " is: " + record[i][2]);
                System.out.println("The CGPA of the student " + (i + 1) + " is: " + record[i][3]);
                System.out.println("The grade awarded to student " + (i + 1) + " is: " + record[i][4]);
                System.out.println();
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid Input! Try Again!");
        }

    }
    public static String[][] StoreRecord(String [][] record, double totalHours) {
        Scanner input = new Scanner(System.in);

        //again we iterate over the rows only, as I tried using the columns, but it didn't work the way it was supposed to :(
        for (int i = 0; i < record.length; i++) {
            System.out.print("Enter the name of the student: ");

            // the name of the student is stored in the 1st row, at the 1st column
            record[i][0] = input.nextLine();

            // the studentData function is called
            double totalPoints = studentData();
            record[i][1] = String.valueOf(totalPoints);

            // the calculateGPA is called here
            // we store the value of gpa that the function returns in the variable gpa, which can then be used to determine the grade
            double gpa = calculateGPA(totalPoints, totalHours);
            record[i][2] = String.valueOf(gpa);

            double CGPA = cgpa(gpa, totalHours);
            record[i][3] = String.valueOf(CGPA);

            // the grade according to the gpa is determined here
            record[i][4] = String.valueOf(StudentGrade(gpa));
        }
        return record;
    }
    public static double studentData() {
        Scanner input = new Scanner(System.in);

        // asking for the total subjects of the students
        System.out.print("Enter the total subjects: ");
        int subjects = input.nextInt();
        input.nextLine();

        String subjectName;
        double totalPoints = 0;
        double marks;
        double hours;
        char Grade;

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter the name of the subject: ");
            subjectName = input.nextLine();

            System.out.print("Enter the number of credit hours of the subject: ");
            hours = input.nextDouble();
            input.nextLine();

            System.out.print("Enter your marks out of 100: ");
            marks = input.nextDouble();

            // the marks will be represented by grades which have different points

            if (marks >= 90) {
                Grade = 'A';
            } else if (marks >= 85) {
                Grade = 'B';
            } else if (marks >= 80) {
                Grade = 'C';
            } else if (marks >= 75) {
                Grade = 'D';
            } else if (marks >= 70) {
                Grade = 'E';
            } else if (marks >= 65) {
                Grade = 'G';
            } else if (marks >= 60) {
                Grade = 'H';
            } else {
                Grade = 'F';
            }

            input.nextLine();

            // call the gradePoints function here, so that the total grade points can be calculated
            double points = gradePoints(Grade);
            totalPoints += hours * points;       // determining all the points of the student
        }
        return totalPoints;
    }
    public static double gradePoints(char Grade) {
        double gradePoints = 0;

        // the points of the grades are then determined according to the given arrangement

        if (Grade == 'A') {
            gradePoints = 4;
        } else if (Grade == 'B') {
            gradePoints = 3.5;
        } else if (Grade == 'C') {
            gradePoints = 3;
        } else if (Grade == 'D') {
            gradePoints = 2.5;
        } else if (Grade == 'E') {
            gradePoints = 2;
        } else if (Grade == 'G') {
            gradePoints = 1.5;
        } else if (Grade == 'H') {
            gradePoints = 1;
        } else if (Grade == 'F') {
            gradePoints = 0;
        } else {
            System.out.print("Invalid!");
        }
        return gradePoints;
    }
    public static double calculateGPA(double totalPoints,double totalHours) {
        double gpa = totalPoints / totalHours; // dividing the total points with the total credit hours
        return gpa;
    }
    public static char StudentGrade(double gpa) {
        char grade;

        // the grades of the student on the basis of GPA are as follows

        if (gpa >= 3.5) {
            grade = 'A';
        } else if (gpa >= 3) {
            grade = 'B';
        } else if (gpa >= 2.5) {
            grade = 'C';
        } else if (gpa >= 2) {
            grade = 'D';
        } else if (gpa >= 1) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        return grade;
    }

    public static double cgpa(double gpa, double totalHours) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the gpa for the previous semester: ");
        double prevGPA = input.nextDouble();
        System.out.print("Enter the previous credit hours: ");
        double prevHours = input.nextDouble();

        // CGPA is calculated by getting all the previous points and previous credit hours
        // then we multiply them both and add them to the product of current gpa and current credit hours
        // then the total points are divided by the total credit hours

        double totalPoints = (prevGPA * prevHours) + (gpa * totalHours) ;
        double totalCreditHours = prevHours + totalHours;
        double CGPA = totalPoints / totalCreditHours;
        return CGPA;
    }
}
