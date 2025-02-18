import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Fahrenheit degree: ");
        float fahrenheit  = input.nextFloat();

        float celsius = (fahrenheit - 32) * 5 / 9;

        System.out.println("Celsius degree: "+celsius);

        input.close();
    }
}