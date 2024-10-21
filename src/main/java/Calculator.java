import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public int add(String input) {
        String[] numbers = splitInput(input);
        return sum(numbers);
    }

    private String[] splitInput(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }
        return input.split(delimiter);
    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += parseNumber(number);
        }
        return total;
    }

    private int parseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: " + number);
        }
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Calculator calculator = new Calculator();
        try {
            int result = calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    }

