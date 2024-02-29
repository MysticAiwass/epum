package topic_2;


import java.util.*;

/**
 * Этот класс реализует работу с числами
 *
 * @author Eva Aiwass.
 * <p>
 * Время начала выполнения задания 25.02.2024 19:45.<p>
 * Время окончания выполнения задания: <p>
 * Ввести n чисел с консоли. <p>
 * 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину. <p>
 * 2. Упорядочить и вывести числа в порядке возрастания(убывания)значений их длины. <p>
 * 3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.<p>
 * 4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.<p>
 * 5. Найти количество чисел, содержащих только четные цифры, а среди них — количество чисел с равным числом четных и нечетных цифр.<p>
 * 6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.<p>
 * 7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.<p>
 * 8. Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.<p>
 * 9. Найти корни квадратного уравнения. Параметры уравнения передавать с командной строкой.<p>
 */
public class NumberAnalyzer {

    //написать тесты для класса
    //продумать логику, если числа отрицательные
    public static void main(String[] args) {

        System.out.println("Введите число. Чтобы прекратить ввод чисел, введите \"end\"");
        List<Integer> numbers = extractNumbers();

//      Найти самое короткое и самое длинное число. Вывести найденные числа и их длину
        int min = searchMin(numbers);
        int max = searchMax(numbers);

        System.out.println("Самое короткое число: " + min + ", его длина: " + String.valueOf(min).length());
        System.out.println("Самое длинное число: " + max + ", его длина: " + String.valueOf(max).length());

//      Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
        List<Integer> nums = sortDesc(numbers);
        System.out.println("Сортировка по убыванию " + nums);
        List<Integer> numsAscend = sortAscend(numbers);
        System.out.println("Сортировка по возрастанию " + numsAscend);

//      Вывести на консоль те числа, длина которых меньше (больше) средней,а также длину.
        List<Integer> numbersLessThanAverageLength = findNumbersLessThanAverageLength(numbers);
        System.out.println("Числа меньше средней длины чисел " + numbersLessThanAverageLength);
        List<Integer> numbersMoreThanAverageLength = findNumbersMoreThanAverageLength(numbers);
        System.out.println("Числа больше средней длины чисел " + numbersMoreThanAverageLength);

//      Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
        System.out.println("Число, в котором число различных цифр минимально " + findNumberWithMinUniqueDigits(numbers));

//      Найти количество чисел, содержащих только четные цифры, а среди них количество чисел с равным числом четных и нечетных цифр.
        System.out.println("Количество чисел, содержащие только четные цифры: " + findEvenNumbers(numbers).size());
        System.out.println("Количество чисел, среди которых есть равное количество четных и нечетных цифр: "
                + calculateCountNumbersWithEqualEvenAndOdd(numbers));

//      Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
        System.out.println("Число, цифры в котором идут в строгом порядке возрастания: "
                + findNumberWithIncreasingDigits(numbers));

//      Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них
        System.out.println("Число, состоящее только из различных цифр: " + findNumberWithMaxUniqueDigits(numbers));

//      Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.
        System.out.println("Число-палиндром: " + findSecondNumberPalindrome(numbers));

//      Найти корни квадратного уравнения. Параметры уравнения передавать с командной строкой.
        System.out.println("Корни квадратного уравнения: ");
    }

    public static List<Integer> sortDesc(List<Integer> numbers) {
        isEmptyList(numbers);
        checkForNegativeNumber(numbers);
        Map<Integer, Integer> newNumbers = new HashMap<>();
        for (Integer number : numbers) {
            newNumbers.put(number, String.valueOf(number).length());
        }
        List<Integer> integers = new ArrayList<>(newNumbers.keySet());
        integers.sort((num1, num2) -> newNumbers.get(num2).compareTo(newNumbers.get(num1)));
        return integers;
    }

    public static List<Integer> sortAscend(List<Integer> numbers) {
        List<Integer> sortNumbersDesk = sortDesc(numbers);
        List<Integer> newNumbersAscend = new ArrayList<>();
        for (int i = sortNumbersDesk.size() - 1; i >= 0; i--) {
            newNumbersAscend.add(sortNumbersDesk.get(i));
        }
        return newNumbersAscend;
    }

    public static List<Integer> extractNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.next();
            if (!input.equals("end")) {
                try {
                    int num = Integer.parseInt(input);
                    numbers.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Необходимо вводить числа");
                }
            }
        } while (!input.equals("end"));
        return numbers;
    }

    public static int searchMin(List<Integer> numbers) {
        isEmptyList(numbers);
        int min = numbers.get(0);
        for (int number : numbers) {
            if (String.valueOf(number).length() < String.valueOf(min).length()) {
                min = number;
            }
        }
        return min;
    }

    public static int searchMax(List<Integer> numbers) {
        isEmptyList(numbers);
        int max = numbers.get(0);
        for (int number : numbers) {
            if (String.valueOf(number).length() > String.valueOf(max).length()) {
                max = number;
            }
        }
        return max;
    }

    private static int calculateAverageLength(List<Integer> numbers) {
        isEmptyList(numbers);
        checkForNegativeNumber(numbers);
        int sumAllLengthsNumbers = 0;
        for (Integer number : numbers) {
            sumAllLengthsNumbers += String.valueOf(number).length();
        }
        return sumAllLengthsNumbers / numbers.size();
    }

    private static void isEmptyList(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Список чисел пуст");
        }
    }

    public static List<Integer> findNumbersLessThanAverageLength(List<Integer> numbers) {
        int averageLength = calculateAverageLength(numbers);
        List<Integer> numbersLessThanAverageLength = new ArrayList<>();
        for (Integer number : numbers) {
            if (String.valueOf(number).length() < averageLength) {
                numbersLessThanAverageLength.add(number);
            }
        }
        return numbersLessThanAverageLength;
    }

    public static List<Integer> findNumbersMoreThanAverageLength(List<Integer> numbers) {
        int averageLength = calculateAverageLength(numbers);
        List<Integer> numbersMoreThanAverageLength = new ArrayList<>();
        for (Integer number : numbers) {
            if (String.valueOf(number).length() > averageLength) {
                numbersMoreThanAverageLength.add(number);
            }
        }
        return numbersMoreThanAverageLength;
    }

    public static int calculateCountDigits(int number) {
        Set<Character> uniqueDigits = new HashSet<>();
        char[] digits = String.valueOf(number).toCharArray();
        for (char digit : digits) {
            if (Character.isDigit(digit)) {
                uniqueDigits.add(digit);
            }
        }
        return uniqueDigits.size();
    }

    public static int findNumberWithMinUniqueDigits(List<Integer> numbers) {
        isEmptyList(numbers);
        checkForNegativeNumber(numbers);
        int minUniqueDigits = Integer.MAX_VALUE;
        int resultNumber = numbers.get(0);

        for (int num : numbers) {
            int uniqueDigitsCount = calculateCountDigits(num);
            if (uniqueDigitsCount < minUniqueDigits) {
                minUniqueDigits = uniqueDigitsCount;
                resultNumber = num;
                if (uniqueDigitsCount == 1) {
                    break;
                }
            }
        }
        return resultNumber;
    }

    private static List<Integer> findEvenNumbers(List<Integer> numbers) {
        isEmptyList(numbers);
        List<Integer> evenNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }

    public static int calculateCountNumbersWithEqualEvenAndOdd(List<Integer> numbers) {
        List<Integer> evenNumbers = findEvenNumbers(numbers);
        int count = 0;
        for (Integer number : evenNumbers) {
            char[] nums = String.valueOf(number).toCharArray();
            int countEvenNumbers = 0;
            int countOddNumbers = 0;
            for (char num : nums) {
                int digit = Character.getNumericValue(num);
                if (digit % 2 == 0) {
                    countEvenNumbers += 1;
                } else {
                    countOddNumbers += 1;
                }
            }
            if (countOddNumbers == countEvenNumbers) {
                count += 1;
            }
        }
        return count;
    }

    private static boolean isIncreasingNumber(int number) {
        String numStr = String.valueOf(number);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (Character.getNumericValue(numStr.charAt(i)) >= Character.getNumericValue(numStr.charAt(i + 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param numbers
     * @return findNumberWithIncreasingDigits возвращает -1, если нет чисел, у которых цифры идут в порядке возрастания
     */

    public static int findNumberWithIncreasingDigits(List<Integer> numbers) {
        isEmptyList(numbers);
        checkForNegativeNumber(numbers);
        for (Integer num : numbers) {
            if (isIncreasingNumber(num)) {
                return num;
            }
        }
        return -1;
    }

    public static int findNumberWithMaxUniqueDigits(List<Integer> numbers) {
        isEmptyList(numbers);
        int maxUniqueDigits = Integer.MIN_VALUE;
        int resultNumber = numbers.get(0);

        for (int num : numbers) {
            int uniqueDigitsCount = calculateCountDigits(num);
            if (uniqueDigitsCount > maxUniqueDigits) {
                maxUniqueDigits = uniqueDigitsCount;
                resultNumber = num;
            }
        }
        return resultNumber;
    }

    public static void checkForNegativeNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("Лист содержит отрицательные значения");
            }
        }
    }

    public static boolean findPalindrome(int number) {
        char[] numberChar = String.valueOf(number).toCharArray();
        for (int i = 0, j = numberChar.length - 1; i < numberChar.length / 2; i++, j--) {
            if (numberChar[i] != numberChar[j]) {
                return false;
            }
        }
        return true;
    }

    public static int findSecondNumberPalindrome(List<Integer> numbers) {
        int count = 0;
        int numberPalindrome = numbers.get(0);
        for (Integer number : numbers) {
            if (findPalindrome(number)) {
                numberPalindrome = number;
                count++;
                if (count == 2) {
                    return numberPalindrome;
                }
            }
        }
        return count == 1 ? numberPalindrome : -1;
    }

//    Найти корни квадратного уравнения. Параметры уравнения передавать с командной строкой.

}
