import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);
    public static CourseRecord[][] courseRecords = new CourseRecord[3][5];

    public static void main(String[] args) {

        courseRecords[0][0] = new CourseRecord("IC101", "Introduction to Computing", 2, "Dr. One", 5);
        courseRecords[0][1] = new CourseRecord("IS201", "Fundamentals of IS", 3, "Dr. Two", 6);

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
                        System.out.println("Program is closing...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter a valid choice");
                        input.nextLine();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Exception: " + e);
                input.nextLine();
            }
        }
    }

    public static void addCourse() {
        try {
            System.out.println("Adding New Course:");

            System.out.println("Enter level number: ");
            int level = input.nextInt();
            input.nextLine();

            if (level < 1 || level > 3) {
                System.out.println("Available levels are: 1, 2 and 3");
                return;
            }

            System.out.println("Enter course code: ");
            String code = input.nextLine();

            System.out.println("Enter course title: ");
            String title = input.nextLine();

            System.out.println("Enter credit hours: ");
            double credit = input.nextDouble();

            System.out.println("Enter instructor name: ");
            String instructor = input.nextLine();
            input.nextLine();

            System.out.println("Enter class rooms: ");
            int rooms = input.nextInt();

            for (int i = 0; i < 5; i++) {
                if (courseRecords[level - 1][i] == null) {
                    courseRecords[level - 1][i] = new CourseRecord(code, title, credit, instructor, rooms);
                    System.out.println("Course has been added");
                    return;
                }
            }

            throw new IndexOutOfBoundsException();

        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch Exception");
            input.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The maximum number of courses for each level (5 courses)");
        }
    }

    public static void printAllCourses() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                CourseRecord course = courseRecords[i][j];
                if (course != null) {
                    System.out.println("Level " + (i + 1) + ", Course " + (j + 1) + ": " + course.title);
                }
            }
        }
    }

    public static void updateCourse() {
        System.out.println("Enter level number: ");
        int level = input.nextInt();
        input.nextLine();

        if (level < 1 || level > 3) {
            System.out.println("Available levels are: 1, 2 and 3");
            return;
        }

        System.out.println("Enter course code: ");
        String oldCode = input.nextLine();

        System.out.println("Enter new course code: ");
        String code = input.nextLine();

        System.out.println("Enter new course title: ");
        String title = input.nextLine();

        System.out.println("Enter new credit hours: ");
        double credit = input.nextDouble();

        System.out.println("Enter new instructor name: ");
        String instructor = input.nextLine();
        input.nextLine();

        System.out.println("Enter new class rooms: ");
        int rooms = input.nextInt();

        for (int i = 0; i < 5; i++) {
            if (courseRecords[level - 1][i] != null && courseRecords[level - 1][i].code.equals(oldCode)) {
                courseRecords[level - 1][i].code = code;
                courseRecords[level - 1][i].title = title;
                courseRecords[level - 1][i].credit = credit;
                courseRecords[level - 1][i].instructor = instructor;
                courseRecords[level - 1][i].rooms = rooms;

                System.out.println("Course has been updated");
                return;
            }
        }

        System.out.println("Course not found");
    }

    public static void printCourse() {
        try {
            System.out.println("Enter level number: ");
            int level = input.nextInt();
            input.nextLine();

            if (level < 1 || level > 3) {
                System.out.println("Available levels are: 1, 2 and 3");
                return;
            }

            System.out.println("Enter course number: ");
            int number = input.nextInt();

            if (courseRecords[level - 1][number] != null) {
                System.out.println(
                        "Level " + level + ", Course " + number + ": " + courseRecords[level - 1][number].toString());
            }

        } catch (NullPointerException e) {
            System.out.println("Course not found");
        }
    }
}