import java.util.Scanner;
import java.util.Random;

public class guess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int guessNum, maxTry = 5, ch, correct = 0;
        String name;

        System.out.print("Enter your name: ");
        name = sc.nextLine();

        while (true) {
            guessNum = random.nextInt(100);
            System.out.println("1. Play the Gusseing game");
            System.out.println("2. Show your score");
            System.out.println("3. Quit the game");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    correct = player(name, guessNum, maxTry, correct);
                    break;
                case 2:
                    display(correct);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the right choice.");
                    break;
            }
        }
    }

    private static int player(String name, int guessNum, int maxTry, int correct) {
        Scanner sc = new Scanner(System.in);

        int count = 0, guess;
         showLoadingAnimation();
        
        System.out.println("\nNumber already guessed by me between 1 to 100");
        System.out.println("\nNow it's your turn: ");
        while (count < maxTry) {
            System.out.print(name + " Now it's your turn: ");
            guess = sc.nextInt();
            if (guess == guessNum) {
                System.out.println("\nCongratulations! Your guess is correct.");
                correct++;
                break;
            } else if (guess > guessNum) {
                System.out.println("Your guessing number is too high.");
            } else if (guess < guessNum) {
                System.out.println("Your guessing number is too low.");
            }

            count++;
        }

        if (count >= maxTry) {
            System.out.println("\nSorry, you have run out of attempts.");
        }

        return correct;

    }

    private static void display(int correct) {
        System.out.println("\nYour score is: " + correct);
    }
    static void showLoadingAnimation() {
        System.out.print("I am guessing");
        for (int i = 0; i < 10; i++) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

}
