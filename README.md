# CGPA Calculator (Java Program)

This is a Java program that calculates the GPA (Grade Point Average) and CGPA (Cumulative Grade Point Average) for a list of students based on their subject grades, credit hours, and previous semester information.

## Instructions

1. Run the program `Final.java` using a Java compiler or IDE.
2. Follow the on-screen instructions to input the required data:
   - Number of students in the class.
   - Names of the students.
   - Subject names, credit hours, and marks for each student.
   - GPA of the previous semester for CGPA calculation.
   - Previous credit hours for CGPA calculation.
3. The program will display the following information for each student:
   - Name
   - Total points
   - GPA
   - CGPA
   - Grade

## Program Structure

- The program is organized into several functions:
   - `StoreRecord`: Captures student information and calculates GPA, CGPA, and grade.
   - `studentData`: Captures subject information and calculates total points.
   - `gradePoints`: Returns grade points based on a given grade.
   - `calculateGPA`: Calculates GPA based on total points and total credit hours.
   - `StudentGrade`: Assigns a grade based on the GPA.
   - `cgpa`: Calculates CGPA based on current and previous semester data.

## Input Validation

- The program handles invalid inputs gracefully using try-catch blocks for `InputMismatchException`.

## Note

- Make sure to compile and run the program using a Java compiler or IDE.
- The program provides step-by-step instructions for data input and displays student information accordingly.

## License

This project is licensed under the ownership of Farwah Hamid.

## Contact

For further queries contact farwah.hamid21@gmail.com
