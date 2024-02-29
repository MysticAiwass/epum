package topic_1;

public class SumArgs {
//    Ввести целые числа как аргументы командной строки, подсчитать их суммы и произведения.
//    Вывести результат на консоль.

    public static void main(String[] args) {

        if (args.length > 0) {
            int[] intArgs = new int[args.length];
            int sum = 0;
            int mul = 1;
            for (int i = 0; i < args.length; i++) {
                intArgs[i] = Integer.parseInt(args[i]);
                sum += intArgs[i];
                mul = mul * intArgs[i];
            }
            System.out.println("Сумма " + sum + ". " + "Произведение " + mul);
        } else {
            System.out.println("Нет аргументов командной сроки");
        }
    }
}
