import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    private static CourseRecord[][] courseRecords = new CourseRecord[3][5];

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1- Add course");
            System.out.println("2- Print all course records");
            System.out.println("3- Update course record");
            System.out.println("4- Print a course record");
            System.out.println("5- Exit");

            System.out.print("Enter your choice: ");

            try {
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        addCourse();
                        break;
                    case 2:
                        printAllCourses();
                        break;
                    case 3:
                        updateCourse();
                        break;
                    case 4:
                        printCourse();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter a valid choice.");
                        input.nextLine();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Exception thrown: java.util.InputMismatchException");
                input.nextLine(); 
            }
        }
    }

    public static void addCourse() {
        try {
            System.out.print("Please enter level number (1-3): ");
            int level = input.nextInt();

            if (level < 1 || level > 3) {
                System.out.println("Level number out of range. Please enter a value between 1 and 3.");
                return;
            }

            for (int i = 0; i < 5; i++) {
                if (courseRecords[level - 1][i] == null) {
                    System.out.print("Enter Course Code: ");
                    String code = input.next();

                    input.nextLine(); 

                    System.out.print("Enter Course Title: ");
                    String title = input.nextLine();

                    System.out.print("Enter Credit Hours: ");
                    int credit = input.nextInt();

                    input.nextLine(); 

                    System.out.print("Enter Instructor Name: ");
                    String instructor = input.nextLine();

                    System.out.print("Enter Class Rooms: ");
                    int rooms = input.nextInt();

                    courseRecords[level - 1][i] = new CourseRecord(code, title, credit, instructor, rooms);
                    System.out.println("Course added successfully to Level " + level + ".");
                    return;
                }
            }
            System.out.println(
                    "Exception thrown: java.lang.IndexOutOfBoundsException. Maximum courses reached for this level.");
        } catch (InputMismatchException e) {
            System.out.println("Exception thrown: java.util.InputMismatchException");
            input.nextLine();
        }
    }

    public static void printAllCourses() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Level " + (i + 1) + ":");
            boolean hasCourses = false;
            for (int j = 0; j < 5; j++) {
                if (courseRecords[i][j] != null) {
                    System.out.println(courseRecords[i][j].toString());
                    hasCourses = true;
                }
            }
            if (!hasCourses) {
                System.out.println("No courses available.");
            }
            System.out.println();
        }
    }

    public static void updateCourse() {
        try {
            System.out.print("Enter level number (1-3): ");
            int level = input.nextInt();

            System.out.print("Enter Course Code to update: ");
            String code = input.next();

            boolean found = false;
            for (int i = 0; i < 5; i++) {
                if (courseRecords[level - 1][i] != null && courseRecords[level - 1][i].code.equals(code)) {
                    System.out.print("Enter new Course Title: ");
                    input.nextLine(); 
                    String newTitle = input.nextLine();

                    System.out.print("Enter new Credit Hours: ");
                    int newCredit = input.nextInt();

                    System.out.print("Enter new Instructor Name: ");
                    input.nextLine(); 
                    String newInstructor = input.nextLine();

                    System.out.print("Enter new Class Rooms: ");
                    int newRooms = input.nextInt();

                    courseRecords[level - 1][i] = new CourseRecord(code, newTitle, newCredit, newInstructor, newRooms);
                    System.out.println("Course record updated successfully.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Course with code " + code + " not found in Level " + level + ".");
            }
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.println("Exception thrown: " + e);
            input.nextLine(); 
        }
    }

    public static void printCourse() {
        try {
            System.out.print("Enter level number (1-3): ");
            int level = input.nextInt();

            System.out.print("Enter course number (1-5): ");
            int course = input.nextInt();

            CourseRecord record = courseRecords[level - 1][course - 1];
            if (record == null) {
                throw new NullPointerException("No course found in the specified slot.");
            }
            System.out.println(record.toString());
        } catch (NullPointerException e) {
            System.out.println("Exception thrown: java.lang.NullPointerException");
        } catch (InputMismatchException | IndexOutOfBoundsException e) {
            System.out.println("Exception thrown: " + e);
            input.nextLine();
        }
    }
}