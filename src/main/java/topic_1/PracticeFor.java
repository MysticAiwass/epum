package topic_1;

import java.util.*;

public class PracticeFor {
//    Ввести с консоли n целых чисел. На консоль вывести:
//1. Четные и нечетные числа.
//2. Наибольшее и наименьшее число.
//3. Числа, которые делятся на 3 или на 9.
//4. Числа, которые делятся на 5 и на 7.
//5. Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
//6. Простые числа.
//7. Отсортированные числа в порядке возрастания и убывания.
//8. Числа в порядке убывания частоты встречаемости чисел.
//9. «Счастливые» числа.
//10. Числа-палиндромы, значения которых в прямом и обратном порядке совпадают.
//11. Элементы, которые равны полусумме соседних элементов.


    public static void main(String[] args) {
        System.out.println("Четные числа");
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("Нечетные числа");
        for (int i = 0; i < 30; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("Наибольшее и наименьшее число");
        int[] arr = {10, 12, 3, 1, 0, 2, 0, 1, 30, -1};

        int min = arr[0];
        int max = arr[0];

        for (int j : arr) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
        System.out.println("Минимальное число: " + min + ". " + "Максимальное число: " + max);

        System.out.println("Числа, которые делятся на 3 или на 9.");
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println("Количество " + count);
        System.out.println("Числа, которые делятся на 5 и на 7.");
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0 && i % 7 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.");
        int[] arr2 = {123, 134, 145, 90, 156, 1000, 167, 178, 67, 378, 389, 400, 123, 389, 390, 589, 590, 678, 689, 690, 789, 790, 890};
        HashSet<Integer> newArr = new HashSet<>();
        for (int num : arr2) {
            if (num >= 100 && num < 999) {
                newArr.add(num);
            }
        }
        System.out.println(newArr);
        System.out.println("Простые числа.");

        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        System.out.println("Отсортированные числа в порядке возрастания и убывания.");
        int[] arr3 = {34, 23, 1900, 123, 134, 4, 1000, 145, 90, 156, 1000, 167, 178, 689, 1, 0, -1};
        boolean a;
        do {
            a = false;
            for (int i = 0; i < arr3.length - 1; i++) {
                int temp = arr3[i];
                if (arr3[i] > arr3[i + 1]) {
                    arr3[i] = arr3[i + 1];
                    arr3[i + 1] = temp;
                    a = true;
                }
            }
        } while (a);

        System.out.println(Arrays.toString(arr3));

        for (int i = 0; i < arr3.length / 2; i++) {
            int temp = arr3[i];
            arr3[i] = arr3[arr3.length - 1 - i];
            arr3[arr3.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr3));

        System.out.println("Числа в порядке убывания частоты встречаемости чисел.");

        int[] arr4 = {1, 1, 2, 3, 4, 1, 1, 2, 4, 3, 3, 3, 3, 3, 1};

        // Подсчет частоты встречаемости чисел
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr4) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Создание и сортировка списка ключей по убыванию частоты
        List<Integer> numbers = new ArrayList<>(frequencyMap.keySet());
        numbers.sort((num1, num2) -> frequencyMap.get(num2).compareTo(frequencyMap.get(num1)));

        for (int num : numbers) {
            int frequency = frequencyMap.get(num);
            for (int i = 0; i < frequency; i++) {
                System.out.print(num + " ");
            }
        }

        System.out.println("«Счастливые» числа.");
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
