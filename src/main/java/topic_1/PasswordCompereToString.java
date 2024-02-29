package topic_1;

import java.net.Socket;
import java.util.Scanner;

public class PasswordCompereToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write password");
        String password = scanner.nextLine();
        String sampleStr = "123";

        if (password.equals(sampleStr)){
            System.out.println("Correct password");
        } else {
            System.out.println("Do not correct password");
        }
    }
}
