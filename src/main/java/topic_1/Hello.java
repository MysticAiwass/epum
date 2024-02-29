package topic_1;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Введите имя");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Добро пожаловать " + name + "!");
    }
}
