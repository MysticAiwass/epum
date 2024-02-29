package topic_3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Определить класс Дробь (Рациональная Дробь) в виде пары чисел m и n.
 * Объявить и инициализировать массив из k дробей, ввести/вывести значения для массива дробей. Создать массив/список/множество
 * объектов и передать его в метод, который изменяет каждый элемент массива с четным
 * индексом путем добавления следующего за ним элемента.
 */
public class Fraction {
    private int numerator; // числитель
    private int denominator; // знаменатель

    public Fraction(int numerator, int denominator) {
        validateDenominator(denominator);
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        validateDenominator(denominator);
        this.denominator = denominator;
    }

    private static void validateDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
    }

    public static Fraction[] addFraction(Scanner scanner) {

        System.out.println("Введите размер массива");
        int size = scanner.nextInt();
        Fraction[] fractions = new Fraction[size];

        for (int i = 0; i < fractions.length; i++) {
            System.out.println("Введите числитель и знаменатель: ");
            if (!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Аргумент должен быть числом");
            }
            int numerator = scanner.nextInt();
            int denominator = scanner.nextInt();
            validateDenominator(denominator);
            fractions[i] = new Fraction(numerator, denominator);
        }
        return fractions;
    }
    
    public static void changingFractionWithEvenIndex(Fraction[] fractions) {
        for (int i = 2; i < fractions.length - 1; i += 2) {
            fractions[i].setNumerator(fractions[i].getNumerator() + fractions[i + 1].getNumerator());
            fractions[i].setDenominator(fractions[i].getDenominator() + fractions[i + 1].getDenominator());
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fraction[] fractions = addFraction(scanner);
        System.out.println(Arrays.toString(fractions));
        changingFractionWithEvenIndex(fractions);
        System.out.println(Arrays.toString(fractions));
    }
}
