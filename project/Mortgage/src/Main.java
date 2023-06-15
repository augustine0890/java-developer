public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int doubleTheNumber(int number) {
        return 2 * number;
    }

    private static int add(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }
}
