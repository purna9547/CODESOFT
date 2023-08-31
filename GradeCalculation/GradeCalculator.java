import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your name: ");
        String name = sc.nextLine();
        System.out.print("Enter total number of subjects: ");
        int totalSub = sc.nextInt();
        float sum = number(totalSub);
        System.out.println(name + "! you get " + sum+ " out of " + totalSub*100);
        double percentage = percentage(sum, totalSub);
        System.out.println(name + "! your percentage is " + percentage +"%");
        Grade(percentage, name);
    }

    private static float number(int totalSub) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[totalSub + 1];
        for (int i = 1; i <= totalSub; i++) {
            System.out.print("Enter the number of subject " + i + ": ");
            array[i] = sc.nextInt();
        }
        clearScreen();
        int sum = 0;
        for (int i = 1; i <= totalSub; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static float percentage(float sum, int totalSub) {
        float percentage = (sum / totalSub);
        return percentage;
    }

    private static void Grade(double percentage, String name) {
        if (percentage > 89) {
            System.out.println(name + "! your Grade is O");
            System.out.println("wow! Outstanding");
        } else if (percentage > 79) {
            System.out.println(name + "! your Grade is A");
            System.out.println("Very Good");
        } else if (percentage > 69) {
            System.out.println(name + "! your Grade is B");
            System.out.println("Good");
        } else if (percentage > 59) {
            System.out.println(name + "! your Grade is C");
            System.out.println("Fair");
        } else if (percentage > 49) {
            System.out.println(name + "! your Grade is D");
            System.out.println("Below Average");
        } else {
            System.out.println(name + "! your Grade is F");
            System.out.println("Oops! You are fail");
        }
    }
    static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
