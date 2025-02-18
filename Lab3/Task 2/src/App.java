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
                System.out.println("Exception:" + e.getMessage());
                input.nextLine();
            }
        }
    }

    public static void addCourse() {
        
    }

    public static void printAllCourses() {
        
    }

    public static void updateCourse() {
        
    }

    public static void printCourse() {
        
    }
}